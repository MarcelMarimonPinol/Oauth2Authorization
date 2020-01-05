# Ouath2 Authorization Flow

This is an example using Oaut2RestTemplate for authorization (not for authentication - security):
* Oauth2RestTemplate is used to get the authoritation from the user when we don't have his token
* Once authorized the Oauth2RestTemplate stores the token for future use
* The authorization token is also stored in Oauth2ClientContext
* Note that security is disabled using: @SpringBootApplication(exclude = {SecurityAutoConfiguration.class)
* Guess (or read in the documentation) what Oauth2ClientContext is (beyond a place to store the token)

You may want to see the official documentation at https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/htmlsingle/#boot-features-security-custom-user-info-client
 
