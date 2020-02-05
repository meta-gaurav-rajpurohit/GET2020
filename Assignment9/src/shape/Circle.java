package shape;

import java.util.Date;

public class Circle implements Shape{

    public double radius ;
    private final String name = "Circle";
    Point origenPoint ;
    Point centerPoint ;
    Date date;

    /**Constructor use to initialize the instance variable
     * 
     * @param radius
     * @param origenPoint
     * @param date
     */
    public Circle(double radius, Point origenPoint,Date date){
        this.radius = radius ;
        this.origenPoint = origenPoint ;
        this.date = date ;
        this.centerPoint = getCenterPoint() ;
    }

    @Override
    public double getArea() {
        return (Math.PI * radius * radius);
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }

    @Override
    public boolean isPointEnclosed(double passXCordinate, double passYCordinate) {
        double centerXPoint = centerPoint.getXCoordinate();
        double centerYPoint = centerPoint.getYCoordinate();
        double xdistance = centerXPoint - passXCordinate;
        double ydistance = centerYPoint - passYCordinate;
        double distance = Math.sqrt((xdistance * xdistance) + (ydistance * ydistance));
        
        if(distance >= radius)
            return true;
        
        return false;
    }

    public Date getDate() {
        return date;
    }
    
    public Point getCenterPoint(){
        double xAxis, yAxis;
        double theta = Math.atan(origenPoint.getXCoordinate() / origenPoint.getYCoordinate());
        
        xAxis = radius * Math.cos(theta);
        yAxis = radius * Math.sin(theta);
        
        return new Point(origenPoint.getXCoordinate() + xAxis, origenPoint.getYCoordinate() + yAxis);
    }

    @Override
    public Point getOrigin() {
        return origenPoint;
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
