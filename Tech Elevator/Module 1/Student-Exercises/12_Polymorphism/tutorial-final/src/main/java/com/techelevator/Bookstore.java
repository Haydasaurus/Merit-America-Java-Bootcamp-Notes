package com.techelevator;

/**
 * Bookstore
 */
public class Bookstore {

    public static void main(String[] args) {
        System.out.println("Welcome to the Tech Elevator Bookstore");

        // Create a book object using the default constructor. Then set the book's properties
        Book twoCities = new Book();
        twoCities.setTitle("A Tale of Two Cities");
        twoCities.setAuthor("Charles Dickens");
        twoCities.setPrice(14.99);

        // Create two more book object and set their properties using a constructor
        Book threeMusketeers = new Book("The Three Musketeers", "Alexandre Dumas", 12.95);
        Book childhoodEnd = new Book("Childhood's End", "Arthur C. Clark", 5.99);

        // Add all three books to the shopping cart and print a receipt
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(twoCities);
        shoppingCart.add(threeMusketeers);
        shoppingCart.add(childhoodEnd);

        // Add some new movies and purchase them
        Movie toyStory = new Movie("Toy Story", "G", 81, 19.99);
        shoppingCart.add(toyStory);

        // Shirley, you can't be serious!
        Movie airplane = new Movie("Airplane!", "PG", 88, 14.99);
        shoppingCart.add(airplane);

        // Have a cuppa jo!
        Coffee myCoffee = new Coffee("Extra-large", "Dark Roast", new String[] {"Creme"}, 3.99);
        Coffee myFriendsCoffee = new Coffee("Medium", "House Blend", new String[]{"Soy milk", "Sugar"}, 2.79);
        shoppingCart.add(myCoffee);
        shoppingCart.add(myFriendsCoffee);

        System.out.println(shoppingCart.receipt());
    }
}
