package com.techelevator.auctions.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class LoginUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private LoginUtils() {
    }

    public static String getTokenForLogin(String username, String password, MockMvc mockMvc) throws Exception {
        String content = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"password\": \"" + password + "\", \"username\": \"" + username + "\"}"))
                .andReturn()
                .getResponse()
                .getContentAsString();
        AuthenticationResponse authResponse = OBJECT_MAPPER.readValue(content, AuthenticationResponse.class);

        return authResponse.getIdToken();
    }

    private static class AuthenticationResponse {

        @JsonAlias("token")
        private String idToken;

        public void setIdToken(String idToken) {
            this.idToken = idToken;
        }

        public String getIdToken() {
            return idToken;
        }
    }
}
