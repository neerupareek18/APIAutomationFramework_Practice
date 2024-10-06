package APIAutomationFramework.BaseClass;

import APIAutomationFramework.Endpoints.ReqResAPI.ReqResAPIConstantsClass;
import APIAutomationFramework.Modules.PayloadManager_ReqRes;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BaseClassReqResAPI {
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public PayloadManager_ReqRes payloadManager_reqRes;
    public Gson gson = new Gson();

@BeforeTest
    public void setUp() {
        requestSpecification = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .setBaseUri(ReqResAPIConstantsClass.baseUrl)
                .build();
    }

}