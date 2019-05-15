import java.util.ArrayList;

public class BinaryTree {
    //定义二叉树内的节点
    class Node{
        private  int data;
        private  Node leftNode;
        private  Node rightNode;

        //无参构造节点默认赋值0
        Node(){
            this.data = 0;
            this.leftNode = null;
            this.rightNode = null;
        }

        //有参构造节点
        Node(int data){
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }
    //------------定义二叉树的部分------------
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private Node root;
    //构造新树，同时创建一个根节点
    BinaryTree(int rootData){
        Node newRootNode = new Node(rootData);
       this.root = newRootNode;
       this.nodes.add(this.root);
    }

    //对已有节点创建一个左孩子
    public void createNewLeftNode(Node parent,int data){
        nodes.add(new Node(data));
        parent.setLeftNode(nodes.get(nodes.size()-1));
    }

    //对已有节点创建一个右孩子
    public void createNewRightNode(Node parent,int data){
        nodes.add(new Node(data));
        parent.setRightNode(nodes.get(nodes.size()-1));
    }

    //查找并返回root节点
    public Node root(){
       for (Node node_1 : nodes){
           for (Node node_2 : nodes){
               if (node_1 == node_2.getRightNode() || node_1 == node_2.getLeftNode() ){
                   break;
               }
               else if (node_2 == nodes.get(nodes.size()-1)){
                   return node_1;
               }
           }
       }
       return null;
    }

    //创建一个新root节点，当已有root节点的失效
    public void creatRoot(int rootData){
        if ( this.root() == null){ }
        else {
            nodes.add(new Node(rootData));
        }
    }

    public void getNode(){

    }

    public static void main (String args[]){
        BinaryTree tree = new BinaryTree(4);
        tree.createNewLeftNode(tree.root,2);
        tree.createNewRightNode(tree.root,3);
        tree.createNewRightNode(tree.nodes.get(2),4);
        System.out.println(tree.root.rightNode.rightNode.getData());
    }


}
