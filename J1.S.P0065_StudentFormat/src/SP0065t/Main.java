/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0065t;

/**
 *
 * @author HI
 */
public class Main {
    static Validation util = new Validation();
    public static void main(String[] args) {
        Manager obj = new Manager();
        String cont;
        do {            
            System.out.println("====== Management Student Program ======");
            obj.createStudent();
            obj.printStudentList();
            obj.classificationInfo();
            do{
                cont = util.getString("Do you want to run app again? (Y/N)", "OnlyY/N");
                if(!cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"))
                    System.out.println("Only Y/N");
            }while(cont.trim().isEmpty() || !cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"));
        } while (cont.trim().equalsIgnoreCase("Y"));
    }
}
