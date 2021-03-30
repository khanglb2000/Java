/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentreport;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author HI
 */
public class Manager {
    Validator util = new Validator();
    ArrayList<Student> list = new ArrayList<>();
    
    public Manager(){
        list = new ArrayList<>();
    }
    
    //Display menu - choice
    public int printMenu(){
        System.out.println("---------- Student Report Program ---------");
        System.out.println(" 1.	Create At least 3 students");
        System.out.println(" 2.	Find and Sort student by name");
        System.out.println(" 3.	Update/Delete a student by id");
        System.out.println(" 4.	Make Student Report");
        System.out.println(" 5.	Exit");
        int choice = util.getInt("Input your choice 1->5", "Choice is >= 1 and =< 5", "Choice is an integer 1->5", 1, 5);
        return choice;
    }
    
    //Create at least 3 students
    public void createStudent(){
        int cnt = 1;
        String cont = "Y";
        do {            
            addAStudent();
            cnt++;
            //if students > 3, ask to continue?
            if(cnt > 3){
                do {                
                    cont = util.getString("Do you want to continue? (Y/N)", "Only Y/N");
                    if(!cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"))
                        System.out.println("Only Y/N");
                } while (cont.trim().isEmpty() || !cont.trim().equalsIgnoreCase("Y") && !cont.trim().equalsIgnoreCase("N"));
            }
        } while (cont.trim().equalsIgnoreCase("Y"));
    }
    
    //Add 1 new student
    public void addAStudent(){
        String id, name, semester, course;
        while(true){
            //Input code
            do {  
                System.out.println("Id format Sxxx");
                id = util.getString("Enter student id", "Id is required");
            } while (!id.matches("^S\\d{3}"));
            //Input name
            name = util.getString("Enter student name. Only char.", "Name is required. Only char", "[a-zA-Z\\s]{1,40}");
            //Check duplicated student id & name
            if(util.checkDuplicatedId(list, id, name)){
                System.err.println("Id for this new name is duplicated. Please re-input student");
                continue;
            }
            //Input semester
            semester = util.getString("Input semester. 1-8", "Semester is required. 1-8", "[1-8]{1}");
            //Input course
            course = util.getCourse();
            //add to list
            if(util.checkDuplicatedStudent(list, id, name, semester, course)){
                list.add(new Student(id, name, semester, course));
                System.out.println("Student added successfully!");
                return;
            }
            System.err.println("Duplicated student info");
            
        }
        
    }
    
    public void printStudentList(){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }
    
    //Find students by name
    public ArrayList<Student> createStudentFindByNameList(){
        ArrayList<Student> newList = new ArrayList<>();
        String name = util.getString("Enter student name (or part of it) to search:", "Name is required");
        //Add to new list base on name
        for (Student student : list) {
            if(student.getStudentName().contains(name)){
                newList.add(student);
            }
        }
        return newList;
    }
    
    //Find and sort
    public void findAndSortStuByName(){
        if(list.isEmpty()){
            System.out.println("Student list is empty");
            return;
        }
        //Make a new list base on name
        ArrayList<Student> newList = createStudentFindByNameList();
        //Check the new list
        if(newList.isEmpty()){
            System.out.println("No student found");
        } else{
            Collections.sort(newList);
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for (Student student : newList) {
                student.print();
            }
        }
    }
    
    //Find students by id
    public ArrayList<Student> createStudentFindByIdList(){
        ArrayList<Student> newList = new ArrayList<>();
        String id;
        do {  
                System.out.println("Id format Sxxx");
                id = util.getString("Enter student id to search", "Id is required");
        } while (!id.matches("^S\\d{3}"));
        //Add to new list base on id
        for (Student student : list) {
            if(student.getId().equalsIgnoreCase(id.trim())){
                newList.add(student);
            }
        }
        return newList;
    }
    
    //update or delete student
    public void performUpdateOrDelete(){
        if(list.isEmpty()){
            System.err.println("List is empty");
            return;
        }
        //Create new list base on id
        ArrayList<Student> idList = createStudentFindByIdList();
        //Chck the new list
        if(idList.isEmpty()){
            System.err.println("No student found");
            return;
        } else{
            Student student = getStudentByListFound(idList);
            System.out.println("Do you want to update or delete a student");
            if(util.checkUpdateDelete()){
                //Update
                String id = student.getId();
                String name = student.getStudentName();
                String semester = util.getString("Input semester", "Semester is required");
                String course = util.getCourse();
                
                if (util.checkDuplicatedStudent(list, id, name, semester, course)) {
                    student.setId(id);
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(course);
                    System.err.println("Update success.");
                }
                
                return;
            } else{
                //Delete
                list.remove(student);
                System.err.println("Delete success");
                return;
            }
        }
    }
    
    //Choose a student in list
    public Student getStudentByListFound(ArrayList<Student> newList){
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name", "semester", "Course Name");
        //Print out the list for user to choose
        for (Student student : newList) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count, student.getStudentName(), 
                    student.getSemester(), student.getCourseName());
            count++;
        }
        //get choice of user
        int choice = util.getInt("Choose a Student by number", "Choice is an int", "Choice is an int", 1, newList.size());
        //Return the stu has been chosen
        return newList.get(choice - 1);
    }
    
    //Make a report
    public void printStudentReport(){
        if(list.isEmpty()){
            System.out.println("No student found");
            return;
        }
        ArrayList<reportStudent> repList = new ArrayList<>();
        for (Student student : list) {
            String id = student.getId();
            String name = student.getStudentName();
            String course = student.getCourseName();
            int total = 0;
            //count the courses
            for (Student stuCnt : list) {
                if(id.equalsIgnoreCase(stuCnt.getId()) && name.equals(stuCnt.getStudentName()))
                    total++;
            }
            //Check if this rep exsited
            if (!util.checkReportExist(repList, id, name, total)) {
                repList.add(new reportStudent(id, name, total));
            }
        }
        //Print out the report list
        for (int i = 0; i < repList.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", repList.get(i).getId(),
                    repList.get(i).getStudentName(), repList.get(i).getTotalCourse());
        }
    }
}
