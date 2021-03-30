/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentreport;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Validator {
    Scanner s = new Scanner(System.in);
    
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
    
    public String getString(String msg, String warning, String format){
        String result = "";
        boolean notMatch;
        while(true){
            System.out.println(msg);
            Scanner s = new Scanner(System.in);
            result = s.nextLine().trim();
            notMatch = !result.matches(format);
            if(result.length() == 0 || result.isEmpty() || notMatch == true)
                System.out.println(warning);
            else
                return result;
        }
    }
    
    public String getCourse(){
        String result = "";
        while (true) {
            result = getString("Input course (java; .net; c/c++)", "Only java; .net; c/c++");
            if (result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net") || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }
    
    public boolean checkContinue(String msg, String warning){
        String result;
         while (true) {
            result = getString("Do you want to continue (Y/N):", "Input String only");
            if (result.trim().equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.trim().equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    public boolean checkDuplicatedId(ArrayList<Student> list, String id, String name){
        for (Student student : list) {
            if(id.equalsIgnoreCase(student.getId()) && !name.equals(student.getStudentName()))
                return true;
        }
        return false;
    }
    
    public boolean checkDuplicatedStudent(ArrayList<Student> list, String id, String name, String semenster, String course){
        for (Student student : list) {
            if(id.equalsIgnoreCase(student.getId()) && name.equalsIgnoreCase(student.getStudentName())
            && semenster.equalsIgnoreCase(student.getSemester()) && course.equalsIgnoreCase(student.getCourseName())){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkUpdateDelete(){
        while (true) {
            String result = getString("Input U(Update) or D(Delete)", "U/D is required");
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }
    
    public static boolean checkReportExist(ArrayList<reportStudent> lr, String id, String name, int total) {
        for (reportStudent report : lr) {
            if (name.equals(report.getStudentName()) && id.equalsIgnoreCase(report.getId())
                    && total == report.getTotalCourse()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkStuRepExist(ArrayList<reportStudent> lr, String name, String id, int total){
        return false;
    }
}
