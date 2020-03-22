package linklistloop;

import java.io.IOException;

import linklist.Node;

public class Main {

    public static void main(String[] args) throws NumberFormatException,
            IOException {

        Linklist linklist = new Linklist();
        Node loopnode = new Node(7);
        linklist.add(new Node(1));
        linklist.add(new Node(2));
        linklist.add(loopnode);
        linklist.add(new Node(4));
        linklist.add(new Node(5));
        
//        System.out.print("Enter number of node : ");
        linklist.showLinklist();
        linklist.add(loopnode);
        System.out.println("\nLoop Exists : "+linklist.loopExists());
    }

}
