package APIAutomationFramework.Endpoints.Booking;

public enum APIConstantsEnum {

    baseUrl("https://restful-booker.herokuapp.com");
    private final String value;


    APIConstantsEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
