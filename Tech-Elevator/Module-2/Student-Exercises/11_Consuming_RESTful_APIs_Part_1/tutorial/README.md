# Web Services GET tutorial (Java)

In this tutorial, you'll work on a command-line application that displays meetup locations. The command-line application is partially complete. You'll write the remaining functionality.

Once the application is running, you'll need to call a web API to both get a list of locations and the details for a single location.

## Step One: Start the server

Before you start, you need to ensure that the web API is up and running. You need to change directories into the `./server/` folder.

Next, from the command line, run the command `npm install` to install any dependencies. You won't need to do this on any subsequent run.

While still in the command line, run the command `npm start` to start the json-server application. If there aren't any errors, you'll see the following, which means that you've successfully set up your web API:

```
Resources
http://localhost:3000/locations
```

```
 \{^_^}/ hi!

  Loading ./locations.json
  Done

  Resources
  http://localhost:3000/locations

  Home
  http://localhost:3000

  Type s + enter at any time to create a snapshot of the database
  Watching...
```

When json-server is running on port 3000, no other applications—including other copies of json-server—are able to use port 3000. To free up the port, be sure to stop json-server when you're finished with this tutorial. You do that by selecting the terminal where you typed `npm start` and pressing `Ctrl+C`. Or if you've already closed that terminal, open a new terminal and type:

```
taskkill -T -F -IM node.exe
```

## Step Two: Explore the API

Before moving on to the next step, explore the web API using Postman. You can access the following endpoints:

- GET: http://localhost:3000/locations
- GET: http://localhost:3000/locations/{id}

## Step Three: Review the starting code

### Data model

There's a class in `model/Location.java` that represents the data model for a location object.

### Provided code

In the `App.java` file, you'll find references to two classes:

```java
private final ConsoleService consoleService = new ConsoleService();
private final LocationService locationService = new LocationService();
```

The `ConsoleService` class handles printing to the console and retrieving user input. The `LocationService` class handles interacting with the web API to retrieve data.

### Your code

You'll place your code in `App.java` or in `services/LocationService.java`.

## Step Four: Run the console application

If you run the application, you'll see the following output in the console:

```
----Meetup Locations Menu----
1: List Locations
2: Show Location Details
0: Exit

Please choose an option:
```

The `printMainMenu()` method in the `ConsoleService` prints the menu and the `promptForMenuSelection()` method retrieves the user's input. When the user makes a selection, it's stored in the `menuSelection` variable. You'll need to handle the menu selections for listing all locations and getting the details of a single location.

## Step Five: List all locations

If the user selects `1`, you need to list all locations returned from the web API. Open `LocationService` and find the method `getAll()`:

```java
public Location[] getAll() {
    //Step Five: List all locations
    return null;
}
```

Before you make a call to the web API to get a list of locations, you need to know the URL of the service.

This is stored in a constant in the `LocationService`:

```java
private static final String API_BASE_URL = "http://localhost:3000/locations/";
```

Next, you'll create a new instance of the `RestTemplate`. This is the class that you'll use to perform a `GET` request to the web API.

You could create this in the `getAll()` method, but you'll need this elsewhere, so it's better to create an instance variable at the class level:

```java
private final RestTemplate restTemplate = new RestTemplate();
```

You can use the `RestTemplate`'s `getForObject()` method to perform a `GET` request to the web API. This method takes the URL of the API and the response type:

```java
public Location[] getAll() {
    return restTemplate.getForObject(API_BASE_URL, Location[].class);
}
```

Next, return to `App.java` and locate the `handleListLocations()` method that's called when the user selects `1`. You can call the method you completed in the `LocationService` class to get an array of locations, and the `ConsoleService` class has a method that handles printing an array of locations to the console:

```java
private void handleListLocations() {
    Location[] locations = locationService.getAll();
    consoleService.printLocations(locations);
}
```

If you run the application, you'll see this:

```
----Meetup Locations Menu----
1: List Locations
2: Show Location Details
0: Exit

Please choose an option: 1
--------------------------------------------
Locations
--------------------------------------------
1: Baker Electric Building
2: Rev1 Ventures
3: HCDC Business Center
4: House of Metal
5: TechTown Detroit
6: Duane Morris Plaza
```

## Step Six: Get location details

Back in `App.java`, when the user selects menu option `2`, you need to perform these tasks:

1. Display a list of locations to the user and ask them to select one.
2. Read in the ID of the location.
3. Pass the ID to the `LocationService`'s `getOne()` method.

You can retrieve the locations the same way you did in Step Five and pass them to the `printLocationMenu()` method in the `ConsoleService` class to display them as a menu. Then, call the `promptForMenuSelection()` method in the `ConsoleService` class which returns the user's selection.
Once you have the location ID, you can pass that to the `getOne()` method in the `LocationService` class to get the details for a single location:

```java
private void handleShowLocationDetails() {
    Location[] locations = locationService.getAll();
    consoleService.printLocationMenu(locations);
    int locationId = consoleService.promptForMenuSelection();
    if (locationId > 0) {
        Location location = locationService.getOne(locationId);
        consoleService.printLocation(location);
    }
}
```

Next, open the `LocationService` class and locate the `getOne()` method which currently returns null. You can use the `getForObject()` method that you previously used, but with two differences.

First, you need to call your web API with the base URL and the ID appended. Next, the response type is a `Location.class`:

```java
public Location getOne(int id) {
    return restTemplate.getForObject(API_BASE_URL + id, Location.class);
}
```

> If you had a chance to test the API in Postman, you know that calling `/locations/1` returns the location data for the Baker Electric Building.

If you run the application, you'll see this:

```
----Meetup Locations Menu----
1: List Locations
2: Show Location Details
0: Exit

Please choose an option: 2
--------------------------------------------
Locations
--------------------------------------------
1: Baker Electric Building
2: Rev1 Ventures
3: HCDC Business Center
4: House of Metal
5: TechTown Detroit
6: Duane Morris Plaza
0: Exit

Please choose an option: 1

--------------------------------------------
Location Details
--------------------------------------------
Id: 1
Name: Baker Electric Building
Address: 7100 Euclid Ave
City: Cleveland
State: OH
Zip: 44103
```

## Summary

In this tutorial, you learned:

- How to make an HTTP GET request using Postman and inspect the result
- How to make an HTTP GET request to a RESTful web service using Java process the response
- How to convert a single JSON object into a Java Object
- How to convert an array of JSON objects into an array of Java Objects

### Don't forget to stop json-server

When you're done with the tutorial, remember to stop json-server. Directions are under Step One.
