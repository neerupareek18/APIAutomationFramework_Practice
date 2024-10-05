package APIAutomationFramework.TestCases.CRUDSamePackageITestContext;

import APIAutomationFramework.Assertions.AssertActions;
import APIAutomationFramework.BaseClass.BaseClass;
import APIAutomationFramework.Endpoints.APIConstantsClass;
import APIAutomationFramework.Modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetBookingDetails {

    @Test
    public void getBookingDetails(ITestContext context1){
        PayloadManager payloadManager= new PayloadManager();
        RequestSpecification requestSpecification = RestAssured.given().baseUri(APIConstantsClass.baseUrl);
        Response response;
        AssertActions assertActions = new AssertActions();

        String bookingId = (String) context1.getAttribute("cBookingId");
        System.out.println(bookingId);

        requestSpecification.basePath(APIConstantsClass.createBookingUrl+"/"+bookingId);
        System.out.println(APIConstantsClass.createBookingUrl+"/"+bookingId);

        response = RestAssured.given(requestSpecification).when().get();
        System.out.println("Response Payload -->"+response.asString());

        assertActions.verifyStatusCode(response,200);

        String firstname = payloadManager.getbookingResponse(response.asString()).getFirstname();
        System.out.println(firstname);




    }
}
