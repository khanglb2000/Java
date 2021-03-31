/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0061;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Validation {
    Scanner s;
    
    public double getDouble(String msg, String warning, String error, double min){
        double num = 0d;
        int flag = 0;
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                num = s.nextDouble();
                if(num <= min){
                    System.out.println(warning);
                    flag = 0;
                } else{
                    flag = 1;
                    return num;
                }
            } catch (Exception e) {
                System.out.println(error);
                flag = 0;
            }
        } while (flag == 0);
        return num;
    }
    
    public String getString(String msg, String warning){
        String result = "";
        do {            
            System.out.println(msg);
            s = new Scanner(System.in);
            result = s.nextLine();
            if(result.trim().isEmpty())
                System.out.println(warning);
        } while (result.trim().isEmpty());
        return result;
    }
}
