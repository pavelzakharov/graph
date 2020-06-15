package mydemo;

import mydemo.graph.Edge;

import java.util.List;

public interface GraphPath<V> {
    List<Edge<V>> getEdgeList();

    List<V> getVertexList();

    V getStartVertex();

    V getEndVertex();

    Graph<V> getGraph();

}
