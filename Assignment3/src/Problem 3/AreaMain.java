import java.io.*;

public class AreaMain {
    
    public static void main(String args[]) throws IOException {
        boolean flag = false, flag1 = false;
        //chance variable describe the maximum chance of user to continue program when exception occur
        int chance = 3, minchance = 0;
        double ans = 0.0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Area ar = new Area();
        System.out.print("Calculate Area of : \n 1) Triangle \n "
                + "2) Rectangle \n 3) Square \n 4) Circle \n Select option : ");

        /*this do-while loop are use to continue program when any Exception occur
          or break the loop when no exception occur 
        */
        do {
            try {
                /*this do-while loop are use to continue program when any Wrong option
                  choose by user and break the loop when select right option 
                */
                do {
                    switch (Integer.parseInt(br.readLine())) {
                    case 1:
                        ans = ar.triangleArea();
                        flag = false;
                        break;
                    case 2:
                        ans = ar.rectangleArea();
                        flag = false;
                        break;
                    case 3:
                        ans = ar.squareArea();
                        flag = false;
                        break;
                    case 4:
                        ans = ar.circleArea();
                        flag = false;
                        break;
                    default:
                        System.out
                                .println("Wrong output .... try again.\n Select option again : ");
                        flag = true;
                    }

                } while (flag);
                System.out.println("Area : " + ans);
                chance = minchance;

            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception : "+ e.getMessage());
                System.out.println("Please enter number "
                        + "not string(Contain alphabet, spacial "
                        + "charecter, space, operator) "
                        + ": \nExample :- \n 1, 12, 164, 908 ");
                chance--;
            } catch (IOException e) {
                System.out.println("Input Outout Exception : " + e.getMessage());
                chance--;
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
                chance--;
            }
            //if-else is use to terminate the loop when chance of user become 0 
            if (chance == minchance) {
                flag1 = false;
            }    
            else
                System.out.println("\nRemain Chances available : " + chance);

        } while (flag1);
    }

}
