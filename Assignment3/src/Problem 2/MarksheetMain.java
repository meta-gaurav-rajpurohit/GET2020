import java.io.*;
import java.util.HashMap;

public class MarksheetMain {
    public static void main(String args[]) throws IOException {
        boolean flag = false;
        double result = 0.0;
        int studentnum;

        //HashMap which String contain student name and Double contain student percentage
        HashMap<String, Double> hm = new HashMap<String, Double>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Marksheet mk = new Marksheet();

        try {
            System.out.print("Enter number of user : ");
            studentnum = Integer.parseInt(br.readLine());

            //take students name and percentage
            for (int i = 0; i < studentnum; i++) {
                System.out.println("Enter Name and Percentage : ");
                hm.put(br.readLine(), Double.parseDouble(br.readLine()));
            }

            System.out.print("Menu : \n 1) Average Marks \n 2) Maximum Marks\n "
                            + "3) Minimum Marks\n 4) percentage of students passed\nSelect Option : ");

            do {
                //Select operation
                switch (Integer.parseInt(br.readLine())) {
                case 1:
                    result = mk.avgMarks( hm, studentnum);
                    //terminate condition for do-while loop
                    flag = false;
                    break;
                case 2:
                    result = mk.maxMarks( hm );
                    flag = false;
                    break;
                case 3:
                    result = mk.minMarks( hm );
                    flag = false;
                    break;
                case 4:
                    result = mk.passStdPer( hm, studentnum);
                    flag = false;
                    break;
                default:
                    System.out.print("\nWrong Input .... Try again\nSelect Operation :");
                    //Continues do-while loop
                    flag = true;
                }
            } while (flag);
            System.out.println("Answer : " + result);
        } 
        catch (NumberFormatException e) {
            System.out.println("Number Format Exception : " + e.getMessage());
            System.out.println("Please enter number not string(Contain "
                            + "alphabet, spacial charecter, space, operator) : \nExample :- "
                            + "\n 1, 12, 164, 908 ");
        } 
        catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
