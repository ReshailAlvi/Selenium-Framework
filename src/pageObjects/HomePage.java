package pageObjects;
import base.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Constants;
import utilities.APIUtil;
import utilities.CommonMethods;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Driver {

    CommonMethods helper;

    public HomePage(){
        PageFactory.initElements(driver,this);
        helper = new CommonMethods();
    }

    @FindBy(className = "user")
    WebElement userButton;

    @FindBy(css="a.user-button.login")
    WebElement loginButton;

    @FindBy(css="span.account-icon.icon-log-out")
    public WebElement logoutButton;

    @FindBy(className = "boutique__link")
    List<WebElement> boutiqueLinks;

    @FindBy(className = "boutique__image")
    List<WebElement> boutiqueImages;


    public void navigateToLogin(){
        helper.hoverOverElementAndClick(userButton,loginButton);
        if(!driver.getCurrentUrl().contains(Constants.loginEndpoint)){
            clickUserButton();
        }
    }

    public void hoverOverUserIcon(){
        helper.hoverOverElement(userButton);
    }

    public void clickUserButton(){
        helper.forceClick(userButton);
    }

    public List<String[]> getAllBoutiqueLinks(){
        List<String[]> data = new ArrayList<String[]>();
        data.add(new String[] {"Link", "Response_code" });

        for (int i = 0; i < boutiqueLinks.size(); i++) {
            int statusCode = APIUtil.getResponseCode(boutiqueLinks.get(i).getAttribute("href"));
            data.add(new String[]{boutiqueLinks.get(i).getAttribute("href"),Integer.toString(statusCode)});
        }
        return data;
    }

    public List<String[]> scrollThroughBoutiqueImages(){
        List<String[]> data = new ArrayList<String[]>();
        data.add(new String[] {"Link", "Response_time", "Response_Code" });
        for (int i = 0; i <boutiqueImages.size() ; i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", boutiqueImages.get(i));
            //pass the src to get response time
            APIUtil.getStatusCodeAndResponseTime(boutiqueImages.get(i).getAttribute("src"));
            data.add(new String[]{boutiqueLinks.get(i).getAttribute("href"),Double.toString(APIUtil.getResponseTime()),Integer.toString(APIUtil.getResponseCode())});
        }
        return data;
    }
}

