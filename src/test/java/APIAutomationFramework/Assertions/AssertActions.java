package APIAutomationFramework.Assertions;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertActions {

    public void verifyStatusCode(Response response, int expectedCode){
        Assert.assertEquals(response.getStatusCode(), expectedCode);
    }
}
