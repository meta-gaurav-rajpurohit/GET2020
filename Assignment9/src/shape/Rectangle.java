package shape;

import java.util.Date;

public class Rectangle implements Shape{

    public double length ;
    public double width ;
    private final String name  = "Rectangle";
    Point origenPoint ;
    Date date;

    /**Constructor are use to initialize parameter
     * 
     * @param length double type
     * @param width double type
     * @param origenPoint Point type 
     * @param date Date class object
     */
    public Rectangle(double length, double width, Point origenPoint,Date date){
        this.length = length ;
        this.width = width ;
        this.origenPoint = origenPoint ;
        this.date = date ;
    }

    @Override
    public double getArea() {
        return (length * width);
    }

    @Override
    public double getPerimeter() {
        return (2 * (length + width));
    }

    @Override
    public Point getOrigin() {
        return origenPoint;
    }

    @Override
    public boolean isPointEnclosed(double passXCordinate, double passYCordinate) {
        double origenXPoint = origenPoint.getXCoordinate();
        double origenYPoint = origenPoint.getYCoordinate();
        double anotherXPoint = origenXPoint + length;
        double anotherYPoint = origenYPoint + width;
        
        if(origenXPoint <=  passXCordinate && origenYPoint <=  passYCordinate && 
           anotherXPoint >=  passXCordinate && anotherYPoint >=  passYCordinate &&
           origenPoint.getXMaxCoordinate() >=  passXCordinate && origenPoint.getYMinCoordinate() <=  passYCordinate)
            return true;
        
        return false;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double getOriginDistance() {
        return Math.sqrt(origenPoint.getXCoordinate() * origenPoint.getXCoordinate() +
                origenPoint.getYCoordinate() * origenPoint.getYCoordinate());
    }
}
