You can either implement each method and then start the application, or look the effect of each change by restarting the application after each one.

## Starting code

The starting code should look familiar to the tutorial. The only difference here is the domain model.

### `App.java`

Start by walking through the starting code in `App.java`.

There are private variables to refer to instances of the `ConsoleService` and `HotelService` classes. You have already seen the `ConsoleService` class in the tutorial, it writes to the console and retrieves user input.

The `HotelService` class encapsulates all of the requests to the web API.

```java
ConsoleService consoleService = new ConsoleService();
HotelService hotelService = new HotelService();
```

You'll update the `while` loop in the `run` method throughout the code; specifically, you'll replace the `System.out.println` for menu options 1-6.

### Hotel service

Open the `HotelService` class.

Run the web API locally, which you can find int eh server folder. The HotelService class declares a constant named `API_BASE_URL` pointing to the root URL:

```java
private static final String API_BASE_URL = "http://localhost:3000/";
```

> Note: the URL has path and query parameters appended as necessary.

A new `RestTemplate` has been instantiated for you and stored in the instance variable `restTemplate`. `RestTemplate` makes HTTP requests and deserializes the returned JSON response into an object:

```java
private RestTemplate restTemplate = new RestTemplate();
```

## List hotels

Implement a method that's used for the _List Hotels_ menu option.

Find the `if()` statement for option `1`. In that `if` block, call your new method and print the hotels.

## List reviews

Create a similar method to call the API for a list of reviews. 

Now implement the `if else` for option `2` to print the reviews.

## Get hotel by ID

You can query a specific `Hotel` by appending the hotel's ID as a path parameter. The `getHotelById()` method
accepts a single `int` parameter that's the ID of the hotel to request. Create the URL by concatenating it with the correct URL.

Now implement the `if else` for option `3` to print the individual hotel.

## List reviews by hotel

URL paths can be used to show relationships. The next method requests reviews related to a specific hotel.

You'll pass the hotel ID into the method, and create a URL string to access the reviews. The `getReviewsByHotelId()` method accepts a single integer parameter that's the ID of the hotel. Implement the method using a URL like this:

```java
API_BASE_URL + "hotels/" + id + "/reviews"
```

Now implement the `if else` for option `4` to print the list of reviews for hotels with an ID of `1`.

## Get hotels by star rating

In the next method `getHotelsByStarRating`, accept an integer that represents a star rating. Then query for a filtered list of hotels that have a star rating equal to the parameter, using a query string:

```java
API_BASE_URL + "hotels?stars=" + stars
```

Now implement the `if else` for option `5` that queries for a star rating of `5`.



