package APIAutomationFramework.TestCases.Booking.CRUDSamePackageITestContext;

import APIAutomationFramework.Assertions.AssertActions;
import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import APIAutomationFramework.Endpoints.Booking.APIConstantsEnum1;
import APIAutomationFramework.Modules.PayloadManager_Booking;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class FullUpdateBooking {

    @Test
    public void updateBookingDetails(ITestContext context1) {
        PayloadManager_Booking payloadManager = new PayloadManager_Booking();
        RequestSpecification requestSpecification = RestAssured.given().baseUri(APIConstantsClass.baseUrl);
        Response response;
        AssertActions assertActions = new AssertActions();
        String payload = payloadManager.bookingPayloadDynamic();
        System.out.println("Update Payload-->"+payload);

        String bookingId = (String) context1.getAttribute("cBookingId");

        requestSpecification.basePath(APIConstantsEnum1.createBookingUrl+"/"+bookingId)
                .contentType(ContentType.JSON)
                .cookie("token",context1.getAttribute("ctoken"))
                .body(payload);

        response = requestSpecification.when().put();
        response.then().log().all();

    }
}
