#In class activities (first 45 minute).
###First example, Spring data JPA REST (Person, No Controller).
Here we use in-memory H2 database.
Discuss about spring data JPA REST. For this example we have only domain model and repository (Person). We don't have controller, but still have REST services. Demo POST request and show how data is inserted.

http://localhost:8080/persons, 

If we want to add new search method, we only need to add that method in repository, and REST service is ready.

List<Person> findByLastName(@Param("name") String name);

http://localhost:8080/persons/search/findByLastName?name=Bauer

###Second example, we use data JPA and regular Controller (Customer)
Discuss POST and GET methods provided in Controller.

http://localhost:8080/customers/findByLastName/Hanks

http://localhost:8080/customers

#In Breakout room activities

Create Product domain model with the following attributes:

id, name, description, color, quantity, price.

Add validations in model class.

Students can add more attributes if they want.

Create Repository for Product domain model.

Create Controller for Product domain model. In Controller create methods for CRUD operations.
Create one more method, findByName. Also create appropriate method in Repository.

In Application.java class, on startup, insert 3-5 products in product table.

