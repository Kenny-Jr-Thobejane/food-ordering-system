***Q1. What is JPA? What is Hibernate? How are they related?***

JPA is a specification that defines how the interface interacts with Java ORM.
Hibernate is a framework that provides implementations for a JPA specification. Therefore, the relationship between JPA \& Hibernate is the JPA provides the layout of the project and Hibernate provides the tools you will use.



***Q2. What is the difference between @Entity and @Table?***

The @Entity instructs the JPA that a class maps to a database table.
The @Table lets you customise the specific table name or schema of a database.



***Q3. What is a foreign key? What is @ManyToOne? Give 2 real-world examples***

A foreign key is a secondary data that links to a primary key in another table. A @ManyToOne is a JPA annotation that marks a relationship between multiple child records that belong to one parent.

&#x09;***Examples:***

* Multiple employees that work in one Department.
* Multiple Order items linked to one Order.



***Q4. What does the @JoinColumn(name = 'category\_id') do?***

The annotation is used to define the actual physical foreign key column name in the database table.



***Q5. Why store price as BigDecimal and not double?***

Using a double causes rounding errors due to binary floating-point representation. Therefore, using BigDecimal provides the exact decimal arthimetic numbers required for financial data accuracy.



***Q6. What does FetchType LAZY vs EAGER mean? What is the default for @ManyToOne?***

**LAZY**: Associated data is loaded from the database only when you explicitly call it.

**EAGER:** Associated data is loaded immediately along with the main entity.

**Default**: @ManyToOne defaults to EAGER in JPA.



***Q7. What is the N+1 query problem?***

It occurs when you fetch 1 parent record, and the ORM executes N additional separate queries to fetch related child data for each row.



***Q8. What is dependency injection? Constructor injection vs field injection - which is preferred and why?***
Dependency injection is a design pattern where a framework provides objects their dependencies rather than creating them internally. Constructor Injection passing dependencies through a class constructor. Field Injection using @Autowired directly on class fields. The preferred injection would be a constructor injection is preferred. it allows for immutability (final fields) and easier unit testing without reflection.

***Q9. What does @Required ArgsConstructor (Lombok) do?***

A Lombok annotation that automatically generates a constructor for all final and @NonNull fields

***Q10. What is the role of the SERVICE layer? Why must it be separate from the controller?***
The role of the SERVICE layer is to hold the core business logic, calculations, and transaction boundaries of your applications.

***Q11. Why MUST you validate that categoryId exists before saving a menu?***
So that you can prevent DataIntegerityViolationException database crashes and ensure your application logic respects referential integrity.

***Q12. Difference between save() and saveAndFlush()?***
save() is saves data to the in-memory persistence context; the database commit happens later. saveAndFlush() Forces JPA to send changes to the database immediately during execution.

***Q13. Why write private mapper methods (entity <-> dto)?***
They isolate data transformation logic, keeping your controller and service layers clean and free of repetitive boilerplate code.  

