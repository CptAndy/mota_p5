import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class ContactApp {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        input = new Scanner(System.in);
        int choice = 0;

        try {
            do {
                /*the user will be given three options
                 * 1. Create a new contact list
                 * 2. Load a Contact List
                 * 3. Quit*/
                System.out.println("---Main Menu---");
                System.out.println("1. Create a new Contact List");
                System.out.println("2. Load an existing Contact List");
                System.out.println("3. Quit");
                System.out.println("Enter a choice: ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:

                        //will be taken to create a list menu
                        createAContactList();
                        break;
                    case 2:

loadAFileMenu();
                        break;
                    case 3:
                        System.out.println("Good bye");
                        exit(0);
                        // Exits menu
                        break;
                    default:
                        System.out.println("Choose the given options");
                        break;
                }

            } while (choice != 3);
        } catch (InputMismatchException e) {
            System.out.println("Please Enter integers only...");
            System.out.println("Enter a choice: ");
            input.nextLine();
        }
    }

    private static void createAContactList() {

        int fileChoice = 0;
        do try {
            {
                //Ask the user a if A Contact ist would like to be created
                //1. yes
                //2. no --> will take them back to menu
                System.out.println("Create a Contact List?" + "\n" +
                        "1.Yes" + "\n" + "2.No");
                System.out.println("Enter a choice: ");
                fileChoice = input.nextInt();
                switch (fileChoice) {
                    case 1:
                        ContactList contactList = new ContactList();
                        // Take me to a menu that asks and validates a file name
                        subMenu(createList(), contactList);
                        break;
                    case 2:
                        // goes back to menu
                        menu();
                        break;
                    default:
                        System.out.println("Please choose the given options");
                        break;
                }

            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Please enter an integer");
            input.nextLine();
        } while (fileChoice != 2);
    }


    private static String createList() {

        String listName = "";
        ContactList list = new ContactList();
        System.out.println("Enter a name for your list...: ");
        while (true) {
            listName = input.nextLine();

            if (!listName.isBlank() || listName.length() > 0) {


// if the file name exists ask the user to try entering a valid name...
                // if the user file exists send him back to menu...

                break;
            }
            System.out.println("Cannot leave blank!");
        }

        return listName;
    }
private static String loadList() throws FileNotFoundException {
    System.out.println("Enter name of file..");
    Scanner input = new Scanner(System.in);

String fileName = input.nextLine();
    ContactList contactList = new ContactList();
    while(true) {
        if (!fileName.trim().isEmpty() || !fileName.isBlank() || fileName.length() > 0) {


            BufferedReader abc = new BufferedReader(new FileReader(fileName + ".txt"));
            String s;

            try {
                while ((s = abc.readLine()) != null) {
                    String[] elements = s.split(",");

                    contactList.newAdd(new ContactItem(elements[0], elements[1], elements[2], elements[3]));
                    subMenu(fileName, contactList);
                }
                abc.close();
                break;


            } catch (ArrayIndexOutOfBoundsException | IOException e) {
                System.out.println("There seems to be an issue reading the file!");
                System.out.println("Returning to menu...");
                menu();
            }


        }
    }
    return fileName;
}


    private static void subMenu(String fileName, ContactList cl) throws IOException {
        int subChoice = 0;

        try {
            do {
                subMenuChoices();
                subChoice = input.nextInt();
                switch (subChoice) {

                    case 1:
    if(cl.getSize() > 0) {
        cl.print();
    }
    else {
        System.out.println("Nothing to display...");
    }
                        break;
                    case 2:
                        ContactItem contact = new ContactItem(getFirstName(), getLastName(), getPhoneNumber(), getEmailAddress());
                        cl.newAdd(contact);
                        // back to submenu
                        break;
                    case 3:

                        try {
                            int updateChoice = 0;
                            if (cl.getSize() > 0) {
                                while (updateChoice != 5) {
                                    editingMenu();
                                    updateChoice = input.nextInt();
                                    if (updateChoice == 1) {
                                        cl.updateFirstName(getIndex(), getFirstName());
                                        subMenu(fileName, cl);

                                    } else if (updateChoice == 2) {
                                        cl.updateLastName(getIndex(), getLastName());
                                        subMenu(fileName, cl);
                                    } else if (updateChoice == 3) {
                                        cl.updatePhoneNumber(getIndex(), getPhoneNumber());
                                        subMenu(fileName, cl);

                                    } else if (updateChoice == 4) {


                                        cl.updateEmailAddress(getIndex(), getEmailAddress());
                                        subMenu(fileName, cl);
                                    } else if (updateChoice == 5) {
                                        System.out.println("Returning to the sub menu");
                                        subMenu(fileName, cl);

                                    }


                                }
                            } else {
                                System.out.println("You need at least one index to begin editing");

                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");

                        }catch (InputMismatchException e){
                            System.out.println("Valid integer only");
                        }
                        break;
                    case 4:

                        try {
                            int deleteChoice = 0;
                            if (cl.getSize() > 0) {
                                while (deleteChoice != 2) {
                                    deleteMenu();
                                    deleteChoice = input.nextInt();
                                    if (deleteChoice == 1) {
                                        cl.deleteContact(getIndex());
                                        subMenu(fileName, cl);

                                    } else if (deleteChoice == 2) {
                                        System.out.println("returning to Sub menu...");
                                        subMenu(fileName, cl);

                                    }
                                }
                            } else {
                                System.out.println("You need at least one index to begin editing");

                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        break;
                    case 5:

                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+".txt"));
                           for (ContactItem c: cl.contactList){
                               writer.write(c.toString());
                           }
                           writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 6:
                        System.out.println("Returning to menu...");
                        menu();
                        break;
                    default:
                        System.out.println("Choose the given options");
                        break;

                }


            } while (subChoice != 6);
        } catch (IllegalArgumentException e) {
            System.out.println("Integers only...");

        }


    }

    private static void deleteMenu() {
        System.out.println("---Delete Contact---");
        System.out.println("Delete a Contact?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    private static int getIndex() {
        System.out.println("Which index: ");
        return input.nextInt();
    }

    private static void editingMenu() {
        System.out.println("--- Editing Contact Menu---");
        System.out.println(" ");
        System.out.println("What would you like to edit?");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Phone number");
        System.out.println("4. E-Mail");
        System.out.println("5. Exit");
    }

    private static String getFirstName() {
        String firstName = "";
        System.out.println("Enter a First Name...: ");
        while (true) {

            firstName = input.nextLine();
            if (!firstName.isBlank()) {
                break;
            }
        }
        return firstName;
    }

    private static String getLastName() {
        String lastName = "";
        System.out.println("Enter a Last Name...: ");
        while (true) {
            lastName = input.nextLine();
            if (!lastName.isBlank()) {
                break;
            }
        }
        return lastName;
    }

    private static String getPhoneNumber() {
        String phone = "";
        System.out.println("Enter a phone number");

        while (true) {
            phone = input.nextLine();
            Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}"); // follows the format
            Matcher matcher = pattern.matcher(phone);
            if (!phone.isEmpty() && !phone.isBlank() && matcher.matches()) {
                break;
            }
        }
        return phone;
    }

    private static String getEmailAddress() {
        String email = "";
        System.out.println("Enter a valid e-mail");
        while (true) {
            email = input.nextLine();
            Pattern pattern = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches() && !email.isBlank()) {
                break;
            }
        }
        return email;
    }

    private static void subMenuChoices() {
        System.out.println("List Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add a contact\n" +
                "3) edit a contact\n" +
                "4) remove a contact\n" +
                "5) Write to list\n" +
                "6) Exit to menu\n" );

        System.out.println("Enter a choice...");
    }

    private static void loadAFileMenu() {
        input = new Scanner(System.in);
        // If the user hits yes they will be asked for a name for the file
        // If the file exists asks for a new file name
        // if the user hits no they will be taken back to the menu
        int fileChoice = 0;

        do try {
            {

                System.out.println("Would you like to load a List?" + "\n" +
                        "1.Yes" + "\n" + "2.No");
                fileChoice = input.nextInt();
                switch (fileChoice) {
                    case 1:
                        ContactList contactList = new ContactList();
                        subMenu(loadList(),contactList);
                        //asks for file name
                        //if the file exists asks again
                        //if the file name does not exist go to a submenu

                        break;
                    case 2:
                        menu();
                        break;
                    default:
                        System.out.println("Choose the given options");
                }

            }
        } catch (InputMismatchException ex) {
            System.out.println("Please enter an Integer");
            input.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("File not found returning to menu...");
            menu();
        } catch (IOException e) {
            e.printStackTrace();
        } while (fileChoice != 2);

    }
}
