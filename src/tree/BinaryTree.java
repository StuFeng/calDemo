package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fengsihan
 * @date 2019/10/1 14:28
 * @desc
 */
public class BinaryTree {
    private BinaryTreeNode mRoot;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        mRoot = root;
    }

    public BinaryTreeNode getRoot() {
        return mRoot;
    }

    public void setRoot(BinaryTreeNode root) {
        mRoot = root;
    }

    public void insertAsLeftChild(BinaryTreeNode child) {
        checkTreeEmpty();
        mRoot.setLeftNode(child);
    }

    public void insertAsRightChild(BinaryTreeNode child) {
        checkTreeEmpty();
        mRoot.setRightNode(child);
    }

    private void checkTreeEmpty() {
        if (mRoot == null) {
            throw new IllegalStateException("Can't insert to a null tree! Did you forget set value for root?");
        }
    }

    /**
     * 删除某个节点的二叉树
     *
     * @param node
     */
    public void deleteNode(BinaryTreeNode node) {
        checkTreeEmpty();
        if (node == null) {
            return;
        }
        deleteNode(node.getLeftNode());
        deleteNode(node.getRightNode());
        node = null;
    }

    /**
     * 清空二叉树
     */
    public void clear() {
        if (mRoot != null) {
            deleteNode(mRoot);
        }
    }

    /**
     * 获取二叉树高度
     */
    public int getTreeHeight() {
        return getHeight(mRoot);
    }

    private int getHeight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.getLeftNode());
        int rightHeight = getHeight(node.getRightNode());
        int max = Math.max(leftHeight, rightHeight);
        // 加上自己的根节点
        return max + 1;
    }

    /**
     * 二叉树长度
     *
     * @return
     */
    public int size() {
        return getSize(mRoot);
    }

    private int getSize(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSize = getSize(node.getLeftNode());
        int rightSize = getSize(node.getRightNode());
        // 根节点的数量
        return leftSize + rightSize + 1;
    }

    /**
     * 获取当前节点的父节点
     * 遍历所有节点，判断该节点的左右节点是否与该节点相同
     *
     * @param node
     * @return
     */
    public BinaryTreeNode getParentNode(BinaryTreeNode node) {
        if (mRoot == null || node.equals(mRoot)) {
            return null;
        } else {
            return getParent(mRoot, node);
        }
    }

    private BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
        if (subTree == null) {
            return null;
        }
        if (subTree.getLeftNode().equals(node) || subTree.getRightNode().equals(node)) {
            return subTree;
        } else {
            BinaryTreeNode parent = getParent(subTree.getLeftNode(), node);
            if (parent != null) {
                return parent;
            } else {
                return getParent(subTree.getRightNode(), node);
            }
        }
    }

    /**
     * 二叉树遍历
     */

    /**
     * 先序遍历， 优先遍历根节点，然后左节点 + 右节点
     * 中序遍历， 优先遍历左节点，然后根节点 + 右节点
     * 后序遍历， 优先遍历左节点，然后右节点 + 根节点
     *
     * @param node
     */
    public void interateFirstOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        print(node);
        insertAsLeftChild(node.getLeftNode());
        insertAsLeftChild(node.getRightNode());
    }

    /**
     * 输出节点值
     *
     * @param node
     */
    private void print(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
    }

    /**
     * 创建一棵二叉树
     *
     * @return 根节点
     * @author bin.zhang
     */
    public static BinaryTreeNode createBinTree() {
        BinaryTreeNode<String> R3 = new BinaryTreeNode<>("F", null, null);
        BinaryTreeNode<String> L2 = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> R2 = new BinaryTreeNode<>("E", null, R3);
        BinaryTreeNode<String> L1 = new BinaryTreeNode<>("B", L2, R2);
        BinaryTreeNode<String> R1 = new BinaryTreeNode<>("C", null, null);
        BinaryTreeNode<String> T = new BinaryTreeNode<>("A", L1, R1);
        return T;
    }


    /**
     * 先序遍历
     * 利用栈的特性
     */
    public static void preOrder(){
        BinaryTreeNode p = createBinTree();
        // 初始化栈
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();

        while (p != null || !stack.isEmpty()) {
            // 如果当前节点不为空，则输出节点的值，因为当前节点都被当作了左节点
            if (p != null) {
                System.out.print(p.getData());
                // 为啥需要添加到栈中？ 遍历完根节点后，遍历右子节点
                stack.push(p);
                p = p.getLeftNode();
            }
            // 如果当前节点为空，则意味着左节点遍历完成，需要将之前塞入栈中的节点拿出，遍历其右边节点
            // 将右边节点当作根节点继续遍历
            else {
                p = stack.pop();
                p = p.getRightNode();
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历
     */
    public static void mediaOrder(){
        BinaryTreeNode p = createBinTree();
        // 初始化栈
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        while (p != null || !stack.isEmpty()) {
            // 先遍历到最后一个左节点,将之前的节点存入栈中
            if (p != null){
                stack.push(p);
                p = p.getLeftNode();
            }else{
                // 遍历到null以后，将栈中第一个节点输出，即为左子树中最后一个左节点也是根节点
                // 再以同样的方式遍历右节点
                p = stack.pop();
                System.out.print(p.getData());
                p = p.getRightNode();
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历
     * 通过循环入栈，出栈；相当于利用了递归的思想
     *  第一个栈 入栈时按照 根 左/右 的方式，将所有元素按照排序方式入栈
     *  第二个栈 入栈时按照 根 右/左 的方式
     *  第二个栈 出栈时即为 左/右/根 ，即为最终的结果
     */
    public static void posOrderUnRecur1(){
        BinaryTreeNode p = createBinTree();
        System.out.print("PosOrder:");
        if(p != null){
            Deque<BinaryTreeNode> s1 = new ArrayDeque<>();
            Deque<BinaryTreeNode> s2 = new ArrayDeque<>();
            s1.push(p);
            while(!s1.isEmpty()){

                p = s1.pop();
                s2.push(p);
                if(p.getLeftNode() != null){
                    s1.push(p.getLeftNode());
                }
                if(p.getRightNode() != null){
                    s1.push(p.getRightNode());
                }
            }
            while(!s2.isEmpty()){
                System.out.print(s2.pop().getData() + " ");
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur2(BinaryTreeNode p) {
//        BinaryTreeNode p = createBinTree();
        System.out.print("PosOrder:");
        if (p != null) {
            Deque<BinaryTreeNode> stack = new ArrayDeque<>();
            stack.push(p);
            // 已输出的节点，判断该节点的父节点是
            BinaryTreeNode crrNode = p;
            while (!stack.isEmpty()){
                BinaryTreeNode node = stack.peek();
                // 判断该节点的下的值是否被输出过，如果都没有，则塞入栈中待处理
                // 处理左节点，则需要确认上一个输出的节点是否为其左右节点
                // 如果是右节点，则证明已经处理过左节点；如果是左节点，则说明已经处理过，当前节点可以输出了
                if (node.getLeftNode() != null && crrNode != node.getLeftNode() && crrNode != node.getRightNode()){
                    stack.push(node.getLeftNode());
                // 处理右节点，只需要证明上次处理的是否为当前节点
                }else if (node.getRightNode() != null && crrNode != node.getRightNode()){
                    stack.push(node.getRightNode());
                }else{
                    BinaryTreeNode pop = stack.pop();
                    System.out.print(pop.getData());
                    crrNode = pop;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        preOrder();
        mediaOrder();
        posOrderUnRecur1();
    }
}
