
public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('K');

        graph.addEdge(0, 1, 2); //AB
        graph.addEdge(1, 2, 3); //BC
        graph.addEdge(2, 8, 3); //CI
        graph.addEdge(8, 9, 1); //IK
        graph.addEdge(0, 3, 3); //AD
        graph.addEdge(3, 4, 3); //DE
        graph.addEdge(4, 9, 3); //EK
        graph.addEdge(0, 5, 1); //AF
        graph.addEdge(5, 6, 2); //FG
        graph.addEdge(6, 7, 1); //GH
        graph.addEdge(7, 9, 1); //HK

        graph.dfs();

    }
}