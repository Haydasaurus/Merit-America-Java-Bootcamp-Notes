# Week 7 Pair Exercises: Cat Cards

## Context

Congratulations on your new job at _HazBro_. You'll be working on their latest project, *Cat Cards*. To facilitate development, the VP in charge of this project split the development staff into three teams: Database, Frontend, and Backend. The VP placed you on the Backend team.

The Frontend team developed their part of the application. However, they need you to provide the data so it works properly. They gave you the following API documentation:

* `GET /api/cards`: Provides a list of all Cat Cards in the user's collection.
* `GET /api/cards/{id}`: Provides a Cat Card with the given ID.
* `GET /api/cards/random`: Provides a new, randomly created Cat Card containing information from the cat fact and picture services.
* `POST /api/cards`: Saves a card to the user's collection.
* `PUT /api/cards/{id}`: Updates a card in the user's collection.
* `DELETE /api/cards/{id}`: Removes a card from the user's collection.

### Cat Card JSON object structure

Here's the JSON object structure for a Cat Card:

```
{
    "id" : an integer that represents this particular card's unique identifier,
    "imgUrl" : "A string containing the full URL to the cat image",
    "fact" : "A string containing a cat fact",
    "caption" : "A string containing the caption for this particular card"
}
```

### Cat Card collection example

Here's an example collection of Cat Cards:

```
[
    {
        "id" : 17,
        "imgUrl" : "https://cat-data.netlify.app/images/orange-and-white-cat-sleeping-in-yellow-blanket-600x600.jpg",
        "fact" : "Cats sleep 70% of their lives.",
        "caption" : "Aww, this reminds me of Lefty! He slept CONSTANTLY."
    },

    {
        "id" : 38,
        "imgUrl" : "https://cat-data.netlify.app/images/gray-cat-with-green-eyes-768x768.jpg",
        "fact" : "People who own cats have on average 2.1 pets per household, whereas dog owners have about 1.6.",
        "caption" : "Bartender, I'll take a Salty *Cat*"
    }
]
```

Once you provide implementation for those endpoints and return properly formatted JSON objects in the agreed-upon schema, the application works.

> Hint: Consider starting with the controller method that provides a new, randomly created card.

### Database

The Database team provided you with a script to create a local database and the DAO files to retrieve the data. You should be able to implement your code without reviewing the implementation details of the DAO files. The interface provides you with enough information to complete your tasks.

### Cat data API

There is a web API that provides you with random cat fact and cat picture data.

You can use `https://cat-data.netlify.app/api/pictures/random` to retrieve the URL of a random cat picture as a JSON object that looks like this:

```
{"file":"https://cat-data.netlify.app/images/cat-with-bananas-527x600.jpg"}
```

Make sure to implement the `RestCatPicService` to call this endpoint and return the data as a `CatPic` object.

You can use `https://cat-data.netlify.app/api/facts/random` to retrieve a random cat fact as a JSON object that looks like this:

```
{
    "status": {
        "verified": true,
        "sentCount": 1
    },
    "type": "cat",
    "deleted": false,
    "_id": "591f9890d369931519ce352d",
    "__v": 0,
    "text": "A cat's tongue has tiny barbs on it.",
    "source": "api",
    "updatedAt": "2020-08-23T20:20:01.611Z",
    "createdAt": "2018-04-20T20:20:02.940Z",
    "used": false,
    "user": "5a9ac18c7478810ea6c06381"
}
```

Make sure to implement the `RestCatFactService` to call this endpoint and return the data as a `CatFact` object.

### Getting started

1. Create a new Postgres database called `catcards`.
2. Run the script `database/catcards.sql` in pgAdmin to set up your database.

    **Note**: You'll see a message that says that the "catcards" table doesn't exist the first time you run the `create` script. You can ignore the message.

3. Launch this project by running it as a Spring Boot application and navigate to `http://localhost:8080`.

