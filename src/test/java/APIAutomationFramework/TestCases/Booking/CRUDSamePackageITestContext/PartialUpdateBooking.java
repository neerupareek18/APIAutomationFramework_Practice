package APIAutomationFramework.TestCases.Booking.CRUDSamePackageITestContext;

import APIAutomationFramework.Assertions.AssertActions;
import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import APIAutomationFramework.Endpoints.Booking.APIConstantsEnum1;
import APIAutomationFramework.Modules.PayloadManager_Booking;
import APIAutomationFramework.Pojos.Booking.BookingRequest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class PartialUpdateBooking {

    @Test
    public void patchBookingDetails(ITestContext context1) {
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        PayloadManager_Booking payloadManager = new PayloadManager_Booking();
        RequestSpecification requestSpecification = RestAssured.given().baseUri(APIConstantsClass.baseUrl);
        Response response;
        AssertActions assertActions = new AssertActions();
        Gson gson = new Gson();
        String payload = "{\n" +
                "\"firstname\":\""+firstname+"\"\n" +
                "}";
        System.out.println("Update Payload-->"+payload);

        String bookingId = (String) context1.getAttribute("cBookingId");

        requestSpecification.basePath(APIConstantsEnum1.createBookingUrl+"/"+bookingId)
                .contentType(ContentType.JSON)
                .cookie("token",context1.getAttribute("ctoken"))
                .body(payload);

        response = requestSpecification.when().patch();
        response.then().log().all();

        BookingRequest responsePayload = gson.fromJson(response.asString(),BookingRequest.class);
        Assert.assertTrue(responsePayload.getFirstname().equalsIgnoreCase(firstname));
        assertThat(responsePayload.getBookingdates()).isInstanceOf(Object.class);


    }
}
