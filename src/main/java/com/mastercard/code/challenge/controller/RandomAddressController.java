package com.mastercard.code.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.code.challenge.model.Address;
import com.mastercard.code.challenge.service.RandomGeneratorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Random Address Controller", description = "API calls to retrieve random address information")
public class RandomAddressController {

	@Autowired
	public RandomGeneratorService randomGeneratorSrvc;

	@ApiOperation(value = "Get a random address information", response = Address.class)
	@ApiResponses(value = {@ApiResponse(code = 401, message = "Not Authorized to call this service") , @ApiResponse(code = 404, message = "No random address could be generated") })
	@RequestMapping(method = RequestMethod.GET, value = "/randomizer/address", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Address> getRandomAddress() {

		Address address = randomGeneratorSrvc.getRandomAddress();
		return new ResponseEntity<Address>(address,
				StringUtils.isEmpty(address.getAddressTxt()) ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

}
