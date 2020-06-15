package mydemo.graph.specifics;

import mydemo.graph.Edge;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DirectedEdgeContainer<V> {
    Set<Edge<V>> incoming;
    Set<Edge<V>> outgoing;
    private Set<Edge<V>> unmodifiableOutgoing = null;

    DirectedEdgeContainer() {
        incoming = new HashSet<>();
        outgoing = new HashSet<>();
    }

    public void addIncomingEdge(Edge<V> e) {
        incoming.add(e);
    }

    public void addOutgoingEdge(Edge<V> e) {
        outgoing.add(e);
    }

    public Set<Edge<V>> getUnmodifiableOutgoingEdges() {
        if (unmodifiableOutgoing == null) {
            unmodifiableOutgoing = Collections.unmodifiableSet(outgoing);
        }

        return unmodifiableOutgoing;
    }
}
