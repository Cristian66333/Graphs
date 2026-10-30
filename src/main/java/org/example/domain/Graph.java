package org.example.domain;

import org.example.exception.VertexNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Graph<T> {
    private List<Vertex<T>> vertexList;
    private Comparator<T> comparator;
    private Boolean directed;

    public Graph(Comparator<T> comparator, Boolean directed) {
        this.vertexList = new ArrayList<>();
        this.comparator = comparator;
        this.directed = directed;
    }

    public void addNode(T info) throws VertexNotFoundException{
        if (findNode(info) != null){
            throw new VertexNotFoundException("El objeto ya existe dentro del grafo");
        }else{
            vertexList.add(new Vertex<>(info));
        }
    }

    public void addAdjacent(T source, T destination, double weight) throws VertexNotFoundException{
        Vertex<T> from = findNode(source);
        Vertex<T> to = findNode(destination);
        if (from!=null && to !=null){
            from.addAdjacent(to, weight);
            if (!directed){
                to.addAdjacent(from, weight);
            }
        }else {
            throw new VertexNotFoundException("El nodo no se ha encontrado");
        }

    }

    public Boolean removeNode(T info){
        Vertex<T> removeNode = findNode(info);
        if (removeNode!=null){
            for (Vertex<T> aux : vertexList){
                aux.removeAdjacent(removeNode);
            }
            vertexList.remove(removeNode);
            return true;
        }else {
            return false;
        }
    }

    public List<T> findAdjacents(T info) throws VertexNotFoundException{
        List<T> results = new ArrayList<>();
        Vertex<T> aux = findNode(info);
        if (aux!=null){
            for (Edge<T> edgeAux: aux.getAdjacents()){
                results.add(edgeAux.getDestination().getInfo());
            }
            return results;
        }else {
            throw new VertexNotFoundException("El vertice no se encontró");
        }
    }

    public Vertex<T> findNode(T info){
        if (this.vertexList.isEmpty()){
            return null;
        }else{
            Optional<Vertex<T>> foundVertex = this.vertexList.stream()
                    .filter((vertex) -> comparator.compare(vertex.getInfo(), info)==0)
                    .findFirst();

            return foundVertex.orElse(null);
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexList=" + vertexList +
                ", directed=" + directed +
                '}';
    }
}
