import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Area {
    private int number0 = 0, number1 = 1, number2 = 2;
    private double width, height, radius;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Take input of height, width, radius depend on parameter.
     *
     * @param  dimension the first {@code String} to choose input type
     *         dimension 0 then choose height
     *         dimension 1 then choose width
     *         dimension 2 then choose radius
     * @return no return type 
     */
    public void heightWidthRadius(int dimension) {

        try {
            if (dimension == number0) {
                System.out.print("Enter heigth : ");
                height = Double.parseDouble(br.readLine());
            } else if (dimension == number1) {
                System.out.print("Enter wigth : ");
                width = Double.parseDouble(br.readLine());
            } else {
                System.out.print("Enter radius : ");
                radius = Double.parseDouble(br.readLine());
            }
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception : " + e.getMessage());
            System.out.println("Please enter number "
                    + "not string(Contain alphabet, spacial "
                    + "charecter, space, operator) "
                    + ": \nExample :- \n 1, 12, 164, 908 ");
        } catch (IOException e) {
            System.out.println("Input Outout Exception : " + e.getMessage());
        }
    }

    /**
     * Calculate triangle area
     *
     * @param  no parameter 
     * @return the double value 
     */
    public double triangleArea() {

        heightWidthRadius(number0);
        heightWidthRadius(number1);

        return (height * width) / 2;
    }

    /**
     * Calculate rectangle area
     *
     * @param  no parameter 
     * @return the double value 
     */
    public double rectangleArea() {

        heightWidthRadius(number0);
        heightWidthRadius(number1);

        return (height * width);
    }

    /**
     * Calculate square area
     *
     * @param  no parameter 
     * @return the double value 
     */
    public double squareArea() {

        heightWidthRadius(number1);

        return (width * width);
    }

    /**
     * Calculate circle area
     *
     * @param  no parameter 
     * @return the double value 
     */
    public double circleArea() {

        heightWidthRadius(number2);

        return (radius * radius * Math.PI);
    }

}
