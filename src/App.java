import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class App {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        try {
            do {
                System.out.println("App Menu");
                System.out.println("1.Task List App");
                System.out.println("2.Contact App");
                System.out.println("3.Exit");
                System.out.println("Choose an option: ");
             choice = input.nextInt();
                switch (choice) {
                    case 1:
                        TaskApp taskApp = new TaskApp();
                        taskApp.menu();
                        break;
                    case 2:
                        ContactApp contactApp = new ContactApp();
                        contactApp.menu();
                        break;
                    case 3:
                        System.out.println("Goodbye!");
                        exit(0);
                        break;
                    default:
                        System.out.println("Enter one of the given choices...");

                }

            } while (choice != 3);
        } catch (InputMismatchException e) {
            System.out.println("Integers only...");
            input.nextLine();
        }
    }
}
