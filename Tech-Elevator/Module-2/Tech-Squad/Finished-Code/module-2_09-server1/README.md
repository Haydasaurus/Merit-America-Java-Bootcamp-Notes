**Overview**

- Import existing project into IntelliJ
  - Run the Project
- Models
  - Hotel
  - Address
  - Reservation
- DAOs

**Implement the following in HotelController.java**

- list all reservations
  - path: /reservations
  - request method: `GET`
  - return: list of all reservations in the system
- get reservation by id
  - path: /reservations/{id}
  - request method: `GET`
  - return: reservation info for given id using path variable
- list all reservations by hotel
  - path: /hotels/{id}/reservations
  - request method: `GET`
  - return: list of all reservations in the system by hotel
- add new reservation
  - path: /reservations
  - request method: `POST`
  - add a new reservation based on the request body
- filter hotels
  - path: /hotels/filter?state={state}&city={city}
  - request method: `GET`
  - find hotels by state and city (optional)

  
- Finally, connect the client to the API

