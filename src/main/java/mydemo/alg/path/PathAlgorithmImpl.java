package mydemo.alg.path;

import mydemo.Graph;
import mydemo.GraphPath;
import mydemo.Graphs;
import mydemo.alg.interfaces.PathAlgorithm;
import mydemo.graph.Edge;

import java.util.*;

public class PathAlgorithmImpl<V, E> implements PathAlgorithm<V> {
    private static final String GRAPH_MUST_CONTAIN_THE_SOURCE_VERTEX =
            "Graph must contain the source vertex!";
    private static final String GRAPH_MUST_CONTAIN_THE_SINK_VERTEX =
            "Graph must contain the sink vertex!";

    private final Graph<V> graph;

    public PathAlgorithmImpl(Graph<V> graph) {
        this.graph = Objects.requireNonNull(graph, "Graph is null");
    }

    @Override
    public SingleSourcePaths<V> getPaths(V source) {
        if (!graph.containsVertex(source)) {
            throw new IllegalArgumentException(GRAPH_MUST_CONTAIN_THE_SOURCE_VERTEX);
        }

        Map<V, Edge<V>> sourceAndPredecessorEdgeMap = new LinkedHashMap<>();
        sourceAndPredecessorEdgeMap.put(source, null);

        Deque<V> queue = new ArrayDeque<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (Edge<V> e : graph.outgoingEdgesOf(v)) {
                V u = Graphs.getOppositeVertex(graph, e, v);
                if (!sourceAndPredecessorEdgeMap.containsKey(u)) {
                    queue.add(u);
                    sourceAndPredecessorEdgeMap.put(u, e);
                }
            }
        }

        return new SingleSourcePathsImpl<>(graph, source, sourceAndPredecessorEdgeMap);
    }

    @Override
    public GraphPath<V> getPath(V source, V sink) {

        if (!graph.containsVertex(sink)) {
            throw new IllegalArgumentException(GRAPH_MUST_CONTAIN_THE_SINK_VERTEX);
        }
        return getPaths(source).getPath(sink);
    }

    public static <V, E> GraphPath<V> findPathBetween(Graph<V> graph, V source, V sink) {
        return new PathAlgorithmImpl<>(graph).getPath(source, sink);
    }
}
