package Hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class ApplicationHooks {

    //private WebDriver driver;

    //Start the WebDriver
    @Before
    public void setUp(){

        DriverManager.init();
    }

    //Down the WebDriver
    @After
    public void tearDown(){

        DriverManager.down();
    }



}
