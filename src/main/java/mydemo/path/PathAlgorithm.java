package mydemo.path;

/**
 * The algorithm that computes path between vertices
 *
 * @param <V> vertex type
 */
public interface PathAlgorithm<V> {

    /**
     * Returns path between source and target vertices
     *
     * @param source source vertex
     * @param sink   target vertex
     * @return path from source to target
     */
    GraphPath<V> getPath(V source, V sink);

    /**
     * Set of paths starting from a particular vertex
     *
     * @param <V> vertex type
     */
    interface SingleSourcePaths<V> {
        /**
         * Returns path from this source vertex to the specified target vertex
         *
         * @param sink target vertex
         * @return path to the specified vertex
         */
        GraphPath<V> getPath(V sink);
    }
}
