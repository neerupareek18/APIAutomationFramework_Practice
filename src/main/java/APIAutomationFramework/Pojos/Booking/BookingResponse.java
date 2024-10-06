package APIAutomationFramework.Pojos.Booking;

public class BookingResponse {
    private String bookingid;
    private BookingRequest booking;

    public BookingRequest getBooking() {
        return booking;
    }

    public void setBooking(BookingRequest booking) {
        this.booking = booking;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }



}
