/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentreport;

/**
 *
 * @author HI
 */
public class Main {
    public static void main(String[] args) {
        Manager mn = new Manager();
        int choice = 0;
        do {            
            choice = mn.printMenu();
            switch(choice){
                case 1:
                    mn.createStudent();
                    mn.printStudentList();
                    break;
                case 2:
                    mn.findAndSortStuByName();
                    break;
                case 3:
                    mn.performUpdateOrDelete();
                    mn.printStudentList();
                    break;
                case 4:
                    mn.printStudentReport();
                    break;
            }
        } while (choice != 5);
    }
}
