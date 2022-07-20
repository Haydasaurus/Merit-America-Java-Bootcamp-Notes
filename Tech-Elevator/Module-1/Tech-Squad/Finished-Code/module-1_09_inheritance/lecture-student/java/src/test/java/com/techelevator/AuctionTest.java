package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuctionTest {

	@Test
	public void high_bid_starts_at_zero() {
		Auction theAuction = new Auction("The Thing");
		assertEquals(0, theAuction.getHighBid().getBidAmount());
	}

	@Test
	public void keeps_track_of_high_bid() {
		Auction theAuction = new Auction("The Thing");
		theAuction.placeBid(new Bid("Kermit", 100));
		theAuction.placeBid(new Bid("Miss Piggy", 150));
		theAuction.placeBid(new Bid("Fozzie", 125));

		assertEquals("Miss Piggy", theAuction.getHighBid().getBidder());
		assertEquals(150, theAuction.getHighBid().getBidAmount());
	}

	@Test
	public void returns_all_bids_in_order_placed() {
		Auction theAuction = new Auction("The Thing");
		theAuction.placeBid(new Bid("Kermit", 100));
		theAuction.placeBid(new Bid("Miss Piggy", 150));
		theAuction.placeBid(new Bid("Fozzie", 125));

		List<Bid> bids = theAuction.getAllBids();

		assertEquals("Wrong number of bids", 3, bids.size());
		assertEquals("Kermit", bids.get(0).getBidder());
		assertEquals(100, bids.get(0).getBidAmount());
		assertEquals("Miss Piggy", bids.get(1).getBidder());
		assertEquals(150, bids.get(1).getBidAmount());
		assertEquals("Fozzie", bids.get(2).getBidder());
		assertEquals(125, bids.get(2).getBidAmount());
	}

	@Test
	public void first_bid_placed_wins_in_case_of_tie() {
		Auction theAuction = new Auction("The Thing");
		theAuction.placeBid(new Bid("Kermit", 100));
		theAuction.placeBid(new Bid("Miss Piggy", 100));
		assertEquals("Kermit", theAuction.getHighBid().getBidder());
		assertEquals(100, theAuction.getHighBid().getBidAmount());

	}
}
