package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class DriverManager {


    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef){

        dr.set(driverRef);
    }

    public static WebDriver getDriver(){

        return dr.get();
    }

    //Unload - will make sure all the thread will unload and remove the driver when it is not needed.
    public static void unload(){
        dr.remove();
    }


    public static void init() {
        if(Objects.isNull(DriverManager.getDriver())){
            System.out.println("Launching new Chrome browser...");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications", "--start-maximized");
            WebDriver driver = new ChromeDriver(options);
            setDriver(driver);
        }
    }
    public static void down() {
        if(Objects.nonNull(DriverManager.getDriver())){
            System.out.println("Closing browser...");
            getDriver().quit();
            unload(); //unload all the threads
        }
    }
}
