package stepdefinitions;


import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SignUpPage;

public class SignUpPageSteps {

    private String pageTitle;
    SignUpPage signUp = new SignUpPage(DriverManager.getDriver());


   @Given("I am on the Magento Create Account page")
    public void iAmOnTheMagentoCreateAccountPage() {
        signUp.getUrl();
    }

    @When("the user enter {string} in the First Name field")
    public void theUserEnterInTheFirstNameField(String firstName) {
       signUp.enterFirstName(firstName);
   }

    @And("the user enter {string} in the Last Name field")
   public void theUserInTheLastNameField(String lastName) {

        signUp.enterLastName(lastName);
    }

    @And("the user enter {string} in the Email field")
    public void theUserInTheEmailField(String email) {

        signUp.enterEmail(email);
    }

    @And("the user enter {string} in the Password field")
    public void theUserInThePasswordField(String pass) {
        signUp.enterPassword(pass);
    }

    @And("the user enter {string} in the Confirm Password field")
    public void theUserInTheConfirmPasswordField(String confirmPass) {
        signUp.enterConfirmPassword(confirmPass);
    }

    @And("the user click the Create an Account button")
    public void theUserClickTheCreateAnAccountButton() {

        signUp.clickCreateAnAccountButton();
    }

    @Then("the user gets the title of the account page")
    public void theUserGetsTheTitleOfTheAccountPage() {
        pageTitle = signUp.getAccountPageTitle();
        System.out.println("Title of the page is " + pageTitle);
    }

    @And("the account page title should be {string}")
    public void theAccountPageTitleShouldBe(String title) {

        Assert.assertEquals(pageTitle, title);
    }

    @Then("the user should see an {string} for invalid email format")
    public void theUserShouldSeeAnForInvalidEmailFormat(String msg) {
        String invalidEmailErrorMsg = signUp.displayInvalidEmailAddressMsg();
        Assert.assertEquals(invalidEmailErrorMsg, msg);
    }

    @Then("the user should see an error that {string}")
    public void theUserShouldSeeAnPasswordNotMatchErrorThat(String msg) {
        String passNotMatchErrorMsg = signUp.displayPasswordsNotMatchErrorMsg();
        Assert.assertEquals(passNotMatchErrorMsg, msg);
    }

    @Then("the user should see an {string} related to the password criteria")
    public void theUserShouldSeeAnRelatedToThePasswordCriteria(String msg) {
        String passNotMatchCriteriaErrorMsg = signUp.displayPasswordCriteriaErrorMsg();
        Assert.assertEquals(passNotMatchCriteriaErrorMsg, msg);
    }


    @Then("the user should see an already registered mail error that {string}")
    public void theUserShouldSeeAnAlreadyRegisteredMailErrorThat(String msg) {
        String alreadyRegMailErrorMsg = signUp.displayAlreadyRegisteredMailErrorMsg();
        Assert.assertEquals(alreadyRegMailErrorMsg, msg);
    }

    @Then("the user see required validation messages {string}")
    public void theUserSeeRequiredValidationMessages(String msg) {

        String firstNameReqErrorMsg = signUp.displayFirstNameRequiredErrorMsg();
        Assert.assertEquals(firstNameReqErrorMsg, msg);
        String lastNameReqErrorMsg = signUp.displayLastNameRequiredErrorMsg();
        Assert.assertEquals(lastNameReqErrorMsg, msg);
        String emailReqErrorMsg = signUp.displayEmailRequiredErrorMsg();
        Assert.assertEquals(emailReqErrorMsg, msg);
        String passReqErrorMsg = signUp.displayPasswordRequiredErrorMsg();
        Assert.assertEquals(passReqErrorMsg, msg);
        String confirmPassReqErrorMsg = signUp.displayConfirmPasswordRequiredErrorMsg();
        Assert.assertEquals(confirmPassReqErrorMsg, msg);
    }
}