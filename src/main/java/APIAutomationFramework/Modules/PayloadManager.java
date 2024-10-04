package APIAutomationFramework.Modules;

import APIAutomationFramework.Endpoints.APIConstantsClass;
import APIAutomationFramework.Pojos.*;
import com.azul.crs.client.Response;
import io.restassured.response.*;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class PayloadManager {

Faker faker = new Faker();
public String firstname = faker.name().firstName();
Gson gson = new Gson();

    public String bookingPayloadDynamic(){
        BookingRequest bp = new BookingRequest();
        bp.setFirstname(firstname);
        bp.setLastname(faker.name().lastName());
        bp.setDepositpaid(true);
        bp.setTotalprice(faker.random().nextInt(3));
        bp.setAdditionalneeds(faker.food().ingredient());

        BookingDates bdp = new BookingDates();
        bdp.setCheckin("10-09-2024");
        bdp.setCheckout("10-10-2024");

        bp.setBookingdates(bdp);

        String payload = gson.toJson(bp);

        return payload;
    }

    public BookingResponse bookingResponse(Response response){
        String stringResponse = response.toString();
        BookingResponse bookingResponse = gson.fromJson(stringResponse, BookingResponse.class);
        return bookingResponse;
    }

    public String tokenPayload(){
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setUsername(APIConstantsClass.tokenusername);
        tokenRequest.setPassword(APIConstantsClass.tokenpassword);

        String payload = gson.toJson(tokenRequest);
        return payload;
    }

    public TokenResponse tokenResponse(Response response){
        String stringResponse = response.toString();
        TokenResponse tResponse = gson.fromJson(stringResponse, TokenResponse.class);
        return tResponse;
    }


}
