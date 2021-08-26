package com.pv.demo.it.validate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pv.demo.Service.PasswordService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordValidateControllerTest {

	@Autowired
	private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
    	mockMvc =  MockMvcBuilders.webAppContextSetup(this.context).build();

    }

    @Test
    public void PasswordValidationAPITest() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/check"))
    	.andExpect(MockMvcResultMatchers.status().isOk());
    	
    	mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/check"))
    	.andExpect(MockMvcResultMatchers.status().isOk());
    	
    	mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/check")
    	.param("password","123456abc"))
    	.andExpect(MockMvcResultMatchers.status().isOk());
    	
    	mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/check")
    	    	.param("password","1"))
    	    	.andExpect(MockMvcResultMatchers.status().isOk());
    	mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/check")
    	    	.param("password",""))
    	    	.andExpect(MockMvcResultMatchers.status().isOk());
    }
}