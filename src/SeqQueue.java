public class SeqQueue {
    private int element[];
    private int front;
    private int rear;
    private int mod;

    //构造函数
    SeqQueue(int maxSize){
        element = new int[maxSize];
        mod = maxSize;
        front = 0;
        rear = 0;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public int getMod() {
        return mod;
    }

    //判空
    public boolean isEmpty(){
      return front == rear;
    }

    //判满
    public boolean isFull(){
        return  (rear + 1) % mod == front;
    }

    //入队操作
    public boolean enterQueue(int elem){
        if((rear + 1) % mod == front) {
            System.out.println("队列已满," + elem + " 未入队");
            return false;
        }
        element[rear]=elem;
        rear = (rear + 1) % mod;
        return true;
    }

    //出队操作，返回出队的元素，若出队失败抛异常
    public int deleteQueue(){
        if(front == rear){
            throw new RuntimeException();
        }
        int e = element[front];
        front = (front+1) % mod;
        return e;
    }

    public int visit(int no){
        return element[(front + no - 1) % mod];
    }

    //求队列元素个数
    public int getSize(){
        return (rear - front + mod) % mod;
    }

    //输出杨辉三角形的测试程序
    public static void main(String args[]){
        SeqQueue row = new SeqQueue(100);

        row.enterQueue(1);

        int rowsCount = 20;

        for (int i = 2; i <= rowsCount;i++){
            for (int j = 0; j < rowsCount - i; j++){
                System.out.print("  ");
            }
            row.enterQueue(1);
            for (int j = 0;j < i - 2; j++){
                row.enterQueue(row.visit(1) + row.visit(2));
                System.out.print(row.deleteQueue() + "   ");
            }
            System.out.println(row.deleteQueue());
            row.enterQueue(1);
        }

    }
}
