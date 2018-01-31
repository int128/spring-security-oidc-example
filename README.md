# Spring Security OpenID Connect example

This is an example of OpenID Connect (OIDC) Relying Party (RP) implementation with the followings:

- Spring Boot 2
- Spring Security 5
- Kotlin


## Getting Started

This requires a Keycloak server.

Create a client with the following settings on your Keycloak:

- Client ID: `example`
- Client Protocol: openid-connect
- Access Type: confidential
- Valid Redirect URIs: `http://localhost:8080/*`

Export the following environment variables:

```bash
KEYCLOAK_URI=https://keycloak.example.com
KEYCLOAK_OIDC_CLIENT_ID=example
KEYCLOAK_OIDC_CLIENT_SECRET=your_secret
KEYCLOAK_REALM=your_realm
```

Boot up the app:

```bash
./gradlew bootRun
```
