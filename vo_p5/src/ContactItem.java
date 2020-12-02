public class ContactItem {
    public String first, last, phone, email;


    public ContactItem(String f, String l, String phone, String e){
        this.first = f;
        this.last = l;
        this.phone = phone;
        this.email = e;
    }



    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        String out = "Name: " + this.first + " " + this.last + "\n";
        out += "Phone: " + this.phone + "\n";
        out += "Email: " + this.email;
        return out;
    }
}