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

### Database Organization

There are two tables named *Survey* and *Answer*.

Fields of **Survey** are:
* TOPIC_ID
* TOPIC
* NPM_SCORE

Fields of **Answer** are:
* SUBMIT_ID
* FEEDBACK
* SCORE
* TOPIC_ID

**Project Configuration** file is *application.properties* at *src/main/resources* path.


### Project Execution

* http://localhost:8080/ URI for Postman,
* http://localhost:8080/h2-console URI for db interface, 
* http://localhost:8080/swagger-ui.html URI for swagger interface.

### Project Deployment

Run terminal at project path, run the command given below:
```
mvn clean install
```
After compile has been done, jar file will be created at target folder in project path. Then, run terminal at target folder, execute jar file with the command given below:
```
java -jar customer-satisfaction-survey-0.0.1-SNAPSHOT.jar
```
After jar file has executed, api can be accessible by http://localhost:8080/ URI.

### Installing

* Import this project to your IDE.
* Configure as Maven Project.
* Run project as Spring Boot App.

## Application and its Usage

### Endpoint of *survey/create*
<img src="https://i.ibb.co/t8Xj4f1/create-survey.png">

### Endpoint of *answer/submit*
<img src="https://i.ibb.co/56JGn7V/submit-answer.png">

### Endpoint of *answer/listByTopic/{topicId}*
<img src="https://i.ibb.co/6FprMVL/list-answers-of-survey.png">

### Endpoint of *survey/list*
This endpoint also gets of calculated NPS of related Surveys given below:

<img src="https://i.ibb.co/2MDMHPb/survey-list.png">

### **Net Promoter Score Calculation**
<img src="https://i.ibb.co/XXZjYL2/NPS.png">


## Acknowledgments

*Additional Tip*: I had to install *lombok.jar* file in Eclipse installation path separately. Because there was a problem of getter, setters. I guess that's about using lombok in the Eclipse version I used.

* Also maybe you may want to add new features to this project(i.e. "question" table addition: *Users->Surveys->Questions->Answers* relation..)
