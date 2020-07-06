# Customer Satisfaction Survey

This project is back-end of customer satisfaction survey RESTful Web Service.
It presents surveys, and a repeatedly answerable survey topic, and calculated Net Promoter Score(NPS) of topics.

## Development Environment

Project has developed on **Github** in **Java** language by using **Eclipse** IDE. Also **JDK**, **Maven** for build and **Spring Tool Suite** plugin(Eclipse) required.

### Requirements

* **JDK 1.8**
* **Apache Maven 3.6.3**
* **Spring Boot version is 2.3.1.RELEASE**

### Dependencies Built With

* **Spring Web** (for Service & Controller layers)
* **Spring Data JPA** (JPA/Hibernate for Entity & Repository layers)
* **H2 Database** (inmemory & embedded & portability & fast)
and additionaly;
* **Lombok** (some annotations for simplify getter, setter methods)
* **Swagger** dependency used to getting simple interface for rest and model layers.

### Project Layer Organization

* **Entity** (Domain | Model | DTO)
* **Repository** (DAO/DAOImpl)
* **Service**
* **Controller** (Rest | Endpoint)
* and **Config** (Swagger2 | other-configurations)
* no utility layer.

### Project Execution

* http://localhost:8080/ URI for Postman,
* http://localhost:8080/h2-console URI for db interface, 
* http://localhost:8080/swagger-ui.html URI for swagger interface.

### Project Deployment

Run terminal at project path, run command given below:
```
mvn clean install
```
After compiled file created at target folder in project, run terminal at target folder, execute jar file with the command given below:
```
java -jar customer-satisfaction-survey-0.0.1-SNAPSHOT.jar
```
After jar file has executed, api can be accessible by http://localhost:8080/ URI.
