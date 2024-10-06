package APIAutomationFramework.TestCases.Booking.CRUD;

import APIAutomationFramework.BaseClass.BaseClassBooking;
import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class PostBooking extends BaseClassBooking {

@Test
    public void createBookingId(ITestContext context){

    System.out.println("Token-->"+context.getAttribute("ctoken"));
    System.out.println(payloadManager.bookingPayloadDynamic());


    requestSpecification.basePath(APIConstantsClass.createBookingUrl)
                .body(payloadManager.bookingPayloadDynamic());

        response = RestAssured.given(requestSpecification).when().post();


        String bookingId = payloadManager.bookingResponse(response.asString()).getBookingid();
        System.out.println(bookingId);

        context.setAttribute("cBookingId", bookingId);

    }

}
