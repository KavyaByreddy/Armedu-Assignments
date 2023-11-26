package com.demo.path;
import java.util.*;

class Edge {
    Node target;
    int weight;

    public Edge(Node target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

class Node {
    String name;
    List<Edge> edges;
    int distance;
    int heuristic;
    int cost;
	public Node parent;

    public Node(String name) {
        this.name = name;
        edges = new ArrayList<>();
        distance = Integer.MAX_VALUE;
        heuristic = 0;
        cost = Integer.MAX_VALUE;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}

class Graph {
    List<Node> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public void addNode(Node node) {
        vertices.add(node);
    }
}

public class AStarAlgorithm {

    public static List<Node> astar(Graph graph, Node start, Node end) {
        Set<Node> closedSet = new HashSet<>();
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        start.distance = 0;
        start.cost = start.heuristic;

        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current == end) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (Edge edge : current.edges) {
                Node neighbor = edge.target;

                if (closedSet.contains(neighbor)) {
                    continue;
                }

                int tentativeDistance = current.distance + edge.weight;
                if (tentativeDistance < neighbor.distance) {
                    neighbor.distance = tentativeDistance;
                    neighbor.cost = neighbor.distance + neighbor.heuristic;

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    public static List<Node> reconstructPath(Node end) {
        List<Node> path = new ArrayList<>();
        Node current = end;
        while (current != null) {
            path.add(0, current);
            current = current.parent;
        }
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        A.heuristic = 10;
        B.heuristic = 5;
        C.heuristic = 3;
        D.heuristic = 2;
        E.heuristic = 0;

        A.addEdge(new Edge(B, 3));
        B.addEdge(new Edge(C, 5));
        C.addEdge(new Edge(D, 7));
        D.addEdge(new Edge(A, 3));
        D.addEdge(new Edge(E, 10));

        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addNode(E);

        List<Node> path = astar(graph, A, E);

        if (path != null) {
            System.out.print("Path: ");
            for (Node node : path) {
                System.out.print(node.name + "->");
            }

            int cost = path.get(path.size() - 1).distance;
            System.out.println("\nCost: " + cost);
        } else {
            System.out.println("No path found.");
        }
    }
}