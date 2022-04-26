package com.techelevator.auctions.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.auctions.model.Auction;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuctionControllerIntTest {

    @Autowired
    AuctionController controller;

    @Autowired
    ObjectMapper mapper;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        System.out.println("setup()...");
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void create_ValidAuction_ShouldAddNewAuction() throws Exception {
        final Auction auction = new Auction(
                "Standing Desk",
                "Stand up desk to help you stretch your legs during the day.",
                "Johnnie34",
                350.00);

        mockMvc.perform(post("/auctions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction)))
                .andExpect(status().isCreated());
    }

    @Test
    public void create_InvalidAuction_ShouldNotBeCreated() throws Exception {
        final Auction auction = new Auction(
                "",
                "",
                "",
                0);

        mockMvc.perform(post("/auctions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void update_ValidAuction_ShouldUpdateExistingAuction() throws Exception {
        Auction auction = new Auction(1,
                "Bell Computer Monitor",
                "4K LCD monitor from Bell Computers, HDMI & DisplayPort",
                "Queenie34",
                100.39);

        auction.setTitle("MY_NEW_TITLE");

        mockMvc.perform(put("/auctions/" + auction.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("MY_NEW_TITLE"));
    }

    @Test
    public void update_InvalidAuctionShouldNotBeUpdated() throws Exception {
        Auction auction = new Auction(1,
                "Bell Computer Monitor",
                "4K LCD monitor from Bell Computers, HDMI & DisplayPort",
                "Queenie34",
                100.39);
        auction.setTitle("");

        mockMvc.perform(put("/auctions/" + auction.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))).andExpect(status().isBadRequest());
    }

    @Test
    public void update_InvalidAuctionId_ShouldReturnNotFound() throws Exception {
        Auction auction = new Auction(1,
                "Bell Computer Monitor",
                "4K LCD monitor from Bell Computers, HDMI & DisplayPort",
                "Queenie34",
                100.39);

        mockMvc.perform(put("/auctions/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void delete_ValidAuctionId_ShouldRemoveAuction() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/auctions")).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        List<Auction> allAuctions = mapper.readValue(content,List.class);

        mockMvc.perform(delete("/auctions/5")).andExpect(status().isNoContent());
        mockMvc.perform(get("/auctions")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(allAuctions.size()-1)));
    }

    @Test
    public void delete_InvalidAuctionIdIdShouldReturnNotFound() throws Exception {
        mockMvc.perform(delete("/auctions/99")).andExpect(status().isNotFound());
    }

    private String toJson(Auction auction) throws JsonProcessingException {
        return mapper.writeValueAsString(auction);
    }

}
