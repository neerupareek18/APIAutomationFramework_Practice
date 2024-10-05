package APIAutomationFramework.TestCases.CRUD;

import APIAutomationFramework.BaseClass.BaseClass;
import APIAutomationFramework.Endpoints.APIConstantsClass;
import APIAutomationFramework.Endpoints.APIConstantsEnum;
import APIAutomationFramework.Modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class PostBooking extends BaseClass {

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
