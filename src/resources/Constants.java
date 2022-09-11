package resources;

public class Constants {

    //Remote driver endpoint
    public static String remoteDriver = "http://localhost:4445";
    //config.properties file path
    public static String configProperties = "/src/resources/config.properties";

    //endpoints to validate
    public static String loginEndpoint = "/login";
    public static String ordersEndpoint = "/account/orders";
    public static String forgotPasswordEndpoint = "/sifremiunuttum";
    public static String facebookLoginEndpoint = "https://www.facebook.com/login";
    public static String googleLoginEndpoint = "/accounts.google.com";

    //path of excel sheets we will write data to
    public static String pathForTestData = "/src/resources/testdata.xlsx";
    public static String loginDataFileName = "LoginData";
    public static String pathForBoutiqueLinksSheet = "/src/resources/boutiqueLinks.xlsx";
    public static String pathForBoutiqueLinkImagesSheet = "/src/resources/boutiqueImages.xlsx";

    //Error messages
    public static String errorMessageForInvalidCredentials = "Your e-mail address and/or password is incorrect.";
    public static String errorMessageForCredentialsMissing = "Enter your e-mail and password.";

    //Driver variables
    public static int standardTimeOut = 20;
    public static int standardWaitTime = 10;
}
