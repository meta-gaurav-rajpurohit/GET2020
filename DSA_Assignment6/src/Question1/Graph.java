package Question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Graph {
    List<List<Edge>> edgeList;
    List<List<Edge>> reachableNodeList;
    int vertices;
    int startingEdge;
    List<Edge> listOfEdgesInMST;

    /**
     * Constructs the graph with the given number of vertices.
     * @param vertices : number of vertices.
     */
    public Graph(int vertices) {
        try {
            if (vertices <= 0) {
                throw new Exception("Invalid value of vertices");
            }
            this.vertices = vertices;
            edgeList = new ArrayList<>(vertices);
            reachableNodeList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                edgeList.add(new LinkedList<Edge>());
                reachableNodeList.add(new LinkedList<Edge>());
            }
            listOfEdgesInMST = new ArrayList<Edge>();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public boolean addEdge(int source, int destination, int weight) {
        try {
            if (source <= 0 || source > vertices || destination > vertices
                    || destination <= 0) {
                throw new Exception(
                        "source and destination must be between 1 to "
                                + vertices);
            }
            Edge edge = new Edge(source, destination, weight);
            edgeList.get(source - 1).add(edge);
            reachableNodeList.get(source - 1).add(edge);
            
            Edge reverseEdge = new Edge(destination, source, weight);
            reachableNodeList.get(destination - 1).add(reverseEdge);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return true;
    }

    public boolean isConnected() {
        boolean isConnected = true;
        try {
            boolean[] isVisited = new boolean[vertices];
            for(List<Edge> listOfEdge: edgeList){
                if(!listOfEdge.isEmpty()){
                    startingEdge = listOfEdge.get(0).getSource();
                    break;
                }
            }
            depthFirstSearch(startingEdge, isVisited);
            for (int i = 0; i < vertices; i++) {
                // if all vertices are visited then graph is connected.
                if (isVisited[i] == false) {
                    isConnected = false;
                    return isConnected;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isConnected;

    }

    private void depthFirstSearch(int vertex, boolean[] isVisited) {
        try {
            if (vertex <= 0 || vertex > vertices) {
                throw new Exception("vertex must be between 1 to " + vertices);
            }
            isVisited[vertex - 1] = true;
            for (Edge edge : edgeList.get(vertex - 1)) {
                int destinationVertexOFEdge = edge.getDestination();
                boolean isDestinationVisited = isVisited[destinationVertexOFEdge - 1];

                if (!isDestinationVisited) {
                    depthFirstSearch(destinationVertexOFEdge, isVisited);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> reachableNodes(int vertexNode) {
        List<Integer> listOfReachableNode = null;
        try {

            if (vertexNode > vertices) {
                throw new AssertionError("vertexNode doesn't exist in graph");
            }
            listOfReachableNode = new ArrayList<Integer>();
            for(Edge nodelist: reachableNodeList.get(vertexNode-1)){
                listOfReachableNode.add(nodelist.getDestination());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return listOfReachableNode;
    }

    public List<Edge> getMinimumSpanningTree() {
        try {
            boolean[] isVisited = new boolean[vertices];
            getMSTUsingPrim(startingEdge, new ArrayList<Edge>(), isVisited);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return listOfEdgesInMST;
    }

    private void getMSTUsingPrim(int vertex, List<Edge> listOfTemporaryEdges,
            boolean[] isVisited) {
        try {
            if (vertex <= 0 || vertex > vertices) {
                throw new AssertionError("vertexNode doesn't exist in graph");
            }

            isVisited[vertex - 1] = true;
            List<Edge> listOfAdjacentEdges = edgeList.get(vertex - 1);

            for (Edge edge : listOfAdjacentEdges) {

                int destination = edge.getDestination();
                if (!isVisited[destination - 1]) {
                    listOfTemporaryEdges.add(edge);
                }
            }

            Edge currentEdge = listOfTemporaryEdges.get(0);
            int mininmumWeight = Integer.MAX_VALUE;
            for (Edge edge : listOfTemporaryEdges) {
                int currentWeight = edge.getWeight();

                boolean isMSTContainEdge = listOfEdgesInMST.contains(edge);

                if (mininmumWeight > currentWeight && !isMSTContainEdge) {
                    mininmumWeight = currentWeight;
                    currentEdge = edge;
                }
            }

            int destinationOfCurrent = currentEdge.getDestination();
            if (!isVisited[destinationOfCurrent - 1]) {
                listOfEdgesInMST.add(currentEdge);
                listOfTemporaryEdges.remove(currentEdge);
            }
            for (int i = 0; i < isVisited.length; i++) {
                if (!isVisited[i]) {
                    getMSTUsingPrim(destinationOfCurrent, listOfTemporaryEdges,
                            isVisited);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> shortestPath(int source, int destination) {
        List<Integer> shortestPath = null;
        try {
            if (source <= 0 || source > vertices || destination > vertices
                    || destination <= 0) {
                throw new Exception(
                        "source or destination doesn't exist in graph");
            }
            shortestPath = new ArrayList<Integer>();
            boolean[] isVisited = new boolean[vertices];

            int[][] distanceParentTable = new int[vertices][2];

            for (int i = 0; i < vertices; i++) {
                distanceParentTable[i][0] = Integer.MAX_VALUE;
            }
            distanceParentTable[source - 1][0] = 0;
            setDistanceParentTable(source, isVisited, distanceParentTable);
            int currentNode = destination;
            while (currentNode != source) {
                shortestPath.add(currentNode);
                currentNode = distanceParentTable[currentNode - 1][1];
            }
            shortestPath.add(currentNode);
            Collections.reverse(shortestPath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return shortestPath;

    }

    private void setDistanceParentTable(int currentNode, boolean[] isVisited,
            int[][] distanceParentTable) {
        try {
            if (currentNode <= 0 || currentNode > vertices) {
                throw new Exception("node doesn't exist in graph");
            }
            int minimumDistance = distanceParentTable[currentNode - 1][0];
            for (Edge edge : edgeList.get(currentNode - 1)) {

                int currentDestination = edge.getDestination();
                int currentDistance = edge.getWeight() + minimumDistance;
                if (distanceParentTable[currentDestination - 1][0] > currentDistance) {
                    distanceParentTable[currentDestination - 1][0] = currentDistance;
                    distanceParentTable[currentDestination - 1][1] = currentNode;
                }
            }
            isVisited[currentNode - 1] = true;
            currentNode = getMinimumDistanceNode(distanceParentTable, isVisited);
            for (int i = 0; i < isVisited.length; i++) {
                // recursive call to function if any node is not visited.
                if (!isVisited[i]) {
                    setDistanceParentTable(currentNode, isVisited,
                            distanceParentTable);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    private int getMinimumDistanceNode(int[][] distanceParentTable,
            boolean[] isVisited) {
        int node = 0;
        try {
            int minimum = Integer.MAX_VALUE;
            for (int i = 0; i < distanceParentTable.length; i++) {
                if (minimum > distanceParentTable[i][0] && !isVisited[i]) {
                    minimum = distanceParentTable[i][0];
                    node = i + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return node;
    }
}
