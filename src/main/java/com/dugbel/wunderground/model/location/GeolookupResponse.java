package com.dugbel.wunderground.model.location;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Geolocation Response Model
 * 
 * @author dbell
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeolookupResponse {

	/** {@link Location} */
	private Location location;
	
	/**
	 * Return the {@link Location}
	 * 
	 * @return {@link Location}
	 */
	public Location getLocation() {
		return location;
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