package com.dugbel.wunderground;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.dugbel.wunderground.model.location.GeolookupResponse;
import com.dugbel.wunderground.model.weather.Weather;

/**
 * Weather Underground API Implementation
 * 
 * @author dbell
 *
 */
@Component
@PropertySource("classpath:application.properties")
public class WeatherUnderground {

	/** {@link Logger} */
	private final static Logger logger = LoggerFactory.getLogger(WeatherUnderground.class);

	/** {@link Environment} */
	@Autowired
	private Environment environment;

	/**
	 * Get this historic weather for the given date, state and city
	 * 
	 * @param date		The {@link DateTime} to get historic weather for
	 * @param region	The region (country outside the US or state inside the US) to get weather for
	 * @param city		The city to get weather for
	 * 
	 * @return {@link Weather}
	 */
	public Weather getHistoricWeather(DateTime date, String region, String city) {

		Assert.notNull(date, "date must be provided");
		Assert.isTrue(StringUtils.isNotBlank(region), "region must be provided");
		Assert.isTrue(StringUtils.isNotBlank(city), "city must be provided");

		final String apiKey = environment.getProperty("wunderground.api.key");

		StringBuilder url = new StringBuilder("http://api.wunderground.com/api/");
		url.append(apiKey);
		url.append("/history_");
		url.append(date.toString("yyyyMMdd"));
		url.append("/q/");
		url.append(region);
		url.append("/");
		url.append(StringUtils.replace(city, " ", "_"));
		url.append(".json");

		logger.info("Request: " + url.toString());

		RestTemplate restTemplate = new RestTemplate();
		Weather weather = restTemplate.getForObject(url.toString(), Weather.class);

		logger.info("Response: " + weather.toString());

		return weather;
	}

	/**
	 * Complete a geolookup based on latitude and longitude
	 * 
	 * @param latitude	Latitude as {@link BigDecimal}
	 * @param longitude	Longitude as {@link BigDecimal}
	 * 
	 * @return {@link GeolookupResponse}
	 */
	public GeolookupResponse geolookup(BigDecimal latitude, BigDecimal longitude) {

		Assert.notNull(latitude, "latitude is required");
		Assert.notNull(longitude, "longitude is required");

		final String apiKey = environment.getProperty("wunderground.api.key");

		StringBuilder url = new StringBuilder("http://api.wunderground.com/api/");
		url.append(apiKey);
		url.append("/geolookup/q/");
		url.append(latitude);
		url.append(",");
		url.append(longitude);
		url.append(".json");

		logger.info("Request: " + url.toString());

		RestTemplate restTemplate = new RestTemplate();
		GeolookupResponse response = restTemplate.getForObject(url.toString(), GeolookupResponse.class);

		logger.info("Response: " + response.toString());

		return response;
	}

	/**
	 * Complete a geolookup based on latitude and longitude
	 * 
	 * @param postalCode	The postal code as {@link String}
	 * 
	 * @return {@link GeolookupResponse}
	 */
	public GeolookupResponse geolookup(String postalCode) {

		Assert.notNull(postalCode, "postal code is required");

		final String apiKey = environment.getProperty("wunderground.api.key");

		StringBuilder url = new StringBuilder("http://api.wunderground.com/api/");
		url.append(apiKey);
		url.append("/geolookup/q/");
		url.append(postalCode);
		url.append(".json");

		logger.info("Request: " + url.toString());

		RestTemplate restTemplate = new RestTemplate();
		GeolookupResponse response = restTemplate.getForObject(url.toString(), GeolookupResponse.class);

		logger.info("Response: " + response.toString());

		return response;
	}

}