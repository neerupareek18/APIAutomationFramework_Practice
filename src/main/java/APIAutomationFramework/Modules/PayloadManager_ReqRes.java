package APIAutomationFramework.Modules;

import APIAutomationFramework.Pojos.ReqResAPI.*;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class PayloadManager_ReqRes {
    Gson gson = new Gson();
    static Faker faker = new Faker();
    public static String name = faker.name().firstName();
    public static String job = faker.job().position();

    public String createUserPayload(){

        CreateRequest createRequest= new CreateRequest();

        createRequest.setName(name);
        createRequest.setJob(job);

        String payload = gson.toJson(createRequest);

        return payload;
    }

    public ListUsersResponse listUsersResponsePayload(String response){

    ListUsersResponse listUsersResponsePayload = gson.fromJson(response, ListUsersResponse.class);
        return listUsersResponsePayload;
}

    public SingleUserResponse singleUserResponsePayload(String response){

        SingleUserResponse singleUserResponsePayload = gson.fromJson(response, SingleUserResponse.class);
        return singleUserResponsePayload;
    }

    public CreateResponse createResponsePayload(String response){

    CreateResponse createResponsePayload = gson.fromJson(response, CreateResponse.class);
    return createResponsePayload;
}

//public String SuccRegisterRequestPayload(){
//
//}
//
//public RegisterResponse RegisterResponsePayload(){
//
//}
//
//    public String UnsuccRegisterRequestPayload(){
//
//    }
//
//    public RegisterResponse UnsuccRegisterResponsePayload(){
//
//    }


}