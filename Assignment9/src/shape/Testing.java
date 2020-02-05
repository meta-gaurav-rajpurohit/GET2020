package shape;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Testing {

    // Test for Adding circle to screen
    @Test
    public void testAddShape1() throws Exception {
        Screen screen = Screen.getInstance();
        Date date = new Date();
        Boolean size = screen.addShape(new Circle(7.0, new Point(2.0, 2.0),
                date));
        assertTrue(size);
    }

    // Test for adding rectangle to screen
    @Test
    public void testAddShape2() throws Exception {
        Screen screen = Screen.getInstance();
        Date date = new Date();
        Boolean size = screen
                .addShape(new Circle(8.0, new Point(10, 10), date));
        assertTrue(size);
    }

    // Test for adding triangle to screen
    @Test
    public void testAddShape3() throws Exception {
        Screen screen = Screen.getInstance();
        Date date = new Date();
        Boolean size = screen.addShape(new Rectangle(9.0, 8.0,
                new Point(10, 10), date));
        assertTrue(size);
    }

    // Test for adding square to screen
    @Test
    public void testAddShape4() throws Exception {
        Screen screen = Screen.getInstance();
        Date date = new Date();
        Boolean size = screen.addShape(new Rectangle(9.0, 1.0, new Point(0, 0),
                date));
        assertTrue(size);
    }

    // Test for deleting a shape
    @Test
    public void testDeleteShape() throws Exception {
        Screen screen = Screen.getInstance();
        Date date = new Date();
        screen.addShape(new Rectangle(9.0, 1.0, new Point(0, 0), date));
        Boolean size = screen.delete(new Rectangle(9.0, 1.0, new Point(0, 0),
                date));
        assertTrue(size);

    }

    // Test for deleting all shapes of a type.
    @Test
    public void testAllDeleteShape() throws Exception {
        Screen screen = Screen.getInstance();
        Date date1 = new Date();
        screen.addShape(new Rectangle(9.0, 1.0, new Point(0, 0), date1));
        Date date2 = new Date();
        screen.addShape(new Rectangle(2.0, 1.0, new Point(0, 0), date2));
        Date date3 = new Date();
        screen.addShape(new Circle(9.0, new Point(9, 9), date3));
        Date date4 = new Date();
        screen.addShape(new Circle(8.0, new Point(10, 10), date4));
        Boolean size = screen.deleteAll();
        assertTrue(size);
    }

    @SuppressWarnings("serial")
    @Test
    public void testAscendingInArea() {
        Screen screen = new Screen();
        Shape shape1 = ShapeFactory.shapeSelector(Shape.ShapeTypes.RECTANGLE,
                new Point(1, 1), new ArrayList<Double>() {
                    {
                        add(4.0);
                        add(2.0);
                    }
                });
        

        screen.addShape(shape1);
        Shape shape2 = ShapeFactory.shapeSelector(Shape.ShapeTypes.SQUARE,
                new Point(1, 1), new ArrayList<Double>() {
                    {
                        add(2.0);
                    }
                });
        screen.addShape(shape2);
        List<Shape> sortedShapeByArea = screen.sortByArea();
        assertEquals(sortedShapeByArea, new ArrayList<Shape>() {
            {
                add(shape2);
                add(shape1);
            }
        });
    }
    
    @SuppressWarnings("serial")
    @Test
    public void testAscendingInParimeter() {
        Screen screen = new Screen();
        Shape shape1 = ShapeFactory.shapeSelector(Shape.ShapeTypes.RECTANGLE,
                new Point(1, 1), new ArrayList<Double>() {
                    {
                        add(4.0);
                        add(2.0);
                    }
                });
        

        screen.addShape(shape1);
        Shape shape2 = ShapeFactory.shapeSelector(Shape.ShapeTypes.SQUARE,
                new Point(1, 1), new ArrayList<Double>() {
                    {
                        add(2.0);
                    }
                });
        screen.addShape(shape2);
        List<Shape> sortedShapeByPerimeter = screen.sortByParimeter();
        assertEquals(sortedShapeByPerimeter, new ArrayList<Shape>() {
            {
                add(shape2);
                add(shape1);
            }
        });
    }
}
