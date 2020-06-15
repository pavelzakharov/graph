package mydemo.graph;

import mydemo.GraphType;

public class DefaultGraphType implements GraphType {
    private final boolean directed;

    private DefaultGraphType(
            boolean directed) {
        this.directed = directed;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    public static class Builder {
        private boolean directed;

        public Builder() {
            this.directed = false;
        }

        public Builder(GraphType type) {
            this.directed = type.isDirected();
        }

        public Builder(boolean directed) {
            this.directed = directed;
        }

        public Builder directed() {
            this.directed = true;
            return this;
        }

        public DefaultGraphType build() {
            return new DefaultGraphType(directed);
        }
    }
}
