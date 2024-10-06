package APIAutomationFramework.Pojos.Booking;

public class BookingRequest {
        String firstname;
        String lastname;
        Integer totalprice;
        Boolean depositpaid;
        String additionalneeds;
        BookingDates bookingdates;

        public String getFirstname() {
        return firstname;
    }

        public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

        public String getLastname() {
        return lastname;
    }

        public void setLastname(String lastname) {
        this.lastname = lastname;
    }

        public Integer getTotalprice() {
        return totalprice;
    }

        public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

        public Boolean getDepositpaid() {
        return depositpaid;
    }

        public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

        public String getAdditionalneeds() {
        return additionalneeds;
    }

        public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

        public BookingDates getBookingdates() {
        return bookingdates;
    }

        public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }
}
