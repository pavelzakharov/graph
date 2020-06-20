package mydemo.graph;

import mydemo.graph.specifics.Edge;

import java.util.Set;

/**
 * Graph supporting user-defined vertices.
 *
 * @param <V> vertex type
 */
public interface Graph<V> {

    /**
     * Adds edge connecting specified source and target vertices if not exists,
     * otherwise doesn't touch the graph.
     * Checks if both source and target vertices are in graph.
     * Rejects creating loops when source and target vertices are the same.
     *
     * @param sourceVertex source vertex of required edge
     * @param targetVertex target vertex or required edge
     * @return newly created edge between specified vertices or null if the former exists
     * @throws IllegalArgumentException if any of specified vertices aren't in graph or source vertex equals target
     * @throws NullPointerException     if any of specified vertices is null
     */
    Edge<V> addEdge(V sourceVertex, V targetVertex);

    /**
     * Adds vertex to the graph if it's not present
     *
     * @param v vertex to be added to the graph
     * @return true if specified vertex was actually added to the graph
     * @throws NullPointerException if specified vertex is null
     */
    boolean addVertex(V v);

    /**
     * Cheks if graph contains specified vertex
     *
     * @param source vertex to check for equality
     * @return true if graph contains vertex equal to specified
     */
    boolean containsVertex(V source);

    /**
     * Returns edge connecting specified vertices. If vertices aren't in graph or aren't connected
     * by the edge then returns null.
     * For undirected graph source and target of returned edge may be swapped.
     *
     * @param sourceVertex source edge vertex
     * @param targetVertex target edge vertex
     * @return edge connecting specified vertices
     */
    Edge<V> getEdge(V sourceVertex, V targetVertex);

    /**
     * Returns set of edges outgoing from specified vertex or touching it (in case of undirected one).
     *
     * @param vertex subject of outgoing edges
     * @return set of edges outgoing for the vertex or touching it
     * @throws NullPointerException     if specified vertex is null
     * @throws IllegalArgumentException if vertex is not found in the graph
     */
    Set<Edge<V>> outgoingEdgesOf(V vertex);

    /**
     * Get vertex opposite specified one of the same edge
     *
     * @param e edge which should connect both vertices
     * @param v vertex which opposite one should be found
     * @return vertex opposite to speciied one cnnected by specified edge
     * @throws IllegalArgumentException if no vertex connected with specified one by specified edge
     */
    V getOppositeVertex(Edge<V> e, V v);

    /**
     * Returns the source vertex of an edge. For an undirected graph, source and target are
     * distinguishable designations
     *
     * @param e edge of interest
     * @return source vertex
     */
    V getEdgeSource(Edge<V> e);

    /**
     * Returns the target vertex of an edge. For an undirected graph, source and target are
     * distinguishable designations
     *
     * @param e edge of interest
     * @return target vertex
     */
    V getEdgeTarget(Edge<V> e);
}
