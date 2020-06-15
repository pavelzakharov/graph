package mydemo.graph.builder;

public class GraphTypeBuilder<V, E> {
    private boolean directed;

    private GraphTypeBuilder(boolean directed) {
        this.directed = directed;
    }

    public static <V, E> GraphTypeBuilder<V, E> directed() {
        return new GraphTypeBuilder<>(true);
    }

    public static <V, E> GraphTypeBuilder<V, E> undirected() {
        return new GraphTypeBuilder<>(false);
    }

}
