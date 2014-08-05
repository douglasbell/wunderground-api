package unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.mock.env.MockEnvironment;

import com.dugbel.wunderground.WeatherUnderground;


/**
 * 
 * Unit test for {@link WeatherUnderground} 
 * 
 * @author dbell
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherUndergroundUnitTests {

	/** Create a mock {@link Environment} */
	@Spy
	private Environment environment = new MockEnvironment();

	/** Inject the mocks into the {@link WeatherUnderground} object */
	@InjectMocks
	private WeatherUnderground wu = new WeatherUnderground();

	/**
	 * Initialize the mock
	 */
	@Before
	public void before() {
		((MockEnvironment) this.environment).setProperty("wunderground.api.key", "erf456hi7813d21s0");
	}

	/**
	 * Test geolookup by latitude and longitude
	 */
	@Test 
	public void geolookupByLatLng() {



	}

	/**
	 * Test geolookup by postal code
	 */
	@Test public void geolookupByPostalCode() {
		//System.out.println(wu.geolookup("97086"));
	}

	/**
	 * Test historic weather lookup for a given latitude / longitude
	 */
	@Test public void getHistoricWeather() {

	}
}