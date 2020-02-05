package shape;

import java.util.Date;

public class Square implements Shape{

    public double length ;
    private final String name = "Square";
    Point origenPoint ;
    Date date;

    /**Constructor use to initialize the instance member
     * 
     * @param length
     * @param origenPoint
     * @param date
     */
    public Square(double length, Point origenPoint,Date date){
        this.length = length ; 
        this.origenPoint = origenPoint ;
        this.date = date ;
    }

    @Override
    public double getArea() {
        return (length * length);
    }

    @Override
    public double getPerimeter() {
        return (4 * length);
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
        double anotherYPoint = origenYPoint + length;
        
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
