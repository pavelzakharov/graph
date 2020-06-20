package mydemo.graph;

import mydemo.graph.specifics.Edge;
import mydemo.graph.specifics.EdgesSpecifics;
import mydemo.graph.specifics.EdgesSpecificsImpl;
import mydemo.graph.specifics.Specifics;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGraph<V> implements Graph<V> {
    private static final String LOOPS_NOT_ALLOWED = "loops not allowed";

    protected Specifics<V> specifics;
    private EdgesSpecifics<V> edgesSpecifics;

    public AbstractGraph() {
        this.edgesSpecifics = new EdgesSpecificsImpl<>(new HashSet<>());
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

    private boolean assertVertexExist(V v) {
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
    public V getOppositeVertex(Edge<V> e, V v) {
        V source = edgesSpecifics.getEdgeSource(e);
        V target = edgesSpecifics.getEdgeTarget(e);
        if (v.equals(source)) {
            return target;
        } else if (v.equals(target)) {
            return source;
        } else {
            throw new IllegalArgumentException("no such vertex: " + v.toString());
        }
    }

    @Override
    public V getEdgeSource(Edge<V> e) {
        return edgesSpecifics.getEdgeSource(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V getEdgeTarget(Edge<V> e) {
        return edgesSpecifics.getEdgeTarget(e);
    }
}
