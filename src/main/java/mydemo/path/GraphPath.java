package mydemo.path;

import mydemo.graph.Graph;
import mydemo.graph.specifics.Edge;

import java.util.List;

/**
 * Representation of path
 *
 * @param <V> vertex type
 */
public interface GraphPath<V> {
    /**
     * Returns edge list of current path. If not previously got/calculated
     * it uses vertex list to get edge between each to vertices.
     *
     * @return list of edges
     */
    List<Edge<V>> getEdgeList();

    /**
     * Returns vertex list of current path. If not previously got/calculated
     * it uses edge list to get vertex and opposite one per each edge
     *
     * @return list of vertices
     */
    List<V> getVertexList();

    /**
     * Returns start vertex of the path
     *
     * @return start vertex of the path
     */
    V getStartVertex();

    /**
     * Returns end vertex of the path
     *
     * @return end vertex of the path
     */
    V getEndVertex();

    /**
     * Returns the graph which current path relates to
     *
     * @return graph
     */
    Graph<V> getGraph();

}
