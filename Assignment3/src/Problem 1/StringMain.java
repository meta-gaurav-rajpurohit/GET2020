import java.io.*;

public class StringMain {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * take string input
     *
     * @param number the first {@code int} to take input
     * @return the string value
     */
    public static String input(int number) throws Exception {
        String name;
        boolean flag = false;

        do {
            System.out.print("Enter string " + number + " : ");
            name = br.readLine();
            if (name.isEmpty()) {
                System.out.println("\nString can not be null....\nTry again\n");
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        return name;
    }

    public static void main(String args[]) throws Exception {
        boolean flag = false;
        String sresult = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringOperation so = new StringOperation();

        System.out
                .println("Menu : \n 1) Compare String \n 2) Reverse String \n 3) "
                        + "Change Charecter Case \n 4) Find Largest String ");
        try {
            do {
                System.out.print("Select your operation : ");
                switch (Integer.parseInt(br.readLine())) {
                case 1:
                    sresult = Integer.toString(so.compareString(input(1),
                            input(2)));

                    if ("0".equals(sresult))
                        sresult = "Both strings are equal";
                    else
                        sresult = "Both string are not equal";

                    flag = false;
                    break;
                case 2:
                    sresult = so.reverseString(input(1));
                    flag = false;
                    break;
                case 3:
                    sresult = so.changeCharCase(input(1));
                    flag = false;
                    break;
                case 4:
                    sresult = so.largestWordString(input(1), input(2));
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong selection..... try again\n");
                    flag = true;
                }
            } while (flag);

            System.out.println("Answer : " + sresult);
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception : " + e.getMessage());
            System.out
                    .println("Please enter number not string(Contain "
                            + "alphabet, spacial charecter, space, operator) : \nExample :- "
                            + "\n 1, 12, 164, 908 ");
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
