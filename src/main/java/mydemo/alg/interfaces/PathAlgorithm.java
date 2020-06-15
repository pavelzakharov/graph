package mydemo.alg.interfaces;

import mydemo.GraphPath;

public interface PathAlgorithm<V> {
    SingleSourcePaths<V> getPaths(V source);

    GraphPath<V> getPath(V source, V sink);

    interface SingleSourcePaths<V> {
        GraphPath<V> getPath(V sink);
    }
}
