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
public class Student {
    //fields
    String name;
    String sClass;
    double math;
    double physics;
    double chemistry;
    String type;
    double avg;

    public Student(String name, String sClass, double math, double physics, double chemistry, double avg) {
        this.name = name;
        this.sClass = sClass;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public String getsClass() {
        return sClass;
    }

    public double getMath() {
        return math;
    }

    public double getPhysics() {
        return physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public String getType() {
        return type;
    }

    public double getAvg() {
        return avg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
    
    
}
