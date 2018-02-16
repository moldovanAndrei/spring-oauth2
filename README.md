# spring-oauth2

Demo project showing how to implement 3 different use-cases for OAuth2 authentication using Spring Security.

The projects come in pairs of two, a authorization server for the token generation and a resource server, which represents the protected API.

Small use-case description:
  1) in-memory-authorization-service/in-memory-resource-server: most basic implementation of OAuth2 using simple tokens and in memory users/clients.
  2) in-memory-jwt-authorization-service/in-memory-jwt-resource-server: implementation of OAuth2 using JWT tokens and in memory users/clients.
  3) persistent-jwt-authorization-service/persistent-jwt-resource-server: implementation of OAuth2 using simple tokens and persistent users/clients. Credentials are stored in a Oracle DB and accessed using Spring Data JPA.
  
The postman requests used in the demo can be found in the "postman-requests" folder. Don't forget to check the query params (grant_type, username, password) and the authorization (username/password). Also, tokens found in the requests have to be replaced with the newly emitted ones.

Enjoy!
