package com.techelevator.auctions.services;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

@RunWith(MockitoJUnitRunner.class)
public class AuctionServiceTest {

    private static final String EXPECTED_API_URL = "http://localhost:3000/auctions/";
    private final Auction[] expectedAuctions = {new Auction(0, "Zero", "Zero Auction", "User0", 0.0),
            new Auction(1, "One", "One Auction", "User1", 1.1)};
    private final Auction expectedAuction = new Auction(0, "Zero", "Zero Auction", "User0", 0.0);

    @Mock
    private RestTemplate mockRestTemplate;

    @InjectMocks
    private AuctionService sut;


    @Test
    public void getAllAuctions_returns_all_auctions() {
        // Arrange
        when(mockRestTemplate.getForObject(eq(EXPECTED_API_URL), eq(Auction[].class)))
                .thenReturn(expectedAuctions);

        // Act
        Auction[] actualAuctions = sut.getAllAuctions();

        // Assert
        assertArrayEquals("The API was not called correctly", expectedAuctions, actualAuctions);
    }

    @Test
    public void getAuction_returns_auction_with_specified_id() {
        // Arrange
        when(mockRestTemplate.getForObject(eq(EXPECTED_API_URL + "1"), eq(Auction.class)))
                .thenReturn(expectedAuction);

        // Act
        Auction actualAuction = sut.getAuction(1);

        // Assert
        assertEquals("The API was not called correctly", expectedAuction, actualAuction);
    }

    @Test
    public void getAuctionsMatchingTitle_returns_correct_auctions() {
        // Arrange
        when(mockRestTemplate.getForObject(eq(EXPECTED_API_URL + "?title_like=Zero"), eq(Auction[].class)))
                .thenReturn(expectedAuctions);

        // Act
        Auction[] actualAuctions = sut.getAuctionsMatchingTitle("Zero");

        // Assert
        assertArrayEquals("The API was not called correctly", expectedAuctions, actualAuctions);
    }

    @Test
    public void getAuctionsAtOrBelowPrice_returns_correct_auctions() {
        // Arrange
        when(mockRestTemplate.getForObject(eq(EXPECTED_API_URL + "?currentBid_lte=23.25"), eq(Auction[].class)))
                .thenReturn(expectedAuctions);

        // Act
        Auction[] actualAuctions = sut.getAuctionsAtOrBelowPrice(23.25);

        // Assert
        assertArrayEquals("The API was not called correctly", expectedAuctions, actualAuctions);
    }

}
