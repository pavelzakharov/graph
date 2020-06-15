package mydemo.graph;

public class SimpleUndirectedGraph<V, E> extends AbstractGraph<V> {

    public SimpleUndirectedGraph() {
        super(new DefaultGraphType.Builder()
                .build());
    }

}
