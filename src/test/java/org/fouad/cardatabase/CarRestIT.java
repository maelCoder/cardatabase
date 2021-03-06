package org.fouad.cardatabase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarRestIT {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void should_return_200_when_using_valid_credentials() throws Exception {
		this.mockMvc//
		.perform(post("/login")//
				.contentType(MediaType.APPLICATION_JSON)//
				.content("{\"username\":\"admin2\", \"password\":\"admin2\"}"))//
		.andDo(print())//
		.andExpect(status().isOk());
	}
	
	@Test
	public void should_return_4xx_when_using_invalid_credentials() throws Exception {
		this.mockMvc//
		.perform(post("/login")//
				.contentType(MediaType.APPLICATION_JSON)//
				.content("{\"username\":\"admin\", \"password\":\"admin\"}"))//
		.andDo(print())//
		.andExpect(status().is4xxClientError());
	}
	
}