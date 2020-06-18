package mydemo.graph;

import mydemo.graph.specifics.Edge;

import java.util.Set;

public interface Graph<V> {

    Edge<V> addEdge(V sourceVertex, V targetVertex);

    boolean addVertex(V v);

    boolean containsVertex(V source);

    Edge<V> getEdge(V sourceVertex, V targetVertex);

    Set<Edge<V>> outgoingEdgesOf(V vertex);

    V getOppositeVertex(Edge<V> e, V v);
}
