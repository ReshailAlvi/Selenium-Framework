package pageObjects;
import base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;

public class LoginPage extends Driver {

    CommonMethods helper;
    public LoginPage(){
        PageFactory.initElements(driver, this);
        helper = new CommonMethods();
    }

    @FindBy(id = "emaillogin")
    WebElement emailTextbox;

    @FindBy(id = "passwordlogin")
    WebElement passwordTextbox;

    @FindBy(css = ".input-icon-right.icon-eye-close.m")
    WebElement passwordNotVisible;

    @FindBy(css = ".input-icon-right icon-eye-open.m")
    WebElement passwordVisible;

    @FindBy(className = "login-button")
    WebElement loginButton;

    @FindBy(className = "icon-facebook-square")
    WebElement signInWithFacbook;

    @FindBy(className = "icon-google-square")
    WebElement signInWIthGmail;

    @FindBy(xpath = "//button[text()='Forgot Password']")
    WebElement forgotPasswordButton;

    @FindBy(id = "error-box-wrapper")
    WebElement errorBox;

    public void enterEmail(String email){
        emailTextbox.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordTextbox.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
        helper.waitForLoader();
    }

    public String getErrorMessage(){
        return errorBox.getText();
    }

    public void clickOnLoginWithFacebook(){
        signInWithFacbook.click();
    }

    public void clickOnLoginWithGmail(){
        signInWIthGmail.click();
    }

    public void clickOnForgotPassword(){
        forgotPasswordButton.click();
        helper.waitForLoader();
    }

    public String hidePassword(){
        passwordNotVisible.click();
        driver.findElement(By.xpath("//span[contains(@class,'icon-eye-open')]")).click();
        return passwordTextbox.getAttribute("type");
    }

    public String showPassword(){
        passwordNotVisible.click();
        return passwordTextbox.getAttribute("type");
    }
}
