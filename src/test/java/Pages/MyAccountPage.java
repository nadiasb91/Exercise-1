package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {


    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Your Store")
    WebElement yourStoreLink;
    @FindBy(linkText = "Edit your account information")
    WebElement editAccountLink;
    @FindBy(xpath = "//*[@id=\"account-account\"]/div[1]")
    WebElement successMessage;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    WebElement continueButton;
    @FindBy(linkText = "Back")
    WebElement backButton;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[1]/div/div")
    WebElement errorMessageEditFirstName;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[2]/div/div")
    WebElement errorMessageEditLastName;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[3]/div/div")
    WebElement errorMessageEditEmail;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[4]/div/div")
    WebElement errorMessageEditPhone;


    public String getStoreLinkText() {
        return yourStoreLink.getText();
    }

    public void clickEditAccountLink() {
        editAccountLink.click();
    }

    public String successMessage() {
        return successMessage.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickBackButton(){
        backButton.click();
    }

    public String getErrorMessageEditFirstName(){
        return errorMessageEditFirstName.getText();
    }

    public String getErrorMessageEditLastName(){
        return errorMessageEditLastName.getText();
    }
    public String getErrorMessageEditEmail(){
        return errorMessageEditEmail.getText();
    }
    public String getErrorMessageEditPhone(){
        return errorMessageEditPhone.getText();
    }
}
