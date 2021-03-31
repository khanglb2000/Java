/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0065t;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Manager {
    ArrayList<Student> list;
    int count;
    Validation util = new Validation();
    Scanner s = new Scanner(System.in);
    
    public Manager(){
        list = new ArrayList<>();
        count = 0;
    }
    
    //methods
    public void createStudent(){
        String cont;
        do {  
            list.add(inputStuInfo());
            System.out.println("Student added successfully!");
            
            do{
                cont = util.getString("Do you want to continue? (Y/N)", "OnlyY/N");
                if(!cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"))
                    System.out.println("Only Y/N");
            }while(cont.trim().isEmpty() || !cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"));
        } while (cont.trim().equalsIgnoreCase("Y"));
    }
    
    public Student inputStuInfo(){
        String name, sClass;
        double math, physics, chemistry, avg;
            do {                
                name = util.getString("Input student name", "Name is required. (Char only)", "[a-zA-Z\\s]{3,40}");
                if(getStuByName(name) == 1)
                    System.out.println("Duplicated student name. Input again");
            } while (getStuByName(name) == 1);
            sClass = util.getStuClass("^C\\d\\d$");
            math = util.getDouble("Input maths point", "Maths is 0->10", "Maths is digit", 0, 10);
            physics = util.getDouble("Input physics point", "Physics is 0->10", "Physics is digit", 0, 10);
            chemistry = util.getDouble("Input chemistry point", "Chemistry is 0->10", "Chemistry is digit", 0, 10);
            avg = calculateAVG(math, physics, chemistry);
        return new Student(name, sClass, math, physics, chemistry, avg);
    }
    
    public double calculateAVG(double math, double physics, double chemistry){
        double a = (math + physics + chemistry)/3;
        double avg = Math.ceil((a * 100)) / 100;
        return avg;
    }
    
    
    public int getStuByName(String name){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != null && list.get(i).getName().equalsIgnoreCase(name))
                return 1;
        }
        return -1;
    }
    
    public String checkType(double avg){
        if(avg > 7.5)
            return "A";
        else if(avg >= 6 && avg <= 7.5)
            return "B";
        else if(avg >= 4 && avg < 6)
            return "C";
        else
            return "D";
    }
    
    public void printStudentList(){
        for(int i = 0; i < list.size(); i++){
            System.out.println("------ Student " + (i + 1) + " Info ------");
            System.out.println("Name: " + list.get(i).name);
            System.out.println("Class: " + list.get(i).sClass);
            System.out.println("AVG: " + list.get(i).avg);
            System.out.println("Type: " + checkType(list.get(i).avg));
            System.out.println();
        }
    }
    
    public double countType(String type){
        double count = 0;
        for(int i = 0; i < list.size(); i++){
            if(checkType(list.get(i).avg).equals(type))
                count++;
        }
        return count;
    }
    
    public void classificationInfo(){
        int size = list.size();
        System.out.println("--------Classification Info -----");
        System.out.println("A: " + countType("A") / size * 100 + "%");
        System.out.println("B: " + countType("B") / size * 100 + "%");
        System.out.println("C: " + countType("C") / size * 100 + "%");
        System.out.println("D: " + countType("D") / size * 100 + "%");
    }
}
