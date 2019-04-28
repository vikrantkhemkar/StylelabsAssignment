package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	@Before
    public void beforeAll(){
        DriverInstance.startDriver();
        
    } 
 
 @After
    public void afterAll(){
        DriverInstance.closeBrowser();
    }
}



 
 
 