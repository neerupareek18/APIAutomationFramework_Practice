package APIAutomationFramework.TestCases.Booking.CRUDSamePackageITestContext;

import APIAutomationFramework.Assertions.AssertActions;
import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import APIAutomationFramework.Endpoints.Booking.APIConstantsEnum1;
import APIAutomationFramework.Modules.PayloadManager_Booking;
import APIAutomationFramework.Pojos.Booking.BookingRequest;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBooking {

    @Test
    public void deleteBookingDetails(ITestContext context1) {
        PayloadManager_Booking payloadManager = new PayloadManager_Booking();
        RequestSpecification requestSpecification = RestAssured.given().baseUri(APIConstantsClass.baseUrl);
        Response response;
        AssertActions assertActions = new AssertActions();
        Gson gson = new Gson();
        String bookingId = (String) context1.getAttribute("cBookingId");

        requestSpecification.basePath(APIConstantsEnum1.createBookingUrl+"/"+bookingId)
                .contentType(ContentType.JSON)
                .cookie("token",context1.getAttribute("ctoken"));

        response = requestSpecification.when().delete();
        response.then().log().all();

        BookingRequest responsePayload = gson.fromJson(response.asString(),BookingRequest.class);
        ValidatableResponse validatableResponse = response.then().statusCode(201);


    }
}
