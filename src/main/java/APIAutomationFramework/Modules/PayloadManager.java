package APIAutomationFramework.Modules;

import APIAutomationFramework.Endpoints.APIConstantsClass;
import APIAutomationFramework.Pojos.*;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.testng.TestInstanceParameter;
import org.junit.Test;

public class PayloadManager {

Faker faker = new Faker();
public String firstname = faker.name().firstName();
public String lastname = faker.name().lastName();
Gson gson = new Gson();


    public String bookingPayloadDynamic(){
        BookingRequest bp = new BookingRequest();
        bp.setFirstname(firstname);
        bp.setLastname(lastname);
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

    public BookingResponse bookingResponse(String stringResponse){
        BookingResponse bookingResponse = gson.fromJson(stringResponse, BookingResponse.class);
        return bookingResponse;
    }

    public BookingRequest getbookingResponse(String stringResponse){
        BookingRequest bookingRequest = gson.fromJson(stringResponse, BookingRequest.class);
        return bookingRequest;
    }



    public String tokenPayload(){
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setUsername(APIConstantsClass.tokenusername);
        tokenRequest.setPassword(APIConstantsClass.tokenpassword);

        String payload = gson.toJson(tokenRequest);
        return payload;
    }

    public TokenResponse tokenResponse(String stringResponse){
        TokenResponse tResponse = gson.fromJson(stringResponse, TokenResponse.class);
        return tResponse;
    }


}
