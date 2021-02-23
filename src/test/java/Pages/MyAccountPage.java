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
    @FindBy(linkText = "Change your password")
    WebElement changePasswordLink;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[1]/div/div")
    WebElement errorMessageEditPassword;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div[2]/div/div")
    WebElement errorMessageEditPasswordConfirm;
    @FindBy(linkText = "Modify your address book entries")
    WebElement modifyAddressBookLink;
    @FindBy(xpath = "//div[@id=\"content\"]/p")
    WebElement messageAddressBook;
    @FindBy(linkText = "New Address")
    WebElement newAddressButton;
    @FindBy(xpath = "//div[@id=\"content\"]/h2")
    WebElement headerNewAddress;
    @FindBy(linkText = "Modify your wish list")
    WebElement modifyWishListLink;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    WebElement continueButtonWishList;
    @FindBy(linkText = "View your order history")
    WebElement viewOrderHistoryLink;
    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    WebElement subscribeOrUnsubscribeLink;
    @FindBy(xpath = "//label[1]/input[@name=\"newsletter\"]")
    WebElement radioButtonYes;
    @FindBy(xpath = "//label[2]/input[@name=\"newsletter\"]")
    WebElement radioButtonNo;

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

    public void clickChangePasswordLink(){
        changePasswordLink.click();
    }

    public String getErrorMessageEditPassword(){
        return errorMessageEditPassword.getText();
    }

    public String getErrorMessageEditPasswordConfirm(){
        return errorMessageEditPasswordConfirm.getText();
    }

    public void clickModifyAddressBookLink(){
        modifyAddressBookLink.click();
    }

    public String getMessageAddressBook(){
        return messageAddressBook.getText();
    }

    public void clickNewAddressButton(){
        newAddressButton.click();
    }
    public String getHeaderTextFromNewAddressBook(){
       return headerNewAddress.getText();
    }

    public void clickModifyWishListLink(){
        modifyWishListLink.click();
    }
    public void clickContinueButtonWishList(){
        continueButtonWishList.click();
    }
    public void clickViewOrderHistoryLink(){
        viewOrderHistoryLink.click();
    }
    public void clickOnSubscribeOrUnsubscribeLink(){
        subscribeOrUnsubscribeLink.click();
    }
    public void clickRadioButtonYes(){
        radioButtonYes.click();
    }

    public void clickRadioButtonNo(){
        radioButtonNo.click();
    }
}
