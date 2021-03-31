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
public class Triangle extends Shape{
    //fields
    private double a;
    private double b;
    private double c;
    
    public Triangle(){
        a = 2;
        b = 3;
        c = 4;
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + this.a);
        System.out.println("Side B: " + this.b);
        System.out.println("Side C: " + this.c);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    public double getArea() {
        double p = (a + b + c)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
    
}
