/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0004;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Validation {
    Scanner s = new Scanner(System.in);
    
    public int getInt(String msg, String warning, String error, int min){
        int result = 0;
        int flag = 0;
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                result = s.nextInt();
                if(result <= min){
                    System.out.println(warning);
                    flag = 0;
                } else{
                    flag = 1;
                    return result;
                }
            } catch (Exception e) {
                System.out.println(error);
                flag = 0;
            }
        } while (flag == 0);
        return result;
    }
    
    public int getInt(String msg, String warning, String error){
        int result = 0;
        int flag = 0;
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                result = s.nextInt();
                flag = 1;
                return result;
            } catch (Exception e) {
                System.out.println(error);
                flag = 0;
            }
        } while (flag == 0);
        return result;
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
