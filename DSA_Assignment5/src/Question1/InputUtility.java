package Question1;

import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static int getPositiveIntegerOnly() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                if (value <= 0) {
                    throw new Exception();
                }
                return value;
            } catch (Exception ex) {
                System.out.println("Please enter a positive integer value : ");
            }
        }
    }

    public static String getString() {
        return sc.nextLine();
    }
}
