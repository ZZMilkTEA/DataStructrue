package exam.linear;

public class EightQueens {
    private int[] column; //同栏是否有皇后，1表示有
    private int[] rup; //右上至左下是否有皇后
    private int[] lup; //左上至右下是否有皇后
    private int[] queen; //解答
    private int num; //解答编号

    public EightQueens() {
        column = new int[8+1];
        rup = new int[(2*8)+1];
        lup = new int[(2*8)+1];
        for (int i = 1; i <= 8; i++)
            column[i] = 0;
        for (int i = 1; i <= (2*8); i++)
            rup[i] = lup[i] = 0;  //初始定义全部可放置
        queen = new int[8+1];   //初始化皇后数组
    }

    public void backtrack(int i) {
        if (i > 8) {
            showAnswer();   //找到一个解，输出
        } else {
            for (int j = 1; j <= 8; j++) {
                if ((column[j] == 0) && (rup[i+j] == 0) && (lup[i-j+8] == 0)) {
                    //若无皇后
                    queen[i] = j; //放下皇后，设定为占用
                    column[j] = rup[i+j] = lup[i-j+8] = 1;  //设置无法放置的位置
                    backtrack(i+1);  //递归调用
                    column[j] = rup[i+j] = lup[i-j+8] = 0;
                }
            }
        }
    }

    protected void showAnswer() {
        num++;
        System.out.println("\n解答" + num);
        for (int y = 1; y <= 8; y++) {
            for (int x = 1; x <= 8; x++) {
                if(queen[y]==x) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.backtrack(1);
    }
}
