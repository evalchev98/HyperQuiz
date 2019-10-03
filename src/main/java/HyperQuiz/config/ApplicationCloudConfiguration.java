package HyperQuiz.config;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class ApplicationCloudConfiguration {

	//@Value("${cloudinary.cloud-name}")
	private String cloudApiName="evgeni";
	//@Value("${cloudinary.api-key}")
	private String cloudApiKey="764743112695178";
	//@Value("${cloudinary.api-secret}")
	private String cloudApiSecret="G10cjg9u8e9QoyJvnhCX8vAaBEQ";
	
	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(new HashMap<String, Object>(){{
			put	("cloud_name", cloudApiName);
			put ("api_key", cloudApiKey);
			put ("api_secret", cloudApiSecret);
		}}) ;
	}
}
