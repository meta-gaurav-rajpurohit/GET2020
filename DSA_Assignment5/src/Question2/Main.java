package Question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException,
            IOException {
        
        Linklist linklist = new Linklist();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        linklist.add("gaurav", 26000.00, 1);
        linklist.add("rahul", 30000.00, 2);
        linklist.add("surjeet", 24000.00, 9);
        linklist.add("bhupat", 2000.00, 7);
        linklist.showLinklist();
        System.out.println("After Sorting : ");
        linklist.sort();
        linklist.showLinklist();
//        
        Linklist linklist1 = new Linklist();
        System.out.println("\n\n\n\n\nnext : ");
        linklist1.add("gaurav", 26000.00, 1);
        linklist1.add("rahul", 24000.00, 5);
        linklist1.add("surjeet", 24000.00, 3);
        linklist1.add("bhupat", 24000.00, 4);
        linklist1.add("bhupat", 2000.00, 7);
        linklist1.showLinklist();
        System.out.println("After Sorting : ");
        linklist1.sort();
        linklist1.showLinklist();
        
        Linklist linklist2 = new Linklist();
        System.out.println("\n\n\n\n\nnext : ");
        linklist2.add("gaurav", 24000.00, 5);
        linklist2.add("rahul", 26000.00, 5);
        linklist2.add("surjeet", 24000.00, 2);
        linklist2.add("bhupat", 2000.00, 4);
        linklist2.add("bhupat", 24000.00, 3);
        linklist2.showLinklist();
        System.out.println("After Sorting : ");
        linklist2.sort();
        linklist2.showLinklist();
        
        Linklist linklist3 = new Linklist();
        System.out.println("\n\n\n\n\nnext : ");
        linklist3.add("gaurav", 24000.00, 5);
        linklist3.add("rahul", 26000.00, 5);
        linklist3.add("surjeet", 24000.00, 2);
        linklist3.add("bhupat", 2000.00, 4);
        linklist3.add("bhupat", 24000.00, 3);
        linklist3.add("bhupat", 1000.00, 3);
        linklist3.add("bhupat", 3000.00, 3);
        linklist3.showLinklist();
        System.out.println("After Sorting : ");
        linklist3.sort();
        linklist3.showLinklist();
        
        Linklist linklist4 = new Linklist();
        System.out.println("\n\n\n\n\nnext : ");
        linklist4.add("gaurav", 1000.00, 8);
        linklist4.add("rahul", 1000.00, 7);
        linklist4.add("surjeet", 1000.00, 6);
        linklist4.add("bhupat", 1000.00, 5);
        linklist4.add("bhupat", 1000.00, 4);
        linklist4.add("bhupat", 1000.00, 3);
        linklist4.add("bhupat", 1000.00, 2);
        linklist4.showLinklist();
        System.out.println("After Sorting : ");
        linklist4.sort();
        linklist4.showLinklist();

    }

}
