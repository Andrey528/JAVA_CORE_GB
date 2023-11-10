package sem.sem4;

/**
 * Найти ближайшего общего предка двух узлов дерева.
 * Ограничение по памяти: O(1)
 */
public class TreeNode {
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(TreeNode parent, TreeNode left, TreeNode right) {
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public TreeNode lowestCommonAncestor(TreeNode first, TreeNode second) {
        int depthFirst = getDepth(first);
        int depthSecond = getDepth(second);

        // выравнивание глубин
        while (depthFirst > depthSecond) {
            first = first.parent;
            depthFirst--;
        }
        while (depthSecond > depthFirst) {
            second = second.parent;
            depthSecond--;
        }

        // поиск предка
        while (first != second) {
            first = first.parent;
            second = second.parent;
        }

        return first;
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
}
