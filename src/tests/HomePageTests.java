package tests;

import base.Driver;
import org.testng.annotations.*;
import pageObjects.HomePage;
import resources.Constants;
import utilities.ExcelUtil;
import java.util.List;

public class HomePageTests extends Driver {

    HomePage homePage;

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        initiateDriver(browser);
        homePage = new HomePage();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }


    @Test(priority = 1)
    public void linkAndResponseCodeForBoutiques(){
        //get all links with <a> tag with class boutique__links
        List<String[]> dataToWriteToExcel = homePage.getAllBoutiqueLinks();
        //write the link and response code to an excel file
        ExcelUtil.writeDataAtOnce(System.getProperty("user.dir") + Constants.pathForBoutiqueLinksSheet,dataToWriteToExcel);
    }

    @Test(priority = 2)
    public void loadTimeAndResponseCodeForBoutiqueImages(){
        //get all links with boutique img
        List<String[]> dataToWriteToExcel = homePage.scrollThroughBoutiqueImages();
        //write the link and response code to an excel file
        ExcelUtil.writeDataAtOnce(System.getProperty("user.dir") + Constants.pathForBoutiqueLinkImagesSheet,dataToWriteToExcel);
    }

}
