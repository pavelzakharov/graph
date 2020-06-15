package mydemo.graph;

import mydemo.Graph;
import mydemo.graph.specifics.DirectedSpecifics;
import mydemo.graph.specifics.Specifics;
import mydemo.graph.specifics.UndirectedSpecifics;

import java.util.LinkedHashMap;
import java.util.function.Function;

public class GraphSpecificsStrategyImpl<V> implements GraphSpecificsStrategy<V> {
    @Override
    public Function<Graph<V>, Specifics<V>> getSpecificsFactory(boolean directed) {
        return (Function<Graph<V>,
                Specifics<V>>) (graph) -> {
            if (directed) {
                return new DirectedSpecifics<V>(
                        graph, new LinkedHashMap<>());
            } else {
                return new UndirectedSpecifics<>(
                        graph, new LinkedHashMap<>());
            }
        };
    }

}
