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
public class ComputerManager {
    //enum
    private enum Operator {
        Add, Subtract, Multiply, Divide, Exponent, Equal;
    }
    
    //fields
    Validation util = new Validation();
    Scanner s;
    private Operator operator;
    private double number;
    
    //methods
    
    public Operator checkOperator (String operator) {
        switch(operator) {
            case "+": return Operator.Add;
            case "-": return Operator.Subtract;
            case "*": return Operator.Multiply;
            case "/": return Operator.Divide;
            case "^": return Operator.Exponent;
            case "=": return Operator.Equal;
            default: return null;
        }
    }
    
    public Operator enterOperator() {
        do {
            System.out.print("Enter operator (+, -, *, /, ^, =): ");
            Scanner s = new Scanner(System.in);
            operator = checkOperator(s.nextLine());
        } while (operator == null);
        return operator;
    }
    
    public void caculateNormal() {        
        switch(operator) {
            case Add:
                number += util.getDouble("Enter number: ", "Number is a double");
                break;
            case Subtract:
                number -= util.getDouble("Enter number: ", "Number is a double");
                break;
            case Multiply:
                number *= util.getDouble("Enter number: ", "Number is a double");
                break;            
            case Divide:
                double temp = util.getDouble("Enter number: ", "Number is a double");
                if (temp == 0) {
                    System.out.println("Cannot divide  by 0!");
                } else {
                    number /= temp;
                }
                break;
            case Exponent:
                number = Math.pow(number, util.getDouble("Enter number: ", "Number is a double"));
                break;
        }
    }
    
    public void runCaculateCom() {
        for (int i = 0; operator != Operator.Equal; i++) {        
            if (i==0) {
                number = util.getDouble("Enter number: ", "Number is a double");
            }
            operator = enterOperator();
            if (operator == Operator.Equal) {
                System.out.println("Result: " +number);
            } else {
                caculateNormal();
                System.out.println("Memory: " +number);
            }
        }
    }    
}
