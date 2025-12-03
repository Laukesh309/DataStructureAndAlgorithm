package ArrayRevision;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructQuadTree {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public static Node findQuadTree(int grid[][], int startRow, int startCol, int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol) {
            return null;
        }
        int value = grid[startRow][startCol];
        boolean isValid = true;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (grid[i][j] != value) {
                    isValid = false;
                    break;
                }

            }
        }
        if (isValid) {
            return new Node(false, true);
        }
        int midRow = (startRow + endRow) / 2;
        int midCol = (startCol + endCol) / 2;
        Node newNode = new Node(false, false);
        newNode.topLeft = findQuadTree(grid, startRow, startCol, midRow, midCol);
        newNode.topRight = findQuadTree(grid, startRow, midCol + 1, midRow, endCol);
        newNode.bottomLeft = findQuadTree(grid, midRow + 1, startCol, endRow, midCol);
        newNode.bottomRight = findQuadTree(grid, midRow + 1, midCol + 1, endRow, endCol);
        return newNode;
    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 1 }, { 1, 0 } };
        Node cqd = findQuadTree(grid, 0, 0, grid.length - 1, grid.length - 1);
        Queue<Node> que = new LinkedList<>();
        que.add(cqd);
        while (!que.isEmpty()) {
            Node curNode = que.poll();
            System.out.println(curNode.val + " " + curNode.isLeaf);
            if (curNode != null) {

            }

        }

    }

}
