package com.techelevator.auctions.services;


import org.junit.Test;
import org.springframework.http.*;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

public class AuthenticationServiceTest {

    private static final String EXPECTED_API_URL = "http://localhost:8080/login";

    private final RestTemplate restTemplate = new RestTemplate();
    private final AuthenticationService sut = new AuthenticationService();

    @Test
    public void step2_loginMethod() {
        String testToken = "abcdefgh123456789";

        ReflectionTestUtils.setField(sut, "restTemplate", restTemplate);
        MockRestServiceServer server = MockRestServiceServer.createServer(restTemplate);

        server.expect(requestTo(EXPECTED_API_URL))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json("{\"username\":\"testuser\", \"password\":\"testpass\"}"))
                .andRespond(withSuccess("{ \"token\" : \"" + testToken + "\"}", MediaType.APPLICATION_JSON));

        String token = null;
        try {
            token = sut.login("testuser", "testpass");
        } catch (AssertionError e) {
            fail("Didn't send the expected request to log in. Verify that the URL, HTTP method, and body are all correct.");
        }
        assertNotNull("Didn't get anything back after sending username and password.", token);
        assertEquals("Didn't get expected token after logging in.", testToken, token);
    }

}
