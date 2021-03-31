/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0056;

import java.util.Date;

/**
 *
 * @author HI
 */
public class Worker {
    //fields
    String code;
    String name;
    int age;
    int salary;
    String loc;//working location
    Date currentdate = new Date();
    String date;
    String status = "UP";

    public Worker(String code, String name, int age, int salary, String loc, String date, String status) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.loc = loc;
        this.date = date;
        this.status = status;
    }
    
    public Worker(){
        code ="";
        name = "";
        age = 18;
        salary = 0;
        loc ="";
        date = "01/01/2000";
        status = "UP";
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getLoc() {
        return loc;
    }
    
    public void showProfile(){
        String msg;
        msg = String.format("%-10s%-18s%-10s%-10s%-10s%-25s", code, name, age, salary, status, date);
        System.out.println(msg);
    }
    
}
