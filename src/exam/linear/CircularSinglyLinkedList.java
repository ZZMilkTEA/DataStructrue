package exam.linear;


public class CircularSinglyLinkedList {

    private Node head;  //一个循环单链表的头节点
    private Node rear; //一个循环单链表的尾节点

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getRear() {
        return rear;
    }

    public void setRear(Node rear) {
        this.rear = rear;
    }

    //构造函数
    CircularSinglyLinkedList(){
        this.head = new Node();
        this.rear = new Node();
        this.head.next = null;
        this.rear.next = null;
    }

    //判断输入的序号是否合法（在范围内）
    private boolean numInputJudge(int no){
        return no >= 1 &&  no <= this.getSize();
    }

    //头插法
    public void headInsert(int elem){
        Node node = new Node(elem);
        node.next = this.head.next;
        this.head.next = node;
    }

    //尾插法
    public void tailInsert(int elem){
            Node node = new Node(elem);
        if (rear.next == null) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        else {
            rear.next.next = node;
            rear.next = node;
            node.next = head;
        }
    }

    //设置尾节点
    public void initRear(){
        Node temp = head;
        while (temp.next !=null) {
            if (temp.next == head) break;
            temp = temp.next;
        }
        rear.next = temp;
        temp.next = head;
    }

    //返回指定序号的节点的内容
    public int visit(int no){
        Node current = this.head;
        for (int i = 0; i < no; i++){
            current = current.next;
        }
        return current.data;
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
    public void insert(int postion, int elem){
        Node newNode = new Node(elem);
        newNode.next = this.getNode(postion-1).next;
        this.getNode(postion-1).next = newNode;
    }

    //获取单链表长度
    public int getSize(){
        Node temp = head;
        int count = 0;
        while (temp.next != null){
            if (temp.next == head) break;
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
        if (this.head.next == null || this.head.next.next == null){
            return;
        }
        Node temp;
        Node iterator = this.head.next.next;
        this.head.next.next = null;
        while (iterator != null){
            temp = iterator.next;
            iterator.next = this.head.next;
            this.head.next = iterator;
            iterator= temp;
        }
    }


    //合并
    public static CircularSinglyLinkedList merge(CircularSinglyLinkedList a, CircularSinglyLinkedList b){
        Node temp = a.getNode(a.getSize());
        temp.next = b.head.next;
        return a;
    }

    //差运算
    public static void  difference (CircularSinglyLinkedList list_a, CircularSinglyLinkedList list_b) {
        Node pre = list_a.head;
        Node p = list_a.head.next;
        while(p != null) {
            Node q= list_b.head.next;
            while (q != null && q.data != p.data)  {
                q = q.next;
            }
            if(q != null) {
                pre.next = p.next;
                Node r = p;
                p = p.next;
            }
            else {
                pre = p;
                p = p.next;
            }
        }
    }

    //输出一个单链表
    public void outputList(){
        Node temp = this.head;
        while(temp.next!=null)
        {
            if(temp.next == head)break;
            temp = temp.next;
            System.out.println(temp.data + " ");
        }
        System.out.print("length=" + this.getSize());
        System.out.println();   // 输出完毕后换行操作
    }

    public static void main(String[] args){
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.headInsert(2);
        list.headInsert(3);
        list.headInsert(5);
        list.headInsert(1);
        list.initRear();
        System.out.println(list.rear.next.data);
        list.outputList();
    }
}
