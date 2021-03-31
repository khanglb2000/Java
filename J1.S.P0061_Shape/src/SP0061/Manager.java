/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SP0061;

import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Manager {
    Scanner s;
    Validation util = new Validation();
    
    //methods
    public Triangle inputTriangle(){
        while(true){
            double a = util.getDouble("Please input side A of Triangle:", "Side is > 0", "Double is required", 0);
            double b = util.getDouble("Please input side B of Triangle:", "Side is > 0", "Double is required", 0);
            double c = util.getDouble("Please input side C of Triangle:", "Side is > 0", "Double is required", 0);
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Triangle: (a + b > c) && (b + c > a) && (c + a > b)");
                System.out.println("Re-input");
            }
        }
    }
    
    public Rectangle inputRectangle(){
        double width = util.getDouble("Please input side width of Rectangle:", "Width is > 0", "Double is required", 0);
        double length = util.getDouble("Please input side length of Rectangle:", "Length is > 0", "Double is required", 0);
        if(width > length){
            double tmp = width;
            width = length;
            length = tmp;
        }
        return new Rectangle(length, width);
    }
    
    public Circle inputCircle(){
        double radius = util.getDouble("Input radius of circle:", "Radius is > 0", "Double is required", 0);
        return new Circle(radius);
    }
    
    public void displayAll(Triangle tri, Rectangle rec, Circle cir){
        rec.printResult();
        cir.printResult();
        tri.printResult();
    }
}
