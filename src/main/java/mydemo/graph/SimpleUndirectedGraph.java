package mydemo.graph;

import mydemo.graph.specifics.UndirectedSpecifics;

import java.util.LinkedHashMap;

public class SimpleUndirectedGraph<V> extends AbstractGraph<V> {

    public SimpleUndirectedGraph() {
        this.specifics = new UndirectedSpecifics<>(this, new LinkedHashMap<>());
    }

}
