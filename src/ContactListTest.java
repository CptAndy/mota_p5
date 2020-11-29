import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    void editingSucceedsWithBlankEmail() {
        ContactList list = new ContactList();
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);
        assertEquals("Email", contact.getEmailAddress());

        list.updateEmailAddress(0, "");
        if (contact.getEmailAddress().equals("")) {
            contact.setEmailAddress("N/A");

        }
        assertEquals("N/A", contact.getEmailAddress());
        System.out.println(contact);

    }

    @Test
    void editingSucceedsWithBlankFirstName() {
        ContactList list = new ContactList();
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);
        assertEquals("A", contact.getFirstName());

        list.updateFirstName(0, "");
        if (contact.getFirstName().equals("")) {
            contact.setFirstName("N/A");

        }
        assertEquals("N/A", contact.getFirstName());
        System.out.println(contact);
    }

    @Test
    void getFirstNameFromMethod() {
        String a = "";
        System.out.println(name(a));
        ContactList list = new ContactList();
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactItem contact = new ContactItem(name(a), b, c, d);
        list.newAdd(contact);
        assertEquals("Name from method", contact.getFirstName());

    }

    public static String name(String name) {
        name = "Name from method";

        return name;
    }

    @Test
    void getLastNameFromMethod() {
        String b = "";
        System.out.println(lname());
        ContactList list = new ContactList();
        String a = "First Name";
        String c = "xxx-xxx-xxxx";
        String d = "xxx@xxx.com";
        ContactItem contact = new ContactItem(a, lname(), c, d);
        list.newAdd(contact);
        assertEquals("Last name from method", contact.getLastName());
    }

    public static String lname() {
        String lname = "Last name from method";
        return lname;
    }

    @Test
    void getValidPhoneNumberFromMethod() {
        String a = "First Name";
        String b = "Last Name";
        String c = "";
        String d = "xxx@xxx.com";
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem(a, b, phone(c), d);
        list.newAdd(contact);
        System.out.println(phone(c));
        assertEquals("110-111-1111", contact.getPhoneNumber());
    }

    @Test
    void getInvalidPhoneNumberFromMethod() {
        String a = "First Name";
        String b = "Last Name";
        String c = "";
        String d = "xxx@xxx.com";
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem(a, b, invalidPhone(c), d);
        list.newAdd(contact);
        System.out.println(invalidPhone(c));
        assertEquals("Invalid number", contact.getPhoneNumber());

    }

    public static String invalidPhone(String c) {
        String phone = "";
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}"); // follows the format
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()) {
            return "Invalid number";
        } else ;
        return phone;


    }

    public static String phone(String phone) {
        phone = "110-111-1111";
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}"); // follows the format
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) {
            return phone;
        } else {
            return "xxx-xxx-xxxx";
        }
    }

    @Test
    void getValidEmailFromMethod() {
        String a = "First Name";
        String b = "Last Name";
        String c = "111-111-1111";
        String d = "111@gmail.com";
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem(a, b, c, email(d));
        System.out.println(contact);
        assertEquals("111@gmail.com", contact.getEmailAddress());
    }

    @Test
    void getInvalidEmailFromMethod() {
        String a = "First Name";
        String b = "Last Name";
        String c = "111-111-1111";
        String d = "1";
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem(a, b, c, email(d));
        System.out.println(contact);
        assertEquals("Invalid Email", contact.getEmailAddress());
    }

    private String email(String email) {

        Pattern pattern = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return email;
        } else {
            return "Invalid Email";
        }

    }

    @Test
    void editingSucceedsWithBlankLastName() {
        ContactList list = new ContactList();
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);
        assertEquals("B", contact.getLastName());

        list.updateLastName(0, "");
        if (contact.getLastName().equals("")) {
            contact.setLastName("N/A");

        }
        assertEquals("N/A", contact.getLastName());
        System.out.println(contact);
    }

    @Test
    void editingSucceedsWithBlankPhone() {
        ContactList list = new ContactList();
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);
        assertEquals("C", contact.getPhoneNumber());

        list.updatePhoneNumber(0, "");
        if (contact.getPhoneNumber().equals("")) {
            contact.setPhoneNumber("xxx-xxx-xxxx");

        }
        assertEquals("xxx-xxx-xxxx", contact.getPhoneNumber());
        System.out.println(contact);
    }

    @Test
    void editingSucceedsWithNonBlankValues() {
        ContactList list = new ContactList();
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);

        list.updateFirstName(0, "Edited");
        list.updateLastName(0, "Edited");
        list.updatePhoneNumber(0, "Edited");
        list.updateEmailAddress(0, "Edited@updated.com");
        assertEquals("Edited", contact.getPhoneNumber());
        assertEquals("Edited@updated.com", contact.getEmailAddress());
        assertEquals("Edited", contact.getLastName());
        assertEquals("Edited", contact.getLastName());


        System.out.println(contact);
    }

    @Test
    void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);
        assertEquals(1, list.getSize());
    }

  @Test
    void indexOutofBoundsForUpdatingEmail(){
      ContactList list = new ContactList();
      String a = "A";
      String b = "B";
      String c = "C";
      String d = "Email";
      ContactItem contact = new ContactItem(a, b, c, d);
      list.newAdd(contact);
assertThrows(IndexOutOfBoundsException.class,() -> list.updateEmailAddress(1,contact.setEmailAddress("out")));
  }
  @Test
    void indexOutOfBoundsForEditingPhoneNumber(){
      ContactList list = new ContactList();
      String a = "A";
      String b = "B";
      String c = "C";
      String d = "Email";
      ContactItem contact = new ContactItem(a, b, c, d);
      list.newAdd(contact);
      assertThrows(IndexOutOfBoundsException.class,() -> list.updatePhoneNumber(1,contact.setPhoneNumber("out-out-outt")));
  }
@Test
    void indexOutOfBoundsForEditingFirstName(){
    ContactList list = new ContactList();
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "Email";
    ContactItem contact = new ContactItem(a, b, c, d);
    list.newAdd(contact);
    assertThrows(IndexOutOfBoundsException.class,() -> list.updateFirstName(1,contact.setFirstName("outofbounds")));

}
@Test
    void indexOutOfBoundsForEditingLastName(){
    ContactList list = new ContactList();
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "Email";
    ContactItem contact = new ContactItem(a, b, c, d);
    list.newAdd(contact);
    assertThrows(IndexOutOfBoundsException.class,() -> list.updateLastName(1,contact.setLastName("outofboundJones")));


}
@Test
    void removeIndex(){
    ContactList list = new ContactList();
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "Email";
    ContactItem contact = new ContactItem(a, b, c, d);
    list.newAdd(contact);
    list.newAdd(new ContactItem("2","2","2","2"));
    list.print();
    System.out.println("--------------------------------------------------------------------------------------------");
    System.out.println("--------------------------------------------------------------------------------------------");
    list.deleteContact(0);

    list.print();
    assertEquals(1,list.getSize());

}
@Test
    void removeIndexFailsOutOfBounds(){
    ContactList list = new ContactList();
    list.newAdd(new ContactItem("2","2","2","2"));

    assertThrows(IndexOutOfBoundsException.class,() -> list.deleteContact(3));


}
@Test
    void readContactsFromFile() throws FileNotFoundException {
    ContactList contactList = new ContactList();
    BufferedReader abc = new BufferedReader(new FileReader("exam 2" + ".txt"));
    String s;

    try {
        while ((s = abc.readLine()) != null) {
            String[] elements = s.split(",");

            contactList.newAdd(new ContactItem(elements[0], elements[1], elements[2], elements[3]));

        }
        abc.close();
        contactList.print();



    } catch (ArrayIndexOutOfBoundsException | IOException e) {
        System.out.println("There seems to be an issue reading the file!");
    }


}
@Test
    void writeToFile(){
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "Email";
        ContactList list = new ContactList();
    ContactItem contact = new ContactItem(a, b, c, d);
    list.newAdd(contact);

    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("testme.txt"));
        for (ContactItem elements: list.contactList){
            writer.write(elements.toString());
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }


}
@Test
    void writeUpdatedFirstNameToFile(){
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "Email";
    ContactList list = new ContactList();
    ContactItem contact = new ContactItem(a, b, c, d);
    list.newAdd(contact);
    list.updateFirstName(0,"updated");
   assertEquals("updated",contact.getFirstName());
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Updated first name.txt"));
        for (ContactItem elements: list.contactList){
            writer.write(elements.toString());
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
    @Test
    void writeUpdatedLastNameToFile(){
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);
        list.updateLastName(0,"updated");
        assertEquals("updated",contact.getLastName());
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Updated last name.txt"));
            for (ContactItem elements: list.contactList){
                writer.write(elements.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    void writeUpdatedPhoneNumberToFile(){
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);
        list.updatePhoneNumber(0,"updated");
        assertEquals("updated",contact.getPhoneNumber());
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Updated phone number.txt"));
            for (ContactItem elements: list.contactList){
                writer.write(elements.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void writeUpdatedEmailToFile(){
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "Email";
        ContactList list = new ContactList();
        ContactItem contact = new ContactItem(a, b, c, d);
        list.newAdd(contact);
        list.updateEmailAddress(0,"updated@updated.com");
        assertEquals("updated@updated.com",contact.getEmailAddress());
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Updated Email.txt"));
            for (ContactItem elements: list.contactList){
                writer.write(elements.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
@Test
    void writeAllUpdatedValuesToFile(){
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "Email";
    ContactList list = new ContactList();
    ContactItem contact = new ContactItem(a, b, c, d);
    list.newAdd(contact);

    list.updateFirstName(0,"updated");
    assertEquals("updated",contact.getFirstName());
    list.updateLastName(0,"updated");
    assertEquals("updated",contact.getLastName());
    list.updatePhoneNumber(0,"updated");
    assertEquals("updated",contact.getPhoneNumber());
    list.updateEmailAddress(0,"updated@updated.com");
    assertEquals("updated@updated.com",contact.getEmailAddress());
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Updated values.txt"));
        for (ContactItem elements: list.contactList){
            writer.write(elements.toString());
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
@Test
    void readFileThenAddNewContactTofile() throws IOException {
    ContactList contactList = new ContactList();
    BufferedReader abc = new BufferedReader(new FileReader("testme" + ".txt"));
    String s;

    try {
        while ((s = abc.readLine()) != null) {
            String[] elements = s.split(",");

            contactList.newAdd(new ContactItem(elements[0], elements[1], elements[2], elements[3]));

        }
        abc.close();


    } catch (IOException e){
        e.printStackTrace();
    }
    contactList.newAdd(new ContactItem("a2","b2","c2","d2"));
    contactList.print();
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("testme.txt"));
        for (ContactItem elements: contactList.contactList){
            writer.write(elements.toString());
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
    void readFileThenRemoveContact() throws FileNotFoundException {
    ContactList contactList = new ContactList();
    BufferedReader abc = new BufferedReader(new FileReader("testme" + ".txt"));
    String s;

    try {
        while ((s = abc.readLine()) != null) {
            String[] elements = s.split(",");

            contactList.newAdd(new ContactItem(elements[0], elements[1], elements[2], elements[3]));

        }
        abc.close();


    } catch (IOException e){
        e.printStackTrace();
    }
    contactList.deleteContact(3);
    contactList.print();
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("testme.txt"));
        for (ContactItem elements: contactList.contactList){
            writer.write(elements.toString());
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
    void readFileThenUpdateFirstName() throws FileNotFoundException {
    ContactList contactList = new ContactList();
    BufferedReader abc = new BufferedReader(new FileReader("testme" + ".txt"));
    String s;

    try {
        while ((s = abc.readLine()) != null) {
            String[] elements = s.split(",");

            contactList.newAdd(new ContactItem(elements[0], elements[1], elements[2], elements[3]));

        }
        abc.close();
        contactList.print();



    } catch (ArrayIndexOutOfBoundsException | IOException e) {
        System.out.println("There seems to be an issue reading the file!");
    }
    contactList.updateFirstName(0,"Updated first name");
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("testme.txt"));
        for (ContactItem elements: contactList.contactList){
            writer.write(elements.toString());
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    contactList.print();
}
@Test
    void readFileThenUpdateLastName() throws FileNotFoundException {
        ContactList contactList = new ContactList();
        BufferedReader abc = new BufferedReader(new FileReader("testme" + ".txt"));
        String s;

        try {
            while ((s = abc.readLine()) != null) {
                String[] elements = s.split(",");

                contactList.newAdd(new ContactItem(elements[0], elements[1], elements[2], elements[3]));

            }
            abc.close();
            contactList.print();



        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("There seems to be an issue reading the file!");
        }
        contactList.updateLastName(0,"Updated last name");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("testme.txt"));
            for (ContactItem elements: contactList.contactList){
                writer.write(elements.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contactList.print();
    }
    @Test
    void readFileThenUpdatePhone() throws FileNotFoundException {
        ContactList contactList = new ContactList();
        BufferedReader abc = new BufferedReader(new FileReader("testme" + ".txt"));
        String s;

        try {
            while ((s = abc.readLine()) != null) {
                String[] elements = s.split(",");

                contactList.newAdd(new ContactItem(elements[0], elements[1], elements[2], elements[3]));

            }
            abc.close();
            contactList.print();



        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("There seems to be an issue reading the file!");
        }
        contactList.updatePhoneNumber(0,"Updated phone number");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("testme.txt"));
            for (ContactItem elements: contactList.contactList){
                writer.write(elements.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contactList.print();
    }
    @Test
    void readFileThenUpdateEmail() throws FileNotFoundException {
        ContactList contactList = new ContactList();
        BufferedReader abc = new BufferedReader(new FileReader("testme" + ".txt"));
        String s;

        try {
            while ((s = abc.readLine()) != null) {
                String[] elements = s.split(",");

                contactList.newAdd(new ContactItem(elements[0], elements[1], elements[2], elements[3]));

            }
            abc.close();
            contactList.print();



        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("There seems to be an issue reading the file!");
        }
        contactList.updateEmailAddress(0,"Updated@email.com");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("testme.txt"));
            for (ContactItem elements: contactList.contactList){
                writer.write(elements.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        contactList.print();
    }
    @Test
    void checkIfFileExists(){
        File file = new File("testme.txt");
        assertTrue(file.exists());
    }
    @Test
    void checkIfFileWithUpdatedValuesExist(){
        File file = new File("Updated values.txt");
        assertTrue(file.exists());
    }
    @Test
    void checkForFileThatDoesNotExist(){
        File file = new File("Updated 0 values.txt");
        assertFalse(file.exists());
    }
@Test
    void checkIfFileIsReadable(){
    File file = new File("testme.txt");
    assertTrue(file.canRead());

}
}