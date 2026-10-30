package org.example.domain;

public class Edge<T> {
    private Vertex<T> destination;
    private double weight;

    public Edge(Vertex<T> destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    public void setDestination(Vertex<T> destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                ", weight=" + weight +
                '}';
    }
}
