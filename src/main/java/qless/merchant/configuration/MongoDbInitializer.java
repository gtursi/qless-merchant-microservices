package qless.merchant.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import qless.merchant.model.Location;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Component()
@Profile("dev")
@RequiredArgsConstructor
@Slf4j
public class MongoDbInitializer {

	private final MongoConfig mongoConfig;

	/**
	 * Initialize the DB just for development (if necessary, replace it with an initialization script).
	 *
	 * @throws Exception
	 */
	@PostConstruct
	public void initDB() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Path path = Paths.get("us-locator-etl.json");
		log.info("DB initialization reading file {}", path.toAbsolutePath());
		Location[] locations = objectMapper.readValue(path.toFile(), Location[].class);

		MongoClient mongoClient = (MongoClient) mongoConfig.mongo();
		MongoCollection<Location> locationCollection = mongoClient.getDatabase("merchant").getCollection("location", Location.class);
		locationCollection.drop();
		locationCollection.insertMany(Arrays.asList(locations));
		locationCollection.createIndex(Indexes.geo2dsphere("location.contactInfo.gps"));
	}
}
