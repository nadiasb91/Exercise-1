package Step;

import Helper.Helper;
import Pages.MyAccountPage;
import Pages.SignUpPage;
import com.google.common.base.Verify;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.xml.crypto.Data;
import java.net.PortUnreachableException;
import java.util.List;


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
    public void user_navigates_to_url_to_login() {
        driver.get(new Helper().OPENCART_URL);
    }

    @And("user log in")
    public void user_is_already_sign_up() {
        signUpPage.clickMyAccount();
        signUpPage.clickLoginMenu();
        signUpPage.sendKeysEmail("lola1@gmail.com");
        signUpPage.sendKeysPassword("1234");
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

    @Given("user is in my account information form page")
    public void user_is_in_my_account_information_form_page() {
        myAccountPage.clickEditAccountLink();
        Assert.assertEquals(driver.getTitle(), "My Account Information");
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
        signUpPage.clearPhoneInput();
        signUpPage.sendKeysPhone("123789989");

    }

    @And("user click continue button")
    public void user_click_continue_button() {
        myAccountPage.clickContinueButton();
    }

    @Then("message account updated successfully is display on my account page")
    public void message_account_updated_successfully_is_display_on_my_account_page() {
        Assert.assertEquals(myAccountPage.successMessage(), "Success: Your account has been successfully updated.");
    }

    @When("user click on the back button")
    public void user_clicks_on_the_back_button() {
        myAccountPage.clickBackButton();
    }

    @Then("is display my account page")
    public void is_display_my_account_page() {
        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @When("user edits all the fields and leaves them blank")
    public void user_edits_all_the_fields_and_leaves_them_blank() {
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
        softAssert.assertAll();
    }

    @When("user edit email to one without @")
    public void user_change_email_to_one_without_at(DataTable table) {
        List<String> list = table.asList();
        signUpPage.clearEmailInput();
        signUpPage.sendKeysEmail(list.get(0));
        signUpPage.setTypeForEmail();

    }

    @Then("error message in email field detailing that the field is invalid")
    public void error_message_in_email_field_detailing_that_the_field_is_invalid() {
        Assert.assertEquals(myAccountPage.getErrorMessageEditEmail(), "E-Mail Address does not appear to be valid!");
    }

    @When("user edit an email without domain")
    public void user_edit_an_email_without_domain(DataTable table) {
        List<String> list = table.asList();
        myAccountPage.clickEditAccountLink();
        signUpPage.clearEmailInput();
        signUpPage.sendKeysEmail(list.get(0));
    }

    @When("user click on the change password option")
    public void user_clicks_on_the_change_password_option() {
        myAccountPage.clickChangePasswordLink();
    }

    @Then("is display a change password page")
    public void is_display_change_password_page() {
        Assert.assertEquals(driver.getTitle(), "Change Password");
    }

    @Given("user is in change password page")
    public void user_is_in_change_password_page() {
        myAccountPage.clickChangePasswordLink();
        Assert.assertEquals(driver.getTitle(), "Change Password");
    }

    @Then("error message detailing that the fields are required")
    public void error_message_detailing_that_the_fields_are_required() {
        Assert.assertEquals(myAccountPage.getErrorMessageEditPassword(), "Password must be between 4 and 20 characters!");
    }

    @When("user enters a password confirm different than password")
    public void user_enters_a_password_confirm_different_than_password(DataTable table) {
        List<String> list = table.asList();
        signUpPage.sendKeysPassword(list.get(0));
        signUpPage.sendKeysPasswordConfirm(list.get(1));
    }

    @Then("error message on the password confirm field detailing that the field the both fields most be equals")
    public void error_message_on_the_password_confirm_field_detailing_that_the_field_the_both_fields_most_be_equals() {
        Assert.assertEquals(myAccountPage.getErrorMessageEditPasswordConfirm(), "Password confirmation does not match password!");
    }

    @When("user fill out the password and password confirm fields with the same value")
    public void user_fill_out_the_password_and_password_confirm_fields_with_the_same_value(DataTable table) {
        List<String> list = table.asList();
        signUpPage.sendKeysPassword(list.get(0));
        signUpPage.sendKeysPasswordConfirm(list.get(0));
    }

    @Then("message password updated successfully is display on my account page")
    public void message_password_updated_successfully_is_display_on_my_account_page() {
        Assert.assertEquals(myAccountPage.successMessage(), "Success: Your password has been successfully updated.");
    }

    @When("user click on modify your address book entries option")
    public void user_click_on_modify_your_address_book_entries_option() {
        myAccountPage.clickModifyAddressBookLink();
    }

    @Then("is display a page with address book entries")
    public void is_display_a_page_with_address_book_entries() {
        Assert.assertEquals(driver.getTitle(), "Address Book");
    }

    @And("message you have no addresses in your account")
    public void message_you_have_no_addresses_in_your_account() {
        Assert.assertEquals(myAccountPage.getMessageAddressBook(), "You have no addresses in your account.");
    }

    @Given("user is in address book entries")
    public void user_is_in_address_book_entries() {
        myAccountPage.clickModifyAddressBookLink();
        Assert.assertEquals(driver.getTitle(), "Address Book");
    }

    @When("user click on new address button")
    public void user_click_on_new_address_button() {
        myAccountPage.clickNewAddressButton();
    }

    @Then("is display a add address form")
    public void is_display_a_add_address_form() {
        Assert.assertEquals(myAccountPage.getHeaderTextFromNewAddressBook(), "Add Address");
    }

    @When("user click on the modify your wish list option")
    public void user_click_on_the_modify_your_wish_list_option() {
        myAccountPage.clickModifyWishListLink();
    }

    @Then("is display the message your wish list is empty")
    public void is_display_the_message_your_wish_list_is_empty() {
        Assert.assertEquals(myAccountPage.getMessageAddressBook(), "Your wish list is empty.");
    }

    @When("user click continue button from wish list")
    public void user_click_continue_button_from_wish_list() {
        myAccountPage.clickContinueButtonWishList();
    }

    @When("user click on view your order history option")
    public void user_click_on_view_your_order_history_option() {
        myAccountPage.clickViewOrderHistoryLink();
    }

    @Then("is display order history page")
    public void is_display_order_history_page() {
        Assert.assertEquals(driver.getTitle(), "Order History");
    }

    @And("message you have not made any previous orders")
    public void message_you_have_not_made_any_previous_orders() {
        myAccountPage.getMessageAddressBook();
    }

    @When("user click on subscribe or unsubscribe to newsletter")
    public void user_click_on_subscribe_or_unsubscribe_to_newsletter() {
        myAccountPage.clickOnSubscribeOrUnsubscribeLink();
    }

    @Then("is display newsletter subscription page")
    public void is_display_newsletter_subscription_page() {
        Assert.assertEquals(driver.getTitle(), "Newsletter Subscription");
    }

    @When("user click on option yes")
    public void user_click_on_option_yes() {
        myAccountPage.clickRadioButtonYes();
    }

    @Then("message newsletter subscription updated successfully")
    public void message_newsletter_subscription_updated_successfully() {
        Assert.assertEquals(myAccountPage.successMessage(), "Success: Your newsletter subscription has been successfully updated!");
    }

    @When("user click on option no")
    public void user_click_on_option_no() {
        myAccountPage.clickRadioButtonNo();
    }

    @After("@MyAccount")
    public void tearDown() {
        driver.close();
    }

}
