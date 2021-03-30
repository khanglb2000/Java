/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentreport;

/**
 *
 * @author HI
 */
public class reportStudent {
    private String id;
    private String studentName;
    private String courseName;
    private int totalCourse;//Number of courses for a stu
    
    public reportStudent(){}
    
    public reportStudent(String id, String studentName, int totalCourse){
        this.id = id;
        this.studentName = studentName;
        this.totalCourse = totalCourse;
    }

    public reportStudent(String id, String studentName, String courseName, int totalCourse) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
