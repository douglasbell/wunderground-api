package integration;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
public class WeatherUndergroundIntegrationTests {

	/** {@link WeatherUnderground} */
	@Autowired
	private WeatherUnderground wu;

	/**
	 * Test geolookup by postal code
	 */
	@Test
	public void geolookupByPostalCode() {
		GeolookupResponse response = wu.geolookup("97086");
		Assert.assertNotNull("GeolookupResponse is null", response);
		Assert.assertNotNull("GeolookupResponse->Lookup is null",response.getLocation());
		Assert.assertEquals("City", "Happy Valley", response.getLocation().getCity());
	}

	/**
	 * Test geolookup by latitude / longitude
	 */
	@Test
	public void geolookupByLatLng() {
		BigDecimal latitude = new BigDecimal(37.50999832);
		BigDecimal longitude = new BigDecimal(-122.50000000);
		GeolookupResponse response = wu.geolookup(latitude, longitude);
		Assert.assertNotNull("GeolookupResponse is null", response);
		Assert.assertNotNull("GeolookupResponse->Lookup is null",response.getLocation());
		Assert.assertEquals("City", "Half Moon Bay", response.getLocation().getCity());
	}

	/**
	 * Test historic weather lookup for a given latitude / longitude
	 */
	@Test
	public void getHistoricWeather() {
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