package org.example;


import org.example.domain.Student;
import org.example.exception.VertexNotFoundException;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class Application {

    public static void main(String[] args) {
        /*Graph<Student> students
                = new Graph<>((o1,o2)->o1.getName().compareTo(o2.getName()), false);
        try{
            students.addNode(new Student("Daniel Canaria", 2));
            students.addNode(new Student("Juan Pablo Figueroa", 1));
            students.addNode(new Student("Brayan Holguin", 2));
            students.addNode(new Student("Paula Leon", 1));
            students.addAdjacent(new Student("Daniel Canaria", 2),new Student("Brayan Holguin", 2), 1);
            students.addAdjacent(new Student("Juan Pablo Figueroa", 1),new Student("Paula Leon", 1), 0);
            students.addAdjacent(new Student("Paula Leon", 1),new Student("Daniel Canaria", 2), 2);
        }catch (VertexNotFoundException ve){
            IO.println(ve.getMessage());
        }
        IO.println(students);*/
        Graph<String, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        graph.addVertex("Sogamoso");
        graph.addVertex("Tunja");
        graph.addVertex("Duitama");
        graph.addVertex("Bogota");
        graph.addVertex("Paipa");
        graph.addVertex("Yopal");
        graph.addVertex("Aguazul");

        Graphs.addEdge(graph, "Sogamoso", "Tunja", 80);
        Graphs.addEdge(graph, "Sogamoso", "Duitama", 30);
        Graphs.addEdge(graph, "Sogamoso", "Bogota", 120);
        Graphs.addEdge(graph, "Sogamoso", "Paipa", 50);
        Graphs.addEdge(graph, "Sogamoso", "Yopal", 116);
        Graphs.addEdge(graph, "Sogamoso", "Aguazul", 100);
        Graphs.addEdge(graph, "Tunja", "Duitama", 50);
        Graphs.addEdge(graph, "Tunja", "Bogota", 90);
        Graphs.addEdge(graph, "Tunja", "Paipa", 40);
        Graphs.addEdge(graph, "Tunja", "Yopal", 200);
        Graphs.addEdge(graph, "Tunja", "Aguazul", 180);
        Graphs.addEdge(graph, "Tunja", "Sogamoso", 80);
        Graphs.addEdge(graph, "Paipa", "Yopal", 40);
        Graphs.addEdge(graph, "Paipa", "Duitama", 30);
        Graphs.addEdge(graph, "Paipa", "Bogota", 200);
        Graphs.addEdge(graph, "Paipa", "Sogamoso", 40);
        Graphs.addEdge(graph, "Paipa", "Yopal", 300);
        Graphs.addEdge(graph, "Paipa", "Aguazul", 500);
        Graphs.addEdge(graph, "Duitama", "Sogamoso", 100);
        Graphs.addEdge(graph, "Duitama", "Bogota", 4);
        Graphs.addEdge(graph, "Duitama", "Paipa", 15);

        DijkstraShortestPath<String, DefaultWeightedEdge> dijskstra = new DijkstraShortestPath<>(graph);
        IO.println(dijskstra.getPath("Sogamoso","Yopal"));


    }
}
