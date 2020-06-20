package mydemo.graph.specifics;

import java.util.Objects;

public class Edge<V> {
    V source;

    V target;

    @Override
    public String toString() {
        return "(" + source + " : " + target + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(target, edge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}
