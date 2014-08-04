package com.dugbel.wunderground.model.weather;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Daily Summary Model
 * 
 * @author dbell
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailySummary {

	/** Fog present */
	@JsonProperty("fog")
	private Integer fog;

	/** Hail present */
	@JsonProperty("hail")
	private Integer hail;

	/** Maximum temperature in celsus  */
	@JsonProperty("maxtempm")
	private Integer maxTempC;

	/**Maximum temperature in fahrenheit */
	@JsonProperty("maxtempi")
	private Integer maxTempF;

	/** Maximum visibility in kilometers */
	@JsonProperty("maxvism")
	private Integer maxVisibilityKilometeres;

	/** Maximum visibility in miles */
	@JsonProperty("maxvisi")
	private Integer maxVisibilityMiles;

	/** Mean temperature in celsus */
	@JsonProperty("meantempm")
	private Integer meanTempC;

	/** Mean temperature in fahrenheit */
	@JsonProperty("meantempi")
	private Integer meanTempF;

	/** Mean visibility in kilometers */
	@JsonProperty("meanvism")
	private Integer meanVisibilityKilometeres;

	/** Mean visibility in miles */
	@JsonProperty("meanvisi")
	private Integer meanVisibilityMiles;

	/** Minimum temperature in celsus */
	@JsonProperty("mintempm")
	private Integer minTempC;

	/** Minimum temperature in fahrenheit */
	@JsonProperty("mintempi")
	private Integer minTempF;

	/** Minimum visibility in kilometers */
	@JsonProperty("minvism")
	private Integer minVisibilityKilometeres;

	/** Minimum visibility in miles */
	@JsonProperty("minvisi")
	private Integer minVisibilityMiles;

	/** Rain present */
	@JsonProperty("rain")
	private Integer rain;

	/** Snow present */
	@JsonProperty("snow")
	private Integer snow;

	/** Snowfall in inches */
	@JsonProperty("snowfalli")
	private Double snowfallInches;

	/** Snowfall in meters */
	@JsonProperty("snowfallm")
	private Double snowfallMeters;

	/** Thunder present */
	@JsonProperty("thunder")
	private Integer thunder;

	/** Tornado present */
	@JsonProperty("tornado")
	private Integer tornado;

	/**
	 * Max temperature in celsius 
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMaxTempC() {
		return maxTempC;
	}

	/**
	 * Max temperature in fahrenheit 
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMaxTempF() {
		return maxTempF;
	}

	/**
	 * Maximum visibility in kilometers
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMaxVisibilityKilometeres() {
		return maxVisibilityKilometeres;
	}

	/**
	 * Maximum visibility in miles 
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMaxVisibilityMiles() {
		return maxVisibilityMiles;
	}

	/**
	 * Mean temperature in celsius 
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMeanTempC() {
		return meanTempC;
	}

	/**
	 * Mean temperature in fahrenheit
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMeanTempF() {
		return meanTempF;
	}

	/**
	 * Mean visibility in kilometers
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMeanVisibilityKilometeres() {
		return meanVisibilityKilometeres;
	}

	/**
	 * Mean visibility in miles 
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMeanVisibilityMiles() {
		return meanVisibilityMiles;
	}

	/**
	 * Minimum temperature in celsius 
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMinTempC() {
		return minTempC;
	}

	/**
	 * Minimum temperature in fahrenheit 
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMinTempF() {
		return minTempF;
	}

	/**
	 * Minimum visibility in kilometers
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMinVisibilityKilometeres() {
		return minVisibilityKilometeres;
	}

	/**
	 * Minimum visibility in miles 
	 * 
	 * @return {@link Integer}
	 */
	public Integer getMinVisibilityMiles() {
		return minVisibilityMiles;
	}

	/**
	 * Total snow fall in inches 
	 * 
	 * @return {@link Double}
	 */
	public Double getSnowfallInches() {
		return snowfallInches;
	}

	/**
	 * Total snow fall in millimeters
	 * 
	 * @return {@link Double}
	 */
	public Double getSnowfallMillimeters() {
		return snowfallMeters;
	}

	/**
	 * Was their fog on this day
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isFog() {
		return fog == null || fog == 0 ? false : true;
	}

	/**
	 * Was their hail on this day
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isHail() {
		return hail == null || hail == 0 ? false : true;
	}

	/**
	 * Was there rain on this day
	 *  
	 * @return {@link Boolean}
	 */
	public boolean isRain() {
		return rain == null || rain == 0 ? false : true;
	}

	/**
	 * Was there snow on this day
	 *  
	 * @return {@link Boolean}
	 */
	public boolean isSnow() {
		return snow == null || snow == 0 ? false : true;
	}

	/**
	 * Was there thunder on this day
	 *  
	 * @return {@link Boolean}
	 */
	public boolean isThunder() {
		return thunder == null || thunder == 0 ? false : true;
	}

	/**
	 * Was there a tornado on this day
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isTornado() {
		return tornado == null || tornado == 0 ? false : true;
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