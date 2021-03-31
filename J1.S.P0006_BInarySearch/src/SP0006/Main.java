/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0006;

/**
 *
 * @author HI
 */
public class Main {
    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        String cont;
        Validation util = new Validation();
        do {            
            obj.inputElement();
            obj.printSortedArray();
            obj.binarySearchResult();
            
            do {                
                cont = util.getSring("Do you want to continue? (Y/N)", "Only Y/N");
                if(!cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"))
                    System.out.println("Only Y/N");
            } while (cont.trim().isEmpty() || !cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"));
        } while (cont.trim().equalsIgnoreCase("Y"));
        
    }
}
