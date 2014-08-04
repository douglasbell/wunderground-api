package com.dugbel.wunderground.model.weather;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * History Model
 * 
 * @author dbell
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class History {

	/** {@link DailySummary} */
	@JsonProperty("dailysummary")
	private List<DailySummary> dailysummary;

	/**
	 * Return the {@link DailySummary}
	 * 
	 * @return {@link DailySummary}
	 */
	public List <DailySummary> getDailySummary() {
		return dailysummary;
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