package mydemo.graph;

import mydemo.Graph;
import mydemo.graph.specifics.Specifics;

import java.util.function.Function;

public interface GraphSpecificsStrategy<V> {
    Function<Graph<V>, Specifics<V>> getSpecificsFactory(boolean directed);

}
