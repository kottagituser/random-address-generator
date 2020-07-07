package com.mastercard.code.challenge.service;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.stereotype.Service;

import com.mastercard.code.challenge.model.Address;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

	@Override
	public Address getRandomAddress() {
		Address address = new Address();
		setCountry(address);
		setStateCityCountyStreetHousePostalCode(address);
		return address;
	}
	
	private void setCountry(Address address) {
		RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
		int countryCodeIndex = randomDataGenerator.nextInt(0, COUNTRY_CODES.size()-1);
		address.setCountryCode(COUNTRY_CODES.get(countryCodeIndex));
		address.setCountry(COUNTRIES.get(countryCodeIndex));
	}
	
	private void setStateCityCountyStreetHousePostalCode(Address address) {
		int stateCodeIndex = -1;
		int streetTypIndex = -1;
		int streetIndex = -1;
		String street = "";
		
		RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
		switch(address.getCountryCode()) {
			case "USA": 
				stateCodeIndex = randomDataGenerator.nextInt(0, USA_STATE_CODES.size()-1);
				address.setStateCode(USA_STATE_CODES.get(stateCodeIndex));
				address.setState(USA_STATES.get(stateCodeIndex));
				address.setCity(USA_CITIES.get(randomDataGenerator.nextInt(0, USA_CITIES.size()-1)));
				address.setCounty(USA_CITIES.get(randomDataGenerator.nextInt(0, USA_CITIES.size()-1)));
				
				streetTypIndex = randomDataGenerator.nextInt(0, USA_STREET_TYP.size()-1);
				streetIndex = randomDataGenerator.nextInt(0, USA_STREETS.size()-1);
				street = USA_STREETS.get(streetIndex);
				address.setStreet(street +" "+ (street.contains("BOX")? "" : USA_STREET_TYP.get(streetTypIndex)));
				address.setHouse(String.valueOf(randomDataGenerator.nextInt(1, 9999)));
				address.setPostalCode(String.valueOf(randomDataGenerator.nextInt(00000, 99999)));
				address.setAddressTxt(address.getHouse() + " "+ address.getStreet() + " " + address.getCity() + ", " + address.getStateCode() + " " + address.getPostalCode() + " " + address.getCountryCode());
				break;
			
			case "CAN": 
				stateCodeIndex = randomDataGenerator.nextInt(0, CAN_STATE_CODES.size()-1);
				address.setStateCode(CAN_STATE_CODES.get(stateCodeIndex));
				address.setState(CAN_STATES.get(stateCodeIndex));
				address.setCity(CAN_CITIES.get(randomDataGenerator.nextInt(0, CAN_CITIES.size()-1)));
				//address.setCounty(CAN_CITIES.get(randomDataGenerator.nextInt(0, CAN_CITIES.size()-1)));
				
				streetTypIndex = randomDataGenerator.nextInt(0, CAN_STREET_TYP.size()-1);
				streetIndex = randomDataGenerator.nextInt(0, CAN_STREETS.size()-1);
				street = CAN_STREETS.get(streetIndex);
				address.setStreet(street +" "+(street.contains("BOX")? "" : CAN_STREET_TYP.get(streetTypIndex)));
				address.setHouse(String.valueOf(randomDataGenerator.nextInt(1, 9999)));
				address.setPostalCode(randomDataGenerator.nextSecureHexString(5).toUpperCase());
				address.setAddressTxt(address.getHouse() + " "+ address.getStreet() + ", " + address.getCity() + " " + address.getStateCode() + " " + address.getPostalCode() + " " + address.getCountry());
				break;

			case "MEX": 
				stateCodeIndex = randomDataGenerator.nextInt(0, MEX_STATE_CODES.size()-1);
				address.setStateCode(MEX_STATE_CODES.get(stateCodeIndex));
				address.setState(MEX_STATES.get(stateCodeIndex));
				address.setCity(MEX_CITIES.get(randomDataGenerator.nextInt(0, MEX_CITIES.size()-1)));
				address.setCounty("Col. "+MEX_CITIES.get(randomDataGenerator.nextInt(0, MEX_CITIES.size()-1)));
				
				streetIndex = randomDataGenerator.nextInt(0, MEX_STREETS.size()-1);
				address.setStreet(MEX_STREETS.get(streetIndex));
				address.setHouse(String.valueOf(randomDataGenerator.nextInt(1, 9999)));
				address.setPostalCode(String.valueOf(randomDataGenerator.nextInt(00000, 99999)));
				address.setAddressTxt(address.getStreet() + " " + address.getHouse() + ", "+ address.getCounty() + ", " + address.getCity() + " " + address.getState() + " CP: " + address.getPostalCode() + " " + address.getCountry());
				break;

			case "NLD": 
				stateCodeIndex = randomDataGenerator.nextInt(0, NLD_STATE_CODES.size()-1);
				address.setStateCode(NLD_STATE_CODES.get(stateCodeIndex));
				address.setState(NLD_STATES.get(stateCodeIndex));
				address.setCity(NLD_CITIES.get(randomDataGenerator.nextInt(0, NLD_CITIES.size()-1)));
				address.setCounty(NLD_CITIES.get(randomDataGenerator.nextInt(0, NLD_CITIES.size()-1)));
				
				streetTypIndex = randomDataGenerator.nextInt(0, NLD_STREET_TYP.size()-1);
				streetIndex = randomDataGenerator.nextInt(0, NLD_STREETS.size()-1);
				street = NLD_STREETS.get(streetIndex);
				address.setStreet(street +" "+(street.contains("BOX")? "" : NLD_STREET_TYP.get(streetTypIndex)));
				address.setHouse(String.valueOf(randomDataGenerator.nextInt(1, 9999)));
				address.setPostalCode(String.valueOf(randomDataGenerator.nextInt(0000, 9999)));
				address.setAddressTxt(address.getStreet() + " " + address.getHouse() + ", "+ address.getPostalCode() + " "+ address.getStateCode() + " " + address.getCity() +" " + address.getCountry());
				break;
		}
	}
	
}
