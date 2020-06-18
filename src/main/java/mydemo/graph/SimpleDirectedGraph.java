package mydemo.graph;

import mydemo.graph.specifics.DirectedSpecifics;

import java.util.LinkedHashMap;

public class SimpleDirectedGraph<V> extends AbstractGraph<V> {

    public SimpleDirectedGraph() {
        this.specifics = new DirectedSpecifics<>(this, new LinkedHashMap<>());
    }

}
