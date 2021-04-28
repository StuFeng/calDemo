package tree;

/**
 * @author fengsihan
 * @date 2019/10/3 18:55
 * @desc 根据前序和中序遍历构建二叉树
 */
public class ConstructTree {

    public static BinaryTreeNode Construct(int[] preOrder, int[] inOrder, int length) {
        if (preOrder == null || inOrder == null || length <= 0) {
            return null;
        }
        return ConstructCore(preOrder, inOrder, 0, length - 1,
                0, length - 1);
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode construct = Construct(preOrder, inOrder, preOrder.length);

        BinaryTree.posOrderUnRecur2(construct);
    }

    /**
     * 将数组分段进行处理
     *
     * @param preOrder 前序 对应处理的下标范围
     * @param inOrder 中序 对应处理的下标范围
     * @return
     */
    public static BinaryTreeNode ConstructCore(int[] preOrder, int[] inOrder,
                                        int preStartIndex, int preEndIndex,
                                        int inStartIndex, int inEndIndex) {
        // 根节点的值
        int rootValue = preOrder[preStartIndex];
        // 初始化根节点
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootValue, null, null);

        // 递归出口
        // 最终根节点为当前节点
        if (preStartIndex == preEndIndex && inStartIndex == inEndIndex
                && preOrder[preStartIndex] == inOrder[inStartIndex]) {
            return root;
        }


        // 在中序遍历中找到根节点的值，区分出左子树和右子树
        // 表示根节点位置
        int rootInOrder = inStartIndex;
        while (rootInOrder <= inEndIndex && inOrder[rootInOrder] != rootValue) {
            ++rootInOrder;
        }

        // 没有找到的异常控制

        // 左子树长度
        int leftLength = rootInOrder - inStartIndex;
        // 左子树的下标范围
        int leftPreEndIndex = preStartIndex + leftLength;

        // 存在左子树
        if (leftLength > 0) {
            // 构建左子树
            root.setLeftNode(ConstructCore(preOrder, inOrder,
                    preStartIndex + 1, leftPreEndIndex, inStartIndex, rootInOrder - 1));
        }
        // 存在右子树  整体长度
        if (leftLength < (preEndIndex - preStartIndex)) {
            root.setRightNode(ConstructCore(preOrder, inOrder,
                    leftPreEndIndex + 1, preEndIndex, rootInOrder + 1, inEndIndex));
        }
        return root;
    }
}
