
package com.mastercard.code.challenge.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mastercard.code.challenge.app.CodeChallengeApplication;
import com.mastercard.code.challenge.controller.RandomAddressController;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { CodeChallengeApplication.class })
@AutoConfigureMockMvc
//@WithMockUser(value = "mastercard")
public class RandomAddressControllerTest {

	private final String URI_RANDOM_ADDRESS = "/randomizer/address";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private RandomAddressController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void getRandomAddress_200_OK() throws Exception {

		mockMvc.perform(get(URI_RANDOM_ADDRESS)
				.header("Authorization", "Basic bWFzdGVyY2FyZDptYXN0ZXJjYXJk")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.house").isNotEmpty())
				.andExpect(jsonPath("$.street").isNotEmpty())
				.andExpect(jsonPath("$.postalCode").isNotEmpty())
				.andExpect(jsonPath("$.city").isNotEmpty())
				.andExpect(jsonPath("$.state").isNotEmpty())
				.andExpect(jsonPath("$.stateCode").isNotEmpty())
				.andExpect(jsonPath("$.country").isNotEmpty())
				.andExpect(jsonPath("$.countryCode").isNotEmpty())
				.andExpect(jsonPath("$.addressTxt").isNotEmpty())
				.andDo(print());
	}
	
	@Test
	public void getRandomAddress_401_Not_Authorized() throws Exception {

		mockMvc.perform(get(URI_RANDOM_ADDRESS)
				//.header("Authorization", "Basic bWFzdGVyY2FyZDptYXN0ZXJjYXJk")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isUnauthorized())
				.andDo(print());
	}

}
