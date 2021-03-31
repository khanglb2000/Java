/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0051;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Main {
    static int printMenu(){
        Scanner s;
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1->3): ");
        while (true) {
            try {
                s = new Scanner(System.in);
                int result = Integer.parseInt(s.nextLine());
                if (result < 1 || result > 3) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer 1 to 3.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner s;
        int choice;
        do {            
            choice = printMenu();
            switch(choice){
                case 1:
                    System.out.println("----- Normal Calculator -----");
                    ComputerManager runCal = new ComputerManager();
                    runCal.runCaculateCom();
                    break;
                case 2:
                    System.out.println("----- BMI Calculator -----");
                    BMIComManager runBMI = new BMIComManager();
                    runBMI.runBMICaculator();
                    break;
            }
        } while (choice != 3);
    }
}
