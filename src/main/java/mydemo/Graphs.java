package mydemo;

import mydemo.graph.Edge;

public abstract class Graphs {
    public static <V, E> V getOppositeVertex(Graph<V> g, Edge<V> e, V v) {
        V source = g.getEdgeSource(e);
        V target = g.getEdgeTarget(e);
        if (v.equals(source)) {
            return target;
        } else if (v.equals(target)) {
            return source;
        } else {
            throw new IllegalArgumentException("no such vertex: " + v.toString());
        }
    }
}
