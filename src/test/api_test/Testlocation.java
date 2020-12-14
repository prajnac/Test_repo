package test.api_test;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.io.IOException;

public class Testlocation {

    private String baseUrl;
    public void test() throws ClientProtocolException, IOException {
        WebDriverManager.chromedriver().clearPreferences();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://api.citybik.es/v2/networks");
        TotalResponse TotalResposonseapi = new TotalResponse();
        String ExpectedString = TotalResposonseapi.getResponse();

        ObjectMapper objectMapper = new ObjectMapper();
        GeoLocation citydetails = objectMapper.readValue(ExpectedString, GeoLocation.class);
        String cityName = citydetails.getCity();
        System.out.println("City Name is "+ cityName);
        String country = citydetails.getCountry();
        Double longitudinal = citydetails.getLongitude();
        Double latitude = citydetails.getLatitude();

        while (cityName.equals("Frankfurt")) {
            if (country.equals("DE")) {
                System.out.println("Frankfurt is in Germany");
                System.out.println("Longitudinal:" + longitudinal+"and Latitude:" + latitude);
                Assert.assertEquals(true, "Frankfurt is in Germany");

            } else
                Assert.assertFalse(Boolean.parseBoolean("Frankfurt is not in Germany"));
        }
    }
    }

