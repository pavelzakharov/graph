package mydemo.graph.specifics;

import mydemo.graph.Graph;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DirectedSpecifics<V> implements Specifics<V> {
    protected Graph<V> graph;
    protected Map<V, DirectedEdgeContainer<V>> vertexMap;

    public DirectedSpecifics(
            Graph<V> graph, Map<V, DirectedEdgeContainer<V>> vertexMap) {
        this.graph = Objects.requireNonNull(graph);
        this.vertexMap = Objects.requireNonNull(vertexMap);
    }

    @Override
    public Edge<V> createEdgeToTouchingVerticesIfAbsent(
            V sourceVertex, V targetVertex) {
        // lookup for edge with same source and target
        DirectedEdgeContainer<V> ec = getEdgeContainer(sourceVertex);
        for (Edge<V> e : ec.outgoing) {
            if (e.target.equals(targetVertex)) {
                return null;
            }
        }

        // create and add
        Edge<V> edge = new Edge<>();
        ec.addOutgoingEdge(edge);
        getEdgeContainer(targetVertex).addIncomingEdge(edge);

        return edge;
    }

    private DirectedEdgeContainer<V> getEdgeContainer(V vertex) {
        DirectedEdgeContainer<V> ec = vertexMap.get(vertex);

        if (ec == null) {
            ec = new DirectedEdgeContainer<>();
            vertexMap.put(vertex, ec);
        }

        return ec;
    }

    @Override
    public boolean addVertex(V v) {
        DirectedEdgeContainer<V> ec = vertexMap.get(v);
        if (ec == null) {
            vertexMap.put(v, new DirectedEdgeContainer<>());
            return true;
        }
        return false;
    }

    @Override
    public Set<V> getVertexSet() {
        return vertexMap.keySet();
    }

    @Override
    public Edge<V> getEdge(V sourceVertex, V targetVertex) {
        if (graph.containsVertex(sourceVertex) && graph.containsVertex(targetVertex)) {
            DirectedEdgeContainer<V> ec = getEdgeContainer(sourceVertex);

            for (Edge<V> e : ec.outgoing) {
                if (e.target.equals(targetVertex)) {
                    return e;
                }
            }
        }

        return null;
    }

    @Override
    public Set<Edge<V>> outgoingEdgesOf(V vertex) {
        return getEdgeContainer(vertex).getUnmodifiableOutgoingEdges();
    }

}
