package exam.map;

import java.util.Scanner;

public class createAndOutput {

    public static void main (String[] args){
        int v_number;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入顶点数：");
        v_number = scanner.nextInt();
        int[] vertexs = new int[v_number];
        boolean[][] adjMatrix = new boolean[v_number][v_number];

        System.out.println("请输入顶点的值");
        for (int i = 0; i < v_number; i++){
            System.out.print("顶点" + (i+1) +":");
            vertexs[i] = scanner.nextInt();
        }

        System.out.println("请输入各条边（有向）,不存在输入0，存在输入非0整数：");
        for (int i = 0; i < v_number; i++){
            for (int j = 0; j < v_number; j++){
                if (i == j) continue;
                System.out.print("顶点" + (i+1) + " 到 顶点" + (j+1) + ":" );
                if (scanner.nextInt() == 0){
                    adjMatrix[i][j] = false;
                }
                else {
                    adjMatrix[i][j] = true;
                }
            }
        }

        ArrayMap arrayMap = new ArrayMap(vertexs,adjMatrix);
        arrayMap.outputMap();

    }
}
