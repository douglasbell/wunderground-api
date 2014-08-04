package com.dugbel.wunderground.model.location;

import java.math.BigDecimal;
import java.util.TimeZone;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Geolookup Location Model
 * 
 * @author dbell
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

	/** The City */
	private String city;
	
	/** The Country */
	private String country;
	
	/** The State */
	private String state;
	
	/** The response type */
	private String type;
	
	/** The ISO 3166 Country code */
	@JsonProperty("country_iso3166")
	private String countryIso3166;
	
	/** The Country name */
	@JsonProperty("country_name")
	private String countryName;

	/** The timezone name */
	@JsonProperty("tz_long")
	private String timeZoneName;
	
	/** The latitude */
	@JsonProperty("lat")
	private BigDecimal latitude;
	
	/** The longitude */
	@JsonProperty("lon")
	private BigDecimal longitude;
	
	/** The postal code */
	@JsonProperty("zip")
	private String postalCode;
	

	/**
	 * Return the {@link TimeZone}
	 * 
	 * @return {@link TimeZone}
	 */
	public TimeZone getTimeZone() {
		return TimeZone.getTimeZone(this.timeZoneName);
	}
	
	/**
	 * Return the City
	 * 
	 * @return {@link String}
	 */
	public String getCity() {
		return city;
	}


	/**
	 * Return the Country 
	 * 
	 * @return {@link String}
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * Return the State 
	 * 
	 * @return {@link String}
	 */
	public String getState() {
		return state;
	}


	/**
	 * Return the type e.g. CITY / COUNTRY
	 * @return {@link String}
	 */
	public String getType() {
		return type;
	}


	/**
	 * Return the ISO 3166 code
	 * 
	 * @return {@link String}
	 */
	public String getCountryIso3166() {
		return countryIso3166;
	}


	/**
	 * Return the Country name
	 * 
	 * @return {@link String}
	 */
	public String getCountryName() {
		return countryName;
	}


	/**
	 * Return the timezone name
	 * 
	 * @return {@link String}
	 */
	public String getTimeZoneName() {
		return timeZoneName;
	}


	/**
	 * Return the latitude 
	 * 
	 * @return {@link BigDecimal}
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}


	/**
	 * Return the longitude
	 * 
	 * @return {@link BigDecimal}
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}


	/**
	 * Return the postal code
	 * 
	 * @return {@link String}
	 */
	public String getPostalCode() {
		return postalCode;
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, 
				ToStringStyle.MULTI_LINE_STYLE);
	}
}