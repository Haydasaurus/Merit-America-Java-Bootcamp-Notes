# 08_Consuming_RESTful_APIs_Part_2

1. Clone repo to your computer.
2. Open project in IntelliJ.

## Add reservation

Open `App.java` and look at the `handleAddReservation()` method. This is where a user can add a new reservation. The console service prompts the user for reservation data in the form of a comma separated value (CSV) string, and creates a `Reservation` object from it. You'll pass that object to the `hotelService.addReservation()` method:

You'll first walk through completing the `hotelService.addReservation()` method. There are several aspects of this method to focus on.

The first is that you're using the method `postForObject()` on the `RestTemplate` where previously you used `getForObject()`.

Secondly, you create a new `HttpEntity`. As mentioned in the book, an `HttpEntity` represents an HTTP request or response entity, consisting of headers and a body.

The last thing is the exception handling. The `RestClientResponseException` allows you to catch common exceptions that include status codes, like 401 (Unauthorized), 404 (Not Found) or a general server exception (500). The `ResourceAccessException` occurs if the server can't be reached. You can mimic that by shutting down the API server during the demo:


After you've completed this method, run the application, add a new reservation to an existing hotel, and verify that it was added. You might also want to show the exception handling here. Try doing something with the server stopped.

Note that the `BasicLogger` is used to write information on errors that occur to a log file in the `logs` folder. This is a common way to report problems from a class that doesn't directly interact with the user.

## Update reservation

In `App.java`, look at the `handleUpdateReservation()` method. This is where a user can update an existing reservation. There are some checks along the way to make sure you pass a valid reservation to the `hotelService.updateReservation()` method:


Updating a reservation in the `HotelService` is similar to adding a new one but with two changes. You use the `put()` method on the `RestTemplate`, and you need to pass the ID of the reservation you're changing as part of the URL:


Note that the `put` method of `RestTemplate` doesn't return a value, so a `boolean` is returned by this method to let the caller know if it completed successfully or not.

After you've completed the method, run the application, update an existing reservation, and verify that the changes were saved.

## Delete reservation

In `App.java`, look at the `handleDeleteReservation()` method. This is where a user can delete an existing reservation:


The `DELETE` method differs from the `POST` and `PUT` method in that you don't need to create an `HttpEntity` because you aren't sending anything in the request body.

To perform a `DELETE` request, use the `delete()` method in `RestTemplate`. Like the `PUT` operation, you'll pass the ID of the reservation as part of the path in the URL:


After you've completed the method, run the application, delete an existing reservation, and verify the changes were saved. You can try and delete a reservation with an ID that doesn't exist and see the 404 status error in the log.

This is a good opportunity to add a breakpoint and step debug the application so you can see what's going on. Make sure to inspect the `RestClientResponseException`.
