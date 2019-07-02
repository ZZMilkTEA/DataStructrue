package exam.map;

import java.util.LinkedList;

public class ArrayMap {
    private int[] vertexs;
    private boolean[][] adjMatrix;

    ArrayMap(){
        vertexs = null;
        adjMatrix = null;
    }

    ArrayMap(int[] vertexs, boolean[][] adjMatrix){
        this.vertexs = vertexs;
        this.adjMatrix = adjMatrix;
    }

    public int locateVertex(int vertex){
        return vertex;
    }

    public int getVertex(int location){
        return vertexs[location];
    }

    public int getFirstAdjVertex(int vertex){
        for (int i = 0; i < adjMatrix[vertex].length; i++){
            if (adjMatrix[vertex][i]){
                return i;
            }
        }
        return -1;
    }
    public LinkedList getAdjVertexs(int vertex){
        LinkedList<Boolean> adjVertexs = new LinkedList<>();
        for (int i = 0; i < adjMatrix[vertex].length; i++){
            if (adjMatrix[vertex][i]){
                adjVertexs.add(adjMatrix[vertex][i]);
            }
        }
        return adjVertexs;
    }

    public int showEdge(boolean adjValue){
        if (adjValue)return 1;
        else return 0;
    }

    public void outputMap(){
        System.out.println("顶点值：");
        for (int i = 0; i < vertexs.length; i++){
            System.out.println("\t顶点" + i +"的值:" + vertexs[i]);
        }

        System.out.print("邻接矩阵：\n  ");
        for (int i = 0; i < vertexs.length; i++){
            System.out.print((i+1) + " ");
        }
        System.out.println();
        for (int i = 0; i < vertexs.length; i++){
            System.out.print((i+1) + " ");
            for (int j = 0; j < vertexs.length; j++){
                System.out.print(showEdge(adjMatrix[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
