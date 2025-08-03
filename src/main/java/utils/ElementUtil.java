package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;

public class ElementUtil {

    public void openURL(){
        if(getDriver()!=null){
            getDriver().get(PropertyReader.readKey("url"));
        }
        else {
            System.err.println("WebDriver is null. Cannot navigate to URL.");
        }

    }

    public void clickElement(By by) {

        getDriver().findElement(by).click();
    }

    public void enterInput(By by, String key) {

        getDriver().findElement(by).sendKeys(key);
    }

    public WebElement getElement(By key){
        return getDriver().findElement(key);

    }

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElementLocated(By elementLocation) {
            return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
        }

}
