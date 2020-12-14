package test.api_test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GeoLocation {

    @JsonProperty("longitude")
    private static double longitude;
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("city")
    private static String city;
    @JsonProperty("country")
    private static String country;

//    public GeoLocation()
//    {
//
//    }
//    public String getcityName() {
//        return city;
//    }
//    public void setcityName(String city) {
//        this.city = city;
//    }
    public static String getCity() {
    return city;
}
    public void setCity(String city) {
        this.city = city;
    }
    public static String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public static double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
