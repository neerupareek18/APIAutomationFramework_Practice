package APIAutomationFramework.TestCases.CRUDSamePackageITestContext;

import APIAutomationFramework.Assertions.AssertActions;
import APIAutomationFramework.BaseClass.BaseClass;
import APIAutomationFramework.Endpoints.APIConstantsClass;
import APIAutomationFramework.Modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class PostBooking {

@Test
    public void createBookingId(ITestContext context1){
    PayloadManager payloadManager = new PayloadManager();
    RequestSpecification requestSpecification = RestAssured.given().baseUri(APIConstantsClass.baseUrl);
    Response response;
    AssertActions assertActions = new AssertActions();

    System.out.println("Token-->"+context1.getAttribute("ctoken"));

    requestSpecification.basePath(APIConstantsClass.createBookingUrl)
            .contentType(ContentType.JSON)
                .body(payloadManager.bookingPayloadDynamic());

        response = RestAssured.given(requestSpecification).when().post();
        System.out.println(response.asString());


        String bookingId = payloadManager.bookingResponse(response.asString()).getBookingid();
        System.out.println(bookingId);

        context1.setAttribute("cBookingId", bookingId);

    }

}
