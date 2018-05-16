package qless.merchant.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import de.bild.codec.EnumCodecProvider;
import de.bild.codec.PojoCodecProvider;
import eu.dozd.mongo.codecs.bigdecimal.BigDecimalCodecProvider;
import lombok.extern.slf4j.Slf4j;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import qless.merchant.ApplicationProperties;
import qless.merchant.model.Location;

@Configuration
@Slf4j
public class MongoConfig extends AbstractMongoConfiguration {

	private final ApplicationProperties properties;

	public MongoConfig(ApplicationProperties properties) {
		this.properties = properties;
	}

	@Override
	protected String getDatabaseName() {
		return "merchant";
	}

	@Override
	public Mongo mongo() {
		log.info("MongoDB URI: {}", properties.getMongodbUri());
		MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().codecRegistry(getCodecRegistry()).build();
		return new MongoClient(new ServerAddress(properties.getMongodbUri()), mongoClientOptions);
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

}