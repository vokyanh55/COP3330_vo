import java.util.ArrayList;
import java.io.*;

public class TaskList {

    ArrayList<TaskItem> list = new ArrayList<TaskItem>();
    ArrayList<TaskItem> completeList = new ArrayList<TaskItem>();
    ArrayList<TaskItem> incompleteList = new ArrayList<TaskItem>();
    int size = 0;

    public TaskList (){
    }

    //addItem (item)
    //add item to the list
    //return added item
    //side effect: increase size
    public TaskItem addItem(TaskItem item){
        size++;
        (this.list).add(item);
        (this.incompleteList).add(item);
        return item;
    }

    //removeItem (index)
    //remove item from the list
    //side effect: decrease size
    public void removeItem(int index){
        (this.list).remove(index);
        size--;
    }

    public TaskItem getItem(int index){
        return (this.list).get(index);
    }


    //saveList(stringFile)
    //save saved item to a txt
    public void saveList(String stringFile){
        File txtFile = new File (stringFile);
        try
        {
            BufferedWriter out = new BufferedWriter(new FileWriter(txtFile,true));


            for (int i = 0; i < size; i++){
                out.write((this.list).get(i).toString());
                out.newLine();
            }
            out.close();
        }
        catch (IOException io)
        {
            System.out.println("IOException:" + io.getMessage());
        }
    }

    public String toString(){
        String out = "";
        //System.out.println("SIZE: " + this.size);
        for (int i = 0; i < size; i++){
            out = out + i + ") " + ((this.list).get(i)).toString();
            out += "\n";
        }
        return out;
    }

    public void printCompleteTask(){
        //this.updateList();
        //System.out.print(this.completeList.size());
        String out = "";
        for (int i = 0; i < this.completeList.size(); i++){
            //System.out.println((this.completeList).get(i).toString());
            out = out + i + ") " + ((this.completeList).get(i)).toStringWithoutAstro();
            out += "\n";
        }
        System.out.println(out);
    }

    public void completeTask(int index){
        this.list.get(index).markAsComplete();
        this.completeList.add(this.list.get(index));
        this.incompleteList.remove(index);
    }

    public void incompleteTask(int index){
        this.list.get(index).markAsIncomplete();
        this.incompleteList.add(this.list.get(index));
        this.completeList.remove(index);
    }

    public void printIncompleteTask(){
        //this.updateList();
        String out = "";
        for (int i = 0; i < this.incompleteList.size(); i++){
            out = out + i + ") " + ((this.incompleteList).get(i)).toStringWithoutAstro();
            out += "\n";
        }
        System.out.println(out);
    }

    public int size(){
        return this.size;
    }

    public int completeListSize(){
        return this.completeList.size();
    }

    public int incompleteListSize(){
        return this.incompleteList.size();
    }
}