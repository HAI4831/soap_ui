package com.example.producingwebservice;

import org.example.countries.GetCountryRequest;
import org.example.countries.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://www.example.org/countries";
	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse respone= new GetCountryResponse();
		respone.setCountry(countryRepository.findCountry(request.getName()));
		return respone;
	}
}
