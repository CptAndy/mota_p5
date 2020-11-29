import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class ContactList {
    List<ContactItem> contactList;
    public ContactList() {
        contactList = new ArrayList<>();
    }

    public  void newAdd(ContactItem contact){
        contactList.add(contact);
    }
    public int getSize(){
        return contactList.size();
    }
    public String updateFirstName(int index, String updatedFirstName){
        return  contactList.get(index).setFirstName(updatedFirstName);
    }

    public String updateLastName(int index, String updatedLastName){
        return  contactList.get(index).setLastName(updatedLastName);
    }
    public String updatePhoneNumber(int index, String updatedPhoneNumber){
        return contactList.get(index).setPhoneNumber(updatedPhoneNumber);
    }
    public String updateEmailAddress(int index, String updatedEmailAddress){
        return contactList.get(index).setEmailAddress(updatedEmailAddress);
    }
public void print(){
        int index = 0;
        for (ContactItem contact: contactList){
            System.out.println("----------------------------------------------");
            System.out.println("Index: " +index);
            System.out.println("----------------------------------------------");
            System.out.println("Contact info");
            System.out.println("----------------------------------------------");
            System.out.println("First name...: " + contact.getFirstName());
            System.out.println("Last name...: " + contact.getLastName());
            System.out.println("Phone number...: " + contact.getPhoneNumber());
            System.out.println("Email...: " + contact.getEmailAddress());
index++;

        }


}



    public void deleteContact(int index) {
        contactList.remove(index);
    }


    public void loadToFile(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName + ".txt");

             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // read object from file
            ContactItem contact = (ContactItem) ois.readObject();


        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            exit(0);
        }
    }
}
