module.exports = () => {
    const data = {
        "hotels": [
			{
			  "id": 1,
			  "name": "Aloft Cleveland",
			  "address": {
				"id": "44144a78-725b-47bf-9516-fe9a9d65fbb2",
				"address": "1111 W 10th St",
				"address2": "",
				"city": "Cleveland",
				"state": "Ohio",
				"zip": "44113"
			  },
			  "stars": 3,
			  "roomsAvailable": 48,
			  "costPerNight": 274,
			  "coverImage": "aloft-cleveland.webp"
			},
			{
			  "id": 2,
			  "name": "Hilton Cleveland Downtown",
			  "address": {
				"id": "d3e2743c-dbf8-4c08-8b83-b89506e9e0c1",
				"address": "100 Lakeside Ave",
				"address2": "",
				"city": "Cleveland",
				"state": "Ohio",
				"zip": "44114"
			  },
			  "stars": 4,
			  "roomsAvailable": 12,
			  "costPerNight": 287,
			  "coverImage": "hilton-cleveland.webp"
			},
			{
			  "id": 3,
			  "name": "Metropolitan at the 9",
			  "address": {
				"id": "9c62b191-dec8-499d-a12f-4db2502a25d1",
				"address": "2017 E 9th St",
				"address2": "",
				"city": "Cleveland",
				"state": "Ohio",
				"zip": "44115"
			  },
			  "stars": 4,
			  "roomsAvailable": 22,
			  "costPerNight": 319,
			  "coverImage": "metropolitan-cleveland.webp"
			},
			{
			  "id": 4,
			  "name": "The Westin Pittsburgh",
			  "address": {
				"id": "4b1a53f0-3ab9-446a-a77d-31c46b594a3d",
				"address": "1000 Penn Ave",
				"address2": "",
				"city": "Pittsburgh",
				"state": "Pennsylvania",
				"zip": "15222"
			  },
			  "stars": 4,
			  "roomsAvailable": 60,
			  "costPerNight": 131,
			  "coverImage": "westin-pittsburgh.webp"
			},
			{
			  "id": 5,
			  "name": "Hilton Columbus Downtown",
			  "address": {
				"id": "b8665a61-0413-4295-b502-362033156539",
				"address": "401 N High St",
				"address2": "",
				"city": "Columbus",
				"state": "Ohio",
				"zip": "43215"
			  },
			  "stars": 4,
			  "roomsAvailable": 43,
			  "costPerNight": 190,
			  "coverImage": "hilton-columbus.webp"
			},
			{
			  "id": 6,
			  "name": "The Summit A Dolce Hotel",
			  "address": {
				"id": "dd0cea0c-0908-40de-adca-73ca024008f3",
				"address": "5345 Medpace Way",
				"address2": "",
				"city": "Cincinnati",
				"state": "Ohio",
				"zip": "43215"
			  },
			  "stars": 4,
			  "roomsAvailable": 43,
			  "costPerNight": 218,
			  "coverImage": "summit-cincinnati.webp"
			},
			{
			  "id": 7,
			  "name": "Greektown Detroit",
			  "address": {
				"id": "bce5d791-1ef6-4a93-984b-2cd3fbe46ddd",
				"address": "1200 St Antoine St",
				"address2": "",
				"city": "Detroit",
				"state": "Michigan",
				"zip": "48226"
			  },
			  "stars": 4,
			  "roomsAvailable": 75,
			  "costPerNight": 185,
			  "coverImage": "greektown-detroit.webp"
			}
		],
		"reservations": [
			{
			  "id": 423,
			  "hotelID": 1,
			  "fullName": "John Smith",
			  "checkinDate": "10/10/2022",
			  "checkoutDate": "10/12/2022",
			  "guests": 2
			},
			{
			  "id": 550,
			  "hotelID": 1,
			  "fullName": "Sam Smith",
			  "checkinDate": "08/08/2020",
			  "checkoutDate": "08/10/2020",
			  "guests": 4
			},
			{
			  "id": 706,
			  "hotelID": 3,
			  "fullName": "Dave Smith",
			  "checkinDate": "04/15/2021",
			  "checkoutDate": "04/21/2021",
			  "guests": 4
			}
		]
    }
    return data
}
