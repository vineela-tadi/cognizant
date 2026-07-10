package com.cognizant.spring_learn;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cognizant.spring_learn.controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
void testGetCountry() throws Exception {

    ResultActions actions = mvc.perform(
            get("/country")
            .with(httpBasic("user", "pwd")));

    actions.andExpect(status().isOk());
    actions.andExpect(jsonPath("$.code").value("IN"));
    actions.andExpect(jsonPath("$.name").value("India"));
}
	@Test
void testGetCountryException() throws Exception {

    ResultActions actions = mvc.perform(
            get("/countries/az")
            .with(httpBasic("user", "pwd")));

    actions.andExpect(status().isNotFound());
    actions.andExpect(status().reason("Country not found"));
}

}