import java.util.regex.Pattern;
import java.io.*;

public class main_ {

    /**
     * Take input for Hexadecimal base values as string format.
     *
     * @param hexnumber_1 the first {@code int} to print input number
     * @return the string of hexadecimal base value
     */
    public static String input(int temp) throws IOException {
        String number;
        boolean flag = false, matches = false;
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("Enter number " + temp + " : ");
            number = br.readLine().toUpperCase().trim();
            do {
                count = 0;
                if (number.charAt(count) != '0') {
                    break;
                } else {
                    count = 1;
                    number = number.substring(count);
                }
            } while (true);
            matches = Pattern.matches("[0-9A-F]+", number);
            if (!matches) {
                System.out.println("Please enter valid and "
                                + "positive number.. \n\n Example :- "
                                + "\n Hexadecimal number contain only 0-9 number and A-F alphabet \n "
                                + "(Right Input) : \n  101 \n  1AB \n  ABA1 \n\n "
                                + "(Wrong Input) : "
                                + "\n (Alphabet G-Z are not allowed) : \n \t 1ZA , 23BXC ,GAC "
                                + "\n (Spacial Symbol are not allowed) : \n \t 1@C# , <1(D , AS.,1 , %A12 "
                                + "\n ( Negative number are also not allowed ) : \n \t -101 , -1AB \n");
                flag = true;
            } else
                flag = false;
        } while (flag);
        return number;
    }

    /**
     * Take input for decimal base values as string format.
     *
     * @return the decimal base value
     */
    public static int input() throws IOException {
        String number;
        boolean flag = false, matches = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("Enter Decimal number : ");
            number = br.readLine().trim();
            matches = Pattern.matches("[0-9]+", number);
            if (!matches) {
                System.out.println("Please enter valid and positive number.. "
                                + "\n\n Example :- \n Decimal number contain only 0-9 number "
                                + "\n (Right Input) : \n  101 \n  123 \n  78649 \n\n (Wrong Input) : "
                                + "\n (Alphabets are not allowed) : \n \t 1ZA , 23BXC ,GAC "
                                + "\n (Spacial Symbol are not allowed) : \n \t 1@C# , <1(D , AS.,1 , %A12 "
                                + "\n ( Negative number are also not allowed ) : \n \t -101 , -19 \n");
                flag = true;
            } else
                flag = false;
        } while (flag);
        return Integer.parseInt(number);
    }

    /**
     * Select operation for Hexadecimal base values.
     *
     * @param hexnumber_1 the first {@code int} to select operation
     * @return the output of the operation as string format
     */
    public static String selectOperation(int operation) throws IOException {
        HexCalc HC = new HexCalc();
        String hexa = "";

        switch (operation) {
        case 1:
            hexa = HC.add(input(1), input(2));
            break;
        case 2:
            hexa = HC.sub(input(1), input(2));
            break;
        case 3:
            hexa = HC.mul(input(1), input(2));
            break;
        case 4:
            hexa = HC.div(input(1), input(2));
            break;
        case 5:
            hexa = Integer.toString(HC.hexadecimalTODecimal(input(1)));
            break;
        case 6:
            if (HC.eql(input(1), input(2)))
                hexa = "Both numbers are equal";
            else
                hexa = "Both numbers are not equal";
            break;
        case 7:
            if (HC.less(input(1), input(2)))
                hexa = "Number 1 is less then Number 2";
            else
                hexa = "Number 1 is not less then Number 2";
            break;
        case 8:
            if (HC.grt(input(1), input(2)))
                hexa = "Number 1 is greater then Number 2";
            else
                hexa = "Number 1 is not greater then Number 2";
            break;
        default:
            System.out.println("Wrong Input ....  Try again. ");
        }
        return hexa;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HexCalc HC = new HexCalc();

        int selector, operation;
        boolean temp = true;
        String ans;

        do {
            System.out.print(" Menu : \n 1) Hexadecimal \n 2) Decimal \n 3) Exit "
                            + "\n Choose any one type of number which you want to enter : ");
            selector = Integer.parseInt(br.readLine());
            switch (selector) {
            case 1:
                System.out.print(" Select operatio : \n 1) Addition \n 2) Substraction \n "
                                + "3) Multiplication \n 4) Division \n 5) Convert to Decimal \n "
                                + "6) Check number 1 and number 2 are equel \n 7) check number 1 is Less then number 2 \n "
                                + "8) check number 1 is greater then number 2 \n Select One Operation : ");
                operation = Integer.parseInt(br.readLine());
                ans = selectOperation(operation);
                System.out.println("Answer : " + ans);
                break;
            case 2:
                System.out.println(" Convert Decimal to Hexadecimal operation :");
                ans = HC.decimalTOhexadecimal(input());
                System.out.println("Answer : " + ans);
                break;
            case 3:
                temp = false;
                break;
            default:
                System.out.println("Wrong Input ....  Try again. ");
            }
        } while (temp);
    }
}