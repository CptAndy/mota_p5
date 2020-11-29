import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class TaskApp {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);

        int choice = 0;
        do try {
            {
                System.out.println("---Main Menu---\n" +
                        "\n" +
                        "\n" +
                        "1) create a new list\n" +
                        "2) load an existing list\n" +
                        "3) quit");
                System.out.println("Enter a choice...: ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        createAFileMenu();

                        break;
                    case 2:
                        loadAFileMenu();
                        break;
                    case 3:
                        System.out.println("Good bye");
                        exit(0);
                        break;
                    default:
                        System.out.println("Choose the given options");
                        break;

                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Please Enter Integers only");
            input.nextLine();
        } while (choice != 3);
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
                        TaskList tl = new TaskList();

                        //asks for file name
                        //if the file exists asks again
                        //if the file name does not exist go to a submenu
                        ;
                        subMenu(loadList(), tl);
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

    private static void createAFileMenu() {
        input = new Scanner(System.in);
        // If the user hits yes they will be asked for a name for the file
        // If the file exists asks for a new file name
        // if the user hits no they will be taken back to the menu
        int fileChoice = 0;

        do try {
            {

                System.out.println("Would you like to create a List?" + "\n" +
                        "1.Yes" + "\n" + "2.No");
                fileChoice = input.nextInt();
                switch (fileChoice) {
                    case 1:
                        TaskList tl = new TaskList();

                        //asks for file name
                        //if the file exists asks again
                        //if the file name does not exist go to a submenu
                        ;
                        subMenu(createList(), tl);
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
        } while (fileChoice != 2);

    }

    private static String createList() {


        input = new Scanner(System.in);
        String listName = "";
        TaskList list = new TaskList();

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

    private static String loadList() throws IOException {
        input = new Scanner(System.in);
        String fileName = "";

        TaskList tl = new TaskList();
        ArrayList<TaskItem> ti = new ArrayList<>();
//get the name
        //if the name exists
        //Load it
        //go to submenu
        while (true) {
            System.out.println("Invalid file name will take you back to menu.");
            System.out.println("Enter the name of the file you would like to load...:");

            fileName = input.nextLine();

            if (!fileName.trim().isEmpty() || !fileName.isBlank() || fileName.length() > 0) {


                BufferedReader abc = new BufferedReader(new FileReader(fileName + ".txt"));
                String s;

                try {
                    while ((s = abc.readLine()) != null) {
                        String[] elements = s.split(",");

                        tl.newAdd(new TaskItem(elements[0], elements[1], elements[2], Boolean.parseBoolean(elements[3])));
                        subMenu(fileName, tl);
                    }

                    abc.close();
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("There seems to be an issue reading the file!");
                    System.out.println("Returning to menu...");
                    menu();
                }


            }

        }

        return fileName;
    }

    private static void subMenu(String fileName, TaskList tl) {


        int fileChoice = 0;
        Scanner input = new Scanner(System.in);
//Create a file?

        // If yes get file name
        //store in filename
        //go to submenu
        // Load a file?
        //if yes enter file to load
        //store in file name go to sub menu
        int subChoice = 0;
        do try {

            {

                subMenuChoices();
                subChoice = input.nextInt();

                switch (subChoice) {

                    case 1:
                        tl.print();
                        break;
                    case 2:
                        TaskItem task = new TaskItem(getTaskName(), getTaskDescription(), getTaskDueDate(), false); // Automatically set to incomplete
                        tl.newAdd(task);
                        // back to submenu
                        break;
                    case 3:
                        int updateChoice = 0;

                        try {
                            if (tl.getSize() > 0) {
                                while (updateChoice != 4) {
                                    System.out.println("--- Editing Tasks Menu---");
                                    System.out.println(" ");
                                    System.out.println("What would you like to edit?");
                                    System.out.println("1. Task name");
                                    System.out.println("2. Description");
                                    System.out.println("3. Due date");
                                    System.out.println("4. Exit back to sub menu");
                                    updateChoice = input.nextInt();

                                    if (updateChoice == 1) {
                                        tl.updateTitle(getIndex(), getTaskName());
                                        subMenu(fileName, tl);
                                        break;
                                    } else if (updateChoice == 2) {
                                        tl.updateDescription(getIndex(), getTaskDescription());
                                        subMenu(fileName, tl);
                                        break;
                                    } else if (updateChoice == 3) {
                                        tl.updateDuedate(getIndex(), getTaskDueDate());
                                        subMenu(fileName, tl);
                                        break;
                                    } else if (updateChoice == 4) {
                                        System.out.println("Returning to sub menu...");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Add a task Item to begin editing....");
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        // back to sub menu
                        break;
                    case 4:

                        int deleteChoice = 0;

                        try {
                            if (tl.getSize() > 0) {
                                while (deleteChoice != 2) {
                                    System.out.println("--- Delete Task Menu---");
                                    System.out.println(" ");
                                    System.out.println("Delete a task?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    deleteChoice = input.nextInt();

                                    if (deleteChoice == 1) {
                                        tl.deleteTask(getIndex());
                                        subMenu(fileName, tl);
                                        break;
                                    } else if (deleteChoice == 2) {
                                        System.out.println("Returning to sub menu...");
                                        subMenu(fileName, tl);
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Need at least 1 task to delete....");
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        //delete a whole task index PERIODT
                        break;
                    case 5:
                        int markChoice = 0;

                        try {
                            if (tl.getSize() > 0) {
                                while (markChoice != 2) {
                                    System.out.println("--- Mark as Complete---");
                                    System.out.println(" ");
                                    System.out.println("Complete a task?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    markChoice = input.nextInt();

                                    if (markChoice == 1) {
                                        tl.setComplete(true, getIndex());
                                        subMenu(fileName, tl);
                                        break;
                                    } else if (markChoice == 2) {

                                        System.out.println("Returning to sub menu...");
                                        break;

                                    }
                                }
                            } else {
                                System.out.println("Need at least 1 task to delete....");
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        // Would you like to mark a task?
                        // yes or no
                        // if yes ask for index
                        // get index
                        // mark as complete
                        break;
                    case 6:
                        int unmarkChoice = 0;

                        try {
                            if (tl.getSize() > 0) {
                                while (unmarkChoice != 2) {
                                    System.out.println("--- Mark as Incomplete---");
                                    System.out.println(" ");
                                    System.out.println("Unmark a task?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");

                                    unmarkChoice = input.nextInt();

                                    if (unmarkChoice == 1) {
                                        tl.setComplete(false, getIndex());
                                        subMenu(fileName, tl);
                                        break;
                                    } else if (unmarkChoice == 2) {
                                        System.out.println("Returning to sub menu...");

                                        subMenu(fileName, tl);
                                        break;

                                    }
                                }
                            } else {
                                System.out.println("Need at least 1 task to delete....");
                                break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Enter a valid index");
                        }
                        break;
                    case 7:
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
                            for (TaskItem t : tl.taskList) {
                                writer.write(t.toString());

                            }
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 8:
                        menu();
                        // back to menu
                        break;
                    default:
                        System.out.println("Choose the given options");
                        break;

                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Integers only");
            input.nextLine();
        } while (subChoice != 8);

    }

    private static void subMenuChoices() {
        System.out.println("List Operation Menu\n" +
                "---------\n" +
                "\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu");
        System.out.println("Enter a choice...");
    }

    public static int getIndex() {
        Scanner indexInput = new Scanner(System.in);
        int index = 0;
        System.out.println("Which index....?");
        index = indexInput.nextInt();
        return index;

    }

    private static String getTaskDueDate() {
        Scanner taskDueDateInput = new Scanner(System.in);
        String taskDueDate = "";


        while (true) {

            System.out.println("xxxx-xx-xx");
            System.out.println("Year/Month/day");
            System.out.println("Enter a Duedate...: ");
            taskDueDate = taskDueDateInput.nextLine();
            Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}"); // follows the format xxxx/xx/xx
            Matcher matcher = pattern.matcher(taskDueDate);
            if (!taskDueDate.isEmpty() && !taskDueDate.isBlank() && matcher.matches()) {
                break;
            }
        }

        return taskDueDate;

    }

    private static String getTaskDescription() {
        Scanner taskDescriptionInput = new Scanner(System.in);
        String taskDescription = "";
        while (true) {
            System.out.println("Enter a Description...: ");
            taskDescription = taskDescriptionInput.nextLine();
            if (!taskDescription.isEmpty() || !taskDescription.isBlank() || taskDescription.length() > 0) {
                break;
            }
        }
        return taskDescription;
    }

    private static String getTaskName() {
        Scanner taskNameInput = new Scanner(System.in);
        String taskName = "";
        while (true) {
            System.out.println("Enter a name for this task...: ");
            taskName = taskNameInput.nextLine();
            if (!taskName.isEmpty() || !taskName.isBlank()) {
                break;
            }
        }
        return taskName;
    }


}
