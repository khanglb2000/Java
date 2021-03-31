/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0056;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author HI
 */
public class WorkerManage {
    ArrayList<Worker> list, infoList;
    int count;
    Validation util = new Validation();
    
    public WorkerManage(){
        list = new ArrayList<>();
        infoList = new ArrayList<>(); //For adding changed history
        count = 0;
    }
    
    //methods
    public int searchWorkerById(String id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != null && list.get(i).getCode().equals(id)){
                return 1;
            }
        }
        return -1;
    }
    
    //Search and return worker
    public Worker searchWorkerById2(String id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != null && list.get(i).getCode().equals(id)){
                return list.get(i);
            }
        }
        return null;
    }
    
    public Worker searchWorkerById3(String id){
        for(int i = infoList.size() - 1; i >= 0; i--){
            if(infoList.get(i) != null && infoList.get(i).getCode().equals(id)){
                return infoList.get(i);
            }
        }
        return null;
    }
    
    //Set update date
    public String getCurrentDay(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    
    //Add a new worker
    public void addWorker(){
        String id, name, loc, date, status;
        int age, salary;
        int pos;
        //Input id
        do {            
            id = util.getString("Enter id (Wxx): ", "Id format is Wxx", "^W\\d\\d$");
            pos = searchWorkerById(id);
            if(pos != -1)
                System.out.println("This id is already exists!");
        } while (pos != -1);
        ////
        name = util.getString("Enter name: ", "Name is required! Only a-zA-Z", "[a-zA-Z\\s]{0,50}");
        loc = util.getString("Enter work location: ", "Work location is required! Only[a-zA-Z_/-]", "[^!@#$%^&*]{0,50}");
        status = "UP"; //Default for new worker
        date = getCurrentDay();
        age = util.getInt("Enter age (18->50): ", "Age is required", "Age is an integer", 18, 50);
        salary = util.getInt("Enter salary: ", "Salary is required", "Salay is an integer", 0);
        
        list.add(new Worker(id, name, age, salary, loc, date, status));
        infoList.add(new Worker(id, name, age, salary, loc, date, status));//Also add to history list
        System.out.println("Added successfully!");
    }
    
    //Print the original list
    public void printAll(){
        System.out.println("-----------------   Display Information Salary   -------------------");
        System.out.println("Code      Name              Age       Salary    Status    Date");
        for(int i = 0; i < list.size(); i++){
            list.get(i).showProfile();
        }
    }
    
    //Print the history list
    public void printAllInfo(){
        if(infoList.isEmpty()){
            System.out.println("History is empty");
            return;
        }
        System.out.println("-----------------   Display Information Salary   -------------------");
        System.out.println("Code      Name              Age       Salary    Status    Date");
        for(int i = 0; i < infoList.size(); i++){
            infoList.get(i).showProfile();
        }
    }
    
    //Up worker salary
    public void upSalary(){
        if(list.isEmpty()){
            System.out.println("The list is empty");
            return;
        }
        String selectedId;
        int addAmount;
        int total;
        selectedId = util.getString("Enter id (Wxx): ", "Id format is Wxx", "^W\\d\\d$");
        
        //Check worker by id
        if(searchWorkerById(selectedId) == -1){
            System.out.println("There is no worker which that id");
        } else{
                addAmount = util.getInt("Input amount to up salary", "Amount > 0", "Amount is int", 0);
                total = searchWorkerById3(selectedId).getSalary() + addAmount;
                Worker s = searchWorkerById2(selectedId);
                
                Worker w = new Worker(s.getCode(), s.getName(), s.getAge(), total, s.getLoc(), getCurrentDay(), "UP");
                infoList.add(w);
                System.out.println("Worker salary has been upped");
        }
    }
    
    public void downSalary(){
        if(list.isEmpty()){
            System.out.println("The list is empty");
            return;
        }
        String selectedId;
        int downAmount;
        int total;
        selectedId = util.getString("Enter id (Wxx): ", "Id format is Wxx", "^W\\d\\d$");
        
        if(searchWorkerById(selectedId) == -1){
            System.out.println("There is no worker which that id");
        } else{
                downAmount = util.getInt("Input amount to down salary", "Amount > 0", "Amount is int", 0);
                total = searchWorkerById3(selectedId).getSalary() - downAmount;
                Worker s = searchWorkerById2(selectedId);
                if(total < 0){
                    System.out.println("Cannot down salary");
                } else{
                    Worker w = new Worker(s.getCode(), s.getName(), s.getAge(), total, s.getLoc(), getCurrentDay(), "DOWN");
                    infoList.add(w);
                    System.out.println("Worker salary has been downed");
                }
        }
    }
}
