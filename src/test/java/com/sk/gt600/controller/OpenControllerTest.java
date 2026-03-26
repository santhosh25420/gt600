package com.sk.gt600.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class OpenControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private OpenController openController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void hi() throws Exception {
        // Test 1: Verify endpoint returns HTTP 200 OK
        mvc.perform(get("/gt/open"))
                .andExpect(status().isOk());
        
        // Test 2: Verify endpoint returns correct response body
        mvc.perform(get("/gt/open"))
                .andExpect(content().string("Hi"));
        
        // Test 3: Verify response is not null
        mvc.perform(get("/gt/open"))
                .andExpect(result -> assertNotNull(result.getResponse().getContentAsString()));
        
        // Test 4: Verify response content type
        mvc.perform(get("/gt/open"))
                .andExpect(content().contentTypeCompatibleWith("text/plain;charset=UTF-8"));


        // Test 6: Direct controller test
        String response = openController.hi();
        assertNotNull(response, "Response should not be null");
        assertEquals("Hi", response, "Response should be 'Hi'");
    }
}