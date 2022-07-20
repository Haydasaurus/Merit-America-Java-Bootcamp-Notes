package com.techelevator.auctions.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.auctions.model.Auction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.techelevator.auctions.controller.LoginUtils.getTokenForLogin;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuctionControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setUp() {
        SecurityContextHolder.clearContext();
    }

    @Test
    public void step4_AllMethods_ExpectUnauthorized() throws Exception {
        Auction auction = new Auction(
                "Standing Desk",
                "Stand up desk to help you stretch your legs during the day.",
                "Johnnie34",
                350.00);

        mvc.perform(get("/auctions/1")).andExpect(status().isUnauthorized());
        mvc.perform(post("/auctions").contentType(MediaType.APPLICATION_JSON).content(toJson(auction))).andExpect(status().isUnauthorized());
        mvc.perform(put("/auctions/1").contentType(MediaType.APPLICATION_JSON).content(toJson(auction))).andExpect(status().isUnauthorized());
        mvc.perform(delete("/auctions/1")).andExpect(status().isUnauthorized());
    }

    @Test
    public void step4_list_ExpectOk() throws Exception {
        mvc.perform(get("/auctions/1")).andExpect(status().isUnauthorized());
        mvc.perform(get("/auctions")).andExpect(status().isOk());
    }

    @Test
    public void step5_CreateMethod() throws Exception {

        if (!isControllerSecure() || !isMethodSecure("create")) {
            fail("Authentication & Authorization not enabled for AuctionController.create()");
        }

        Auction auction = new Auction(
                "Standing Desk",
                "Stand up desk to help you stretch your legs during the day.",
                "Johnnie34",
                350.00);

        final String adminToken = getTokenForLogin("admin", "admin", mvc);

        mvc.perform(post("/auctions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))
                .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isCreated());

        final String creatorToken = getTokenForLogin("creator", "password", mvc);

        mvc.perform(post("/auctions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))
                .header("Authorization", "Bearer " + creatorToken))
                .andExpect(status().isCreated());

    }

    @Test
    public void step5_UpdateMethod() throws Exception {

        if (!isControllerSecure() || !isMethodSecure("update")) {
            fail("Authentication & Authorization not enabled for AuctionController.update()");
        }

        Auction auction = new Auction(
                "Standing Desk",
                "Stand up desk to help you stretch your legs during the day.",
                "Johnnie34",
                350.00);

        final String adminToken = getTokenForLogin("admin", "admin", mvc);

        mvc.perform(put("/auctions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))
                .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isOk());

        final String creatorToken = getTokenForLogin("creator", "password", mvc);

        mvc.perform(put("/auctions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(auction))
                .header("Authorization", "Bearer " + creatorToken))
                .andExpect(status().isOk());
    }

    @Test
    public void step5_DeleteMethod() throws Exception {

        if (!isControllerSecure() || !isMethodSecure("delete")) {
            fail("Authentication & Authorization not enabled for AuctionController.delete()");
        }

        final String adminToken = getTokenForLogin("admin", "admin", mvc);

        mvc.perform(delete("/auctions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + adminToken))
                .andExpect(status().isNoContent());

        final String creatorToken = getTokenForLogin("creator", "password", mvc);

        mvc.perform(delete("/auctions/2")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + creatorToken))
                .andExpect(status().isForbidden());
    }

    @Test
    public void step6_WhoAmI() throws Exception {
        final String token = getTokenForLogin("user", "password", mvc);

        mvc.perform(get("/auctions/whoami")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().string("user"));
    }

    /**
     * Checks to make sure the {@PreAuthorize} annotation was added to the class
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private boolean isControllerSecure() throws InvocationTargetException, IllegalAccessException {
        boolean isControllerSecure = false;
        for (Annotation annotation : AuctionController.class.getAnnotations()) {
            Class<? extends Annotation> type = annotation.annotationType();
            if (type.getName().equals("org.springframework.security.access.prepost.PreAuthorize")) {
                for (Method method : type.getDeclaredMethods()) {
                    Object value = method.invoke(annotation, (Object[])null);
                    if (value.equals("isAuthenticated()")) {
                        isControllerSecure = true;
                        break;
                    }
                }
            }
        }
        return isControllerSecure;
    }

    /**
     * Checks to make sure the {@PreAuthorize} annotation was added to the method
     * @param methodName
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private boolean isMethodSecure(String methodName) throws InvocationTargetException, IllegalAccessException {
        boolean isMethodSecure = false;
        for (Method method : AuctionController.class.getMethods()) {
            if (method.getName().contains(methodName)) {
                for (Annotation annotation : method.getAnnotations()) {
                    Class<? extends Annotation> type = annotation.annotationType();
                    if (type.getName().equals("org.springframework.security.access.prepost.PreAuthorize")) {
                        for (Method annotationMethod : type.getDeclaredMethods()) {
                            Object value = annotationMethod.invoke(annotation, (Object[])null);
                            if (value.toString().contains("hasRole") || value.toString().contains("hasAnyRole")) {
                                isMethodSecure = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isMethodSecure;
    }

    private String toJson(Auction auction) throws JsonProcessingException {
        return mapper.writeValueAsString(auction);
    }
}
