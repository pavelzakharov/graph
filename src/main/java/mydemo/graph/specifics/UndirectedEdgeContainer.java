package mydemo.graph.specifics;

import mydemo.graph.Edge;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UndirectedEdgeContainer<V> {
    Set<Edge<V>> vertexEdges;
    private Set<Edge<V>> unmodifiableVertexEdges = null;

    UndirectedEdgeContainer() {
        vertexEdges = new HashSet<>();
    }

    public void addEdge(Edge<V> e) {
        vertexEdges.add(e);
    }

    public Set<Edge<V>> getUnmodifiableVertexEdges() {
        if (unmodifiableVertexEdges == null) {
            unmodifiableVertexEdges = Collections.unmodifiableSet(vertexEdges);
        }
        return unmodifiableVertexEdges;
    }

}
