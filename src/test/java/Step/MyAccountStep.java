package Step;

import Helper.Helper;
import Pages.MyAccountPage;
import Pages.SignUpPage;
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
import org.testng.asserts.SoftAssert;


public class MyAccountStep {
    protected WebDriver driver;
    protected SignUpPage signUpPage;
    protected MyAccountPage myAccountPage;
    SoftAssert softAssert;


    @Before("@MyAccount")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        signUpPage = new SignUpPage(driver);
        myAccountPage = new MyAccountPage(driver);
        softAssert = new SoftAssert();
    }

    @Given("user navigates to url to login")
    public void user_navigates_to_url_to_login(){
        driver.get(new Helper().OPENCART_URL);
    }

    @And("user log in")
    public void user_is_already_sign_up(){
        signUpPage.clickMyAccount();
        signUpPage.clickLoginMenu();
        signUpPage.emailInput("lola@gmail.com");
        signUpPage.passwordInput("1234");
        signUpPage.clickLoginButton();
    }

    @Then("is display a page with a the message Your Store on the top of the page")
    public void is_display_a_page_with_a_the_message_Your_Store_on_the_top_of_the_page() {
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @Given("user is in my account page")
    public void user_is_in_my_account_page() {
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @When("user clicks on the Edit your account information option")
    public void user_clicks_on_the_Edit_your_account_information_option() {
        myAccountPage.clickEditAccountLink();
    }

    @Then("is display a page with my account information")
    public void is_display_a_page_with_my_account_information() {
        Assert.assertEquals(driver.getTitle(), "My Account Information");
    }

    @When("user edits telephone")
    public void user_edits_telephone() {
        myAccountPage.clickEditAccountLink();
        signUpPage.clearPhoneInput();
        signUpPage.phoneInput("123789989");

    }

    @And("user click continue button")
    public void user_click_continue_button() {
        myAccountPage.clickContinueButton();
    }

    @Then("success message is displayed on my account page")
    public void success_message_is_displayed_on_my_account_page() {
        Assert.assertEquals(myAccountPage.successMessage(), "Success: Your account has been successfully updated.");
    }

    @When("user clicks on the back button")
    public void user_clicks_on_the_back_button() {
        myAccountPage.clickEditAccountLink();
        myAccountPage.clickBackButton();
    }

    @Then("is display my account page")
    public void is_display_my_account_page() {
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @When("user edits all the fields and leaves them blank")
    public void user_edits_all_the_fields_and_leaves_them_blank() {
        myAccountPage.clickEditAccountLink();
        signUpPage.clearFirstNameInput();
        signUpPage.clearLastNameInput();
        signUpPage.clearEmailInput();
        signUpPage.clearPhoneInput();
        myAccountPage.clickContinueButton();
    }

    @Then("error message detailing that fields are required")
    public void error_message_detailing_that_fields_are_required() {
        softAssert.assertEquals(myAccountPage.getErrorMessageEditFirstName(), "First Name must be between 1 and 32 characters!");
        softAssert.assertEquals(myAccountPage.getErrorMessageEditLastName(), "Last Name must be between 1 and 32 characters!");
        softAssert.assertEquals(myAccountPage.getErrorMessageEditEmail(), "E-Mail Address does not appear to be valid!");
        softAssert.assertEquals(myAccountPage.getErrorMessageEditPhone(), "Telephone must be between 3 and 32 characters!");
    }

   @After("@MyAccount")
    public void tearDown() {
       driver.close();
    }

}
