package Model;

import java.lang.Math;

public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area(){

        return height * width;
    }

    public double perimeter(){
        return 2 * (height + width);
    }

    public double diagonal(){
        return Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
    }
}
