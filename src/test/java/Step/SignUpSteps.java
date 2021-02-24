package Step;


import io.cucumber.core.gherkin.Feature;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Pages.SignUpPage;
import Helper.Helper;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SignUpSteps {

    protected WebDriver driver;
    protected SignUpPage signUpPage;
    SoftAssert softAssert;

    @Before("@SignUp")
    public void setUp() {
        softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        signUpPage = new SignUpPage(driver);
    }

    @Given("user navigates to url to sign up")
    public void user_navigates_to_url_to_sign_up() {
        driver.get(new Helper().OPENCART_URL);
    }


    @When("selects My Account Menu")
    public void selects_My_Account_Menu() {
        signUpPage.clickMyAccount();
    }

    @And("click on Register option")
    public void click_on_Register_option() {
        signUpPage.clickRegisterOption();
    }

    @Then("system shows the Register Account Form")
    public void system_shows_the_Register_Account_Form() {
        Assert.assertEquals(driver.getTitle(), "Register Account");
    }


    @When("user fill out the sign up from with valid data")
    public void user_fill_out_the_sign_up_from_with_valid_data(DataTable table) {
       List<String> list = table.asList();
        String email = "lola" + Math.random() + "@gmail.com";
        signUpPage.clickMyAccount();
        signUpPage.clickRegisterOption();
        Assert.assertEquals(driver.getTitle(), "Register Account", "This is not the right page");
        signUpPage.fillForm(list.get(0),list.get(1),email,list.get(3),list.get(4),list.get(5));
        signUpPage.clickPolicyCheckBox();
    }


    @And("user submits")
    public void user_submits() {
        signUpPage.clickContinueButton();
    }

    @Then("Success message should be displayed")
    public void success_message_should_be_displayed() {
        Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");
    }

    @Given("user does not fill any field")
    public void user_does_not_fill_any_field() {
        signUpPage.clickMyAccount();
        signUpPage.clickRegisterOption();
        Assert.assertEquals(driver.getTitle(), "Register Account", "This is not the right page");
        signUpPage.fillForm("","","","","","");
        signUpPage.clickPolicyCheckBox();
    }

    @When("user submit")
    public void user_submit() {
        signUpPage.clickContinueButton();
    }

    @Then("error message detailing what mandatory fields are missing")
    public void error_message_detailing_what_mandatory_fields_are_missing() {

        softAssert.assertEquals(signUpPage.errorMessageFirstName(), "First Name must be between 1 and 32 characters!");
        softAssert.assertEquals(signUpPage.errorMessageLastName(), "Last Name must be between 1 and 32 characters!");
        softAssert.assertEquals(signUpPage.errorMessageEmail(), "E-Mail Address does not appear to be valid!");
        softAssert.assertEquals(signUpPage.errorMessagePhone(), "Telephone must be between 3 and 32 characters!");
        softAssert.assertEquals(signUpPage.errorMessagePassword(), "Password must be between 4 and 20 characters!");
        softAssert.assertAll();
    }

    @Given("user uses an email already in use")
    public void user_uses_an_email_already_in_use(DataTable table) {
        List<String> list = table.asList();
        signUpPage.clickMyAccount();
        signUpPage.clickRegisterOption();
        Assert.assertEquals(driver.getTitle(), "Register Account", "This is not the right page");
        signUpPage.fillForm(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
        signUpPage.clickPolicyCheckBox();
    }

    @Then("error message detailing that the email con be duplicated")
    public void error_message_detailing_that_the_email_con_be_duplicated() {
        Assert.assertEquals(signUpPage.messageEmailDuplicated(), "Warning: E-Mail Address is already registered!");
    }

    @Given("user uses an email without @")
    public void user_uses_an_email_without_at(DataTable table) {
        List<String> list = table.asList();
        signUpPage.clickMyAccount();
        signUpPage.clickRegisterOption();
        Assert.assertEquals(driver.getTitle(), "Register Account", "This is not the right page");
        signUpPage.fillForm(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
        signUpPage.clickPolicyCheckBox();
        signUpPage.setTypeForEmail();
    }

    @Then("error message detailing that the email is invalid because @ is missing")
    public void error_message_detailing_that_the_email_is_invalid_because_at_is_missing() {
        Assert.assertEquals(signUpPage.errorMessageEmail(), "E-Mail Address does not appear to be valid!");
    }


    @Given("user uses an email without domain")
    public void user_uses_an_email_without_domain(DataTable table) {
        List<String> list = table.asList();
        signUpPage.clickMyAccount();
        signUpPage.clickRegisterOption();
        Assert.assertEquals(driver.getTitle(), "Register Account", "This is not the right page");
        signUpPage.fillForm(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
        signUpPage.clickPolicyCheckBox();
    }

    @Then("error message detailing that the email is invalid")
    public void error_message_detailing_that_the_email_is_invalid() {
        Assert.assertEquals(signUpPage.errorMessageEmail(), "E-Mail Address does not appear to be valid!");
    }

    @Given("user enter a password confirm different than the password")
    public void user_enter_a_password_confirm_different_than_the_password(DataTable table) {
        List<String> list = table.asList();
        signUpPage.clickMyAccount();
        signUpPage.clickRegisterOption();
        Assert.assertEquals(driver.getTitle(), "Register Account", "This is not the right page");
        signUpPage.fillForm(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5));
        signUpPage.clickPolicyCheckBox();
    }

    @Then("error message detailing that password and password confirm must be equal")
    public void error_message_detailing_that_password_and_password_confirm_must_be_equal() {
        Assert.assertEquals(signUpPage.errorMessageConfirmPassword(), "Password confirmation does not match password!");
    }

    @After("@SignUp")
    public void tearDown() {
        driver.close();
    }


}
