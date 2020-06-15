package mydemo.graph;

import mydemo.Graph;
import mydemo.GraphType;
import mydemo.graph.specifics.Specifics;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface GraphSpecificsStrategy<V> {
    BiFunction<Graph<V>, GraphType, Specifics<V>> getSpecificsFactory();

    Function<GraphType, EdgesSpecifics<V>> getEdgesSpecificsFactory();

}
