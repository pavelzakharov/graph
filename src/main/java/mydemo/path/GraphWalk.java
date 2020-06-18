package mydemo.path;

import mydemo.graph.specifics.Edge;
import mydemo.graph.Graph;

import java.util.*;

public class GraphWalk<V> implements GraphPath<V> {
    private Graph<V> graph;

    private List<V> vertexList;
    private List<Edge<V>> edgeList;

    private V startVertex;

    private V endVertex;

    public GraphWalk(
            Graph<V> graph, V startVertex, V endVertex, List<V> vertexList, List<Edge<V>> edgeList) {
        if (vertexList == null && edgeList == null)
            throw new IllegalArgumentException("Vertex list and edge list cannot both be null!");
        if (startVertex != null && vertexList != null && edgeList != null
                && edgeList.size() + 1 != vertexList.size())
            throw new IllegalArgumentException(
                    "VertexList and edgeList do not correspond to the same path (cardinality of edgeList +1 must equal the cardinality of the vertexList)");
        if (startVertex == null ^ endVertex == null)
            throw new IllegalArgumentException(
                    "Either the start and end vertices must both be null, or they must both be not null (one of them is null)");

        this.graph = Objects.requireNonNull(graph);
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public static <V, E> GraphWalk<V> singletonWalk(Graph<V> graph, V v) {
        return new GraphWalk<>(
                graph, v, v, Collections.singletonList(v), Collections.emptyList());
    }

    @Override
    public List<Edge<V>> getEdgeList() {
        if (edgeList != null) {
            return edgeList;
        }
        List<V> vertexList = this.getVertexList();
        if (vertexList.size() < 2)
            return Collections.emptyList();

        Graph<V> g = this.getGraph();
        List<Edge<V>> edgeList = new ArrayList<>();
        Iterator<V> vertexIterator = vertexList.iterator();
        V u = vertexIterator.next();
        while (vertexIterator.hasNext()) {
            V v = vertexIterator.next();
            edgeList.add(g.getEdge(u, v));
            u = v;
        }
        return edgeList;
    }

    @Override
    public List<V> getVertexList() {
        if (vertexList != null) {
            return vertexList;
        }
        List<Edge<V>> edgeList = this.getEdgeList();

        if (edgeList.isEmpty()) {
            V startVertex = getStartVertex();
            if (startVertex != null && startVertex.equals(getEndVertex())) {
                return Collections.singletonList(startVertex);
            } else {
                return Collections.emptyList();
            }
        }

        Graph<V> g = this.getGraph();
        List<V> list = new ArrayList<>();
        V v = this.getStartVertex();
        list.add(v);
        for (Edge<V> e : edgeList) {
            v = g.getOppositeVertex(e, v);
            list.add(v);
        }
        return list;
    }

    @Override
    public V getStartVertex() {
        return startVertex;
    }

    @Override
    public V getEndVertex() {
        return endVertex;
    }

    @Override
    public Graph<V> getGraph() {
        return graph;
    }
}