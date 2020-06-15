package mydemo.graph;

import mydemo.Graph;
import mydemo.GraphType;
import mydemo.graph.specifics.DirectedSpecifics;
import mydemo.graph.specifics.Specifics;
import mydemo.graph.specifics.UndirectedSpecifics;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class GraphSpecificsStrategyImpl<V> implements GraphSpecificsStrategy<V> {
    @Override
    public BiFunction<Graph<V>, GraphType, Specifics<V>> getSpecificsFactory() {
        return (BiFunction<Graph<V>, GraphType,
                Specifics<V>>) (graph, type) -> {
            if (type.isDirected()) {
                return new DirectedSpecifics<V>(
                        graph, new LinkedHashMap<>());
            } else {
                return new UndirectedSpecifics<>(
                        graph, new LinkedHashMap<>());
            }
        };
    }

    @Override
    public Function<GraphType, EdgesSpecifics<V>> getEdgesSpecificsFactory() {
        return (Function<GraphType, EdgesSpecifics<V>>) (type) -> new EdgesSpecificsImpl<V>(new HashSet<Edge<V>>());
    }

}
