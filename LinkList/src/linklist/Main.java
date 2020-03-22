package linklist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        int choice, totalNode, leftNode, rightNode, rotate;
        boolean flag = true;
        Linklist linklist = new Linklist();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("\nOperations : \n 1) Add Node\n 2) Rotate\n "
                    + "3) exit \n select operation : ");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
            case 1:
                System.out.print("Enter number of node : ");
                totalNode = Integer.parseInt(br.readLine());
                int count = 0;
                while (count < totalNode) {
                    System.out.println("Enter node " + (count + 1) + " : ");
                    linklist.add(Integer.parseInt(br.readLine()));
                    count++;
                }
                linklist.showLinklist();
                
                break;
            case 2:
                System.out.print("Enter left node number : ");
                leftNode = Integer.parseInt(br.readLine());
                System.out.print("Enter right node number : ");
                rightNode = Integer.parseInt(br.readLine());
                System.out.print("Enter number of rotation : ");
                rotate = Integer.parseInt(br.readLine());
                linklist.rotate(leftNode, rightNode, rotate);
                break;
            case 3:
                flag = false;
                break;

            default:
                System.out.println("Enter valid input...");
            }
            System.out.println("000000000000000000");
        } while (flag);
    }

}
