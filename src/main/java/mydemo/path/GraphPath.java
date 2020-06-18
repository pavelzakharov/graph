package mydemo.path;

import mydemo.graph.Graph;
import mydemo.graph.specifics.Edge;

import java.util.List;

public interface GraphPath<V> {
    List<Edge<V>> getEdgeList();

    List<V> getVertexList();

    V getStartVertex();

    V getEndVertex();

    Graph<V> getGraph();

}
