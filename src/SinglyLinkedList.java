public class SinglyLinkedList {
    class Node{         //定义节点类型，它的实例是一个单链表内的存储元素
        private Node next = null;  //指向下一节点
        private int elem;   //节点所存储的内容

        Node(){
        }

        Node(int elem){
            this.elem = elem;
        }
    }

    private Node head;  //一个单链表的头节点

    SinglyLinkedList(){
        this.head = new Node();
        this.head.next =null;
    }

    public void add(int elem){  //尾插法
        Node node = new Node(elem);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public int getElem(int no){
        Node current = this.head;
        for (int i = 0; i < no; i++){
            current = current.next;
        }
        return current.elem;
    }

    public Node getNode(int no){    //获取单链表中指定位置的节点
        Node current = this.head;
        for (int i = 0; i < no; i++){
            current = current.next;
        }
        return current;
    }

    public void insert(int no,int elem){    //在指定位置插入一个元素
        Node temp = this.getNode(no-1);
        Node newNode = new Node(elem);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void outputList(){   //输出一个单链表
        Node temp = this.head;
        while(temp.next!=null)
        {
            temp=temp.next;
            System.out.print(temp.elem+"\t");
        }
    }

    public int getSize(){   //获取单链表长度
        Node temp = head;
        int count = 0;
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static void main(String args[] ){
        SinglyLinkedList a = new SinglyLinkedList();
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(8);
        System.out.println(a.getElem(1));
        a.insert(2,2);
        System.out.println(a.getSize());
        a.outputList();
    }

}
