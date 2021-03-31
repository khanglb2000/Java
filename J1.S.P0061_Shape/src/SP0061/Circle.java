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
public class Circle extends Shape{
    //fields
    double radius;
    
    public void Circle(){
        radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + this.radius);
//        System.out.println("Area: " + getArea());
//        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + (double) Math.round(getArea() * 100) / 100);
        System.out.println("Perimeter: " + (double) Math.round(getPerimeter() * 100) / 100);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }
    
    
    
}
