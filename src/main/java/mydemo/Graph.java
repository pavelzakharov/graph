package mydemo;

import mydemo.graph.Edge;

import java.util.Set;

public interface Graph<V> {
    Edge<V> addEdge(V sourceVertex, V targetVertex);

    boolean addVertex(V v);

    boolean containsVertex(V source);

    Edge<V> getEdge(V sourceVertex, V targetVertex);

    V getEdgeSource(Edge<V> e);

    V getEdgeTarget(Edge<V> e);

    Set<Edge<V>> outgoingEdgesOf(V vertex);
}
