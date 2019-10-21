package tree;

/**
 * @author fengsihan
 * @date 2019/10/20 21:48
 * @desc 是否包含子树
 * <p>
 * 思路：
 * 首先判定根节点是否相同，如果相同，则判断其节点的子树  第一步
 * 如果不相同：判断根节点的左右节点  第二步
 * <p>
 * 判断子树是否相同，
 * 遍历的方式判断左右节点
 */
public class HasSubTree {
    /**
     * 判断node2是否为node1的子树
     *
     * @param node1
     * @param node2
     * @return
     */
    static boolean hasSubTree(BinaryTreeNode node1, BinaryTreeNode node2) {
        boolean result = false;
        if (node1 != null && node2 != null) {
            if (node1.getData().equals(node2.getData())) {
                // 判断子树是否相同
                result = doseTree1HaveTree2(node1, node2);
            }
            // 如果判断失败，则继续寻找，如果成功，则退出
            if (!result) {
                result = hasSubTree(node1.getLeftNode(), node2);
            }
            if (!result) {
                result = hasSubTree(node1.getRightNode(), node2);
            }
        }
        return result;
    }

    private static boolean doseTree1HaveTree2(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }

        if (!node1.getData().equals(node2.getData())) {
            return false;
        }

        return doseTree1HaveTree2(node1.getLeftNode(), node2.getLeftNode())
                && doseTree1HaveTree2(node1.getRightNode(), node2.getRightNode());
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, R3);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);
        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", null, null);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);

        BinaryTreeNode<String> l2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> r2 = new BinaryTreeNode<>("E", null, null);
        BinaryTreeNode<String> t = new BinaryTreeNode<>("B", l2, r2);

        boolean b = hasSubTree(T, t);
        System.out.println(b);

    }
}
