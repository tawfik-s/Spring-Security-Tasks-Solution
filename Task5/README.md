## Task 5: JWT Authentication
- Configure the application to use JWT for authentication.
- Implement token generation and validation.
- Secure endpoints using the generated JWT tokens.

## Notes
When implementing JWT (JSON Web Token) authentication in a Spring Boot project that utilizes Spring Security, several libraries and approaches can be considered:

- Spring Security's Built-in Support: Spring Security offers comprehensive support for JWT authentication, especially in its newer versions. By configuring Spring Security as a resource server, you can handle JWTs without the need for additional external libraries. This approach ensures seamless integration and leverages Spring Security's robust features.
REDDIT

- JJWT which I use (Java JWT): JJWT is a popular library for creating and parsing JWTs in Java applications. It provides a straightforward API for generating and validating tokens. When combined with Spring Security, JJWT can be used to handle the creation and verification of JWTs, while Spring Security manages the authentication and authorization processes.
REDDIT

- Auth0's Java JWT: Auth0 provides a Java library for JWTs that is widely used and well-documented. It offers functionalities for creating, decoding, and verifying JWTs. Integrating this library with Spring Security allows for effective JWT handling in your application.

## Configure the jwt 
don't forget to change jwt secret and number of hours before jwt expiration property
![img.png](img.png)

## Curl for Endpoints

### Register
```shell
curl --location 'localhost:8080/auth/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName":"tawfeek",
    "password":"password",
    "email":"t.shalash1@gmail.com"
}'
```
### Login
```shell
curl --location 'localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "password":"password",
    "email":"t.shalash1@gmail.com"
}'
```

### Get User Page
```shell
curl --location 'localhost:8080/user' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0LnNoYWxhc2gxQGdtYWlsLmNvbSIsImlhdCI6MTczNTg5NTc3NCwiZXhwIjoxNzM1OTEwMTc0fQ.Sfb8jpJJsrf_eM0wor4_-68SmaYo8StTx4EpNbLXbsI'
```

### Get Admin Page
```shell
curl --location 'localhost:8080/admin' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0LnNoYWxhc2gxQGdtYWlsLmNvbSIsImlhdCI6MTczNTg5NTc3NCwiZXhwIjoxNzM1OTEwMTc0fQ.Sfb8jpJJsrf_eM0wor4_-68SmaYo8StTx4EpNbLXbsI'
```