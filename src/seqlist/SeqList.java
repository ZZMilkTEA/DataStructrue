package seqlist;

import java.util.Scanner;

//一个顺序表的抽象数据类型
public class SeqList<T> {
    private T elem[];
    int last;
    final int MAXSIZE = 100;    //顺序表最大长度设置为100


    SeqList(int length, T intiValue){   //输入长度和初始值构造函数
        if (length > 100 || length < 0){
            System.out.println("由于长度非法，已将顺序表长度默认为50");
            this.elem = (T[])new Object[MAXSIZE];
            for (int i = 0;i < 50;i++){
                this.elem[i] = intiValue;
                last = 49;
            }
        }
        else {
            this.elem = (T[]) new Object[MAXSIZE];
            for (int i = 0; i < length; i++) {
                this.elem[i] = intiValue;
            }
            last = length-1;
        }
    }
    SeqList(){   //无参的构造函数，默认创建一个长度为50，值为null的顺序表
        this.elem = (T[])new Object[MAXSIZE];
        for (int i = 0;i < 50;i++){
            this.elem[i] = null;
        }
        last = 49;
    }

    public T getElem(int no){     //查找序号，返回其元素
         if(no >= 1 && no <= this.last+1){
             return this.elem[no-1];
         }
         else{
             return null;
         }
    }

    public int locate (T elem){        //从左查找第一个出现的元素，返回其序号。未找到返回-1
        for (int i = 0;i <= this.last;i++){
            if (this.elem[i] == elem){
                return i+1;
            }
        }
        return -1;
    }

    public void insert(T elem,int no) {    //插入函数，先判断last+1后是否会超过该线性表的最大长度，不会则执行插入操作。
        if (no >= 1 && no <= this.last + 1) {
            if (last + 1 <= this.elem.length - 1) {
                last++;
                for (int i = last; i + 1 > no; i--) {
                    this.elem[i] = this.elem[i - 1];
                }
                this.elem[no - 1] = elem;
            } else {
                System.out.println("线性表已满");
            }
        }
        else {
            System.out.println("输入位置非法");
        }
    }
    public void delete(int no){   //删除元素函数
        if(no >= 1 && no <= this.last+1){
            for (int i = no-1;i < last;i++ ){
                this.elem[i] = this.elem[i+1];
            }
            last--;
        }
        else{
            System.out.println("输入位置非法");
        }
    }

    boolean isEmpty(){  //判断该顺序表是否为空表
        return this.last == -1;
    }

    public void setElem(int no,T elem){   //修改指定位置的元素
        if(no >= 1 && no <= this.last+1){
            this.elem[no-1] = elem;
        }
        else{
            System.out.println("输入位置非法");
        }
    }

    public void outputList(){
        for (int i = 0;i <= this.last;i++){
            System.out.print(this.getElem(i+1)+" ");
        }
        System.out.println();
    }
    public void setLast(int value){
        this.last = value;
    }

    public void clearList(){
        this.setLast(-1);
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入线性表的长度和填充的初始值，其中长度不超过100，初始值为整型\n长度：");
        int length = scanner.nextInt();
        System.out.print("初始值：");
        int initValue = scanner.nextInt();

        SeqList seqList =new SeqList(length,initValue);

        System.out.print("现在的线性表：");
        seqList.outputList();

        System.out.print("下面将执行插入操作，先输入要插入的整数，接着输入要插入的位置\n插入元素：");
        int elem = scanner.nextInt();
        System.out.print("插入位置：");
        int insertPosition = scanner.nextInt();

        seqList.insert(elem,insertPosition);
        System.out.print("现在的线性表：");
        seqList.outputList();

        System.out.print("下面将执行删除操作，输入要删除的位置\n删除位置：");
        int deletePosition = scanner.nextInt();
        seqList.delete(deletePosition);

        System.out.print("现在的线性表：");
        seqList.outputList();

        System.out.print("下面将执行修改操作，先输入要修改的位置，接着输入修改为的内容\n修改位置：");
        int setPosition = scanner.nextInt();
        System.out.print("修改为：");
        int setElem = scanner.nextInt();
        seqList.setElem(setPosition,setElem);

        System.out.print("现在的线性表：");
        seqList.outputList();

        System.out.print("下面将执行按序号查找操作，输入要查找的序号\n序号：");
        int no = scanner.nextInt();
        if(seqList.getElem(no) != null) {
            System.out.println("你查找到的内容为：" + seqList.getElem(no));
        }
        else {
            System.out.println("输入位置非法");
        }

        System.out.print("下面将执行按元素查找操作，输入要查找的内容（整数）\n内容：");
        int locateElem = scanner.nextInt();
        if (seqList.locate(locateElem) == -1){
            System.out.println("你所查找的内容不存在!");
        }
        else{
            System.out.println("你查找的内容的序号为："+seqList.locate(locateElem));
        }
    }
}
