package Question1;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(2, 5, 5);
        graph.addEdge(3, 5, 2);
        System.out.println("graph is connected : "+graph.isConnected());

        int node = 5;
        List<Integer> listOfReachableNode = graph.reachableNodes(node);
        System.out.print("nodes that are reachable from node "+node+" :");
        for(int a : listOfReachableNode){
            System.out.print(" "+a);
        }
        
        System.out.println("\nMST : ");
        List<Edge> MSTOutput = graph.getMinimumSpanningTree();
        for (Edge edge : MSTOutput) {
            System.out.println(edge.getSource() + " " + edge.getDestination()
                    + " " + edge.getWeight());
        }
        System.out.println("SP : ");
        List<Integer> SPOutput = graph.shortestPath(1, 4);
        for (Integer edge : SPOutput) {
            System.out.println(edge + " ");
        }
    }

}
