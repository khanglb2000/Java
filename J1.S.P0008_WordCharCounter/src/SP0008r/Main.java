/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0008r;


/**
 *
 * @author HI
 */
public class Main {
    public static void main(String[] args) {
        String cont;
        Manager obj;
        Validation util = new Validation();
        do {
            obj = new Manager();
            String content = util.getString("Input your string", "String is required");
            obj.countString(content);
            obj.display();
            
            do {                
                cont = util.getString("Do you want to continue? (Y/N)", "Only Y/N");
                if(!cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"))
                    System.out.println("Only Y/N");
            } while (cont.trim().isEmpty() || !cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"));
        } while (cont.trim().equalsIgnoreCase("Y"));
        
    }
}
