import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class App
{
    public static void main(String [] args)
    {
        boolean run = true;

        Scanner myScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        do{
            showMainMenu();
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
                System.exit(0);
            } else {
                //INVALID INPUT
            }
        }while (run == true);

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
                System.out.println("THER ARE NO TASKS");
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

    public static String[] mySplit(String inp){
        int c_pos, s_pos;
        c_pos = inp.indexOf("]");
        s_pos = inp.indexOf(":");
        String [] out = {inp.substring(1, c_pos), inp.substring(c_pos+2, s_pos), inp.substring(s_pos+2,inp.length())};
        return out;
    }
}

