# Event Handlers Exercise

In this exercise, you'll build on the shopping list exercise that you've been working on. You can find the starting code for this exercise and the automated tests in the `shopping-list` directory.

## Exercise

In `js/shopping-list.js` there are three variables declared for you:

* **allItemsIncomplete:** You'll use this later.
* **pageTitle:** The title of the page.
* **groceries:** An array of groceries that's displayed in your shopping list.

There are also two methods declared for you:

* **setPageTitle()**: Sets `pageTitle` to the `h1` element on the page.
* **displayGroceries()**: Assigns `groceries` to the `ul` element on the page.

This application is similar to a previous exercise you worked on.

### Event listener

Right now the `setPageTitle()` and `displayGroceries()` methods aren't called. There is an event you can listen for where these are best suited to run from. Create an event listener for this special event and place the two methods inside of it. This is also where the rest of your code must go.

### Mark item complete

When a user clicks on an item in the shopping list, you must mark the item complete. To do so, add the `completed` class to the list item and the icon. You must check the item to make sure it doesn't already have the completed class. There is no sense in performing your logic on an item that's already complete.

### Mark item incomplete

When a user double clicks on an item in the shopping list, you must mark the item incomplete. To do so, remove the `completed` class to the list item and the icon. You must check the item to make sure it has the completed class. There is no sense in performing your logic on an item that isn't completed.

### Toggle all

When your application loads, all of the items are incomplete, and the button on the page says 'Mark All Complete'. When a user clicks this button, you must mark all of the items in the list complete. The button's text must also switch to say 'Mark All Incomplete'. When a user clicks the button again, you must mark all of the items in the list incomplete.

> Hint: You can use the variable `allItemsIncomplete` to track the current state of the button. Whenever you mark all items complete or incomplete, make sure to update this variable to keep track of where you are.

> Note: The labels "Mark All Complete" and "Mark All Incomplete" are case sensitive. If you don't type them exactly as they appear in the exercise notes, your tests won't pass.

## Tests

If you haven't done so already, run `npm install`. This installs any dependencies that you need to run your tests. Once you've completed this step, run the tests using this command:

```
npm run test
```

The tests are in `cypress/integration/shopping-list.spec.js`:

* Must have a title of "My Shopping List"
* Must have 10 items on the shopping list
* Each item in the list must not have the class `completed` until clicked
* Each item in the list that's completed can be double-clicked and marked incomplete
* Clicking on the 'Mark All Complete' button must set all items to complete
* Clicking on the 'Mark All Incomplete' button must set all items to incomplete
