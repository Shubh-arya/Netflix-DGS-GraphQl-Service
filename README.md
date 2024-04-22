# Sample Netflix DGS GraphQL application

This application is a simple demo application to demonstrate how to use Netflix OOS DGS framework to build graphQL
services.

- Service is containing below features currently:
    - Spring Boot 3.2.4
    - Netflix DGS
    - GraphQL Schema
    - Extended Scalars GraphQL
    - Avro sample
    - maven basic plugins
    - Kafka Setup
    - Kafka Producer
    - DGS Extended validation
    - DGS Pagination for GraphQL
## Pending Tasks

- Add Database and JPA
- Liquibase migration set up
- Logger addition for logstash
- Create new service for GraphQL client using Apollo library
- Set up performance test for K6 in local and docker env
- Integration test with Karate and Wiremock
- Retry and DLQ set up 

### Useful Intellij plugins
- Key Promoter X
- Digma Continuous Feedback
- GraphQL
- PlantUml Integration
- Spring Boot Assistant
- tabnine AI support
- Codium AI for test cases
- Ignore
- Atom One them
- FiraCode for font
- Avro Schema Support
- Big Data tools
- Check-style Idea
- Rainbow Brackets
- Sonarlint

### To build a docker image run below command:
```shell
docker build -f ./docker/service.dockerfile -t service .
```
Or build using docker-compose

```shell
docker-compose up -d service
```
### How to run the service

Import the project in IntelliJ and run

or
```shell
mvnw springboot:run
```
