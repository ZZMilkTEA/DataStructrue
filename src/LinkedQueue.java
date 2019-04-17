public class LinkedQueue {
    class Node{         //定义节点类型，它的实例是一个队列内的存储元素
        private Node next = null;  //指向下一节点
        private int data;   //节点所存储的内容

        Node(){
        }

        Node(int data){
            this.data = data;
        }
    }

    private Node front;  //一个队列的队头节点
    private Node rear;  //一个队列的队尾节点

    //构造函数
    LinkedQueue(){
        front = new Node();
        front.next = null;
        rear =front;

    }

    //判空
    boolean isEmpty(){
        return front == rear;
    }

    //头插法
    public void enter(int elem){
        Node node = new Node(elem);
        if(isEmpty()){
            front = node;
            rear = node;
            return;
        }
        Node temp = front;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        rear = node;

        this.front.next = node;
    }

    //获取队列长度
    public int getSize(){
        Node temp = front;
        int count = 0;
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    //删除一个节点，原理是把指向被删除的节点的指针修改，使其指向被删除的节点的后一个节点
    public int delete(){
        if (isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException();
        }
        else {
            int temp = front.data;
            front = front.next;
            return  temp;
        }
    }



    //逆置
    public void reverseList(){
        if (this.front.next == null || this.front.next.next == null){
            return;
        }
        Node temp;
        Node iterator = this.front.next.next;
        this.front.next.next = null;
        while (iterator != null){
            temp = iterator.next;
            iterator.next = this.front.next;
            this.front.next = iterator;
            iterator= temp;
        }
    }

    //排序
    public void listSort(){
        if(this.front.next==null) return;
        Node s =this.front.next.next;
        this.front.next.next=null;
        while(s != null) {
            Node pre=this.front;
            Node p=this.front.next;
            while(p != null && s.data > p.data) {
                pre=p; p= p.next;
            }
            Node temp=s.next;
            pre.next=s;  s.next=p;
            s=temp;
        }

    }

    //差运算
    public static void  difference (LinkedQueue list_a, LinkedQueue list_b) {
        Node pre = list_a.front;
        Node p = list_a.front.next;
        while(p != null) {
            Node q= list_b.front.next;
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

    //输出一个队列
    public void outputList(){
        Node temp = this.front;
        while(temp.next!=null)
        {
            temp=temp.next;
            System.out.print(temp.data +" ");
        }
        System.out.print("length=" + this.getSize());
        System.out.println();   // 输出完毕后换行操作
    }
}
