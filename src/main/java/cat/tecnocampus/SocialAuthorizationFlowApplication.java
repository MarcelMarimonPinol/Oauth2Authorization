package cat.tecnocampus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
@RestController
@EnableOAuth2Client
public class SocialAuthorizationFlowApplication {

	private OAuth2ClientContext oauth2ClientContext;
	private OAuth2RestTemplate gitHubRestTemplate;

	public SocialAuthorizationFlowApplication(OAuth2ClientContext oauth2ClientContext) {
		this.oauth2ClientContext = oauth2ClientContext;
	}

	@Autowired
	public void setGitHubRestTemplate(OAuth2RestTemplate gitHubRestTemplate) {
		this.gitHubRestTemplate = gitHubRestTemplate;
	}

	private String url_GET_repositories = "https://api.github.com/user/repos";

	@GetMapping("/repositories")
	public ResponseEntity<String> getRepositories() {

		ResponseEntity<String> response;
		response = gitHubRestTemplate.exchange(url_GET_repositories, HttpMethod.GET, null, String.class);

		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(SocialAuthorizationFlowApplication.class, args);
	}

	@Bean
	public OAuth2RestTemplate gitHubRestTemplate() {
		return new OAuth2RestTemplate(gitHub(), oauth2ClientContext);
	}

	@Bean
	@ConfigurationProperties("github.client")
	public AuthorizationCodeResourceDetails gitHub() {
		return new AuthorizationCodeResourceDetails();
	}
}


