/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0065t;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Validation {
    Scanner s = new Scanner(System.in);
    
    public int getInt(String msg, String warning, String error, int min, int max){
        int result = 0;
        if(min > max){
            int tmp = max;
            max = min;
            min = tmp;
        }
        int flag;
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
                System.out.println(error);
                flag = 0;
            }
        } while (flag == 0);
        return result;
    }
    
    public double getDouble(String msg, String warning, String error, double min, double max){
        double result = 0;
        if(min > max){
            double tmp = max;
            max = min;
            min = tmp;
        }
        int flag;
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                result = s.nextDouble();
                if(result < min || result > max){
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
    
    public String getString(String msg, String warning){
        String result;
        do {            
            System.out.println(msg);
            s = new Scanner(System.in);
            result = s.nextLine();
            if(result.trim().isEmpty())
                System.out.println(warning);
        } while (result.trim().isEmpty());
        return result;
    }
    
    public String getString(String msg, String warning, String format){
        String result;
        do {            
            System.out.println(msg);
            s = new Scanner(System.in);
            result = s.nextLine();
            if(result.trim().isEmpty() || !result.matches(format))
                System.out.println(warning);
        } while (result.trim().isEmpty() || !result.matches(format));
        return result;
    }
    
    public String getStuClass(String format){
        String c = "";
        boolean flag = true;
        do{
            c = getString("Input student class (Cxx)", "Class is required");
            if(!c.matches(format)){
                System.out.println("Format is Cxx");
                flag = false;
            } else{
                flag = true;
            }
        } while(flag == false);
        return c;
    }
}
