package shape;

import java.util.Date;



public interface Shape {
    int number0 = 0, number1 = 1, number2 = 2, number3 = 3;
    
    enum ShapeTypes {SQUARE, RECTANGLE, CIRCLE, TRIANGLE, REGULAR_POLYGON; }
    
    double getArea();
    double getPerimeter();
    Point getOrigin();
    boolean isPointEnclosed(double passXCordinate, double passYCordinate); 
    Date getDate();
    String getName();
    double getOriginDistance();
}
