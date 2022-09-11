package tests;

import base.Driver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Constants;
import utilities.DataProvider;

public class LoginTests extends Driver{
    LoginPage loginPage;
    HomePage homePage;
    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        initiateDriver(browser);
        homePage= new HomePage();
        loginPage = new LoginPage();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

    @BeforeMethod
    public void navigateToLogin(){
        homePage.navigateToLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.loginEndpoint));
    }

    @Test(priority = 1,dataProvider = "LoginTestData", dataProviderClass = DataProvider.class)
    public void signInWithValidCredentials(String testname,String userId, String pwd) {
        //login using the credentials fetched from data provider
        loginPage.enterEmail(userId);
        loginPage.enterPassword(pwd);
        loginPage.clickLoginButton();
        homePage.clickUserButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.ordersEndpoint));
    }

    @Test(dataProvider = "LoginTestData", dataProviderClass = DataProvider.class)
    public void signInWithInvalidCredentials(String testname,String userId, String pwd) {
        //login using the credentials fetched from data provider
        loginPage.enterEmail(userId);
        loginPage.enterPassword(pwd);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),Constants.errorMessageForInvalidCredentials);
    }

    @Test(dataProvider = "LoginTestData", dataProviderClass = DataProvider.class)
    public void signInWitoutEmail(String testname,String userId, String pwd) {
        //login using the credentials fetched from data provider
        loginPage.enterEmail(userId);
        loginPage.enterPassword(pwd);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),Constants.errorMessageForCredentialsMissing);
    }

    @Test(dataProvider = "LoginTestData", dataProviderClass = DataProvider.class)
    public void signInWitoutPassword(String testname,String userId, String pwd) {
        //login using the credentials fetched from data provider
        loginPage.enterEmail(userId);
        loginPage.enterPassword(pwd);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),Constants.errorMessageForCredentialsMissing);
    }

    @Test(dataProvider = "LoginTestData", dataProviderClass = DataProvider.class)
    public void signInWitoutEmailAndPassword(String testname,String userId, String pwd) {
        //login using the credentials fetched from data provider
        loginPage.enterEmail(userId);
        loginPage.enterPassword(pwd);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),Constants.errorMessageForCredentialsMissing);
    }

    @Test
    public void signInWithGmail() {
        //login using the credentials fetched from data provider
        loginPage.clickOnLoginWithGmail();
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.googleLoginEndpoint));
    }

    @Test
    public void signInWithFacebook() {
        //login using the credentials fetched from data provider
        loginPage.clickOnLoginWithFacebook();
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.facebookLoginEndpoint));
    }

    /*
    Another possible test case where user is already logged into facebook and asked to give permission (lands on auth page)
     */

    @Test
    public void clickOnForgetPassword()  {
        //login using the credentials fetched from data provider
        loginPage.clickOnForgotPassword();
        Assert.assertTrue(driver.getCurrentUrl().contains(Constants.forgotPasswordEndpoint));
    }

    @Test
    public void verifyShowPasswordIconDisplaysPassowrd() {
        //login using the credentials fetched from data provider
        loginPage.enterPassword("Is this visible");
        String textboxState = loginPage.showPassword();
        Assert.assertEquals(textboxState,"text");
    }

    @Test
    public void verifyHidePasswordIconHidesPassowrd() {
        //login using the credentials fetched from data provider
        loginPage.enterPassword("Is this visible");
        String textboxState = loginPage.hidePassword();
        Assert.assertEquals(textboxState,"password");
    }

    @Test
    public void failingTest(){
        Assert.assertTrue(2==1);
    }

}
