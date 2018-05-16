package qless.merchant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationProperties {

	@Value("${spring.data.mongodb.uri}")
	private String mongodbUri;

}
