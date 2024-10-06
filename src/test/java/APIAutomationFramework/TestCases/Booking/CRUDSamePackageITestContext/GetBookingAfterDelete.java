package APIAutomationFramework.TestCases.Booking.CRUDSamePackageITestContext;

import APIAutomationFramework.Assertions.AssertActions;
import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import APIAutomationFramework.Modules.PayloadManager_Booking;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetBookingAfterDelete {

    @Test
    public void getBookingDetailsAfterDelete(ITestContext context1){
        PayloadManager_Booking payloadManager= new PayloadManager_Booking();
        RequestSpecification requestSpecification = RestAssured.given().baseUri(APIConstantsClass.baseUrl);
        Response response;
        AssertActions assertActions = new AssertActions();

        String bookingId = (String) context1.getAttribute("cBookingId");
        System.out.println(bookingId);

        requestSpecification.basePath(APIConstantsClass.createBookingUrl+"/"+bookingId);
        System.out.println(APIConstantsClass.createBookingUrl+"/"+bookingId);

        response = RestAssured.given(requestSpecification).when().get();

        assertActions.verifyStatusCode(response,404);

    }
}
