# Customer Satisfaction Survey

This project is back-end of customer satisfaction survey Restful Web Application.
It presents surveys, and a repeatedly answerable survey topic, and calculated Net Promoter Score(NPS) of topics.

## Development Environment

Project developed on **Github** in **Java** language by using **Eclipse** IDE. Also **JDK**, **Maven** for build and **Spring Tool Suite** plugin(Eclipse) required.

### Requirements

* **JDK 1.8**
* **Apache Maven 3.6.3**
* **Spring Boot version is 2.3.1.RELEASE**

### Dependencies Built With

* **Spring Web** (for Service & Controller layers)
* **Spring Data JPA** (for Entity & Repository layers)
* **H2 Database** (inmemory & embedded & portability & fast)
and additionaly;
* **Lombok** (some annotations for simplify getter, setter methods)
* **Swagger** dependency used to getting simple interface for rest and model layers.

### Project Layer Organization

* **Entity** (Domain | Model | DTO)
* **Repository** (DAO)
* **Service** (DAOImpl)
* **Controller** (Rest | Endpoint)
* and **Config** (Swagger2 | other-configurations)
* no utility layer.
