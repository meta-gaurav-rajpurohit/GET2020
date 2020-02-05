package shape;

import java.util.ArrayList;
import java.util.Date;

public class ShapeFactory {

    public static Shape shapeSelector(Shape.ShapeTypes shape, Point origenPoint, ArrayList<Double> parameter){
        boolean flag = true;
        
        Date date = new Date();
        Shape shapeContainer = null;
        Screen screen = Screen.getInstance();
        do{
        switch(shape){
        case SQUARE : 
            shapeContainer = new Square(parameter.get(0), origenPoint, date);
            flag = false;
            break;
        case RECTANGLE : 
            shapeContainer = new Rectangle(parameter.get(0), parameter.get(1), origenPoint, date);
            flag = false;
            break;
        case CIRCLE : 
            shapeContainer = new Circle(parameter.get(0), origenPoint, date);
            flag = false;
            break;
        case TRIANGLE : 
            shapeContainer = new Triangle(parameter.get(0), parameter.get(1), parameter.get(2), origenPoint, date);
            flag = false;
            break;
        default : 
            System.out.println("Wrong input......... try again");
        }
        }while(flag);
        screen.addShape(shapeContainer);
        return shapeContainer;
    }
}
