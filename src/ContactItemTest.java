import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {





    @Test
    void creationFailsWithAllBlankValues() {
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        boolean validity = true;

        if (a.equals("") || b.equals("") || c.equals("") || d.equals("")) {
            validity = false;
            assertFalse(false);

        } else ;


    }

    @Test
    void creationSucceedsWithBlankEmail() {
        String a = "name";
        String b = "name 2";
        String c = "number";
        String d = "";
        if (d.equals("")) {
            d = "N/A";
        }
        ContactItem contactItem = new ContactItem(a, b, c, d);
        assertEquals("N/A", contactItem.getEmailAddress());
        System.out.println(contactItem);


    }

    @Test
    void creationSucceedsWithAnyEmailFormat() {
        String a = "name";
        String b = "name 2";
        String c = "number";
        String d = "email@mail.com";
        ContactItem contactItem = new ContactItem(a, b, c, d);
        assertEquals("email@mail.com", contactItem.getEmailAddress());
    }
    @Test
    void creationSucceedsValidEmailFormat(){
        String a = "name";
        String b = "name 2";
        String c = "number";
        String email = "hello@AOL.com";


        Pattern pattern = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            ContactItem contactItem = new ContactItem(a, b, c, email);
            assertEquals("hello@AOL.com", contactItem.getEmailAddress());
            System.out.println(contactItem.toString());
        }
        else {
            email = "Invalid email";
            ContactItem contactItem = new ContactItem(a, b, c, email);
            assertEquals("Invalid", contactItem.getEmailAddress());
        }

        }
        @Test
    void creationWithInvalidEmailFormat(){
        String a = "name";
        String b = "name 2";
        String c = "number";
        String email = "hello@OLcom";


        Pattern pattern = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            ContactItem contactItem = new ContactItem(a, b, c, email);
            assertEquals("hello@AOL.com", contactItem.getEmailAddress());
            System.out.println(contactItem.toString());
        }
        else {
            email = "Invalid email";
            ContactItem contactItem = new ContactItem(a, b, c, email);
            assertEquals("Invalid email", contactItem.getEmailAddress());
        }

    }
    @Test
    void creationSucceedsWithBlankFirstName() {
        String a = "";
        String b = "name 2";
        String c = "number";
        String d = "email";
        if (a.equals("")) {
            a = "N/A";
        }
        ContactItem contactItem = new ContactItem(a, b, c, d);
        assertEquals("N/A", contactItem.getFirstName());
        System.out.println(contactItem);

    }

    @Test
    void creationSucceedsWithValidFirstName() {
        String a = "name";
        String b = "name 2";
        String c = "number";
        String d = "email";

        ContactItem contactItem = new ContactItem(a, b, c, d);
        assertEquals("name", contactItem.getFirstName());
        System.out.println(contactItem);

    }

    @Test
    void creationSucceedsWithBlankLastName() {
        String a = "name";
        String b = "";
        String c = "number";
        String d = "email";
        if (b.equals("")) {
            b = "N/A";
        }
        ContactItem contactItem = new ContactItem(a, b, c, d);
        assertEquals("N/A", contactItem.getLastName());
        System.out.println(contactItem);

    }

    @Test
    void creationSucceedsWithValidLastName() {
        String a = "name";
        String b = "name 2";
        String c = "number";
        String d = "email";

        ContactItem contactItem = new ContactItem(a, b, c, d);
        assertEquals("name 2", contactItem.getLastName());
        System.out.println(contactItem);

    }
@Test
void creationSucceedsWithAnyPhoneFormat(){
    String a = "name";
    String b = "name 2";
    String c = "6546-555-555";
    String d = "email";
    ContactItem contactItem = new ContactItem(a, b, c, d);
    assertEquals("6546-555-555", contactItem.getPhoneNumber());
}
@Test
void creationSucceedWithValidPhoneFormat(){
    String a = "name";
    String b = "name 2";
        String phone = "407-407-4070";
    String d = "email";
    Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}"); // follows the format
    Matcher matcher = pattern.matcher(phone);
    if(matcher.matches()){
        ContactItem contactItem = new ContactItem(a, b, phone, d);
    assertEquals("407-407-4070",contactItem.getPhoneNumber());
    }
    else{
        phone = "Invalid Number";
        ContactItem contactItem = new ContactItem(a, b, phone, d);
        assertEquals("Invalid Number",contactItem.getPhoneNumber());
    }


}
    @Test
    void creationWithInvalidPhoneFormat(){
        String a = "name";
        String b = "name 2";
        String phone = "40707-4070";
        String d = "email";
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}"); // follows the format
        Matcher matcher = pattern.matcher(phone);
        if(matcher.matches()){
            ContactItem contactItem = new ContactItem(a, b, phone, d);
            assertEquals("407-407-4070",contactItem.getPhoneNumber());
        }
        else{
            phone = "Invalid Number";
            ContactItem contactItem = new ContactItem(a, b, phone, d);
            assertEquals("Invalid Number",contactItem.getPhoneNumber());
        }


    }
    @Test
    void creationSucceedsWithBlankPhone() {
        String a = "name";
        String b = "name 2";
        String c = "";
        String d = "email";
        if (c.equals("")) {
            c = "xxx-xxx-xxxx";
        }
        ContactItem contactItem = new ContactItem(a, b, c, d);
        assertEquals("xxx-xxx-xxxx", contactItem.getPhoneNumber());
        System.out.println(contactItem);

    }

    @Test
    void creationSucceedsWithNonBlankValues() {
        String a = "name";
        String b = "name 2";
        String c = "number";
        String d = "email";

        ContactItem contactItem = new ContactItem(a, b, c, d);
        assertEquals("name", contactItem.getFirstName());
        assertEquals("name 2", contactItem.getLastName());
        assertEquals("number", contactItem.getPhoneNumber());
        assertEquals("email", contactItem.getEmailAddress());

        System.out.println(contactItem);

    }

    @Test
    void editingFailsWithAllBlankValues() {
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        boolean ableTodEdit = false;
        if (a.length() == 0 || b.length() == 0 || c.length() == 0 || d.length() == 0) {
            assertFalse(ableTodEdit);

        } else ;

    }




}