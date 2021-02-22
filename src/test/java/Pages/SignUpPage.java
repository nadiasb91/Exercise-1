package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title=\"My Account\"]")
    WebElement myAccountOption;
    @FindBy(linkText = "Register")
    WebElement registerOption;
    @FindBy(id = "input-firstname")
    WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    WebElement lastNameInput;
    @FindBy(id = "input-email")
    WebElement emailInput;
    @FindBy(id = "input-telephone")
    WebElement phoneInput;
    @FindBy(id = "input-password")
    WebElement passwordInput;
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordInput;
    @FindBy(name = "agree")
    WebElement policyCheckBox;
    @FindBy(xpath = "//input[@value=\"Continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    WebElement loginOption;
    @FindBy(xpath = "//input[@value=\"Login\"]")
    WebElement loginButton;
    @FindBy(xpath = "//div[@id=\"account-register\"]/div[1][@class=\"alert\"]")
    WebElement errorMessagePolicy;
    @FindBy(xpath = "//*[@id=\"account\"]/div[2]/div/div")
    WebElement errorMessageFirstName;
    @FindBy(xpath = "//*[@id=\"account\"]/div[3]/div/div")
    WebElement errorMessageLastName;
    @FindBy(xpath = "//*[@id=\"account\"]/div[4]/div/div")
    WebElement errorMessageEmail;
    @FindBy(xpath = "//*[@id=\"account\"]/div[5]/div/div")
    WebElement errorMessagePhone;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
    WebElement errorMessagePassword;
    @FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
    WebElement messageEmailDuplicated;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")
    WebElement errorMessageConfirmPassword;


    public void clickMyAccount() {
        myAccountOption.click();
    }

    public void clickRegisterOption() {
        registerOption.click();
    }


    public void sendKeysToForm(String firstname, String lastname, String email, String phone, String password, String passwordConfirm) {
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(passwordConfirm);

    }

    public void sendKeysFirstNameField(String firstname) {

        firstNameInput.sendKeys(firstname);
    }

    public void clickPolicyCheckBox() {
        policyCheckBox.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickLoginMenu() {
        loginOption.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String errorMessageFirstName() {
        this.waitUntilVisibilityOfElement(errorMessageFirstName);
        return errorMessageFirstName.getText();
    }

    public String errorMessageLastName() {
        this.waitUntilVisibilityOfElement(errorMessageLastName);
        return errorMessageLastName.getText();
    }

    public String errorMessageEmail() {
        this.waitUntilVisibilityOfElement(errorMessageEmail);
        return errorMessageEmail.getText();
    }

    public String errorMessagePhone() {
        this.waitUntilVisibilityOfElement(errorMessagePhone);
        return errorMessagePhone.getText();
    }

    public String errorMessagePassword() {
        this.waitUntilVisibilityOfElement(errorMessagePassword);
        return errorMessagePassword.getText();
    }

    public String errorMessagePolicy() {
        this.waitUntilVisibilityOfElement(errorMessagePolicy);
        return errorMessagePolicy.getText();
    }

    public String messageEmailDuplicated() {
        return messageEmailDuplicated.getText();

    }

    public String errorMessageConfirmPassword() {
        return errorMessageConfirmPassword.getText();
    }

    public void emailInput(String email) {
        // emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void passwordInput(String password) {
        // passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void phoneInput(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void clearFirstNameInput() {
        firstNameInput.clear();
    }

    public void clearLastNameInput() {
        lastNameInput.clear();
    }

    public void clearEmailInput() {
        emailInput.clear();
    }

    public void clearPhoneInput() {
        phoneInput.clear();
    }

    public void setTypeForEmail(){
        String script="document.getElementById(\"input-email\").setAttribute('type','text');";
       // var JSExecutor = ;
        ((JavascriptExecutor)driver).executeScript(script,emailInput);
    }

    public void waitUntilVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

