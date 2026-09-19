# Workshop: Jakarta Security 4.0 vs Spring Security 7: The Ultimate 2026 Guide

Companion code for the post `jakarta-security-4-vs-spring-security-7`: the same secured API in two stacks.

| Folder | Stack | What it shows |
|--------|-------|---------------|
| `spring-security/` | Spring Boot 4, Spring Security 7 | `SecurityFilterChain`, JWT resource server (`application.yml` issuer) |
| `jakarta-security/` | Jakarta EE 11 (Jakarta Security 4.0) | `@OpenIdAuthenticationMechanismDefinition`, `@RolesAllowed`, MicroProfile JWT config and `@Claim` injection |

## Requirements
- `spring-security/`: JDK 25, Maven 3.9+.
- `jakarta-security/`: JDK 21+, Maven 3.9+, and a Jakarta EE 11 runtime that also provides MicroProfile JWT (for example Payara 7, Open Liberty, WildFly). The runtime is not chosen here.

## Build
```bash
cd spring-security  && mvn verify
cd jakarta-security && mvn package     # produces target/jakarta-security-4-demo.war
```

## Notes
- The issuer URL `auth.enterprise.com` comes from the post and is a placeholder. Point it at your own identity provider; nothing here can authenticate against it.
- Spring: the post uses `oauth2.jwt()`; this code uses `oauth2.jwt(Customizer.withDefaults())`, the form current Spring Security expects. The post's `/api/admin` endpoint is added as `ApiController`.
- Jakarta: the client secret must come from configuration (environment variable), never from the repository.

Status: written but not yet built, run or deployed. Boot 4.0.0 / Jakarta EE 11 artifact versions are from memory.
