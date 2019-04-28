package stepDefination;


import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Functionlibrary;

public class Operations {
	Functionlibrary fs=new Functionlibrary();
	String s;
	
	@Given("^I launch the google search page$")
	public void i_launch_the_google_search_page() throws Throwable {
		fs.launchApplication();
	}

	@When("^I search for \"(.*?)\"$")
	public void i_search_for(String searchTerm) throws Throwable {
		fs.googleSearch(searchTerm);
		s=searchTerm;
	}

	@Then("^I should see the search result page$")
	public void i_should_see_the_search_result_page() throws Throwable {
		String str= fs.verifySearchResult();
		Assert.assertEquals(str, "People also ask");
	}
	
	@Then("^I take the screenshot of the result page$")
	public void i_take_the_screenshot_of_the_result_page() throws Throwable {
		fs.captureScreenshot();
	}
	@Given("^I launch the Expedia US version application$")
	public void i_launch_the_Expedia_US_version_application() throws Throwable {
		fs.browseTo();	
	}

	@When("^I search for flight from \"(.*?)\" to \"(.*?)\"$")
	public void i_search_for_flight_from_to(String from, String to) throws Throwable {
		fs.toAndFro(from,to);
	}

	@When("^I enter travelers details as \"(.*?)\" adult and \"(.*?)\" child of \"(.*?)\" years age$")
	public void i_enter_travelers_details_as_adult_and_child_of_years_age(String noOfAdult, String noOfChild, String ageOfChild) throws Throwable {
		fs.travelerDetails(noOfAdult,noOfChild,ageOfChild);
	}

	@When("^I enter other itinerary details and search$")
	public void i_enter_other_itinerary_details_and_search() throws Throwable {
		fs.itineraryDetails();
	}

	@Then("^I should see the travel options for searched destination$")
	public void i_should_see_the_travel_options_for_searched_destination() throws Throwable {
		WebElement element= fs.verifyResult();
		Assert.assertEquals(element.getText(), "Select your departure to New York Mon, May 20");;
	}

	@When("^I make a get request to Openweathermap api and verify the max temprature is below 10$")
	public void i_make_a_get_request_to_Openweathermap_api() throws Throwable {
		fs.getRequest();
	}
}
