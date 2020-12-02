import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class App
{
    public static void main(String [] args)
    {
        boolean run = true;



        Scanner appScanner = new Scanner (System.in);
        do{
            showAppMenu();
            int input = appScanner.nextInt();
            if (input == 1){
                runTask();
            } else if (input == 2){
                runContact();
            } else if (input == 3){
                System.exit(0);
            } else {
                System.out.println("INVALID INPUT");
            }
        }while (run == true);

    }


    public static void runTask(){
        do{
            showMainMenu();
            Scanner stringScanner = new Scanner(System.in);
            Scanner myScanner = new Scanner(System.in);
            int input = myScanner.nextInt();
            if (input == 1){
                TaskList tl = new TaskList();
                System.out.println("new task list has been created");
                runOp(tl);
            } else if (input == 2){
                System.out.println("Enter the filename to load: ");
                String in = stringScanner.nextLine();
                TaskList tl = new TaskList();
                tl = getSavedList(in);
                runOp(tl);
            } else if (input == 3){
                break;
            } else {
                System.out.println("INVALID INPUT");
            }
        } while (true);
    }

    public static void runContact(){
        do{
            showMainMenu();
            Scanner myScanner = new Scanner(System.in);
            Scanner stringScanner = new Scanner(System.in);
            int input = myScanner.nextInt();
            if (input == 1){
                ContactList cl = new ContactList();
                System.out.println("new contact list has been created");
                runOpContact(cl);
            } else if (input == 2){
                System.out.println("Enter the filename to load: ");
                String in = stringScanner.nextLine();
                ContactList cl = new ContactList();
                cl = getContactSavedList(in);
                runOpContact(cl);
            } else if (input == 3){
                break;
            } else {
                System.out.println("INVALID INPUT");
            }
        } while (true);
    }

    public static void runOpContact(ContactList cl){
        {
            Scanner intScanner = new Scanner (System.in);
            do {
                showOpMenuContact();
                int in = intScanner.nextInt();
                if (in == 1){
                    System.out.println("Current Contacts");
                    System.out.println("-------------");
                    System.out.println();
                    System.out.println(cl.toString());
                } else if (in == 6){
                    break;
                } else if (in == 2){
                    Scanner stringScanner = new Scanner (System.in);
                    System.out.print("First Name: ");
                    String fn = askForFirst();
                    System.out.print("Last Name: ");
                    String ln = askForLast();
                    System.out.print("Phone number (xxx-xxx-xxxx): ");
                    String phone = askForPhone();
                    System.out.print("Email address (x@y.z)" );
                    String email = askForEmail();
                    if (!fn.equals("fail") && !ln.equals("fail") && !phone.equals("fail") && !email.equals("fail")){
                        ContactItem ci = new ContactItem(fn, ln, phone, email);
                        cl.addItem(ci);
                    } else if(fn.equals("fail")){
                        System.out.println("WARNING: first name must be at least 1 character long; task not created");
                    } else if (ln.equals("fail")){
                        System.out.println("WARNING: last name must be at least 1 character long; task not created");
                    } else if (phone.equals("fail")){
                        System.out.println("WARNING: phone must be at least 1 character long; task not created");
                    } else if (email.equals("fail")){
                        System.out.println("WARNING: email must be at least 1 character long; task not created");
                    }

                } else if (cl.size == 0){
                    System.out.println("THER ARE NO CONTACTS");
                } else if (in == 3){
                    System.out.println("Current Contacts");
                    System.out.println("------------");
                    System.out.println();
                    System.out.println(cl.toString());
                    System.out.println();
                    System.out.println("Which contact will you edit? ");
                    int contactNumber = askForContactNumber(cl);
                    if (contactNumber != -1){
                        System.out.print("Enter a new first name for contact " + contactNumber + ": ");
                        String fn = askForFirst();
                        System.out.print("Enter a new last name for contact " + contactNumber + ": ");
                        String ln = askForLast();
                        System.out.print("Enter a nwe phone number (xxx-xxx-xxxx) for contact " + contactNumber + ": ");
                        String phone = askForPhone();
                        System.out.print("Enter a new email address for contact " + contactNumber + ": ");
                        String email = askForEmail();
                        if (!fn.equals("fail") && !ln.equals("fail") && !phone.equals("fail") && !email.equals("fail")){
                            cl.getItem(contactNumber).setFirst(fn);
                            cl.getItem(contactNumber).setLast(ln);
                            cl.getItem(contactNumber).setPhone(phone);
                            cl.getItem(contactNumber).setEmail(email);
                        } else if(fn.equals("fail")){
                            System.out.println("WARNING: first name must be at least 1 character long; task not created");
                        } else if (ln.equals("fail")){
                            System.out.println("WARNING: last name must be at least 1 character long; task not created");
                        } else if (phone.equals("fail")){
                            System.out.println("WARNING: phone must be at least 1 character long; task not created");
                        } else if (email.equals("fail")){
                            System.out.println("WARNING: email must be at least 1 character long; task not created");
                        }
                    }
                }
                else if (in == 4){
                    System.out.println("Current Contacts");
                    System.out.println("------------");
                    System.out.println();
                    System.out.println(cl.toString());
                    System.out.println();
                    System.out.println("Which contact will you remove? ");
                    int contactNumber = askForContactNumber(cl);
                    if (contactNumber != -1){
                        cl.removeItem(contactNumber);
                    }
                } else if (in == 5){
                    System.out.println("Enter the file name to save as: ");
                    Scanner stringScanner = new Scanner (System.in);
                    String fileName = stringScanner.nextLine();
                    cl.saveList(fileName);
                    System.out.println("contact list has been saved");
                }
            } while (true);
        }
    }


    public static void showAppMenu(){
        System.out.println("Select Your Application");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit");
    }

    public static void showMainMenu(){
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println();
    }

    public static void showOpMenu(){
        System.out.println();
        System.out.println("List Operation Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println();
    }

    public static void showOpMenuContact(){
        System.out.println();
        System.out.println("List Operation Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");
        System.out.println();
    }

    //getSavedList(file)
//return an ArrayList of saved TaskItem from file
    public static TaskList getSavedList(String stringFile){
        TaskList tl = new TaskList();
        File txtFile = new File (stringFile);
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(txtFile));

            String line = in.readLine();

            while (line != null){
                tl.addItem(new TaskItem(mySplit(line)[0],mySplit(line)[1],mySplit(line)[2]));
                line = in.readLine();
            }

            in.close();
        }
        catch (IOException io)
        {
            System.out.println("IOException:" + io.getMessage());
        }

        return tl;
    }

    public static ContactList getContactSavedList(String stringFile){
        ContactList cl = new ContactList();
        File txtFile = new File (stringFile);
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(txtFile));

            String line = in.readLine();

            while (line != null){
                //System.out.println(line);
                String [] fLine = line.split(" ");
                line = in.readLine();
                //System.out.println(line);
                String [] sLine = line.split(" ");
                line = in.readLine();
                //System.out.println(line);
                String [] tLine = line.split(" ");
                cl.addItem(new ContactItem(fLine[1], fLine[2], sLine[1], tLine[1]));
                line = in.readLine();
            }

            in.close();
        }
        catch (IOException io)
        {
            System.out.println("IOException:" + io.getMessage());
        }

        return cl;
    }


    public static void runOp(TaskList tl){
        Scanner intScanner = new Scanner (System.in);

        do {
            showOpMenu();
            int in = intScanner.nextInt();
            if (in == 1){
                System.out.println("Current Tasks");
                System.out.println("-------------");
                System.out.println();
                System.out.println(tl.toString());
            } else if (in == 8){
                break;
            } else if (in == 2){
                Scanner stringScanner = new Scanner (System.in);
                System.out.print("Task title: ");
                String tt = askForTitle();
                System.out.print("Task description: ");
                String td = askForDescription();
                System.out.print("Task due date (YYYY-MM-DD): ");
                String tdd = askForDd();
                if (!tt.equals("fail") && !td.equals("fail") && !tdd.equals("fail")){
                    TaskItem ti = new TaskItem(tt, td, tdd);
                    tl.addItem(ti);
                } else if(tt.equals("fail")){
                    System.out.println("WARNING: title must be at least 1 character long; task not created");
                } else if (tdd.equals("fail")){
                    System.out.println("WARNING: invalid due date; task not created");
                }

            } else if (tl.size == 0){
                System.out.println("THERE ARE NO TASKS");
            } else if (in == 3){
                System.out.println("Current Tasks");
                System.out.println("------------");
                System.out.println();
                System.out.println(tl.toString());
                System.out.println();
                System.out.println("Which task will you edit? ");
                int taskNumber = askForTaskNumber(1,tl);
                if (taskNumber != -1){
                    System.out.print("Enter a new title for task " + taskNumber + ": ");
                    String tt = askForTitle();
                    System.out.print("Enter a new description for task " + taskNumber + ": ");
                    String td = askForDescription();
                    System.out.print("Enter a enw due date (YYYY-MM-DD) for task " + taskNumber + ": ");
                    String tdd = askForDd();
                    if (!tt.equals("fail") && !td.equals("fail") && !tdd.equals("fail")){
                        tl.getItem(taskNumber).editTitle(tt);
                        tl.getItem(taskNumber).editDescription(td);
                        tl.getItem(taskNumber).editDd(tdd);
                    } else if(tt.equals("fail")){
                        System.out.println("WARNING: title must be at least 1 character long; task not edited");
                    } else if (tdd.equals("fail")){
                        System.out.println("WARNING: invalid due date; task not edited");
                    }

                }
            } else if (in == 4){
                System.out.println("Current Tasks");
                System.out.println("------------");
                System.out.println();
                System.out.println(tl.toString());
                System.out.println();
                System.out.println("Which task will you remove? ");
                int taskNumber = askForTaskNumber(1,tl);
                if (taskNumber != -1){
                    tl.removeItem(taskNumber);
                }
            } else if (in == 5){
                System.out.println("Uncompleted Tasks");
                System.out.println("------------");
                System.out.println();
                tl.printIncompleteTask();
                System.out.println();
                System.out.println("Which task will you mark as completed");
                int taskNumber = askForTaskNumber(2,tl);
                if (taskNumber != -1){

                    tl.completeTask(taskNumber);
                }else {System.out.println("INVALID INPUT");}
            } else if (in == 6){
                System.out.println("Completed Tasks");
                System.out.println("------------");
                System.out.println();
                tl.printCompleteTask();
                System.out.println();
                System.out.println("Which task will you unmark as completed");
                int taskNumber = askForTaskNumber(3,tl);
                if (taskNumber != -1){

                    tl.incompleteTask(taskNumber);
                } else {System.out.println("INVALID INPUT");}
            } else if (in == 7){
                System.out.println("Enter the file name to save as: ");
                Scanner stringScanner = new Scanner (System.in);
                String fileName = stringScanner.nextLine();
                tl.saveList(fileName);
                System.out.println("task list has been saved");
            }
        } while (true);
    }

    public static String askForTitle(){
        Scanner myScanner = new Scanner (System.in);
        String input = myScanner.nextLine();
        if (input.equals("")){
            //System.out.println("INVALID TT");
            return "fail";
        }
        return input;
    }

    public static String askForDescription(){
        Scanner myScanner = new Scanner (System.in);
        String input = myScanner.nextLine();
        return input;
    }

    public static String askForDd(){
        Scanner myScanner = new Scanner (System.in);
        String input = myScanner.nextLine();
        if (input.equals("")){
            return "fail";
        }
        return input;
    }

    public static String askForEmail(){
        Scanner myScanner = new Scanner (System.in);
        String input = myScanner.nextLine();
        if (input.equals("")){
            return "fail";
        }
        return input;
    }

    public static String askForFirst(){
        Scanner myScanner = new Scanner (System.in);
        String input = myScanner.nextLine();
        if (input.equals("")){
            return "fail";
        }
        return input;
    }

    public static String askForLast(){
        Scanner myScanner = new Scanner (System.in);
        String input = myScanner.nextLine();
        if (input.equals("")){
            return "fail";
        }
        return input;
    }

    public static String askForPhone(){
        Scanner myScanner = new Scanner (System.in);
        String input = myScanner.nextLine();
        if (input.equals("")){
            return "fail";
        }
        return input;
    }

    public static int askForTaskNumber(int type, TaskList tl){
        Scanner intScanner = new Scanner (System.in);
        if (type == 1){
            int input = intScanner.nextInt();
            if (input >= 0 && input <= tl.size()){
                return input;
            }
            return -1;
        } else if (type == 2){
            if (tl.incompleteListSize() == 0){
                return -1;
            } else {
                int input = intScanner.nextInt();
                if (input >= 0 && input <= tl.incompleteListSize()){
                    return input;
                } else {return -1;}}
        } else {
            if (tl.completeListSize() == 0){
                return -1;
            } else {
                int input = intScanner.nextInt();
                if (input >= 0 && input <= tl.completeListSize()){
                    return input;
                } else {return -1;}
            }
        }
    }

    public static int askForContactNumber(ContactList cl){
        Scanner intScanner = new Scanner (System.in);
        int input = intScanner.nextInt();
        if (input < 0 || input > cl.size()-1){
            return -1;
        }
        return input;
    }

    public static String[] mySplit(String inp){
        int c_pos, s_pos;
        c_pos = inp.indexOf("]");
        s_pos = inp.indexOf(":");
        String [] out = {inp.substring(1, c_pos), inp.substring(c_pos+2, s_pos), inp.substring(s_pos+2,inp.length())};
        return out;
    }

}

