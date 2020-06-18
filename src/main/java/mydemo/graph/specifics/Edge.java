package mydemo.graph.specifics;

import java.util.Objects;

public class Edge<V> {
    protected V source;

    protected V target;

    public V getSource() {
        return source;
    }

    public V getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "(" + source + " : " + target + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(getSource(), edge.getSource()) &&
                Objects.equals(getTarget(), edge.getTarget());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getTarget());
    }
}
