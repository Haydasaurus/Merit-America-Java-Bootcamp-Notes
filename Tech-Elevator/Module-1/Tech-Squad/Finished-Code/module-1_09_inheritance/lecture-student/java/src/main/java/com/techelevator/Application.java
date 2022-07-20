package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        //place several bids and check is bid valid
        Boolean bidValid;
        bidValid = generalAuction.placeBid(new Bid("Josh", 1));
        System.out.println(bidValid);
        bidValid = generalAuction.placeBid(new Bid("Fonz", 23));
        System.out.println(bidValid);
        bidValid = generalAuction.placeBid(new Bid("Rick Astley", 13));
        System.out.println(bidValid);
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        // Print winning bid
        System.out.println("Winning bidder is: " + generalAuction.getHighBid().getBidder());
        System.out.println("Bid amount is: " + generalAuction.getHighBid().getBidAmount());

        // Create a new buyout auction
        // The rules of a buyout auction automatically end
        // when the buyout price is met
        System.out.println();
        System.out.println("--------------");
        System.out.println("Buyout Auction");
        System.out.println();
        System.out.println();

        Auction BuyoutAuction = new BuyoutAuction("Tech Elevator Travel Mug",55);

        //place several bids and check is bid valid
        bidValid = BuyoutAuction.placeBid(new Bid("Rick Astley", 20));
        System.out.println(bidValid);
        bidValid = BuyoutAuction.placeBid(new Bid("Michael Scott", 30));
        System.out.println(bidValid);
        bidValid = BuyoutAuction.placeBid(new Bid("Dwight Schrute", 20));
        System.out.println(bidValid);
        bidValid = BuyoutAuction.placeBid(new Bid("Ryan Howard", 56));
        System.out.println(bidValid);
        bidValid = BuyoutAuction.placeBid(new Bid("Bob Billy", 60));
        System.out.println(bidValid);

        // Print winning bid
        System.out.println("Winning bidder is: " + BuyoutAuction.getHighBid().getBidder());
        System.out.println("Bid amount is: " + BuyoutAuction.getHighBid().getBidAmount());

        // Create a new reserve auction
        System.out.println();
        System.out.println("--------------");
        System.out.println("Reserve Auction");
        System.out.println();
        System.out.println();

        Auction ReserveAuction = new ReserveAuction("Tech Elevator Hat",80);

        //place several bids and check is bid valid
        bidValid = ReserveAuction.placeBid(new Bid("Ted Mosby", 35));
        System.out.println(bidValid);
        bidValid = ReserveAuction.placeBid(new Bid("Marshall Erickson", 55));
        System.out.println(bidValid);
        bidValid = ReserveAuction.placeBid(new Bid("Barney Stinson", 80));
        System.out.println(bidValid);
        bidValid = ReserveAuction.placeBid(new Bid("Lily Erickson", 60));
        System.out.println(bidValid);
        bidValid = ReserveAuction.placeBid(new Bid("Robin Sherbatsky", 85));
        System.out.println(bidValid);

        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        // Print winning bid
        System.out.println("Winning bidder is: " + ReserveAuction.getHighBid().getBidder());
        System.out.println("Bid amount is: " + ReserveAuction.getHighBid().getBidAmount());

    }
}
