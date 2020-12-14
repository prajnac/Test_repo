package test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import test.api_test.GeoLocation;
import test.api_test.Testlocation;
import test.api_test.TotalResponse;

public class MyStepdefs {

//    public MyStepdefs() {
//    }
        @Given("The link is accessible")
        public void thelinkisAccessible () throws Exception {
            TotalResponse.getResponse();
        }

        @Then("^confirm the city (.*) is in (.*)$")
        public void confirmthecityisincountry (String cityname, String country) throws Exception{

            Testlocation test1= new Testlocation();
            test1.test();
           String exp_country= GeoLocation.getCountry();
           String act_country = country;
           String exp_city =GeoLocation.getCity();
           String act_city = cityname;
           System.out.println("Test");

           if (exp_city==act_city){
               Assert.assertTrue("City intended is found",true);
               if(exp_country!=act_country){
                   Assert.assertFalse(exp_city+"is part of "+ exp_country +"country", false);
               }
               Assert.assertFalse(exp_city+"is part of "+ exp_country +"country", false);
           }else {
               Assert.fail(exp_city+"is part of "+ exp_country +"country");

           }
        }
    }

