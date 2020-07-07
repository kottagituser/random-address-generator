package com.mastercard.code.challenge.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("address")
@JsonPropertyOrder({ "house", "street", "postalCode", "city", "county", "state", "stateCode", "country",
		"countryCode" })
@Data
@ApiModel(description = "Address information object")
public class Address {

	@ApiModelProperty(notes = "House or street number.")
	private String house;
	@ApiModelProperty(notes = "Street name (in practice may also contain street number).")
	private String street;
	@ApiModelProperty(notes = "An alphanumeric string included in a postal address to facilitate mail sorting (a.k.a. post code, postcode, or ZIP code).")
	private String postalCode;
	@ApiModelProperty(notes = "The name of the primary locality of the place.")
	private String city;
	@ApiModelProperty(notes = "A division of a state; typically a secondary-level administrative division of a country or equivalent.")
	private String county;
	@ApiModelProperty(notes = "A division of a country; typically a first-level administrative division of a country and/or a geographical region.")
	@JsonInclude(Include.NON_NULL)
	private String state;
	@ApiModelProperty(notes = "A code/abbreviation for the state division of a country.")
	@JsonInclude(Include.NON_NULL)
	private String stateCode;
	@ApiModelProperty(notes = "The localised country name.")
	@JsonInclude(Include.NON_NULL)
	private String country;
	@ApiModelProperty(notes = "A three-letter country code.")
	private String countryCode;
	@ApiModelProperty(notes = "Address as one line text")
	private String addressTxt;

}
