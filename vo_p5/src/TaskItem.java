public class TaskItem {
    public String title, description, dd;
    public boolean complete = false;


    public TaskItem(String title, String description, String dd){
        this.title = title;
        this.description = description;
        this.dd = dd;
    }

    public void editTitle(String newTitle){
        this.title = newTitle;
    }

    public void editDescription(String newDescription){
        this.description = newDescription;
    }
    public void editDd(String newDd){
        this.dd = newDd;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getDd(){
        return this.dd;
    }

    public boolean isComplete(){
        return complete;
    }

    public void markAsComplete(){
        this.complete = true;
    }

    public void markAsIncomplete(){
        this.complete = false;
    }

    public String toString(){
        String out = "";
        if (this.isComplete()){
            out += "*** ";
        }
        return out + "[" + this.dd + "] " + this.title + ": " + this.description;
    }

    public String toStringWithoutAstro(){
        String out = "";
        return out + "[" + this.dd + "] " + this.title + ": " + this.description;
    }
}