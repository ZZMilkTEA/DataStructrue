package exam.map;

import java.util.LinkedList;

public class WeightArrayMap {
    private int[] vertexs;
    private Integer[][] adjMatrix;

    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }

    public Integer[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(Integer[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    WeightArrayMap(){
        vertexs = null;
        adjMatrix = null;
    }

    WeightArrayMap(int[] vertexs, Integer[][] adjMatrix){
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
            if (adjMatrix[vertex][i] > 0){
                return i;
            }
        }
        return -1;
    }
    public LinkedList getAdjVertexs(int vertex){
        LinkedList<Integer> adjVertexs = new LinkedList<>();
        for (int i = 0; i < adjMatrix[vertex].length; i++){
            if (adjMatrix[vertex][i] > 0){
                adjVertexs.add(adjMatrix[vertex][i]);
            }
        }
        return adjVertexs;
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
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
