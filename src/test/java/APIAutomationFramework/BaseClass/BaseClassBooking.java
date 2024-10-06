package APIAutomationFramework.BaseClass;

import APIAutomationFramework.Assertions.AssertActions;
import APIAutomationFramework.Endpoints.Booking.APIConstantsClass;
import APIAutomationFramework.Endpoints.Booking.APIConstantsEnum;
import APIAutomationFramework.Modules.PayloadManager_Booking;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

public class BaseClassBooking {
    public RequestSpecification requestSpecification;
    public Response response;
    public PayloadManager_Booking payloadManager=new PayloadManager_Booking();
    public AssertActions assertActions= new AssertActions();

    @Owner("Neeru Pareek")
    @Description("Verify that the intital setup is done properly")
    @BeforeTest
    public void a_setUp(){
        requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .setBaseUri(APIConstantsEnum.baseUrl.getValue())
                .setContentType("application/json")
                .build();
    }

    @Severity(SeverityLevel.NORMAL)
    @Owner("Neeru Pareek")
    @Description("Verify thet the token is generated correctly")

    public void b_getToken(ITestContext context){
        requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .setBaseUri(APIConstantsClass.baseUrl)
                .setBasePath(APIConstantsClass.authUrl)
                .setContentType("application/json")
                .setBody(payloadManager.tokenPayload())
                .build();

//        requestSpecification = RestAssured.given().relaxedHTTPSValidation()
//                .baseUri(APIConstantsClass.baseUrl)
//                .basePath(APIConstantsClass.authUrl)
//                .contentType(ContentType.JSON)
//                .body(payloadManager.tokenPayload());

            response = RestAssured.given(requestSpecification).when().post();

            assertActions.verifyStatusCode(response, 200);

            String stringResponse = response.asString();


            String token = payloadManager.tokenResponse(stringResponse).getToken();

            context.setAttribute("ctoken", token);


        //return token;
    }
    @BeforeTest
    public void c_getBookingId(ITestContext context){
String stringPayload = payloadManager.bookingPayloadDynamic();

        requestSpecification.basePath(APIConstantsClass.createBookingUrl)
                .body(stringPayload);

        response = RestAssured.given(requestSpecification).when().post();
        System.out.println(response.asString());

        String bookingId = payloadManager.bookingResponse(response.asString()).getBookingid();
        System.out.println(payloadManager.bookingResponse(response.asString()));

        context.setAttribute("cBookingId", bookingId);
        System.out.println(bookingId);
        //return bookingId;
    }
}
