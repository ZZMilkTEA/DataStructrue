package array;

public class Triple {
    private int row,col,e;

    Triple(int row,int col,int e){
        this.row = row;
        this.col = col;
        this.e = e;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getE() {
        return e;
    }

    //用来输出元素
    @Override
    public String toString() {
        return  "(" + this.getRow() + "," + this.getCol() + "," + this.getE() + ")";
    }

    public static  Triple returnTriple(int row, int col, int e){
        Triple a = new Triple(row,col,e);
        return a;
    }
}
