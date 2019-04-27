package array;

import array.Triple;

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

    //三元组以行排序,这里使用选择排序算法
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
    public boolean TransposeSMatrix(TSMatrix m, TSMatrix n) {
        int num[] = new int[m.getM()+1];
        int pos[] = new int[m.getN()+1];
        n.m = m.getN(); n.n=m.getM(); n.len=m.getLen();
        if(n.getN() > 0) {
            for(int col = 1;col <= m.getN(); ++col) {
                num[col] = 0;
            }
            for(int t = 1;t <= m.getLen(); ++t) {
                ++num[m.data[t].getCol()];
            }
            pos[1] = 1;
            for(int col = 2; col <= m.getN();++col) {
                pos[col] = pos[col - 1] + num[col - 1];
            }
      //……
        }
        return true;
    }

    //输出矩阵
    public void outputMatrix(){

    }

    public static void main (String args[]){
        TSMatrix testM = new TSMatrix(3,3,3);
        testM.insertData(Triple.returnTriple(2,1,1));
        testM.insertData(Triple.returnTriple(1,3,2));

        Triple triples[] = testM.getData();
        System.out.println(triples[1].toString() +  " " + triples[2].toString());

        testM.sortData();
        System.out.println(triples[1].toString() +  " " + triples[2].toString());
    }
}

