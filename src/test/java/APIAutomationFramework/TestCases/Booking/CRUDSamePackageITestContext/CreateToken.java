package APIAutomationFramework.TestCases.Booking.CRUDSamePackageITestContext;

import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import APIAutomationFramework.Pojos.Booking.TokenRequest;
import APIAutomationFramework.Utilities.PropertyReader;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateToken {

    PropertyReader propertyReader = new PropertyReader();
    RequestSpecification requestSpecification;
    Response response;
    Gson gson = new Gson();

    @Test
    public void getTokenValue(ITestContext context1) throws IOException {
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setUsername(propertyReader.getValue("token.username"));
        tokenRequest.setPassword(propertyReader.getValue("token.password"));

        String payload = gson.toJson(tokenRequest);

        requestSpecification = RestAssured.given().relaxedHTTPSValidation()
                .baseUri(propertyReader.getValue("url"))
                .basePath(APIConstantsClass.authUrl)
                .body(payload)
                .contentType(ContentType.JSON);

        response = requestSpecification.when().post();

        response.then().log().all();
        context1.setAttribute("ctoken", response.jsonPath().getString("token"));

    }
}
