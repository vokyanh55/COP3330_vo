import java.util.ArrayList;
import java.io.*;

public class ContactList {

    ArrayList<ContactItem> list = new ArrayList<ContactItem>();
    int size = 0;

    public ContactList (){
    }

    //addItem (item)
    //add item to the list
    //return added item
    //side effect: increase size
    public ContactItem addItem(ContactItem item){
        size++;
        (this.list).add(item);
        return item;
    }

    //removeItem (index)
    //remove item from the list
    //side effect: decrease size
    public void removeItem(int index){
        (this.list).remove(index);
        size--;
    }

    public int size(){
        return size;
    }

    public ContactItem getItem(int index){
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
        for (int i = 0; i < size; i++){
            out = out + i + ") " + ((this.list).get(i)).toString();
            out += "\n";
        }
        return out;
    }

}