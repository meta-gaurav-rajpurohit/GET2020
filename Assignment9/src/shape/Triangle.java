package shape;

import java.util.Date;

public class Triangle implements Shape{

    public double side1 ;
    public double side2 ;
    public double side3 ;
    public double height ;
    private final String name = "Triangle";
    Point origenPoint ;
    Date date;

    /**Constructor use to initialize the instance member
     * 
     * @param side1
     * @param side2
     * @param side3
     * @param origenPoint
     * @param date
     */
    public Triangle(double side1, double side2,  double side3, Point origenPoint,Date date){
        this.side1 = side1 ;
        this.side2 = side2 ;
        this.side3 = side3 ;
        this.origenPoint = origenPoint ;
        this.date = date ;
    }

    @Override
    public double getArea() {
        double semiPerameter = ( this.getPerimeter() )/2;
        return (Math.sqrt(semiPerameter * (semiPerameter - side1)
                * (semiPerameter - side2)
                * (semiPerameter - side3)));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public Point getOrigin() {
        return origenPoint;
    }

    @Override
    public boolean isPointEnclosed(double passXCordinate, double passYCordinate) {
        double origenXPoint = origenPoint.getXCoordinate();
        double origenYPoint = origenPoint.getYCoordinate();
        double anotherXPoint = origenXPoint + side1;
        double anotherYPoint = origenYPoint + side2;
        
        return checkPoint(origenXPoint, origenYPoint, anotherXPoint, origenYPoint, 
                origenXPoint, anotherYPoint, passXCordinate, passYCordinate);
    }

    public Date getDate() {
        return date;
    }
    
    public boolean checkPoint(double x1Coordinate, double y1Coordinate, double x2Coordinate, double y2Coordinate,
            double x3Coordinate, double y3Coordinate, double xCoordinate, double yCoordinate){
  
           double Area = area(x1Coordinate, y1Coordinate, x2Coordinate, y2Coordinate, x3Coordinate, y3Coordinate); 
           double Area1 = area(xCoordinate, yCoordinate, x2Coordinate, y2Coordinate, x3Coordinate, y3Coordinate);    
           double Area2 = area(x1Coordinate, y1Coordinate, xCoordinate, yCoordinate, x3Coordinate, y3Coordinate);   
           double Area3 = area(x1Coordinate, y1Coordinate, x2Coordinate, y2Coordinate, xCoordinate, yCoordinate); 
           return (Area == Area1 + Area2 + Area3); 

    }
    
    public double area(double x1Coordinate, double y1Coordinate, double x2Coordinate, double y2Coordinate, 
            double x3Coordinate, double y3Coordinate) 
    { 
       return Math.abs((x1Coordinate * (y2Coordinate - y3Coordinate) + 
               x2Coordinate * (y3Coordinate - y1Coordinate)+ 
               x3Coordinate * (y1Coordinate - y2Coordinate))/2.0); 
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
