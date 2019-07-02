package exam.query;

import java.util.*;

public class BinarySortTree {
    //定义内部节点类，内容与数据表保持一致
    static class Node {
        int data;
        Integer other_int;
        String other_string;
        Node parent;
        Node left;
        Node right;

        public Node(int data,Integer other_int, String other_string,
                    Node parent, Node left, Node right) {
            this.data = data;
            this.other_int = other_int;
            this.other_string = other_string;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[data=" + data + "]\n" + "[other_int=" + other_int + "]\n" + "[other_string=" + other_string + "]\n";
        }
    }

    private Node root;

    // 两个构造器用于创建排序二叉树
    public BinarySortTree() {
        root = null;
    }

    public BinarySortTree(int o) {
        root = new Node(o, null, null, null,null,null);
    }

    // 添加节点
    public void add(int ele,Integer other_int,String other_string) {
        // 如果根节点为null
        if (root == null) {
            root = new Node(ele, other_int, other_string, null,null,null);
        }
        else {
            Node current = root;
            Node parent = null;
            // 搜索合适的叶子节点，以该叶子节点为父节点添加新节点
            do {
                parent = current;
                // 如果新节点的值大于当前节点的值
                if (current.data < ele) {
                    // 以右子节点作为当前节点
                    current = parent.right;
                } else {
                    // 如果新节点的值小于当前节点的值
                    // 以左节点作为当前节点
                    current = parent.left;
                }
            }
            while (current != null);
            // 创建新节点
            Node newNode = new Node(ele,other_int,other_string, parent, null, null);
            // 如果新节点的值大于父节点的值
            if (newNode.data > parent.data) {
                // 新节点作为父节点的右子节点
                parent.right = newNode;
            } else {
                // 如果新节点的值小于父节点的值
                // 新节点作为父节点的左子节点
                parent.left = newNode;
            }
        }
    }

    // 删除节点
    public void remove(int ele) {
        // 获取要删除的节点
        Node target = getNode(ele);
        if (target == null) {
            return;
        }
        // 左、右子树为空
        if (target.left == null && target.right == null) {
            // 被删除节点是根节点
            if (target == root) {
                root = null;
            } else {
                // 被删除节点是父节点的左子节点
                if (target == target.parent.left) {
                    // 将target的父节点的left设为null
                    target.parent.left = null;
                } else {
                    // 将target的父节点的right设为null
                    target.parent.right = null;
                }
                target.parent = null;
            }
        } else if (target.left == null && target.right != null) {
            // 左子树为空，右子树不为空
            // 被删除节点是根节点
            if (target == root) {
                root = target.right;
            } else {
                // 被删除节点是父节点的左子节点
                if (target == target.parent.left) {
                    // 让target的父节点的left指向target的右子树
                    target.parent.left = target.right;
                } else {
                    // 让target的父节点的right指向target的右子树
                    target.parent.right = target.right;
                }
                // 让target的右子树的parent指向target的parent
                target.right.parent = target.parent;
            }
        } else if (target.left != null && target.right == null) {
            // 左子树不为空，右子树为空
            // 被删除节点是根节点
            if (target == root) {
                root = target.left;
            } else {
                // 被删除节点是父节点的左子节点
                if (target == target.parent.left) {
                    // 让target的父节点的left指向target的左子树
                    target.parent.left = target.left;
                } else {
                    // 让target的父节点的right指向target的左子树
                    target.parent.right = target.left;
                }
                // 让target的左子树的parent指向target的parent
                target.left.parent = target.parent;
            }
        } else {
            // 左、右子树都不为空
            // leftMaxNode用于保存target节点的左子树中值最大的节点
            Node leftMaxNode = target.left;
            // 搜索target节点的左子树中值最大的节点
            while (leftMaxNode.right != null) {
                leftMaxNode = leftMaxNode.right;
            }
            // 从原来的子树中删除leftMaxNode节点
            leftMaxNode.parent.right = null;
            // 让leftMaxNode的parent指向target的parent
            leftMaxNode.parent = target.parent;
            // 被删除节点是父节点的左子节点
            if (target == target.parent.left) {
                // 让target的父节点的left指向leftMaxNode
                target.parent.left = leftMaxNode;
            } else {
                // 让target的父节点的right指向leftMaxNode
                target.parent.right = leftMaxNode;
            }
            leftMaxNode.left = target.left;
            leftMaxNode.right = target.right;
            target.parent = target.left = target.right = null;
        }
    }

    // 根据给定的值搜索节点
    public Node getNode(int ele) {
        // 从根节点开始搜索
        Node p = root;
        while (p != null) {
            // 如果搜索的值小于当前p节点的值
            if (ele < p.data) {
                // 向左子树搜索
                p = p.left;
            } else if (ele > p.data) {
                // 如果搜索的值大于当前p节点的值
                // 向右子树搜索
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 广度优先遍历
    public List<Node> breadthFirst() {

        Queue<Node> queue = new ArrayDeque<Node>();
        List<Node> list = new ArrayList<Node>();
        if (root != null) {
            // 将根元素入“队列”
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            // 将该队列的“队尾”的元素添加到List中
            list.add(queue.peek());
            Node p = queue.poll();
            // 如果左子节点不为null，将它加入“队列”
            if (p.left != null) {
                queue.offer(p.left);
            }
            // 如果右子节点不为null，将它加入“队列”
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return list;
    }


    public static void main(String[] args){
        BinarySortTree binarySortTree = new BinarySortTree();
        System.out.println("*******二叉搜索树*******");

        Scanner scanner =new Scanner(System.in);

        int sourceData_number;
        System.out.print("请输入源数据的数量：");
        sourceData_number = scanner.nextInt();
        STable sTable = new STable(sourceData_number);
        System.out.println("下面输入源数据");
        for (int i = 0;i < sTable.getNodes().length; i++){
            System.out.println("数据" + (i+1) + "：");
            System.out.print( "\tkey(int):");
            sTable.getNodes()[i].setKey(scanner.nextInt());
            System.out.print("\totherData(int):");
            sTable.getNodes()[i].setOther_int(scanner.nextInt());
            System.out.print("\totherData(String):");
            sTable.getNodes()[i].setOther_string(scanner.next());
        }

        for (int i = 0; i < sTable.getNodes().length; i++){
            int newInt =sTable.getNodes()[i].getKey();
            int newOther_int = sTable.getNodes()[i].getOther_int();
            String newOther_string = sTable.getNodes()[i].getOther_string();
            binarySortTree.add(newInt,newOther_int,newOther_string);
        }

        List list = binarySortTree.breadthFirst();
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        while (true) {
            System.out.println("请输入要查找的结点key");
            int searchInt = scanner.nextInt();
            Node searchNode = binarySortTree.getNode(searchInt);
            if(searchNode != null){
                System.out.println("查找成功，数据为：");
                System.out.println("[data=" + searchNode.data + "]\n" + "[other_int=" + searchNode.other_int + "]\n"
                        + "[other_string=" + searchNode.other_string + "]");
            }
            else {
                System.out.println("查找失败，查找的数据不存在");
            }
        }
    }
}