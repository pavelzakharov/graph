package mydemo.graph;

import mydemo.Graph;
import mydemo.graph.specifics.Specifics;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractGraph<V> implements Graph<V> {
    private static final String LOOPS_NOT_ALLOWED = "loops not allowed";

    private boolean directed;
    private Specifics<V> specifics;
    private EdgesSpecifics<V> edgesSpecifics;

    protected AbstractGraph(boolean directed) {
        this.directed = directed;

        GraphSpecificsStrategy<V> graphSpecificsStrategy = new GraphSpecificsStrategyImpl<>();

        this.specifics = graphSpecificsStrategy.getSpecificsFactory(directed).apply(this);
        this.edgesSpecifics = new EdgesSpecificsImpl<V>(new HashSet<Edge<V>>());
    }

    @Override
    public Edge<V> addEdge(V sourceVertex, V targetVertex) {
        assertVertexExist(sourceVertex);
        assertVertexExist(targetVertex);

        if (sourceVertex.equals(targetVertex)) {
            throw new IllegalArgumentException(LOOPS_NOT_ALLOWED);
        }

        Edge<V> e = specifics
                .createEdgeToTouchingVerticesIfAbsent(sourceVertex, targetVertex);
        if (e != null && edgesSpecifics.add(e, sourceVertex, targetVertex)) {
            return e;
        }
        return null;
    }

    @Override
    public boolean addVertex(V v) {
        if (v == null) {
            throw new NullPointerException();
        } else if (containsVertex(v)) {
            return false;
        } else {
            specifics.addVertex(v);
            return true;
        }
    }

    @Override
    public boolean containsVertex(V v) {
        return specifics.getVertexSet().contains(v);
    }

    @Override
    public Edge<V> getEdge(V sourceVertex, V targetVertex) {
        return specifics.getEdge(sourceVertex, targetVertex);
    }

    @Override
    public V getEdgeSource(Edge<V> e) {
        return e.source;
    }

    public V getEdgeTarget(Edge<V> e) {
        return e.target;
    }

    protected boolean assertVertexExist(V v) {
        if (containsVertex(v)) {
            return true;
        } else if (v == null) {
            throw new NullPointerException();
        } else {
            throw new IllegalArgumentException("no such vertex in graph: " + v.toString());
        }
    }

    @Override
    public Set<Edge<V>> outgoingEdgesOf(V vertex) {
        assertVertexExist(vertex);
        return specifics.outgoingEdgesOf(vertex);
    }

    @Override
    public boolean isDirected() {
        return directed;
    }
}
