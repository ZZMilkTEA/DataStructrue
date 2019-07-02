package exam.linear;

public class Node{         //定义节点类型，它的实例是一个单链表内的存储元素
    public Node next = null;  //指向下一节点
    public int data;   //节点所存储的内容
    Node(){

    }

    Node(int data){
        this.data = data;
    }
}
