package com.progressive.htmlescape.collections.graph;

import lombok.Data;

import java.util.*;

@Data
public class MyGraph {
    private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    public void addVertex(String label){
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public String removeVertex(String label){
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e->e.remove(v));
        adjVertices.remove(v);
        return null;
    }

    public void addEdges(String label1, String label2){
        Vertex v1= new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    public void removeEdges(String label1, String label2){
        Vertex v1= new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).remove(v2);
        adjVertices.get(v2).remove(v1);
        /*if (adjVertices.get(v1) != null) {
            adjVertices.get(v1).remove(v2);
        }
        if (adjVertices.get(v2) != null) {
            adjVertices.get(v2).remove(v1);
        }*/
    }

    public static MyGraph createGraph(){
        MyGraph myGraph = new MyGraph();
        myGraph.addVertex("Bob");
        myGraph.addVertex("Rob");
        myGraph.addVertex("Alice");
        myGraph.addVertex("Maria");
        myGraph.addVertex("Mark");
        myGraph.addEdges("Bob","Rob");
        myGraph.addEdges("Bob","Alice");
        myGraph.addEdges("Alice","Mark");
        myGraph.addEdges("Alice","Maria");
        myGraph.addEdges("Mark","Rob");
        myGraph.addEdges("Maria","Rob");
        return myGraph;
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    Set<String> depthFirstSearch(MyGraph graph, String root){
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            String vertex = stack.pop();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for (Vertex v:graph.getAdjVertices(vertex)){
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    Set<String> breadthFirstSearch(MyGraph graph, String root){
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            String vertex = queue.remove();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for (Vertex v:graph.getAdjVertices(vertex)){
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        MyGraph graph;
        graph = createGraph();
        Set<String> bfs = graph.breadthFirstSearch(graph,"Bob");
        System.out.println("BFS = "+bfs);
        Set<String> dfs = graph.depthFirstSearch(graph,"Bob");
        System.out.println("DFS = "+dfs);
    }
}
