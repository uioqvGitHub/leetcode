package datastruct;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author LiuGuoQing
 * @since 2020-04-09
 */
public class NodeGroup<T> {
    private Node<T>[] nodes;
    private Map<String, Supplier<Node<T>>> getMethod = new HashMap<>();

    private NodeGroup(Builder builder) {

    }

    public static class Builder<T> {
        private Node<T>[] nodes;
        private Map<String, Function<Node<T>, Node<T>>> getMethod = new HashMap<>();

        public Builder<T> initMethod() {

            return this;
        }

        private void addMethod(NodeType nodeType) {
            getMethod.put(nodeType.getMethod(), (e)-> nodes[nodeType.ordinal()]);
            getMethod.put(nodeType.setMethod(), (e)-> nodes[nodeType.ordinal()] = e);

        }

    }


    enum NodeType {
        LEFT, RIGHT, PARENT
        ;
        private static final String GETPRE = "get_";
        private static final String SETPRE = "set_";

        public String getMethod() {
            return GETPRE.concat(name());
        }

        public String setMethod() {
            return SETPRE.concat(name());
        }
    }
}
