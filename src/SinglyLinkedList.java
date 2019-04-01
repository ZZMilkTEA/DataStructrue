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

    //构造函数
    SinglyLinkedList(){
        this.head = new Node();
        this.head.next =null;
    }

    //判断输入的序号是否合法（在范围内）
    private boolean numInputJudge(int no){
        return no >= 1 &&  no <= this.getSize();
    }

    //尾插法
    public void add(int elem){
        Node node = new Node(elem);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    //返回指定序号的节点的内容
    public int visit(int no){
        Node current = this.head;
        for (int i = 0; i < no; i++){
            current = current.next;
        }
        return current.elem;
    }

    //获取单链表中指定位置的节点
    public Node getNode(int no){
        Node current = this.head;
        for (int i = 0; i < no; i++){
            current = current.next;
        }
        return current;
    }

    //在指定位置插入一个元素
    public void insert(int no,int elem){
        Node newNode = new Node(elem);
        newNode.next = this.getNode(no-1).next;
        this.getNode(no-1).next = newNode;
    }

    //获取单链表长度
    public int getSize(){
        Node temp = head;
        int count = 0;
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    //删除一个节点，原理是把指向被删除的节点的指针修改，使其指向被删除的节点的后一个节点
    public void deleteNode(int no){
        getNode(no-1).next = getNode(no-1).next.next;
    }



    //逆置

    public void reverseList(){

        }

    }

    //排序

    //合并

    //输出一个单链表
    public void outputList(){
        Node temp = this.head;
        while(temp.next!=null)
        {
            temp=temp.next;
            System.out.print(temp.elem+"\t");
        }
        System.out.println();
    }

    public static void main(String args[] ){
        SinglyLinkedList a = new SinglyLinkedList();
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(8);
        System.out.println(a.visit(1));
        a.insert(2,2);
        System.out.println(a.getSize());
        a.deleteNode(2);
        a.outputList();
        System.out.println( a.numInputJudge(99));
    }

}
