package APIAutomationFramework.TestCases.Booking.CRUD;

import APIAutomationFramework.BaseClass.BaseClassBooking;
import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetBookingDetails extends BaseClassBooking {

    @Test
    public void getBookingDetails(ITestContext context){

        String bookingId = (String) context.getAttribute("cBookingId");
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
