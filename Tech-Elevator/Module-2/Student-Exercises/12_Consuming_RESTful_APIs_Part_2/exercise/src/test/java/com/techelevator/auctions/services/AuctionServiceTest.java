package com.techelevator.auctions.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

@RunWith(MockitoJUnitRunner.class)
public class AuctionServiceTest {

    private static final String EXPECTED_API_URL = "http://localhost:3000/auctions/";
    private static final RestClientResponseException REST_CLIENT_RESPONSE_EXCEPTION =
            new RestClientResponseException("This is a RestClientResponseException", 0, "Testing", null, null, null);
    private static final ResourceAccessException RESOURCE_ACCESS_EXCEPTION =
            new ResourceAccessException("This is a ResourceAccessException");

    @Mock
    private RestTemplate mockRestTemplate ;

    @InjectMocks
    private AuctionService sut;


    @Test
    public void add_should_return_new_auction() {
        // Arrange
        Auction newAuction = new Auction(0, "a", "b", "c", 99.99);
        Auction expectedAuction = new Auction(3, "a", "b", "c", 99.99);

        when(mockRestTemplate.postForObject(
                Mockito.eq(EXPECTED_API_URL),
                Mockito.eq(makeEntityHelper(newAuction)),
                Mockito.eq(Auction.class)))
                .thenReturn(expectedAuction);

        // Act
        Auction actualAuction = sut.add(newAuction);

        // Assert
        assertEquals("auctionService.add() should call the API and return the newly created auction", expectedAuction, actualAuction);
    }

    @Test
    public void add_should_return_null_for_failure_response_code() {
        // Arrange
        when(mockRestTemplate.postForObject(
                Mockito.eq(EXPECTED_API_URL),
                any(HttpEntity.class),
                Mockito.eq(Auction.class)))
                .thenThrow(REST_CLIENT_RESPONSE_EXCEPTION);

        // Act
        Auction actualAuction = sut.add(new Auction());

        // Assert
        assertNull("auctionService.add() should return null when RestTemplate throws a RestClientResponseException",actualAuction);
        // Since the provided method stub returns null, only let the test pass if the API was called.
        verify(mockRestTemplate, description("auctionService.add() didn't call the API correctly"))
                .postForObject(eq(EXPECTED_API_URL), any(HttpEntity.class), eq(Auction.class));
    }

    @Test
    public void add_should_return_null_for_communication_failure() {
        // Arrange
        when(mockRestTemplate.postForObject(
                Mockito.eq(EXPECTED_API_URL),
                any(HttpEntity.class),
                Mockito.eq(Auction.class)))
                .thenThrow(RESOURCE_ACCESS_EXCEPTION);

        // Act
        Auction actualAuction = sut.add(new Auction());

        // Assert
        assertNull("auctionService.add() should return null when RestTemplate throws a ResourceAccessException",actualAuction);
        verify(mockRestTemplate, description("auctionService.add() didn't call the API correctly"))
                .postForObject(eq(EXPECTED_API_URL), any(HttpEntity.class), eq(Auction.class));
    }

    @Test
    public void update_should_return_true_after_updating() {
        // Arrange
        Auction updatedAuction = new Auction(9, "q", "w", "e", 11.11);
        HttpEntity<Auction> entity = makeEntityHelper(updatedAuction);
        Mockito.doNothing().when(mockRestTemplate).put(
                Mockito.eq(EXPECTED_API_URL + "9"),
                Mockito.eq(entity));

        // Act
        boolean result = sut.update(updatedAuction);

        // Assert
        assertTrue("auctionService.update() should return true after updating auction", result);
        verify(mockRestTemplate, description("auctionService.update() didn't call the API correctly"))
                .put(eq(EXPECTED_API_URL + "9"), eq(entity));
    }

    @Test
    public void update_should_return_false_for_failure_response_code() {
        // Arrange
        Auction updatedAuction = new Auction(9, "q", "w", "e", 11.11);
        Mockito.doThrow(REST_CLIENT_RESPONSE_EXCEPTION).when(mockRestTemplate).put(
                Mockito.eq(EXPECTED_API_URL + "9"),
                any(HttpEntity.class));

        // Act
        boolean result = sut.update(updatedAuction);

        // Assert
        assertFalse("auctionService.update() should return false when RestTemplate throws a RestClientResponseException", result);
        verify(mockRestTemplate, description("auctionService.update() didn't call the API correctly"))
                .put(eq(EXPECTED_API_URL + "9"), any(HttpEntity.class));
    }

    @Test
    public void update_should_return_false_for_communication_failure() {
        // Arrange
        Auction updatedAuction = new Auction(9, "q", "w", "e", 11.11);
        Mockito.doThrow(RESOURCE_ACCESS_EXCEPTION).when(mockRestTemplate).put(
                Mockito.eq(EXPECTED_API_URL + "9"),
                any(HttpEntity.class));

        // Act
        boolean result = sut.update(updatedAuction);

        // Assert
        assertFalse("auctionService.update() should return false when RestTemplate throws a ResourceAccessException", result);
        verify(mockRestTemplate, description("auctionService.update() didn't call the API correctly"))
                .put(eq(EXPECTED_API_URL + "9"), any(HttpEntity.class));
    }

    @Test
    public void delete_should_return_true_when_resource_successfully_deleted() {
        // Arrange
        Mockito.doNothing().when(mockRestTemplate).delete(
                Mockito.eq(EXPECTED_API_URL + "1"),
                any(HttpEntity.class));

        // Act
        boolean result = sut.delete(1);

        // Assert
        assertTrue("auctionService.delete() should return true for successful deletion", result);
        verify(mockRestTemplate, description("auctionService.delete() didn't call the API correctly")).delete(eq(EXPECTED_API_URL + "1"));
    }

    @Test
    public void delete_should_return_false_for_failure_response_code() {
        // Arrange
        Mockito.doThrow(REST_CLIENT_RESPONSE_EXCEPTION).when(mockRestTemplate).delete(
                Mockito.eq(EXPECTED_API_URL + "1"));

        // Act
        boolean result = sut.delete(1);

        assertFalse("auctionService.delete() should return false when a RestClientResponseException is thrown", result);
        verify(mockRestTemplate, description("auctionService.delete() didn't call the API correctly")).delete(eq(EXPECTED_API_URL + "1"));
    }

    @Test
    public void delete_should_return_false_for_communication_failure() {
        // Arrange
        Mockito.doThrow(RESOURCE_ACCESS_EXCEPTION).when(mockRestTemplate).delete(
                Mockito.eq(EXPECTED_API_URL + "1"));

        // Act
        boolean result = sut.delete(1);

        assertFalse("auctionService.delete() should return false when a ResourceAccessException is thrown.", result);
        verify(mockRestTemplate, description("auctionService.delete() didn't call the API correctly")).delete(eq(EXPECTED_API_URL + "1"));
    }

    private HttpEntity<Auction> makeEntityHelper(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }


}
