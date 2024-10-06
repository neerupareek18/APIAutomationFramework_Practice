package APIAutomationFramework.TestCases.Booking.CRUDSamePackageITestContext;

import APIAutomationFramework.Assertions.AssertActions;
import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import APIAutomationFramework.Modules.PayloadManager_Booking;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class PostBooking {

@Test
    public void createBookingId(ITestContext context1){
    PayloadManager_Booking payloadManager = new PayloadManager_Booking();
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
