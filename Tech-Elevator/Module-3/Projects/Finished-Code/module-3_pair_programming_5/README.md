React Pair Programming Assignment 3

Earlier you built a Spring application that used REST API to create Catcards in pair-programming assignment 3 for module 2. Now we are going to build a robust UI in React to pair with our Spring app.

******************************* SPECS **********************************************************

1. A Cat Card display at the top of the page that will call the "/random" API path from the REST Controller to get a new cat image everytime the application is loaded or refreshed.

2. An input box just underneath the Cat Card display that the user will use to type their own caption onto the Cat Card. 

3. Two buttons should go underneath the Cat Card display. One should be labeled "Add to collection" and will add the Cat Card in the display to the user's collection. The second button should be labeled "Get next card" and should generate a new Cat Card in the display.

4. You need to add the collection display below the Cat Card display and buttons. This should allow the user to scroll down in the app to see all of their Cat Card.

5. Each Cat Card in the collection should have two buttons. One should be labeled "Delete" and should erase the Cat Card from the collection and the other should be labeled "Edit" and should allow the user to edit the Caption and CatFact on the Cat Card.



QUICK NOTE: The React app will be running on port 3000 and the Spring app will be running on port 8080. This will cause an issue when trying make calls for the REST API to the Spring side from the React side. This is caused by CORS (Cross Origin Resource Sharing) and can be remedied by @CrossOrigin annotation in Spring (See online Spring documentation for more details).
