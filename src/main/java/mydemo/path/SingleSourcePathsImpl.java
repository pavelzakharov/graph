package mydemo.path;

import mydemo.graph.Graph;
import mydemo.graph.specifics.Edge;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class SingleSourcePathsImpl<V, E> implements PathAlgorithm.SingleSourcePaths<V> {
    protected Graph<V> graph;
    protected V source;
    protected Map<V, Edge<V>> sourceAndPredecessorEdgeMap;

    public SingleSourcePathsImpl(Graph<V> graph, V source, Map<V, Edge<V>> sourceAndPredecessorEdgeMap) {
        this.graph = Objects.requireNonNull(graph, "Graph is null");
        this.source = Objects.requireNonNull(source, "Source vertex is null");
        this.sourceAndPredecessorEdgeMap = Objects.requireNonNull(sourceAndPredecessorEdgeMap, "Source and predecessor edge map is null");
    }

    @Override
    public GraphPath<V> getPath(V targetVertex) {
        if (source.equals(targetVertex)) {
            return GraphWalk.singletonWalk(graph, source);
        }

        LinkedList<Edge<V>> edgeList = new LinkedList<>();

        V cur = targetVertex;
        Edge<V> edge = sourceAndPredecessorEdgeMap.get(cur);
        if (edge == null) {
            return null;
        }

        while (!cur.equals(source)) {
            edgeList.addFirst(edge);
            cur = graph.getOppositeVertex(edge, cur);
            edge = sourceAndPredecessorEdgeMap.get(cur);
        }

        return new GraphWalk<>(graph, source, targetVertex, null, edgeList);
    }
}
