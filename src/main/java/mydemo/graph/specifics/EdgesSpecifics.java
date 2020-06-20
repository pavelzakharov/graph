package mydemo.graph.specifics;

/**
 * Provides access to the edges internals
 *
 * @param <V> vertex type
 */
public interface EdgesSpecifics<V> {
    /**
     * Setting source and target of specified edge and adds it to internal edge set
     *
     * @param e            edge to be added
     * @param sourceVertex source vertex
     * @param targetVertex target vertex
     * @return true if edge was added during method call
     */
    boolean add(Edge<V> e, V sourceVertex, V targetVertex);

    /**
     * Returns the source vertex of an edge.
     *
     * @param e the edge
     * @return the source vertex
     * @throws IllegalArgumentException if edge isn't present
     */
    V getEdgeSource(Edge<V> e);

    /**
     * Returns the target vertex of an edge.
     *
     * @param e the edge
     * @return the target vertex
     * @throws IllegalArgumentException if edge isn't present
     */
    V getEdgeTarget(Edge<V> e);

}
