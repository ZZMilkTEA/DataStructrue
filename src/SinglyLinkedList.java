import java.util.Scanner;

public class SinglyLinkedList {
    class Node{         //定义节点类型，它的实例是一个单链表内的存储元素
        private Node next = null;  //指向下一节点
        private int data;   //节点所存储的内容

        Node(){
        }

        Node(int data){
            this.data = data;
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

    //头插法
    public void headInsert(int elem){
        Node node = new Node(elem);
        node.next = this.head.next;
        this.head.next = node;
    }

    //尾插法
    public void tailInsert(int elem){
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

    //排序
    public void listSort(){
        if(this.head.next==null) return;
        Node s =this.head.next.next;
        this.head.next.next=null;
        while(s != null) {
            Node pre=this.head;
            Node p=this.head.next;
            while(p != null && s.data > p.data) {
                pre=p; p= p.next;
            }
            Node temp=s.next;
            pre.next=s;  s.next=p;
            s=temp;
        }

    }

    //合并
    public static SinglyLinkedList merge(SinglyLinkedList a,SinglyLinkedList b){
        Node temp = a.getNode(a.getSize());
        temp.next = b.head.next;
        return a;
    }

    //差运算
    public static void  difference (SinglyLinkedList list_a,SinglyLinkedList list_b) {
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
            temp=temp.next;
            System.out.print(temp.data +" ");
        }
        System.out.print("length=" + this.getSize());
        System.out.println();   // 输出完毕后换行操作
    }



    public static void main(String args[] ){
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list_a = new SinglyLinkedList();
        System.out.println("单链表a初始化完成\n下面将进行头插法对单链表a加入数值，以空格分隔当输入非整数数值时加入结束");
        while (scanner.hasNextInt()){
            list_a.headInsert(scanner.nextInt());
        }
        System.out.print("当前的线性表a内容为：");
        list_a.outputList();

        SinglyLinkedList list_b = new SinglyLinkedList();
        System.out.println("-----------------------------------\n " +
                "单链表b初始化完成\n下面将进行尾插法对单链表b加入数值，以空格分隔当输入非整数数值时加入结束");
        scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            list_b.tailInsert(scanner.nextInt());
        }
        System.out.print("当前的线性表b内容为：");
        list_b.outputList();

        System.out.print("-----------------------------------\n " +
                "下面将对单链表a进行插入操作，请输入要插入的序号和内容\n序号：");
        scanner = new Scanner(System.in);
        int no = scanner.nextInt();
        System.out.print("内容：");
        int data =  scanner.nextInt();
        try {
            list_a.insert(no,data);
        }catch (Exception e){
            System.out.println("输入的数值似乎非法");
        }
        System.out.print("当前的单链表a内容为：");
        list_a.outputList();

        System.out.println("-----------------------------------\n " +
                "下面将对单链表a进行删除操作，请输入要删除的序号");
        no = scanner.nextInt();
        try {
            list_a.deleteNode(no);
        }catch (Exception e){
            System.out.println("输入的数值似乎非法");
        }
        System.out.print("当前的单链表a内容为：");
        list_a.outputList();
        System.out.println("请按回车键继续");
        String str = new Scanner(System.in).nextLine();

        System.out.println("-----------------------------------\n " +
                "下面将对单链表a进行逆置操作");
        list_a.reverseList();
        System.out.print("当前的单链表a内容为：");
        list_a.outputList();
        System.out.println("请按回车键继续");
        str = new Scanner(System.in).nextLine();

        System.out.println("-----------------------------------\n " +
                "下面将进行对单链表a，单链表b进行差运算操作");
        difference(list_a,list_b);
        System.out.print("当前的单链表a内容为：");
        list_a.outputList();
        System.out.println("请按回车键继续");
        str = new Scanner(System.in).nextLine();

        SinglyLinkedList list_c = new SinglyLinkedList();
        System.out.println("-----------------------------------\n " +
                "单链表c初始化完成\n下面将进行对单链表a，单链表b进行合并操作，将结果置入单链表c中");
        list_c = merge(list_a,list_b);
        System.out.print("当前的单链表c内容为：");
        list_c.outputList();
        System.out.println("请按回车键继续");
        str = new Scanner(System.in).nextLine();

        System.out.println("-----------------------------------\n " +
                "下面将对单链表c进行排序操作");
        list_c.listSort();
        System.out.print("当前的单链表c内容为：");
        list_c.outputList();
    }
}
