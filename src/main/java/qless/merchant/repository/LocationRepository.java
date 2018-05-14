package qless.merchant.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import qless.merchant.model.Location;
import qless.merchant.model.NetworkSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Repository
public class LocationRepository {

	private final MongoTemplate mongoTemplate;

	public LocationRepository(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public Location findOne(String locationGid, Boolean mobileClientAccess, Boolean omitMerchantInfo, Boolean omitContactInfo, Boolean omitConsumerFeatures) {
		DBObject location = mongoTemplate.execute("location", new CollectionCallback<DBObject>() {
			@Override
			public DBObject doInCollection(DBCollection dbCollection) throws MongoException, DataAccessException {
				BasicDBObject projections = getExcludedProjections(omitMerchantInfo, omitContactInfo, omitConsumerFeatures);
				List<BasicDBObject> filters = new ArrayList<BasicDBObject>();
				addLocationGlobalIdCriteria(filters, locationGid);
				addMobileClientAccessCriteria(filters, mobileClientAccess);
				BasicDBObject andCriteria = new BasicDBObject();
				andCriteria.put("$and", filters);
				return dbCollection.findOne(andCriteria, projections);
			}
		});
		return dbObjectToLocation(location);
	}

	public List<Location> findBy(String name, BigDecimal longitude, BigDecimal latitude, Integer radius, List<String> gid,
								 Integer maximumResults, Boolean mobileClientAccess, Boolean omitMerchantInfo,
								 Boolean omitContactInfo, Boolean omitConsumerFeatures) {

		DBCursor cursor = mongoTemplate.execute("location", new CollectionCallback<DBCursor>() {
			@Override
			public DBCursor doInCollection(DBCollection dbCollection) throws MongoException, DataAccessException {
				BasicDBObject projections = getExcludedProjections(omitMerchantInfo, omitContactInfo, omitConsumerFeatures);
				List<BasicDBObject> filters = new ArrayList<BasicDBObject>();
				addNameCriteria(filters, name);
				addGeospatialCriteria(filters, longitude, latitude, radius);
				addGlobalIdsCriteria(filters, gid);
				addMobileClientAccessCriteria(filters, mobileClientAccess);
				BasicDBObject andCriteria = new BasicDBObject();
				if(!filters.isEmpty()) {
					andCriteria.put("$and", filters);
				}
				return dbCollection.find(andCriteria, projections).limit(maximumResults);
			}
		});
		List<Location> locations = new ArrayList<>();
		while (cursor.hasNext()) {
			DBObject obj = cursor.next();
			locations.add(dbObjectToLocation(obj));
		}
		return locations;
	}

	private Location dbObjectToLocation(DBObject obj) {
		return mongoTemplate.getConverter().read(Location.class, obj);
	}

	private void addLocationGlobalIdCriteria(List<BasicDBObject> filters, String locationGid) {
		BasicDBObject locationQuery = new BasicDBObject();
		locationQuery.append("source.globalId", locationGid);
		filters.add(locationQuery);
		BasicDBObject typeQuery = new BasicDBObject();
		typeQuery.append("source.type", NetworkSource.TypeEnum.LOCATION.name());
		filters.add(typeQuery);
	}


	private void addNameCriteria(List<BasicDBObject> filters, String name) {
		if (StringUtils.isNotBlank(name)) {
			BasicDBObject nameQuery = new BasicDBObject();
			nameQuery.append("name", name);
			filters.add(nameQuery);
		}
	}

	private void addGeospatialCriteria(List<BasicDBObject> filters, BigDecimal longitude, BigDecimal latitude, Integer radius) {
		// FIXME filter not working, always returns an empty collection
		if (longitude != null && latitude != null && radius != null) {
			BasicDBObject geoCriteria = new BasicDBObject("$nearSphere", new double[]{longitude.doubleValue(), latitude.doubleValue()});
			geoCriteria.put("$maxDistance", radius);
			BasicDBObject query = new BasicDBObject("location.contactInfo.gps", geoCriteria);
			filters.add(query);
		}
	}

	private void addGlobalIdsCriteria(List<BasicDBObject> filters, List<String> gid) {
		if (gid != null && !gid.isEmpty()) {
			List<BasicDBObject> gidFilters = new ArrayList<>();
			for (String globalId : gid) {
				BasicDBObject glogablIDCriteria = new BasicDBObject();
				glogablIDCriteria.put("source.globalId", globalId);
				gidFilters.add(glogablIDCriteria);
			}
			BasicDBObject orCriteria = new BasicDBObject();
			orCriteria.put("$or", gidFilters);
			filters.add(orCriteria);
		}
	}

	private void addMobileClientAccessCriteria(List<BasicDBObject> filters, Boolean mobileClientAccess) {
		if (mobileClientAccess != null) {
			BasicDBObject mobileClientAccessCriteria = new BasicDBObject();
			mobileClientAccessCriteria.put("consumerFeatures.hasMobileAccess", mobileClientAccess);
			filters.add(mobileClientAccessCriteria);
		}
	}

	private BasicDBObject getExcludedProjections(Boolean omitMerchantInfo, Boolean omitContactInfo, Boolean omitConsumerFeatures) {
		BasicDBObject projections = new BasicDBObject();
		if (TRUE.equals(omitMerchantInfo)) {
			projections.append("merchantInfo", false);
		}
		if (TRUE.equals(omitContactInfo)) {
			projections.append("contactInfo", false);
		}
		if (TRUE.equals(omitConsumerFeatures)) {
			projections.append("consumerFeatures", false);
		}
		return projections;
	}

}
