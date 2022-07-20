package com.techelevator.auctions.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AuctionController.class)
public class AuctionControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    private AuctionDao dao;

    public AuctionControllerTest() {
        dao = new MemoryAuctionDao();
    }

    @Test
    public void listShouldReturnStatusOK() throws Exception {
        mvc.perform(get("/auctions").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void listShouldReturnCorrectCount() throws Exception {
        int count = dao.list().size();
        mvc.perform(get("/auctions").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(count)));
    }

    @Test
    public void getShouldReturnSingleAuction() throws Exception {
        List<Auction> auctions = dao.list();
        Auction first = auctions.get(0);

        mvc.perform(get("/auctions/" + first.getId()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(first.getTitle()))
                .andExpect(jsonPath("$.description").value(first.getDescription()))
                .andExpect(jsonPath("$.user").value(first.getUser()))
                .andExpect(jsonPath("$.currentBid").value(first.getCurrentBid()));
    }

    @Test
    public void getInvalidIdShouldReturnNothing() throws Exception {
        mvc.perform(get("/auctions/99")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void createShouldThrowExceptionWhenRequestBodyDoesntExist() throws Exception {
        mvc.perform(post("/auctions")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createShouldAddNewAuction() throws Exception {
        Auction auction = new Auction(
                "Standing Desk",
                "Stand up desk to help you stretch your legs during the day.",
                "Johnnie34",
                350.00);

        mvc.perform(post("/auctions").contentType(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(8));
    }

    @Test
    public void searchByTitleShouldReturnList() throws Exception {
        List<Auction> allAuctions = dao.list();
        List<Auction> expected = new ArrayList<>();
        expected.add(allAuctions.get(1));
        expected.add(allAuctions.get(6));

        MvcResult mvcResult = mvc.perform(get("/auctions?title_like=watch").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        List<Auction> searchResults = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Auction>>() {});
        assertEquals(expected.size(),searchResults.size());
        assertEquals(expected.get(0).getTitle(),"Pineapple Smart Watch");
        assertEquals(expected.get(1).getTitle(),"Molex Gold Watch");
    }

    @Test
    public void searchByTitleExpectNone() throws Exception {
        mvc.perform(get("/auctions?title_like=abcsdfsdf").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("[]"));
    }

    @Test
    public void searchByPriceShouldReturnList() throws Exception {
        List<Auction> allAuctions = dao.list();
        List<Auction> expected = new ArrayList<>();
        expected.add(allAuctions.get(3));

        MvcResult mvcResult = mvc.perform(get("/auctions?currentBid_lte=70").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        List<Auction> searchResults = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Auction>>() {});
        System.out.println(searchResults);
        assertEquals(expected.size(),searchResults.size());
        assertEquals(expected.get(0).getTitle(),"Annie Sunglasses");
        assertEquals(expected.get(0).getDescription(),"Keep the sun from blinding you");
        assertEquals(expected.get(0).getCurrentBid(), 69.67,1);
    }

    @Test
    public void searchByPriceExpectNone() throws Exception {
        mvc.perform(get("/auctions?currentBid_lte=1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("[]"));
    }

    @Test
    public void searchByTitleAndPriceExpectOne() throws Exception {
        // Arrange
        String queryString = "?title_like=Watch&currentBid_lte=200";

        // Act
        MvcResult mvcResult = mvc.perform(
                get("/auctions" + queryString).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        List<Auction> searchResults = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Auction>>() {});

        // Assert
        assertEquals(1, searchResults.size());
    }

    @Test
    public void searchByTitleAndPriceExpectNone() throws Exception {
        // Arrange
        String queryString = "?title_like=Watch&currentBid_lte=50";

        // Act
        MvcResult mvcResult = mvc.perform(
                get("/auctions" + queryString).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        List<Auction> searchResults = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Auction>>() {});

        // Assert
        assertEquals(0, searchResults.size());
    }

    private String toJson(Auction auction) throws JsonProcessingException {
        return mapper.writeValueAsString(auction);
    }

}
