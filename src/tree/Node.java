package tree;

public class Node<T> {

    public T data;   // 结点数据
    Node<T> left;  // 指向左孩子结点
    Node<T> right;  // 指向右孩子结点
    boolean isFirst;  // 用于非递归后序遍历


    /**
     * 构造函数
     *
     * @param data
     *            新元素数据
     */
    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return data == null ? null : data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (obj instanceof Node) {
            Node<T> temp = (Node<T>) obj;
            if (data.equals(temp.data)) {
                return true;
            }
        }
        return false;
    }
}