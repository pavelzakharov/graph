package mydemo.graph;

public interface EdgesSpecifics<V> {
    boolean add(Edge<V> e, V sourceVertex, V targetVertex);

    boolean containsEdge(Edge<V> e);

}
