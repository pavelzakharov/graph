package mydemo.graph.specifics;

import java.util.Set;

/**
 * Encapsulates basic graph operations which may vary for directed/undirected graph nature
 * @param <V> vertex type
 */
public interface Specifics<V> {
    /**
     * Creates an edge and sets it connecting specified source and target vertices.
     * Doesn't create multiple edges per source and target - returns null in this case.
     *
     * @param sourceVertex source vertex
     * @param targetVertex target vertex
     * @return edge if created during method call
     */
    Edge<V> createEdgeToTouchingVerticesIfAbsent(
            V sourceVertex, V targetVertex);

    /**
     *Adds specified vertex to the graph
     *
     * @param vertex to be added
     * @return true if vertex was added
     */
    boolean addVertex(V vertex);

    /**
     * Returns vertex set
     * @return vertex set
     */
    Set<V> getVertexSet();

    /**
     * Returns edge connecting source and target vertices.
     *
     * @param sourceVertex source vertex
     * @param targetVertex target vertex
     * @return edge connecting source and target vertices, if exist, null otherwise
     */
    Edge<V> getEdge(V sourceVertex, V targetVertex);

    /**
     * Returns outgoing edges of specified vertex
     *
     * @param vertex vertex to find outgoing edges
     * @return set of vertex outgoing edges
     */
    Set<Edge<V>> outgoingEdgesOf(V vertex);
}
