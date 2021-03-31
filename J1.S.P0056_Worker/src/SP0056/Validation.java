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
            }
        } while (flag == 0);
        return result;
    }
    
    public int getInt(String msg, String warning, String error, int min, int max){
        int result = 0;
        int flag = 0;
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                result = s.nextInt();
                if(result < min || result > max){
                    System.out.println(warning);
                    flag = 0;
                } else{
                    flag = 1;
                    return result;
                }
            } catch (Exception e) {
            }
        } while (flag == 0);
        return result;
    }
    
    public String getString(String msg, String warning){
        String result = "";
        while(true){
            System.out.println(msg);
            Scanner s = new Scanner(System.in);
            result = s.nextLine().trim().toUpperCase();
            if(result.length() == 0 || result.isEmpty())
                System.out.println(warning);
            else
                return result;
        }
    }
    
    public String getString(String msg, String warning, String format){
        String result = "";
        boolean notMatch;
        while(true){
            System.out.println(msg);
            Scanner s = new Scanner(System.in);
            result = s.nextLine().trim().toUpperCase();
            notMatch = !result.matches(format);
            if(result.length() == 0 || result.isEmpty() || notMatch == true)
                System.out.println(warning);
            else
                return result;
        }
    }
}
