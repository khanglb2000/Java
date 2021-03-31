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
public class Main {
    public static void main(String[] args) {
        ContactManager mn = new ContactManager();
        Validation util = new Validation();
        int choice;
        do { 
            System.out.println("====== Contact Management Program ======");
            System.out.println("1. Add a contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Delete a contact");
            System.out.println("4. Exit");
            choice = util.getInt("Input your choice 1-4", "Choice is an int 1-4", 1, 4);
            switch(choice){
                case 1:
                    mn.addPersonContact();
                    break;
                case 2:
                    mn.displayContactList();
                    break;
                case 3:
                    mn.deleteById();
                    break;
            }
        } while (choice != 4);
    }
}
