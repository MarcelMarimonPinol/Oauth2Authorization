# Ouath2AuthorizationFlow

This is an example using Oaut2RestTemplate for authorization (not for authentication - security):
* Oauth2RestTemplate is used to get the authoritation from the user when we don't have his token
* Once authorized the Oauth2RestTemplate stores the token for future use
* A plain RestTemplate is used when we aready have the token
* Note that security is disabled using: @SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
* Guess (or read in the documentation) what Oauth2ClientContext is used for!
