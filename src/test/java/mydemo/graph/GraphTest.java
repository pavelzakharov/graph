package mydemo.graph;

import mydemo.graph.specifics.Edge;
import mydemo.path.GraphPath;
import mydemo.path.PathAlgorithmImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GraphTest {
    @Test
    public void testUndirectedGraph() {
        Graph<String> graph = createUndirectedGraph();
        List<Edge<String>> edgeListAB = PathAlgorithmImpl.findPathBetween(graph, "A", "B").getEdgeList();
        Assertions.assertTrue(edgeListAB != null && edgeListAB.size() == 1, "Edge<String>list has wrong size");
        Edge<String> edgeAB = edgeListAB.get(0);
        Assertions.assertTrue(edgeAB.getSource().equals("A") && edgeAB.getTarget().equals("B"));

        List<Edge<String>> edgeListDC = PathAlgorithmImpl.findPathBetween(graph, "D", "C").getEdgeList();
        Assertions.assertTrue(edgeListDC != null && edgeListDC.size() == 2, "Edge<String>list has wrong size");
        Edge<String>edgeDB = edgeListDC.get(0);
        Assertions.assertTrue(edgeDB.getSource().equals("B") && edgeDB.getTarget().equals("D"));
        Edge<String>edgeBC = edgeListDC.get(1);
        Assertions.assertTrue(edgeBC.getSource().equals("B") && edgeBC.getTarget().equals("C"));
    }

    @Test
    public void testDirectedGraph() {
        Graph<String> graph = createDirectedGraph();
        List<Edge<String>> edgeListAB = PathAlgorithmImpl.findPathBetween(graph, "A", "B").getEdgeList();
        Assertions.assertTrue(edgeListAB != null && edgeListAB.size() == 1, "Edge<String>list has wrong size");
        Edge<String> edgeAB = edgeListAB.get(0);
        Assertions.assertTrue(edgeAB.getSource().equals("A") && edgeAB.getTarget().equals("B"));

        GraphPath<String> pathDC = PathAlgorithmImpl.findPathBetween(graph, "D", "C");
        Assertions.assertNull(pathDC, "No path should be found");

        List<Edge<String>> edgeListAD = PathAlgorithmImpl.findPathBetween(graph, "A", "D").getEdgeList();
        Assertions.assertTrue(edgeListAD != null && edgeListAD.size() == 2, "Edge<String>list has wrong size");
        Assertions.assertEquals(edgeListAD.get(0), edgeAB);
        Edge<String> edgeBD = edgeListAD.get(1);
        Assertions.assertTrue(edgeBD.getSource().equals("B") && edgeBD.getTarget().equals("D"));
    }

    private <T> Graph<String> createDirectedGraph() {
        Graph<String> graph = new SimpleDirectedGraph<>();
        fillGraph(graph);
        return graph;
    }

    private void fillGraph(Graph<String> graph) {

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);

        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(b, d);

    }

    private Graph<String> createUndirectedGraph() {
        Graph<String> graph = new SimpleUndirectedGraph<>();
        fillGraph(graph);
        return graph;
    }
}
