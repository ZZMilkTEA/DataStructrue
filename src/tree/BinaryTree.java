//感谢
// @author rico
// 的代码QAQ
package tree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree<E> {
    //定义二叉树内的节点
    /**
     * Title: 结点类
     * Description: 二叉树的结点
     */

    /**
     * 二叉树的根结点
     */
    private Node<E> root;


    /**
     * 无参构造函数
     *
     * @description 默认无参构造函数
     */
    public BinaryTree() {
        super();
    }

    /**
     * 构造函数
     *
     * @param node 原树的根结点
     * @description 根据一个树的根结点复制构造树
     */
    public BinaryTree(Node<E> node) {
        // TODO Auto-generated constructor stub
        this.root = copy(node);
    }


    /**
     * 构造函数
     *
     * @param preOrderStr
     * @description 根据一个树的前序遍历结果复制构造树
     */
    public BinaryTree(char[] preOrderStr) {
        root = createTreeByPreOrederStr(preOrderStr, null);
    }


    /**
     * 构造函数
     *
     * @param s1
     * @param s2
     * @param isPreIn
     * @description 根据一个树的前序遍历+中序遍历(或中序遍历+后序遍历)复制构造树
     */
    public BinaryTree(String s1, String s2, boolean isPreIn) {
        if (isPreIn) {
            root = createBinaryTreeByPreAndIn(s1, s2);
        } else {
            root = createBinaryTreeByInAndPost(s1, s2);
        }
    }

    /**
     * @param exp 广义表
     * @description 根据广义表表达式创建树
     */
    public void createBinaryTree(String exp) {
        LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 辅助栈
        Node<E> node = null; // 新结点
        Node<E> temp = null; // 用于入栈
        Node<E> parent = null; // 父亲结点
        boolean flag = false; // true 表示链入到父结点的左孩子位置，false表示链入父结点的右孩子位置

        for (int i = 0; i < exp.length(); i++) { // 逐个读入表达式的各个字符
            char c = exp.charAt(i);
            switch (c) {
                case '(': // 当前节点有孩子节点，入栈以便设置其孩子
                    stack.push(temp);
                    flag = true;
                    break;
                case ')': // 设置好了栈顶节点的孩子，出栈
                    stack.pop();
                    break;
                case ',': // 当前节点无孩子，不需要设置其孩子节点，因此不需要入栈
                    flag = false;
                    break;
                default: // 创建根据内容创建节点
                    node = new Node(c);
                    break;
            }

            // 若树不存在，则创建树的根结点
            if (root == null) {
                root = node;
            }

            // 为栈顶节点链入子女
            if (!stack.isEmpty()) {
                if (node != null) { // 当读入的是'('、')'、','字符时，略过
                    parent = stack.peek();
                    if (flag) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
            }

            temp = node; // 用于入栈
            node = null; // node链入后，置空
        }
    }

    /**
     * @param exp 广义表
     * @description 根据广义表表达式创建树
     */
    public static Node createBinaryTree(String exp, Node root) {
        LinkedList<Node> stack = new LinkedList<Node>(); // 辅助栈
        Node node = null; // 新结点
        Node temp = null; // 用于入栈
        Node parent = null; // 父亲结点
        boolean flag = false; // true 表示链入到父结点的左孩子位置，false表示链入父结点的右孩子位置

        for (int i = 0; i < exp.length(); i++) { // 逐个读入表达式的各个字符
            char c = exp.charAt(i);
            switch (c) {
                case '(': // 当前节点有孩子节点，入栈以便设置其孩子
                    stack.push(temp);
                    flag = true;
                    break;
                case ')': // 设置好了栈顶节点的孩子，出栈
                    stack.pop();
                    break;
                case ',': // 当前节点无孩子，不需要设置其孩子节点，因此不需要入栈
                    flag = false;
                    break;
                default: // 创建根据内容创建节点
                    node = new Node(c);
                    break;
            }

            // 若树不存在，则创建树的根结点
            if (root == null) {
                root = node;
            }

            // 为栈顶节点链入子女
            if (!stack.isEmpty()) {
                if (node != null) { // 当读入的是'('、')'、','字符时，略过
                    parent = stack.peek();
                    if (flag) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
            }

            temp = node; // 用于入栈
            node = null; // node链入后，置空
        }
        return root;
    }

    /**
     * @return
     * @description 广序/层次遍历，工作队列
     */
    public String levelOrder() {
        StringBuilder sb = new StringBuilder();
        LinkedList<Node<E>> queue = new LinkedList<Node<E>>(); // 辅助队列
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<E> temp = queue.pop();
                sb.append(temp.data).append(" ");

                // 在遍历当前节点时，同时将其左右孩子入队
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return sb.toString().trim();
    }

    /**
     * @param root
     * @return
     * @description 前序遍历(递归)
     */
    public String preOrder(Node<E> root) {
        StringBuilder sb = new StringBuilder(); // 存到递归调用栈
        if (root != null) { // 递归终止条件
            sb.append(root.data + " "); // 前序遍历当前结点
            sb.append(preOrder(root.left)); // 前序遍历左子树
            sb.append(preOrder(root.right)); // 前序遍历右子树
        }
        return sb.toString();
    }

    /**
     * @return
     * @description 前序遍历(迭代):非线性结构(树)，工作栈：当前节点入栈
     */
    public String preOrder() {

        StringBuilder sb = new StringBuilder();
        LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 工作栈：记录回退路径
        Node<E> node = root;

        while (node != null || !stack.isEmpty()) { // 迭代条件
            if (node != null) { // 当前节点不为空
                sb.append(node.data + " "); // 访问当前节点
                stack.push(node); // 当前节点入栈
                node = node.left; // 遍历其左子树
            } else {
                node = stack.pop(); // 弹出其父节点
                node = node.right; // 遍历其右子树
            }
        }
        return sb.toString();
    }

    /**
     * @param root
     * @return
     * @description 中序遍历(递归)
     */
    public String inOrder(Node<E> root) {
        StringBuilder sb = new StringBuilder(); // 存到递归调用栈
        if (root != null) { // 递归终止条件
            sb.append(inOrder(root.left)); // 中序遍历左子树
            sb.append(root.data + " "); // 中序遍历当前结点
            sb.append(inOrder(root.right)); // 中序遍历右子树
        }
        return sb.toString();
    }

    /**
     * @return
     * @description 中序遍历(迭代)：非线性结构(树)，工作栈：当前节点入栈
     */
    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 工作栈：记录回退路径
        Node<E> node = root;

        while (node != null || !stack.isEmpty()) { // 迭代条件
            if (node != null) { // 当前节点不为空
                stack.push(node); // 当前节点入栈
                node = node.left; // 遍历其左子树
            } else {
                node = stack.pop(); // 父节点弹栈
                sb.append(node.data + " "); // 访问父节点
                node = node.right; // 遍历访问其右子树
            }
        }
        return sb.toString();
    }

    /**
     * @param root
     * @return
     * @description 后序遍历(递归)
     */
    public String postOrder(Node<E> root) {
        StringBuilder sb = new StringBuilder(); // 存到递归调用栈
        if (root != null) { // 递归终止条件
            sb.append(postOrder(root.left)); // 后序遍历左子树
            sb.append(postOrder(root.right)); // 后序遍历右子树
            sb.append(root.data + " "); // 后序遍历当前结点
        }
        return sb.toString();
    }

    /**
     * @return
     * @description 后序遍历(迭代):非线性结构(树)，工作栈：当前节点入栈
     * 第三次遍历一个节点时才访问,因此需要在节点Node中新增一个bool字段，用于标记是否需要在本次访问该节点
     */
    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 记录回退路径的工作栈
        Node<E> node = root;
        while (node != null || !stack.isEmpty()) { // 迭代条件
            if (node != null) { // 当前节点不为空
                node.isFirst = true; // 首次访问该节点，记为true
                stack.push(node); // 压栈操作
                node = node.left; // 继续遍历左子树
            } else { // 当前节点为空但工作栈不为空
                node = stack.pop(); // 当前节点弹栈
                if (node.isFirst) {
                    node.isFirst = false; // 第二次访问该节点,改为false
                    stack.push(node); // 只有在第三次才访问，因此，前节点再次压栈
                    node = node.right; // 访问该节点的右子树
                } else { // 第三次访问该节点
                    sb.append(node.data + " "); // 访问
                    node = null; // 当前节点的左子树、右子树及本身均已访问,需要访问工作栈中的节点
                }
            }
        }
        return sb.toString();
    }

    public LinkedList<Node<E>> getPath(E name) {
        // 从根节点开始搜索
        LinkedList<Node<E>> stack = new LinkedList<Node<E>>(); // 工作栈：记录路径
        Node<E> node = root;
        Node<E> pre = null;

        while (node != null || !stack.isEmpty()) { // 迭代条件
            while(node != null) {
                //这个while循环的思想还是一直往左找，找的过程结点入栈，如果找到了就打印输出并返回。
                stack.push(node);
                if(node.data == name) {
                        return stack;
                }
                node = node.left;
            }
            //走到这一步说明栈顶元素的左子树为null，那么就开始往栈顶元素的右子树上去找。
            if(!stack.isEmpty()) {
                node = stack.peek();
                //如果栈顶元素的右子树为null，或者右子树被遍历过，则弹栈。
                while(node.right == null || (pre != null && node.right == pre)) {
                    pre = stack.pop();
                    node = stack.peek();
                }
                //继续遍历p的右子树
                node = node.right;
            }
        }
        return stack;
    }

    /**
     * @return
     * @description 根据前序、中序遍历结果重建二叉树
     */
    public Node<E> createBinaryTreeByPreAndIn(String pre, String in) {
        if (pre.length() > 0) {
            Node<E> root = new Node(pre.charAt(0));
            int index = in.indexOf(pre.charAt(0));
            root.left = createBinaryTreeByPreAndIn(pre.substring(1, index + 1),
                    in.substring(0, index));
            root.right = createBinaryTreeByPreAndIn(
                    pre.substring(index + 1, pre.length()),
                    in.substring(index + 1, in.length()));
            return root;
        }
        return null;
    }

    /**
     * @return
     * @description 根据中序、后序遍历结果重建二叉树
     */
    public Node<E> createBinaryTreeByInAndPost(String in, String post) {
        if (post.length() > 0) {
            Node<E> root = new Node(post.charAt(post.length() - 1));
            int index = in.indexOf(post.charAt(post.length() - 1));

            root.left = createBinaryTreeByInAndPost(in.substring(0, index),
                    post.substring(0, index));
            root.right = createBinaryTreeByInAndPost(
                    in.substring(index + 1, in.length()),
                    post.substring(index, post.length() - 1));
            return root;
        }
        return null;
    }

    /**
     * @param root
     * @return
     * @description 根据原树的根结点复制出一颗一模一样的树
     */
    public Node<E> copy(Node<E> root) {
        if (root == null)
            return null;
        Node<E> node = new Node<E>(null);
        node.data = root.data;
        node.left = copy(root.left);
        node.right = copy(root.right);
        return node;
    }

    /**
     * 方法createTreeByPreOrederStr需要用到的指针 (@author: rico)
     */
    private int index = 0;

    /**
     * @param preOrderStr
     * @param temp
     * @return
     * @description 根据前序遍历结果重建二叉树，所有的叶子节点都用"#"表示
     */
    public Node<E> createTreeByPreOrederStr(char[] preOrderStr, Node<E> temp) {
        if (index < preOrderStr.length) {
            char c = preOrderStr[index++];
            if (c != '#') { // 递归终止条件
                Node<E> node = new Node(c);
                node.left = createTreeByPreOrederStr(preOrderStr, node); // 递归为当前节点创建左子树
                node.right = createTreeByPreOrederStr(preOrderStr, node); // 递归为当前节点创建右子树
                return node;
            }
            return null;
        }
        return null;
    }

    /**
     * @return
     * @description 获取树的根结点
     */
    public Node<E> getRoot() {
        return root;
    }

    /**
     * @param node
     * @return
     * @description 获得当前结点的左孩子结点
     */
    public Node<E> getLeftChild(Node<E> node) {
        return node.left;
    }

    /**
     * @param node
     * @return
     * @description 获得当前结点的右孩子结点
     */
    public Node<E> getRightChild(Node<E> node) {
        return node.right;
    }

    /**
     * @param root
     * @return
     * @description 后序遍历的思想：树中节点个数
     */
    public int size(Node<E> root) {
        if (root != null) { // 递归终止条件
            return size(root.left) + size(root.right) + 1;
        }
        return 0;
    }

    /**
     * @param root
     * @return
     * @description 后序遍历的思想：树的高度(空树为0)
     */
    public int height(Node<E> root) {
        if (root != null) { // 递归终止条件
            int h1 = height(root.left);
            int h2 = height(root.right);
            return h1 > h2 ? h1 + 1 : h2 + 1;
        }
        return 0;
    }

    /**
     * @param root
     * @return
     * @description 以广义表的形式打印二叉树：前序遍历的应用
     */
    public String printBinaryTree(Node<E> root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.data);
            if (root.left != null || root.right != null) {
                sb.append('(');
                sb.append(printBinaryTree(root.left));
                sb.append(',');
                sb.append(printBinaryTree(root.right));
                sb.append(')');
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return levelOrder();
    }

    /**
     * @param src 原树的根结点
     * @param des 目标树的根结点
     * @return
     * @description 根据树的根结点判断两颗树是否相等
     */
    private boolean equals0(Node<E> src, Node<E> des) {
        if (src == null && des == null) { // 空树相等
            return true;
        } else if (src == null || des == null) { // 空树与非空树不相等
            return false;
        } else { // 非空树与非空树是否相等：当前节点是否相等 && 左子树是否相等 && 右子树是否相等
            return src.equals(des) && equals0(src.left, des.left)
                    && equals0(src.right, des.right);
        }
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (obj instanceof BinaryTree) { // 对方是否也是一颗二叉树
            BinaryTree<E> tree = (BinaryTree<E>) obj;
            return equals0(this.root, tree.root);
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree<Character> tree =null;

        while (true) {
            System.out.println("-----菜单------\n" +
                    "1.建立二叉树存储结构\n" +
                    "2.求二叉树的先序遍历序列\n" +
                    "3.求二叉树的中序遍历序列\n" +
                    "4.求二叉树的后序遍历序列\n" +
                    "5.求二叉树的层序遍历序列\n" +
                    "6.求根结点到指定结点的路径\n" +
                    "0.退出\n");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("-----建立二叉树存储结构------\n" +
                        "利用广义表输入建树字符，节点名（左，右），例：\"k(e(a,c),c(b,s))\"：");
                String inputString = scanner.next();
                tree = new BinaryTree<Character>();
                tree.createBinaryTree(inputString);
                System.out.println("二叉树建立成功！");
            }
            if (input == 2) {
                if(tree == null){
                    System.out.println("树未建立！返回");
                    continue;
                }
                System.out.println("-----求二叉树的先序遍历序列------\n");
                System.out.println(tree.preOrder());

            }
            if (input == 3) {
                if(tree == null){
                    System.out.println("树未建立！返回");
                    continue;
                }
                System.out.println("-----求二叉树的中序遍历序列------\n");
                System.out.println(tree.inOrder());
            }
            if (input == 4) {
                if(tree == null){
                    System.out.println("树未建立！返回");
                    continue;
                }
                System.out.println("-----求二叉树的后序遍历序列------\n");
                System.out.println(tree.postOrder());
            }
            if (input == 5) {
                if(tree == null){
                    System.out.println("树未建立！返回");
                    continue;
                }
                System.out.println("-----求二叉树的层序遍历序列------\n");
                System.out.println(tree.levelOrder());
            }
            if (input == 6) {
                if(tree == null){
                    System.out.println("树未建立！返回");
                    continue;
                }
                System.out.println("-----求根结点到指定结点的路径------\n" +
                        "输入目标结点的字母：");
                String name = scanner.next();
                Character ch = name.charAt(0);
                LinkedList<Node<Character>> path = tree.getPath(ch);
                System.out.print("路径：");
                for (int i = path.size()-1; i >= 0; i--) {
                    System.out.print(path.get(i) + " ");
                }
                System.out.println();
            }
            if (input == 0) {
                return;
            }
        }
    }
}

