# Dockerized Leasing Contract Service

### This service provides a restful endpoint to manage a leasing contract.

# Dockerized Service
### This service is based on docker-compose in order to run it, please make sure that you have the following services up and running:

1. Docker Desktop or equivalent on other operating systems.
2. Docker compose.
3. WSL-2 in case you are running from windows os.

for further documentation please have a look at [Docker compose installation guide](https://docs.docker.com/compose/install/)

# Database
## *MySQL is the database used in this application.*


## Database Initialization
#### database initialization happens using spring data jpa, and it creates the schema bases on the classes annotated with `@Entity`

#### for the first time before you run the application make sure that these two properties are set as follows in docker-compose.yml and in application.properties as well in case you are going to run it locally:

`"spring.sql.init.mode": "always"`

`"spring.jpa.hibernate.ddl-auto" : "update"`

#### for consecutive runs change these two properties to:

`"spring.sql.init.mode": "never"`

`"spring.jpa.hibernate.ddl-auto" : "none"`

**make sure that port 3306 is not taken by any other application**


# How to run the service

1. Navigate to the directory where docker-compose.yml exists, it will be under `\leasing-contract-dockerized\docker-compose.yml`
2. Run this command `docker-compose up --build --detach`

After the container starts the endpoint will be available under [localhost:6868](http://localhost:6868)

## OpenAPI could be found here after the application is up and running

OpenAPI: [Default JSON representation](http://localhost:8080/api-docs)

Swagger UI: [Default setup](http://localhost:8080/swagger-ui/index.html)

# How to stop the service

1. Navigate to the directory where docker-compose.yml exists, it will be under `\leasing-contract-dockerized\docker-compose.yml`
2. Run this command `docker-compose down`
