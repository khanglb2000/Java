/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0056;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Main {
    static int printMenu(){
        Scanner s;
        System.out.println("======== Worker Management =========");
        System.out.println("1. Add worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1->5): ");
        while (true) {
            try {
                s = new Scanner(System.in);
                int result = Integer.parseInt(s.nextLine());
                if (result < 1 || result > 5) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer 1 to 5.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static void main(String[] args) {
        WorkerManage obj = new WorkerManage();
        int choice = 0;
        do{
            choice = printMenu();
            switch(choice){
                case 1:
                    obj.addWorker();
                    //obj.printAll();
                    break;
                case 2:
                    obj.upSalary();
                    break;
                case 3:
                    obj.downSalary();
                    break;
                case 4:
                    //obj.printAll();
                    obj.printAllInfo();
                    break;
            }
        }while(choice != 5);
    }
}
