package APIAutomationFramework.BaseClass;

import APIAutomationFramework.Endpoints.APIConstantsClass;
import APIAutomationFramework.Modules.PayloadManager;
import com.azul.crs.client.Response;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
    RequestSpecification requestSpecification;
    Response response;
    PayloadManager payloadManager;

    @BeforeTest
    public void setUp(){
        requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .setBaseUri(APIConstantsClass.baseUrl)
                .setContentType("application/json")
                .build();
    }

    @Test
    public String getToken(){
        requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .setBaseUri(APIConstantsClass.baseUrl)
                .setBasePath(APIConstantsClass.authUrl)
                .setContentType("application/json")
                .setBody(payloadManager.tokenPayload())
                .build();

//        requestSpecification = RestAssured.given().relaxedHTTPSValidation()
//                .baseUri(APIConstantsClass.baseUrl)
//                .basePath(APIConstantsClass.authUrl)
//                .contentType(ContentType.JSON)
//                .body(payloadManager.tokenPayload());

            response = (Response) requestSpecification.when().post();

            String token = payloadManager.tokenResponse(response).getToken();

        return token;
    }

    public String getBookingId(){

        return null;
    }
}
