package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

import static driver.DriverManager.getDriver;

public class SignUpPage extends ElementUtil {


    private WebDriver driver;

    //Locators
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By email = By.id("email_address");
    private By password = By.id("password");
    private By confirmPassword = By.id("password-confirmation");
    private By submitButton = By.xpath("(//button[@type=\"submit\"])[2]");
    private By invalidEmailErrorMsg = By.id("email_address-error");
    private By passwordsNotMatchErrorMsg = By.id("password-confirmation-error");
    private By passwordCriteriaErrorMsg = By.id("password-error");
    private By alreadyRegisteredMailErrorMsg = By.xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]");
    private By firstNameRequiredErrorMsg = By.id("firstname-error");
    private By lastNameRequiredErrorMsg = By.id("lastname-error");
    private By emailRequiredErrorMsg = By.id("email_address-error");
    private By passwordRequiredErrorMsg = By.id("password-error");
    private By confirmPasswordRequiredErrorMsg = By.id("password-confirmation-error");

    // Constructor of the page class
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }


    //Actions
    public void getUrl() {
        openURL();
    }

    public void enterFirstName(String firstname) {
        enterInput(firstName, firstname);
    }

    public void enterLastName(String lastname) {
        enterInput(lastName, lastname);
    }

    public void enterEmail(String userEmail) {
        enterInput(email, userEmail);
    }

    public void enterPassword(String pass) {
        enterInput(password, pass);
    }

    public void enterConfirmPassword(String confirmPass) {
        enterInput(confirmPassword, confirmPass);
    }

    public void clickCreateAnAccountButton() {
        clickElement(submitButton);
    }

    public String displayInvalidEmailAddressMsg() {
        return getElement(invalidEmailErrorMsg).getText();
    }

    public String displayPasswordsNotMatchErrorMsg() {
        return getElement(passwordsNotMatchErrorMsg).getText();
    }

    public String displayPasswordCriteriaErrorMsg() {
        return getElement(passwordCriteriaErrorMsg).getText();
    }

    public String displayAlreadyRegisteredMailErrorMsg() {
        presenceOfElement(alreadyRegisteredMailErrorMsg);
        visibilityOfElementLocated(alreadyRegisteredMailErrorMsg);
        return getElement(alreadyRegisteredMailErrorMsg).getText();

    }

    public String displayFirstNameRequiredErrorMsg() {
        return getElement(firstNameRequiredErrorMsg).getText();

    }

    public String displayLastNameRequiredErrorMsg() {
        return getElement(lastNameRequiredErrorMsg).getText();

    }

    public String displayEmailRequiredErrorMsg() {
        return getElement(emailRequiredErrorMsg).getText();

    }

    public String displayPasswordRequiredErrorMsg() {
        return getElement(passwordRequiredErrorMsg).getText();

    }

    public String displayConfirmPasswordRequiredErrorMsg() {
        return getElement(confirmPasswordRequiredErrorMsg).getText();

    }

    public String getAccountPageTitle() {
        return getDriver().getTitle();
    }
}
