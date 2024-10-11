package APIAutomationFramework.TestCases.ReqResAPI.Integration;

import APIAutomationFramework.BaseClass.BaseClassReqResAPI;
import APIAutomationFramework.Endpoints.ReqResAPI.ReqResAPIConstantsClass;
import APIAutomationFramework.Listners.RetryAnalyzer;
import APIAutomationFramework.Modules.PayloadManager_ReqRes;
import APIAutomationFramework.Pojos.ReqResAPI.*;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

@Test(retryAnalyzer = RetryAnalyzer.class)
public class IntegrationScenariosReqResAPI extends BaseClassReqResAPI{

    @Test(priority = 1)
    public void listUsers(ITestContext context){
        payloadManager_reqRes = new PayloadManager_ReqRes();

requestSpecification
        .basePath(ReqResAPIConstantsClass.listUsersOnPage);

    response = RestAssured.given(requestSpecification).when().get();

    assertThat(response.getTime()).isLessThan(5000l);

    ListUsersResponse listUsersResponse = payloadManager_reqRes.listUsersResponsePayload(response.asString());

    int pages = listUsersResponse.getTotal_pages();

//-------------------------------------------------------------------------------------------------

for(int i=1;i<=pages;i++){
   requestSpecification
        .basePath(ReqResAPIConstantsClass.listUsersOnPage+"?pages="+i);

    response = RestAssured.given(requestSpecification).when().get();
    ListUsersResponse listUsersResponse1 = payloadManager_reqRes.listUsersResponsePayload(response.asString());
    System.out.println("Ids on Page"+i);
    for(DataResponse data: listUsersResponse1.getData()){
            System.out.println(data.getId());
        }
    }

int id = listUsersResponse.getData().get(0).getId();
context.setAttribute("id",id);
    }

    @Test(priority = 2)
    public void getSingleUserDetails(ITestContext context){
int id = (int) context.getAttribute("id");

requestSpecification.basePath(ReqResAPIConstantsClass.listUsersOnPage+"/"+id);
response = RestAssured.given(requestSpecification).when().get();


        validatableResponse = response.then().statusLine("HTTP/1.1 200 OK");
        assertThat(response.statusLine()).contains("200 OK");

        SingleUserResponse singleUserResponse = gson.fromJson(response.asString(), SingleUserResponse.class);
        System.out.println(singleUserResponse.getData().getId());
        System.out.println(singleUserResponse.getData().getEmail());
        System.out.println(singleUserResponse.getData().getFirst_name());
        System.out.println(singleUserResponse.getData().getLast_name());
        System.out.println(singleUserResponse.getData().getAvatar());
        System.out.println(singleUserResponse.getSupport().getUrl());
        System.out.println(singleUserResponse.getSupport().getText());
    }

    @Test(priority = 3)
    public void getDetailsIdNotExists(ITestContext context) {
        Faker faker = new Faker();
        int id = faker.random().nextInt(90);

        requestSpecification.basePath(ReqResAPIConstantsClass.listUsersOnPage + "/" + id);
        response = RestAssured.given(requestSpecification).when().get();
        System.out.println(response.asString());
        validatableResponse = response.then().statusCode(404);
        assertThat(response).isInstanceOf(Object.class);
    }

    @Test (priority = 4)
    public void createUser(ITestContext context1){
        payloadManager_reqRes = new PayloadManager_ReqRes();
        String name = PayloadManager_ReqRes.name;

        String payload = payloadManager_reqRes.createUserPayload();

        requestSpecification.basePath(ReqResAPIConstantsClass.createUser)
                .contentType(ContentType.JSON)
                .body(payload);

        response = RestAssured.given(requestSpecification).when().post();

        response.then().log().all();
        CreateResponse createResponsePayload = gson.fromJson(response.asString(), CreateResponse.class);

        context1.setAttribute("creationId", createResponsePayload.getId());
        assertThat(createResponsePayload.getName()).isEqualTo(name);
    }

    @Test(priority = 5)
    public void getUserDetails(ITestContext context1){
        String id = (String) context1.getAttribute("creationId");
        requestSpecification.basePath(ReqResAPIConstantsClass.createUser+"/"+id);
        response = RestAssured.given(requestSpecification).when().get();
        response.then().log().all();
    }

}
