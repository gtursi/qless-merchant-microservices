package io.swagger.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import de.bild.codec.EnumCodecProvider;
import de.bild.codec.PojoCodecProvider;
import eu.dozd.mongo.codecs.bigdecimal.BigDecimalCodecProvider;
import io.swagger.model.Location;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	private final ResourceLoader resourceLoader;

	public MongoConfig(@Qualifier("webApplicationContext") ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}


	@Override
	protected String getDatabaseName() {
		return "merchant";
	}

	@Override
	public Mongo mongo() {
		MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().codecRegistry(getCodecRegistry()).build();
		return new MongoClient(new ServerAddress("localhost", 27017), mongoClientOptions);
	}

	public CodecRegistry getCodecRegistry() {
		return CodecRegistries.fromRegistries(
				CodecRegistries.fromProviders(
						new EnumCodecProvider(),
						PojoCodecProvider.builder()
								.register(Location.class.getPackage().getName())
								.build(),
						new BigDecimalCodecProvider()
				),
				MongoClient.getDefaultCodecRegistry());
	}

	@PostConstruct
	public void initDB() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Resource resource = this.resourceLoader.getResource("classpath:us-locator-etl.json");
		Location[] locations = objectMapper.readValue(resource.getInputStream(), Location[].class);

		MongoClient mongoClient = (MongoClient) mongo();
		MongoCollection<Location> locationCollection = mongoClient.getDatabase(getDatabaseName()).getCollection("location", Location.class);
		locationCollection.drop();
		locationCollection.insertMany(Arrays.asList(locations));
		locationCollection.createIndex(Indexes.geo2dsphere("location.contactInfo.gps"));

	}
}