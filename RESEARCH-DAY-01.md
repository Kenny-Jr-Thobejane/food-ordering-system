RESEARCH-DAY-01



***Q1. What does CRUD stand for?***
C - Create
R - Read

U - Update

D - Delete



CRUD is used as a basic operation that manages data inside a database or application.



***Q2. Difference between HTTP methods POST, PUT, PATCH, DELETE?:*
POST**: It is used to create brand-new message body by sending the same request twice which creates two separate records.

**PUT:** It replaces an existing record. which you must send a new message.

**PATCH:** provides updates to the message sent when sending specific fields that require change.

**DELETE:** To remove a record or message permanently from the system.



***Q3. Correct HTTP status codes:***

**a.)** 201 created
**b.)** 200 ok

**c.)** 404 Not Found

**d.)** 400 Bad Request

**e.)** 403 Forbidden

***Q4. Difference between @RequestBody, @RequestParam, @PathVariable:*
@RequestBody:** It reads data from the main body of the HTTP request.

**@RequestParam:** It collects the data from the URL query after the ? sign.

**@PathVarible:** It extracts the data directly out of the URL itself.


***Q5. What is Jakarta Bean Validation? Explain @Valid, @NotBlank, @Size:
\** A @Valid** acts as a trigger that tells the system to do a validation inside the object.
\* **A @NotBlank** makes sure a text field is not null by containing at least more than 1 character that is not a blank space.

\* **A @Size** restricts the length of a string or the size of a collection to stay between a defined minimum and maximum value.


***Q6. Why return a DTO and not the entity itself?:***
\* For security and privacy, it contains sensitive database columns such as hashed passwords  that should not expose the client.

***Q7***. ***What is Optional<T>? Why does fundById return Optional?***

Optional<T> is a container which represents a value that might either exist or empty. Therefore, ById will return Optional because the application cannot guarantee that the requested exists in the database. 



