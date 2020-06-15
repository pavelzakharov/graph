package mydemo.graph;

import java.util.Objects;
import java.util.Set;

public class EdgesSpecificsImpl<V> implements EdgesSpecifics<V> {
    private Set<Edge<V>> edgeSet;

    public EdgesSpecificsImpl(Set<Edge<V>> edgeSet) {
        this.edgeSet = Objects.requireNonNull(edgeSet);
    }

    @Override
    public boolean add(Edge<V> edge, V sourceVertex, V targetVertex) {
        if (edgeSet.contains(edge)) {
            return false;
        }

        edge.source = sourceVertex;
        edge.target = targetVertex;

        edgeSet.add(edge);
        return true;
    }

    @Override
    public boolean containsEdge(Edge<V> e) {
        return edgeSet.contains(e);
    }

}
