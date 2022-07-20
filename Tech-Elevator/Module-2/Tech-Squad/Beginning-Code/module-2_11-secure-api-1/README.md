# Securing APIs

## Instructions

In this lecture, you'll continue working with the hotel reservation API server and client application. You'll focus on adding authentication and authorization to both.

The server application has been modified to use JWT authentication, and provide a login endpoint. The client application has been modified to provide an option to log in.

## Running the application

First, import the Hotel Reservations client and server applications into IntelliJ as a Maven projects. Remember to run each application to make sure everything works before adding any new code.

### Login endpoint

With the server application running, open Postman and test the login endpoint. Make a `POST` request to `http://localhost:8080/login` and use the following JSON as the request body. Remember to set body type to "Raw" and "JSON":

```json
{
	"username": "user",
	"password": "password"
}
```

Look at the response received from the request. Your token value won't match the screenshot, because timestamps are encoded in it. (You will use this token later, so copy this token somewhere)

> Keep the login tab open—you'll reuse it later.

### JWT

Copy the token value from the Postman response, open [JWT decoder](https://jwt.io/#debugger-io), and paste in the token on the "Encoded" side. Hover over any field name—except "auth"—and it shows you what the field name stands for. If you hover over a Unix timestamp, it shows you the time in a human-readable format, including your timezone.

### Setting authorization rules

Now you'll set up authorization rules on the server. In the next example, the authorization rule is as follows: anyone that's authenticated—meaning they have a valid JWT token—is authorized to access the resource.

Start the server again if it's not already running. Before adding any authorization rules, verify the `/hotels` and `/hotels/{id}` endpoints again in Postman. It retrieves data like before.

Stop the server and open `HotelController.java`. Add the `@PreAuthorize("isAuthenticated()")` annotation to the `get()` method. The annotation order doesn't matter.

Start the server again and try to request the `/hotels` and `/hotels/{id}` endpoints again. The `/hotels` method still works, but the `/hotels/{id}` endpoint results in a `401 Unauthorized` response. Because no authorization credentials were sent, the server responded with a `401` code.

In Postman, open the "Authorization" tab in the request, change the "Type" dropdown to "Bearer Token", and paste the token you copied earlier in the "Token" field. After you send the request, it returns the data with a `200 OK` response code.

You can verify that the token was passed in the `Authorization` HTTP header by switching to the "Headers" tab. If you don't see the "Authorization" key, click on the "hidden" text to the right of the "Headers" label to reveal all header key-value pairs.

Next, move the `@PreAuthorize("isAuthenticated()")` annotation from the method to the class. Start the server again and verify in Postman that requests to both `/hotels` and `/hotels/{id}` endpoints now require authorization. In fact, all methods in the controller now require authorization.

Imagine that you want authorization on all methods, except the `/hotels` endpoint. To override the class-level rule and allow anonymous—that is, not authenticated—access to the method, add the `@PreAuthorize("permitAll")` annotation to the `list()` method.

Run the server and return to Postman. In the request to `/hotels`, set the authorization type dropdown to "No Auth." The request now returns data again. Please notice that adding an ID, such as `/hotels/2`, without authorization won't work and returns a `401`.

### Role based authorization

First, note that the endpoints work with the token you've been using. Make a `GET` request to the `/reservations` endpoint. 

Then, make a `DELETE` request to `/reservations/{id}` with a valid ID of one of the reservations, such as `/reservations/1`. You'll receive a successful `204 No Content` response.

> You can perform a `GET` request again to see it was deleted. Notice that all data resets when you restart the application.

Return to `HotelController.java` and find the `delete()` method towards the bottom of the class. Add the `@PreAuthorize("hasRole('ADMIN')")` annotation to the method. Restart the server.

This annotation means only users with the "ADMIN" role can access this resource. If you perform the same `DELETE` request in Postman, you'll receive a `403 Forbidden` response.

Because the authorization credentials don't have the "ADMIN" role, they only had the view role.

Return to the login request tab, and change the credentials to `admin/admin`:

```json
{
	"username": "admin",
	"password": "admin"
}
```

Send the request and you'll receive a new token.

Copy and paste the new token into the `DELETE` request, and it succeeds again.

### Getting the current user

There are times where you'll need access to the current logged in user. You have secured the `delete()` method to users with the role `ADMIN`, but what if you wanted to keep an audit log of which user deleted each reservation?

In the `HotelController`, there's a private method called `auditLog()` that logs the operation that was executed, the ID of the reservation, and the username of the logged in user that performed the operation.

You need access to the current logged in user, and Spring gives you that access in your controller methods.

Add a new argument to the method that's of type `Principal` (Spring automatically resolves the argument for you). Call auditLog with the username of the current logged in user.

## Client code

Now, switch over to the client code in the `client` project. If you open `App.java`, you'll find the `handleLogin()` method that calls `authenticationService.login`(). This method makes use of two private static classes: `CredentialsDto` and `TokenDto`. A DTO (Data Transfer Object) is a wrapper class used to facilitate exchanging information with an API. Simple wrapper classes like these that are only used internally are often declared within the class that uses them.

The `CredentialsDto` class is used as a container for sending the username and password to the API. The username and password is serialized into a JSON object as part of the request body.

The `TokenDto` class is used as a container for receiving the token back from the API. The token is deserialized from the JSON in the response body.

If you run the client application without logging in, all methods except the first one, "List Hotels", won't work, and you'll receive a `401` response. Try to get a list of reservations for a hotel (Option 2), and you'll get an error message. Check the log to confirm that a `401` was received (you may need to reload the log file or stop the running application to see the updated log file).

Select option 6 to login and use user/password as the username and password. Select option 2, and you'll now receive a list of hotels from which to pick for its reservations.

While logged in as "user", if you attempt to delete a reservation, you'll receive a `403` response. This is because you need to be logged in as a user with the "ADMIN" role (use the `admin/admin` credentials).

### Hotel Service

After logging in, you were able to list all of the hotels. Now, you'll look at that code.

The `exchange()` method is similar to what you did with the `/login` call, but this time it's a `GET` request:

```java
public Hotel[] listHotels() {
    Hotel[] hotels = null;
    try {
        ResponseEntity<Hotel[]> response = 
            restTemplate.exchange(API_BASE_URL + "hotels", HttpMethod.GET, 
                                  makeAuthEntity(), Hotel[].class);
        hotels = response.getBody();
    } catch (RestClientResponseException | ResourceAccessException e) {
        BasicLogger.log(e.getMessage());
    }
    return hotels;
}
```

Next, you need a way to send the `Authorization: Bearer:` header. Since this needs to be done for multiple requests, it's handled in a separate method called `makeAuthEntity()`: 

```java
private HttpEntity<Void> makeAuthEntity() {
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(authToken);
    return new HttpEntity<>(headers);
}
```

The token is available here because `App` calls the `setAuthToken()` method of the `HotelService` class when you log in.

In the command-line application, try to create a new reservation. You'll see an error message.

If you look at the method `addReservation()` in the `HotelService`, you'll see that it's missing the code needed to add the new reservation. Complete the implementation:

```java
 public Reservation addReservation(Reservation newReservation) {
     Reservation returnedReservation = null;

     //TODO: Add implementation
     BasicLogger.log("HotelService.addReservation() has not been implemented");

     return returnedReservation;
 }
```

## References

- [JWT decoder](https://jwt.io/#debugger-io)
- [Pre Authorize Annotation](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#el-pre-post-annotations)
- [SpEL](https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#expressions)
