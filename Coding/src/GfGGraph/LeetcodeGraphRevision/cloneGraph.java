package GfGGraph.LeetcodeGraphRevision;

import java.util.HashMap;
import java.util.List;

public class cloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
    }

    public static Node formedNode(HashMap<Node, Node> hm, Node currentNode) {
        if (hm.containsKey(currentNode)) {
            return hm.get(currentNode);
        }
        Node newNode = new Node();
        hm.put(currentNode, newNode);
        for (int i = 0; i < currentNode.neighbors.size(); i++) {
            newNode.add(formedNode(hm, currentNode.neighbors.get(i)));
        }
        return newNode;

    }

    public static void main(String[] args) {

        HashMap<Node, Node> hm = new HashMap<>();
    }

}
