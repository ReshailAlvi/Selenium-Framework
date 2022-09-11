package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIUtil {

    static int responseCode;
    static double responseTime;

    public static int getResponseCode() {
        return responseCode;
    }

    private static void setResponseCode(int responseCode) {
        APIUtil.responseCode = responseCode;
    }

    public static double getResponseTime() {
        return responseTime;
    }

    private static void setResponseTime(double responseTime) {
        APIUtil.responseTime = responseTime;
    }

    public static int getResponseCode(String link){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(link);

        setResponseCode(response.getStatusCode());
        return getResponseCode();
    }

    public static void getStatusCodeAndResponseTime(String link){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(link);

        setResponseTime(response.time());
        setResponseCode(response.statusCode());
    }
}
