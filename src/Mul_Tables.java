public class Mul_Tables {
    public static void main(String args[]){
        for (int i = 1; i <= 9; i++){
        for (int j = 1;j <= 9; j++){
            if(i < j){
                break;
            }
            else {
                System.out.printf("%d*%d=%d\t",j,i*j);
            }
        }
        System.out.println();
    }
}
}
