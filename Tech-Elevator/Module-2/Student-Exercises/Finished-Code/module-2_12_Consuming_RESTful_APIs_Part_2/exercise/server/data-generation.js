module.exports = () => {
    var faker = require("faker");

    const data = { auctions: [] }

    //hard-code these details so they're the same, use faker for start/end date so it's current when run
    const products = [
        {
            "id": 1,
            "title": "Bell Computer Monitor",
            "description": "4K LCD monitor from Bell Computers, HDMI & DisplayPort",
            "user": "Queenie34",
            "currentBid": 100.39
        },
        {
            "id": 2,
            "title": "Pineapple Smart Watch",
            "description": "Pears with Pineapple ePhone",
            "user": "Miller.Fahey",
            "currentBid": 377.44
        },
        {
            "id": 3,
            "title": "Mad-dog Sneakers",
            "description": "Soles check. Laces check.",
            "user": "Cierra_Pagac",
            "currentBid": 125.23
        },
        {
            "id": 4,
            "title": "Annie Sunglasses",
            "description": "Keep the sun from blinding you",
            "user": "Sallie_Kerluke4",
            "currentBid": 69.67
        },
        {
            "id": 5,
            "title": "Byson Vacuum",
            "description": "Clean your house with a spherical vacuum",
            "user": "Lisette_Crist",
            "currentBid": 287.73
        },
        {
            "id": 6,
            "title": "Fony Headphones",
            "description": "Listen to music, movies, games and not bother people around you!",
            "user": "Chester67",
            "currentBid": 267.38
        },
        {
            "id": 7,
            "title": "Molex Gold Watch",
            "description": "Definitely not fake gold watch",
            "user": "Stuart27",
            "currentBid": 188.39
        }
    ];

    for (let i = 0; i < products.length; i++) {
        var newItem = {
            id: i + 1,
            title: products[i].title,
            description: products[i].description,
            user: products[i].user,
            currentBid: products[i].currentBid,
            startDate: faker.date.recent(5),
            endDate: faker.date.recent(-5)
        };
        // console.log(newItem);
        data.auctions.push(newItem);
    }
    return data;
  }
