package mydemo.graph;

public class SimpleDirectedGraph<V> extends AbstractGraph<V> {

    public SimpleDirectedGraph() {
        super(new DefaultGraphType.Builder().directed().build());
    }

}
