package com.example.producingwebservice;

import org.example.countries.Country;
import org.example.countries.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import jakarta.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(BigInteger.valueOf(46704314));
        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.VND);
        poland.setPopulation(BigInteger.valueOf(38186860));
        countries.put(poland.getName(), poland);
    }
    public Country findCountry(String name) {
    	Assert.notNull(name, "The country's name must not be null");
    	return countries.get(name);
    }
}
