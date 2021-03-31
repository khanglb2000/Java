/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0054;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Validation {
    Scanner s = new Scanner(System.in);
    
    public String getString(String msg, String warning, String error){
        String format = "[0-9a-zA-Z\\s\\,\\/]{2,30}";
        String result = "";
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                result = s.nextLine();
                if(!result.matches(format)){
                    throw new Exception();
                }
                if(result.trim() == null){
                    System.out.println(warning);
                } else{
                    return result;
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }
    
    public String getGroupString(String msg, String warning, String error){
        String format = "(Normal|Star|VIP)";
        String result = "";
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                result = s.nextLine();
                if(!result.matches(format)){
                    throw new Exception();
                }
                if(result.trim() == null){
                    System.out.println(warning);
                } else{
                    return result;
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }
    
    public String getFullName(String msg, String warning, String error){
        String fullname = "";
        String[] arr;
        String format = "[a-zA-Z]{2,15}[ ]([a-zA-Z]{2,15}[ ])?[a-zA-Z]{2,15}";
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                fullname = s.nextLine();
                arr = fullname.split(" ");
                
                if(!fullname.matches(format))
                    throw new Exception();
                
                if(fullname.trim() == null){
                    System.out.println(warning);
                } else if(arr[arr.length - 1] == null){
                    System.out.println(warning);
                } else
                    return fullname;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (true);
    }
    
    public String getLastFirstName(String fullName, String warning, boolean pos){
        String name = "";
        String[] arr = fullName.split(" ");
        if(fullName.trim() == null){
            System.out.println(warning);
        } else{
            if(pos == true)
                name = arr[0];
            else
                name = arr[arr.length - 1];
        }
        return name;
    }
    
    public int getInt(String msg, String warning, int min, int max){
        int result = 0;
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                result = s.nextInt();
                if(result < min || result > max)
                    System.out.println(warning);
                else
                    return result;
                
            } catch (Exception e) {
                System.out.println(warning);
            }
        } while (true);
    }
    
    public int getInt(String msg, String warning){
        int result = 0;
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                result = s.nextInt();
                if(result < 0)
                    System.out.println(warning);
                else
                    return result;
                
            } catch (Exception e) {
                System.out.println(warning);
            }
        } while (true);
    }
    
    public String getPhoneNumber(String msg, String warning, String error){
        String phone = "";
        String format1 = "[0-9]{10}";
        String format2 = "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}";
        String format3 = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{4}";
        String format4 = "[0-9]{3}[ ][0-9]{3}[ ][0-9]{4}";
        String format5 = "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}[ ]([x][0-9]{4})?";
        String format6 = "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}[ ](ext[0-9]{4})?";
        do {            
            try {
                System.out.println(msg);
                s = new Scanner(System.in);
                phone = s.nextLine();
                
                if(!phone.matches(format1) && !phone.matches(format2) && !phone.matches(format3)
                        && !phone.matches(format4) && !phone.matches(format5) && !phone.matches(format6)){
                    throw new Exception();
                }
                
                if(phone.trim().isEmpty())
                    System.out.println(warning);
                else
                    return phone;
            } catch (Exception e) {
                System.out.println(error);
                System.out.println("1234567890");
                System.out.println("123-456-7890");
                System.out.println("123-456-7890 x1234");
                System.out.println("123-456-7890 ext1234");
                System.out.println("123.456.7890");
                System.out.println("123 456 7890");
            }
        } while (true);
    }
}
