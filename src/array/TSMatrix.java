package array;

import java.util.Scanner;

public class TSMatrix {
    private Triple data[];
    private int m,n,len;

    //稀疏矩阵的构造
    TSMatrix(int maxSize,int m ,int n){
        if(maxSize > m * n){
            System.out.println("非零元个数大于矩阵容量");
            return;
        }
        data = new Triple[maxSize+1];
        for (int i = 1; i < data.length; i++) {
            data[i] = new Triple(0,0,0);
        }
        this.m = m;
        this.n = n;
        len = 0;
    }

    //各个成员的get，set
    public Triple[] getData() {
        return data;
    }

    public void setData(Triple[] data) {
        this.data = data;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    //非零元的插入
    public boolean insertData(Triple newData){
        if (len > data.length){
            return false;
        }
        else{
            if(newData.getRow() > n || newData.getCol() > m){
                return false;
            }
            else {
                data[len + 1] = newData;
                len++;
                return true;
            }
        }
    }

    //三元组以行升序排序,这里使用选择排序算法。这个方法给手动乱序输入数据的矩阵使用
    public void sortData(){
        for(int i = 1; i <len ; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < len+1; j++){// 选最小的记录
                if(data[j].getRow() < data[k].getRow()){
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换两个元素
                Triple temp = data[i];
                data[i] = data[k];
                data[k] = temp;
            }
        }
    }

    //快速转置矩阵
    public static TSMatrix transposeSMatrix(TSMatrix m) {
        TSMatrix n = new TSMatrix(m.data.length-1,m.getN(),m.getM());//内部创建个新稀疏矩阵用来接收转置并作为返回值
        int num[] = new int[m.getM()+1];
        int pos[] = new int[m.getN()+1];
        n.setLen(m.getLen());
        if(n.getN() > 0) {
            for(int col = 1;col <= m.getN(); ++col) {
                num[col] = 0;   //数量初始化
            }
            for(int t = 1;t <= m.getLen(); ++t) {
                ++num[m.data[t].getCol()];  // 计数
            }
            pos[1] = 1; //原矩阵第一列位置的元素必定为新三元组的第一个元素（因为新三元组以行升序排列）
            for(int col = 2; col <= m.getN();++col) {
                pos[col] = pos[col - 1] + num[col - 1]; //给原矩阵非1列的元素定位到新三元组里
            }
            for(int p = 1; p <= m.getLen(); ++p) {//进行转置
                int col = m.data[p].getCol();
                int q = pos[col];
                n.data[q].setRow(m.data[p].getCol());
                n.data[q].setCol(m.data[p].getRow());
                n.data[q].setE(m.data[p].getE());
                ++pos[col];
            }
        }
        return n;
    }

    //输出三元组
    public void outputTriple(){
        System.out.println(" r c e");
        for (int i = 1; i <= len; i++){
            System.out.println(data[i].toString());
        }
    }

    //输出矩阵
    public void outputMatrix(){
        /*  此版是对已经排好序的三元组的矩阵进行的输出
        int i = 1;
        for (int row = 1;row <= n; row++){
            for (int col = 1; col <= m; col++) {
                if (i <= len) {
                    if (data[i].getRow() == row && data[i].getCol() == col) {
                        System.out.print(data[i].getE() + "\t");
                        i++;
                    }
                    else {
                        System.out.print(0 + "\t");
                    }
                }
                else {
                    System.out.print(0 + "\t");
                }
            }
            System.out.println();
        }
        */

        //更通用的输出，但是时间复杂度高一些
        for (int row = 1;row <= n; row++){
            for (int col = 1; col <= m; col++) {
                for (int i = 1; i <= len ;i++) {
                    if (data[i].getRow() == row && data[i].getCol() == col) {
                        System.out.print(data[i].getE() + "\t");
                        break;
                    }
                    else {
                        if(i == len) {
                            System.out.print(0 + "\t");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main (String args[]){
        int maxSize,m,n;    //变量声明
        int count;
        Scanner scan = new Scanner(System.in);  //初始化扫描器

        //稀疏矩阵的初始化创建
        System.out.print("请输入稀疏矩阵的最大非零元数，m，n。最大非零元数不得超过m*n：\nmaxSize:");
        maxSize = scan.nextInt();
        System.out.print("m:");
        m = scan.nextInt();
        System.out.print("n:");
        n = scan.nextInt();
        TSMatrix testM = new TSMatrix(maxSize,m,n);

        //稀疏矩阵数据的录入
        System.out.print("请输入稀疏矩阵的非零元数数量，之后将进行非零元的输入\n数量：");
        count = scan.nextInt();
        for (int i = 1 ;i <= count; i++){
            if (testM.getLen() == testM.data.length -1){
                System.out.println("矩阵非零元已满，退出输入");
                break;
            }
            System.out.println("非零元" + i + ":");
            System.out.print("  row:");
            int row = scan.nextInt();
            System.out.print("  col:");
            int col = scan.nextInt();
            System.out.print("  element:");
            int element = scan.nextInt();
            if(testM.insertData(Triple.returnTriple(row,col,element))){
                System.out.println("非零元" + i + "录入成功!\n");
            }
            else {
                System.out.println("非零元" + i + "录入失败，重新录入\n");
                i--;
            }
        }

        //进行转置，前后的矩阵进行对比
        System.out.println("转置前：\n    三元组：");
        testM.outputTriple();
        System.out.println("    矩阵：");
        testM.outputMatrix();

        testM = transposeSMatrix(testM);

        System.out.println("\n\n转置后：\n    三元组：");
        testM.outputTriple();
        System.out.println("    矩阵：");
        testM.outputMatrix();
    }
}

