
# SECURITY
## Iniciar un servicio de Identity Management con Keycloak

`docker run -d --name start-keycloak -p 9999:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:17.0.0 start-dev`

## Tutorial para configurar una app en keycloak
https://medium.com/devops-dudes/securing-spring-boot-rest-apis-with-keycloak-1d760b2004e


# bootcamp-reactive-subscribers
## Database connection

'spring.r2dbc.password=B00tcamp2022'

## Ejecutar un contenedor cambiando variables de entorno
`docker run -d --name subscribers-prd -p 9093:8080 -e "spring_profiles_active=prd" bootcamp-subscribers:0.0.1`
`docker run -d --name subscribers-prd -p 9093:8080 -e "spring_profiles_active=qas" -e "application_urlApiBlog=http://172.17.0.3:8080/blogs" bootcamp-subscribers:0.0.1`

## Ejecutar comandos dentro de un contenedor
### Mostrar variables de entorno
`docker exec -it subscribers-dev printenv`
### Abrir una sesión de bash
`docker exec -it subscribers-dev /bin/bash`

