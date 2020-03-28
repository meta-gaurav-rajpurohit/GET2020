package Question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws NumberFormatException,
            IOException {
        boolean flag = true;
        int capacity, priority, data;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Queue Size : ");
        capacity = Integer.parseInt(br.readLine());

//        int a[] = new int[10];
//        for(int i : a){
//            System.out.println(i);
//        }
        PriorityQueue queue = new PriorityQueue(capacity);
        do {
            System.out
                    .print("\nOperations :\n1) Add item\n2) Delete item\n3) show Queue\n"
                            + "4) Exit \nSelect your operation : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                System.out.print("\nEnter Data : ");
                data = Integer.parseInt(br.readLine());
                System.out.print("\nEnter Priority : ");
                priority = Integer.parseInt(br.readLine());
                queue.add(data, priority);
                break;
            case 2:
                queue.delete();
                break;
            case 3:
                queue.show();
                break;
            case 4:
                flag = false;
                break;
            default:
                System.out.println("Wrong Input try again");
            }
        } while (flag);
    }
}

