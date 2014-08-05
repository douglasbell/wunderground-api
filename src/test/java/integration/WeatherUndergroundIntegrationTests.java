package integration;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dugbel.wunderground.Application;
import com.dugbel.wunderground.WeatherUnderground;
import com.dugbel.wunderground.model.location.GeolookupResponse;
import com.dugbel.wunderground.model.location.Location;
import com.dugbel.wunderground.model.weather.DailySummary;
import com.dugbel.wunderground.model.weather.Weather;


/**
 * 
 * Integration test for {@link WeatherUnderground} 
 * 
 * @author dbell
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest
@PropertySource("classpath:application.properties")
public class WeatherUndergroundIntegrationTests {
	
	/** {@link Environment} */
	@Autowired
	private Environment environment;
	
	/** {@link WeatherUnderground} */
	@Autowired
	private WeatherUnderground wu;
	
	/**
	 * Validate Prerequisites before each test
	 */
	@Before
	public void checkPrerequisites() {
		Assert.assertNotNull("environment is null", environment);
		Assert.assertNotNull("wu is null", wu);
		Assert.assertNotEquals("Please set your wundergroup.api.key property", 
				environment.getProperty("wunderground.api.key"), "[YOUR KEY HERE]");
	}

	/**
	 * Test geolookup by latitude and longitude
	 */
	@Test public void geolookupByLatLng() {
		BigDecimal latitude = new BigDecimal(37.50999832);
		BigDecimal longitude = new BigDecimal(-122.50000000);
		GeolookupResponse response = wu.geolookup(latitude, longitude);
		Assert.assertNotNull("GeolookupResponse is null", response);
		Assert.assertNotNull("GeolookupResponse->Lookup is null",response.getLocation());
		Assert.assertEquals("City", "Half Moon Bay", response.getLocation().getCity());
	}

	/**
	 * Test geolookup by postal code
	 */
	@Test public void geolookupByPostalCode() {
		GeolookupResponse response = wu.geolookup("97086");
		Assert.assertNotNull("GeolookupResponse is null", response);
		Assert.assertNotNull("GeolookupResponse->Lookup is null",response.getLocation());
		Assert.assertEquals("City", "Happy Valley", response.getLocation().getCity());
	}

	/**
	 * Test historic weather lookup for a given latitude / longitude
	 */
	@Test public void getHistoricWeather() {
		BigDecimal latitude = new BigDecimal(37.50999832);
		BigDecimal longitude = new BigDecimal(-122.50000000);
		GeolookupResponse response = wu.geolookup(latitude, longitude);
		Location location = response.getLocation();
		Weather weather = wu.getHistoricWeather(new DateTime().minusDays(120), location.getState(), location.getCity());
		Assert.assertNotNull("Weather is null", weather);
		Assert.assertNotNull("Weather->History is null", weather.getHistory());
		Assert.assertTrue("No Weather->History->DailySummary objects found", weather.getHistory().getDailySummary().size() > 0);
		DailySummary summary = weather.getHistory().getDailySummary().get(0);
		Assert.assertEquals("MeanTempF", new Integer(54), summary.getMeanTempF());
	}
}