package mydemo.graph.specifics;

import java.util.Set;

public interface Specifics<V> {
    Edge<V> createEdgeToTouchingVerticesIfAbsent(
            V sourceVertex, V targetVertex);

    boolean addVertex(V vertex);

    Set<V> getVertexSet();

    Edge<V> getEdge(V sourceVertex, V targetVertex);

    Set<Edge<V>> outgoingEdgesOf(V vertex);
}
