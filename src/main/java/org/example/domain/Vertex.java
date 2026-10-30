package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private T info;
    private List<Edge<T>> adjacents;

    public Vertex(T info) {
        this.info = info;
        this.adjacents = new ArrayList<>();
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public List<Edge<T>> getAdjacents() {
        return adjacents;
    }

    public void setAdjacents(List<Edge<T>> adjacents) {
        this.adjacents = adjacents;
    }

    public void removeAdjacent(Vertex<T> destination){
        this.adjacents.removeIf((edge) ->
             edge.getDestination() == destination
        );
    }

    public void addAdjacent(Vertex<T> destination, double weight){
        this.adjacents.add(new Edge<>(destination, weight));
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "info=" + info +
                ", adjacents=" + adjacents +
                '}';
    }
}
