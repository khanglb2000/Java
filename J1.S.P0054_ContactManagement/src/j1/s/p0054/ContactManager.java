/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0054;

import java.util.ArrayList;

/**
 *
 * @author HI
 */
public class ContactManager {
    ArrayList<Person> list = new ArrayList<>();

    public ContactManager() {
    }
    public ContactManager( ArrayList<Person> list){
        this.list = list;
    }
    
    //Methods
    //Add a person contact to list
    public void addPersonContact(){
        Person p = new Person();
        int id;
        boolean flag;
        
        //Auto id setting
        if(list.isEmpty()){
            id = 1;
        } else{
            id = list.size() + 1;
        }
        
        do {            
            p.inputPersonInfo(id);
            if(checkDuplicatedName(p.getFullName())){
                System.out.println("There is already a person with that name");
                flag = true;
            } else{
                flag = false;
                list.add(p);
                System.out.println("Contact info has been added");
            }
        } while (flag == true);
    }
    
    //Check if person name exist
    public boolean checkDuplicatedName(String name){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != null && list.get(i).getFullName().trim().equals(name))
                return true;
        }
        return false;
    }
    
    //In ra danh sach
    public void displayContactList(){
        if(list.isEmpty()){
            System.out.println("The contact list is empty");
        } else{
            System.out.println("===============================Contact Info==========================================");
            System.out.println("ID\tName\t\t\tFirst Name\tLast Name\tGroup\tAddress\t\tPhone");
            for(int i =0 ;i < list.size(); i++){
                if(list.get(i) != null){
                    list.get(i).printPersonInfo();
                }
            }
        }
    }
    
    //Xoa mot contact theo id
    public void deleteById(){
        if(list.isEmpty()){
            System.out.println("The contact list is empty");
            return;
        }
        Validation util = new Validation();
        boolean flag = false;
        int id = util.getInt("Input id to delete", "Id is int > 0");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != null && list.get(i).getID() == id){
                list.remove(list.get(i));
                flag = true;
                //After delete a person contact
                //Update id again
                for(int j = i; j < list.size();j++){
                    if(list.get(j) != null){
                        list.get(j).setID(j + 1);
                    }
                }
            }
        }
        if(flag == true){
            System.out.println("Contact has been deleted\t");
        }else{
            System.out.println("There is no contact with that ID");
        }
    }
}
