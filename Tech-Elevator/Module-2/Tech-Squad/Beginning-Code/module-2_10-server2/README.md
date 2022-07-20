# 10_ServerSide_APIs_Part_2

Goal of this activity is to finish Server side API so that the application provides full CRUD functionality. 

1. Clone repo to your computer.
2. Open project in IntelliJ.

Implement the following in HotelController.java (HotelController.java is in server folder).

3. Create method to update Reservation
	@RequestMapping(path = "/reservations/{id}", method = RequestMethod.PUT)
4. Create method to delete reservations. Make sure to add the HttpStatus.NO_CONTENT response status.
	@RequestMapping(path = "/reservations/{id}", method = RequestMethod.DELETE)
5. Add validation in Reservation.java class (e.g. @Min, @NotBlank, ...)
6. Make sure the validation added in step 5 is enforced in your controller methods (@Valid).