package shape;

public class Point {
    private final double xMaxCoordinate = 100 ;
    private final double yMaxCoordinate = 100;
    private final double xMinCoordinate = 0;
    private final double yMinCoordinate = 0;
    private final double xCoordinate ;
    private final double yCoordinate ;
    
    public Point(double xCoordinate, double yCoordinate){
        this.xCoordinate  = xCoordinate ;
        this.yCoordinate  = yCoordinate ; 
    }
    
    public double getXCoordinate(){
        return xCoordinate;
    }
    
    public double getYCoordinate(){
        return yCoordinate;
    }
    
    public double getXMaxCoordinate(){
        return xMaxCoordinate;
    }
    
    public double getYMaxCoordinate(){
        return yMaxCoordinate;
    }
    
    public double getXMinCoordinate(){
        return xMinCoordinate;
    }
    
    public double getYMinCoordinate(){
        return yMinCoordinate;
    }
}
