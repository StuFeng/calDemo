package tree;

/**
 * @author fengsihan
 * @date 2019/10/3 22:36
 * @desc 获取中序遍历的下一个节点
 */
public class GetNextTreeNode {

    public static BinaryTreeNode getNext(BinaryTreeNode node){
        if (node == null){
            return null;
        }
        BinaryTreeNode nextNode = null;
        // 如果节点有右子树
        if (node.getRightNode() != null){
            BinaryTreeNode rightNode = node.getRightNode();
            while (rightNode.getLeftNode() != null){
                rightNode = rightNode.getLeftNode();
            }
            nextNode = rightNode;
        }else if (node.getParentNode() != null){
            BinaryTreeNode parentNode = node.getParentNode();
            BinaryTreeNode currNode = node;
            // 如果当前节点没有右子树，并且还是它父节点的右子节点
            while (parentNode != null && currNode == parentNode.getRightNode()){
                currNode = parentNode;
                parentNode = parentNode.getParentNode();
            }
            // 如果没有右子树还是它父节点的左节点，则直接返回父节点
            nextNode = parentNode;
        }

        return nextNode;
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, R3);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);
        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", null, null);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);
        L1.setParentNode(T);
        R1.setParentNode(T);
        L2.setParentNode(L1);
        R2.setParentNode(L1);
        R3.setParentNode(R2);

        System.out.println(getNext(R3).getData());;


    }
}
