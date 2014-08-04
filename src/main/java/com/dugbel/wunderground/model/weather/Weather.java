package com.dugbel.wunderground.model.weather;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Weather Model
 * 
 * @author dbell
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	/** {@link History} */
	private History history;
	
	/**
	 * Return the {@link History}
	 * 
	 * @return {@link History}
	 */
	public History getHistory() {
		return history;
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