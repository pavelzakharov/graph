package mydemo.graph.specifics;

import mydemo.Graph;
import mydemo.graph.Edge;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class UndirectedSpecifics<V> implements Specifics<V> {
    protected Graph<V> graph;
    protected Map<V, UndirectedEdgeContainer<V>> vertexMap;

    public UndirectedSpecifics(
            Graph<V> graph, Map<V, UndirectedEdgeContainer<V>> vertexMap) {
        this.graph = Objects.requireNonNull(graph);
        this.vertexMap = Objects.requireNonNull(vertexMap);
    }

    @Override
    public Edge<V> createEdgeToTouchingVerticesIfAbsent(
            V sourceVertex, V targetVertex) {
        // lookup for edge with same source and target
        UndirectedEdgeContainer<V> ec = getEdgeContainer(sourceVertex);
        for (Edge<V> edge : ec.vertexEdges) {
            if (isEqualsStraightOrInverted(sourceVertex, targetVertex, edge)) {
                return null;
            }
        }

        // create and add
        Edge<V> edge = new Edge<>();
        ec.addEdge(edge);
        getEdgeContainer(targetVertex).addEdge(edge);

        return edge;
    }

    protected UndirectedEdgeContainer<V> getEdgeContainer(V vertex) {
        UndirectedEdgeContainer<V> ec = vertexMap.get(vertex);

        if (ec == null) {
            ec = new UndirectedEdgeContainer<>();
            vertexMap.put(vertex, ec);
        }

        return ec;
    }

    private boolean isEqualsStraightOrInverted(Object sourceVertex, Object targetVertex, Edge<V> e) {
        boolean equalStraight = sourceVertex.equals(graph.getEdgeSource(e))
                && targetVertex.equals(graph.getEdgeTarget(e));

        boolean equalInverted = sourceVertex.equals(graph.getEdgeTarget(e))
                && targetVertex.equals(graph.getEdgeSource(e));
        return equalStraight || equalInverted;
    }

    @Override
    public boolean addEdgeToTouchingVerticesIfAbsent(V sourceVertex, V targetVertex, Edge<V> e) {
        // lookup for edge with same source and target
        UndirectedEdgeContainer<V> ec = getEdgeContainer(sourceVertex);
        for (Edge<V> edge : ec.vertexEdges) {
            if (isEqualsStraightOrInverted(sourceVertex, targetVertex, edge)) {
                return false;
            }
        }

        // add
        ec.addEdge(e);
        getEdgeContainer(targetVertex).addEdge(e);
        return true;
    }

    @Override
    public boolean addVertex(V v) {
        UndirectedEdgeContainer<V> ec = vertexMap.get(v);
        if (ec == null) {
            vertexMap.put(v, new UndirectedEdgeContainer<>());
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

            for (Edge<V> e : getEdgeContainer(sourceVertex).vertexEdges) {
                boolean equal = isEqualsStraightOrInverted(sourceVertex, targetVertex, e);

                if (equal) {
                    return e;
                }
            }
        }

        return null;
    }

    @Override
    public Set<Edge<V>> outgoingEdgesOf(V vertex) {
        return getEdgeContainer(vertex).getUnmodifiableVertexEdges();
    }

}
