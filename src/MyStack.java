import java.io.*;

public class MyStack {  //自己实现栈的数据结构
    private int maxSize;
    private char[] stackArray;
    private int top;
    public MyStack(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push(char j) {
        stackArray[++top] = j;
    }
    public long pop() {
        return stackArray[top--];
    }
    public long peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
    public static void main(String[] args)throws IOException {  //利用栈做括号匹配的测试
        File f =new File("src/MyStack_test"); //读取项目中的测试用源文件
        BufferedReader reader = new BufferedReader(new FileReader(f)); //文件读入字符流
        MyStack theStack = new MyStack(20); //初始化最大大小为20的栈
        int size =(int)f.length();  //读取文件的字节大小
        reader.mark(size+1);//设置输入流的可用标记为文件字节数+1

        System.out.println("源文件："); // 输出源文件
        for (int i = 0;i < size; i++){
            System.out.print((char)reader.read());
        }
        System.out.println('\n');

        reader.reset(); //若在mark标记范围内，则重置输入流

        for (int i = 0;i < size; i++){  //括号匹配检验
            char c = (char)reader.read();
            if (c == '('){
             theStack.push(c);  //遇到'('压栈
            }
            else if (c ==')'){  //遇到")"判断
                if (theStack.top == ')' || theStack.isEmpty()){
                    System.out.println("括号匹配有误！！！");
                    reader.close();
                    return;
                }
                else{
                    theStack.pop();
                }
            }
        }
        if(!theStack.isEmpty()){
            System.out.println("括号匹配有误！！！");
            reader.close();
            return;
        }
        reader.close();
        System.out.println("括号匹配正确");   //  若执行到这则说明括号没有因为匹配错误而提前退出，输出匹配正确信息
    }
}
