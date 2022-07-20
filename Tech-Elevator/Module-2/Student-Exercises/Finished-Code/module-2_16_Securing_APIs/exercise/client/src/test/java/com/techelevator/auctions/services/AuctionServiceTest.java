package com.techelevator.auctions.services;

import com.techelevator.auctions.model.Auction;
import org.hamcrest.core.StringStartsWith;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class AuctionServiceTest {
    private static final String EXPECTED_API_URL = "http://localhost:8080/auctions/";
    private static final int TEST_ID = 99;

    private final RestTemplate restTemplate = new RestTemplate();
    private final AuctionService sut = new AuctionService();

    @Test
    public void step3_getAuction()  {
        ReflectionTestUtils.setField(sut, "restTemplate", restTemplate);
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);

        server.expect(requestTo(EXPECTED_API_URL + TEST_ID))
                .andExpect(method(HttpMethod.GET))
                .andExpect(header(HttpHeaders.AUTHORIZATION, new StringStartsWith("Bearer")))
                .andRespond(withSuccess("{\"id\":" + TEST_ID + "}", MediaType.APPLICATION_JSON));
        Auction auction = null;
        try {
            auction = sut.getAuction(TEST_ID);
        } catch (AssertionError e) {
            fail("Didn't send the expected request to retrieve all auctions. Verify that the URL, HTTP method, and headers are correct.");
        }
        assertNotNull("Call to getAllAuctions() returned null.", auction);
        assertEquals("Call to getAllAuctions() didn't return the expected data.", TEST_ID, auction.getId());
    }


}
