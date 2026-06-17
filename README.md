* ***Purpose of Each Package:***
* **Controller:**
\* Purpose: It manages the API endpoints and handles incoming HTTP requests.

&#x20;  \* Role: It acts as the entry point of the application to receive data from a client and calls the appropriate service logic, and returns the HTTP response.

&#x20;  \* Key Annotations: @RestController, @RequestMapping



&#x20;  **- Service:**
\* Purpose: Manages the API endpoints and handles incoming HTTP requests.

&#x20;  \* Role: It acts as the entry point to the application. It receives data from the client and calls the appropriate service logic and returns the HTTP response (and status codes).

&#x20;  \* Key Annotation: @RestController, @RequestMapping



&#x20;  **- Repository:**
\* Purpose: It manages the data access and communication with the database.

&#x20;  \* Role: It provides CRUD (CREATE, READ, UPDATE, DELETE) capabilities by interacting directly with the data storage layer.



&#x20;  - **Entity:**
\* Purpose: It represents the database schema as Java Objects

&#x20;  \* Role: it calls models, each entity class the maps directly to a specific table in the database, and its field maps to the table columns.

&#x20;  \* Key Annotation: @Entity, @Table



&#x20;  - **DTO:**

&#x20;  \* Purpose: it defines the structure of data that has been sent between each client and the server.

&#x20;  \* Role: It prevents sensitive database entity details from being exposed to the frontend.

&#x20;

&#x20;  - **Config:**

&#x20;  \* Purpose: it contains global configuration classes for the application.

&#x20;  \* Role: It configures the external components, security settings such as Spring Security.

&#x20;  \* Key Annotation: @Configuration, @Bean



&#x20;  -**Exception:**

&#x20;  \* Purpose: It handles error management and global exception interception.

&#x20;  \* Role: It centralises how the application responds to errors. It formats user-friendly error messages and proper HTTP status codes for the client.

&#x20;  \* Key Annotation: @ControllerAdvice, @ExceptionHandler





***1.) What is Spring Boot?***

Spring Boot is a open-source Java framework that is used to create Spring applications much more quickly. It also minimises configurations by providing basic templates that are embedded to a web server.



***2.) What is Maven?***

Maven is project management tool that is used mostly for Java projects. Its purpose is to manage a project's dependencies and documentation that is based on the configuration

***3.) What is the purpose of pom.xml?***
The pom.xml file is a Project Object Model that stores the configuration file for a Maven project. It helps define the project's dependencies, build configuration, metadata, version, plugins that are required to compile and package.

***4.) what is the purpose of application.properties?***
The application.properties file is a file that configures externalised properties for a Spring Boot application. It also provides developers to manage database connection strings, server ports, and logs without making changes to the code.



***5.) What does @SpringBootApplication do?***
It is a annotation that combines three essential properties which are:

* **@EnableAutoConfiguration:** It tells Spring Boot to automatically configure beans based on the classdepth dependencies.

**- @ComponentScan:** It scans the current package and sub-packages for Spring components, services, and controllers.

**- @Configuration:** It enables the Java-based configuration for the Spring context.



***6.) Why do developers use dependency management tools such as Maven?*
-** It downloads and updates external libraries and frameworks automatically.

**-** It ensures a consistent environment across deployment servers and different developer machines.



***7.) What is a REST API?***

* A REST API is a API that is used for designing network applications. It provides a client-server communication protocol that uses standard HTTP methods such as GET, POST, PUT and DELETE.



***8.) What is JSON?***
A JSON is a text-based data interchange format that writes transmit data between a server and a web application.

***9.) What is Dependency Injection?***

It is a design pattern that is used to communicate between classes and their dependencies. This method helps the required dependencies to make the code easier to test.

**--Endpoint:**
  | Method | URL                       | Body                   |

&#x20; |--------|---------------------------|------------------------|

&#x20; | POST   | /api/categories           | { "name": "Grapes }    |

&#x20; | GET    | /api/categories           | - 200 OK               |

&#x20; | GET    | /api/categories/{2}       | - 200 Ok               |

&#x20; | PUT    | /api/categories/{4}      | { "name": "Appetizers"} |

&#x20; | DELETE | /api/categories/{4}      | - 201 No Content       |





