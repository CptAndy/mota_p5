public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

    }

    public String getFirstName() {
        return firstName;
    }

    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String setLastName(String lastName) {
        this.lastName = lastName;

        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return emailAddress;
    }

    @Override
    public String toString() {
        return
                firstName + "," + lastName + "," + phoneNumber + "," + emailAddress + "\n";
    }


}
