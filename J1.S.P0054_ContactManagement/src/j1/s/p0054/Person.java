/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0054;

/**
 *
 * @author HI
 */
public class Person {
    //fields
    int ID;
    String fullName;
    String group;
    String address;
    String phone;
    String firstName;
    String lastName;

    //Constructor
    public Person(int ID, String fullName, String group, String address, String phone, String firstName, String lastName) {
        this.ID = ID;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Person() {
        ID = 0;
        fullName = "Unknown";
        firstName = "Unknown";
        lastName = "Unknown";
        phone = "Unknown";
        address = "Unknown";
    }

    //Getter and setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    //Methods
    public void printPersonInfo(){
        System.out.println(ID+"\t"+fullName+"\t\t"+firstName+"\t\t"
                +lastName+"\t\t"+group+"\t"+address+"\t\t"+phone);
    }
    
    public void inputPersonInfo(int id){
        Validation util = new Validation();
        fullName = util.getFullName("Input person full name", "Name is required. on;y char", "Name has at least first name and last name. Only char");
        firstName = util.getLastFirstName(fullName, "Invalid name input", true);
        lastName = util.getLastFirstName(fullName, "Invalid name input", false);
        group = util.getGroupString("Input person group", "Group is required", "Input only Normal/Star/VIP");
        address = util.getString("Input person address", "Address is required", "Input only a-z, A-Z, 0-9, , and /");
        phone = util.getPhoneNumber("Input person phone", "Phone is required", "Phone is base on formats below");
        ID = id;
    }
}
