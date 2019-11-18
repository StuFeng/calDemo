package tree;

/**
 * @author fengsihan
 * @date 2019/11/17 20:29
 * @desc 二叉搜索树转双向链表
 */
public class BSTConvertLinkedList {

    private static BinaryTreeNode lastNodeInLinkedList = null;

    public static BinaryTreeNode convert(BinaryTreeNode root) {

        convertNode(root);
        BinaryTreeNode headOfList = lastNodeInLinkedList;
        while (headOfList != null && headOfList.getLeftNode() != null){
            headOfList = headOfList.getLeftNode();
        }

        return headOfList;
    }

    private static void convertNode(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        BinaryTreeNode current = node;

        if (current.getLeftNode() != null) {
            convertNode(current.getLeftNode());
        }
        // 当前节点的左节点为已经完成转化的子链表的最后一个节点
        current.setLeftNode(lastNodeInLinkedList);

        if (lastNodeInLinkedList != null) {
            lastNodeInLinkedList.setRightNode(current);
        }
        lastNodeInLinkedList = current;

        if (current.getRightNode() != null) {
            convertNode(current.getRightNode());
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, R3);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);

        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", null, null);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);
        BinaryTreeNode convert = convert(T);
        while (convert != null) {
            System.out.println(convert.getData());
            convert = convert.getRightNode();
        }
    }
}
