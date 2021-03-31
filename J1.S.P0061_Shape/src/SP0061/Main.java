/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0061;

/**
 *
 * @author HI
 */
public class Main {
    public static void main(String[] args) {
        Validation util = new Validation();
        String cont = "Y";
        do {            
            Manager obj = new Manager();
            Rectangle r = obj.inputRectangle();
            Circle c = obj.inputCircle();
            Triangle t = obj.inputTriangle();
            obj.displayAll(t, r, c);
            
            do {                
                cont = util.getString("Do you want to continue? (Y/N)", "Only Y/N");
                if(!cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"))
                    System.out.println("Only Y/N");
            } while (cont.trim().isEmpty() || !cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"));
        } while (cont.trim().equalsIgnoreCase("Y"));
        
    }
}
