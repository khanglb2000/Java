/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0008r;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Validation {
    Scanner s;

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
