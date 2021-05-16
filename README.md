#Task Manager

## Project requirements
* Java 11
* Postgresql 9+
## Configuration
The configuration is defined in */src/main/resources/application.properties*

Database user and password are defined in the following properties: 
`spring.datasource.username=postgres
spring.datasource.password=postgres`

The database must exist for the application to work. The current name used is `task_manager` which can be modified in this property:
`spring.datasource.url=jdbc:postgresql://localhost:5432/task_manager?createDatabaseIfNotExist=true`

By default the application will update or create the schema if it doesn´t exist.
This behaviour can me modified by modifying the following property: `spring.jpa.hibernate.ddl-auto=update`.

## How to build
To generate the runnable *jar* file run the following command:

`gradlew clean build`

This will generate a file under /src/build/libs called *task_manager-0.0.1-SNAPSHOT*

## How to run
The application is generated as a jar file so it can be run as any standard jar.
For example: 
`java -jar task_manager-0.0.1-SNAPSHOT.jar`

This will run the application on port 8080.

## Using the application
By default the application will expose the API documentation under `http://localhost:8080/swagger-ui/`
