package com.mastercard.code.challenge.service.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastercard.code.challenge.model.Address;
import com.mastercard.code.challenge.service.RandomGeneratorService;
import com.mastercard.code.challenge.service.RandomGeneratorServiceImpl;

@RunWith(SpringRunner.class)
public class RandomGeneratorServiceTest {

	@InjectMocks
	RandomGeneratorService service = new RandomGeneratorServiceImpl();

	@Test
	public void getRandomAddress_Test1() throws Exception {

		Address address = service.getRandomAddress();
		assertThat(address).isNotNull();
		assertThat(address.getAddressTxt()).isNotNull();
		assertThat(address.getCity()).isNotNull();
		assertThat(address.getCountry()).isNotNull();
		assertThat(address.getCountryCode()).isNotNull();
		assertThat(address.getHouse()).isNotNull();
		assertThat(address.getPostalCode()).isNotNull();
		assertThat(address.getState()).isNotNull();
		assertThat(address.getStateCode()).isNotNull();
		assertThat(address.getStreet()).isNotNull();
	}


}
