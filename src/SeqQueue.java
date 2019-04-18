import java.util.Scanner;

public class SeqQueue {
    private int element[];
    private int front;  //队头
    private int rear;   //队尾
    private int mod;    //队列的模

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

    //访问第n个元素
    public int visit(int no){
        return element[(front + no - 1) % mod];
    }

    //求队列元素个数
    public int getSize(){
        return (rear - front + mod) % mod;
    }

    //输出杨辉三角形的测试程序
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        SeqQueue row = new SeqQueue(100);

        row.enterQueue(1);

        System.out.print("请输入输出行数：");
        int rowsCount = scanner.nextInt();

        for (int i = 2; i <= rowsCount;i++){    //循环输出n-1次（除开最后一行的输出），其中i赋初值2是为了方便计算生成中间内容的循环次数
            System.out.print("  ");
            for (int j = 0; j < rowsCount - i; j++){ //对应生成n行前的空格数量，保持金字塔状
                System.out.print("  ");
            }
            row.enterQueue(1);
            for (int j = 0;j < i - 2; j++){     //生成中间元素
                row.enterQueue(row.visit(1) + row.visit(2));
                System.out.print(row.deleteQueue() + "   ");
            }
            System.out.println(row.deleteQueue());  //n-1行最后一个元素出队并输出
            row.enterQueue(1);  //第n行的第一个元素1入队
        }

        while (!row.isEmpty()){     //输出最后一行
            System.out.print(row.deleteQueue() + "   ");
        }

    }
}
