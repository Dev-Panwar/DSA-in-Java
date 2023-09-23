package PrimsAlgo;

import java.util.Scanner;

public class Graph {
    public static void prims(int [][] adjacencyMatrix){
        int v=adjacencyMatrix.length;  //num of vertices
        boolean visited[]=new boolean[v];
        int weight[]=new int[v];
        int parent[]=new int[v];

        weight[0]=0;
        parent[0]=-1;

        for (int i = 1; i < v; i++) {
            weight[i]=Integer.MAX_VALUE;  //initially adding infinite
        }

        for (int i = 0; i < v; i++) {
            // pick vertex with minimum weight
            int minVertex=findMinVertex(weight,visited);
            visited[minVertex]=true;
            //explore its unvisited neighbors
            for (int j = 0; j < v; j++) {
                if(adjacencyMatrix[minVertex][j]!=0 && !visited[j]){
                    if (adjacencyMatrix[minVertex][j]<weight[j]) { //then only we update
                        weight[j]=adjacencyMatrix[minVertex][j];
                        parent[j]=minVertex;
                    }
                }
            } 
        }
        //print edges of MST //acc to ques. we have to print large vertex first
        for (int i = 1; i < v; i++) {    //because 0 ka distance 0 hai isliye.. or zero ka koi parent nhi
         if(parent[i]<i){
            System.out.println(parent[i]+" "+i+" "+weight[i]);
         }   
         else{
            System.out.println(i+" "+parent[i]+" "+weight[i]);
         }
        }

    }


    private static int findMinVertex(int[] weight, boolean[] visited) {   //regarding weight
       int minVertex=-1; //let
       for (int i = 0; i < weight.length; i++) {
        if(!visited[i] &&( minVertex==-1 || weight[i]<weight[minVertex])){ //initially for -1 weight array will show array out of bounds so we wrote this in or
            minVertex=i;
        }
       }
       return minVertex;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int v=s.nextInt();
        int e=s.nextInt();

        int adjacencyMatrix[][]=new int[v][v];
        
        for (int i = 0; i < e; i++) {
            int v1=s.nextInt();
            int v2=s.nextInt();
            int weight=s.nextInt();
            adjacencyMatrix[v1][v2]=weight;
            adjacencyMatrix[v2][v1]=weight;
        }
        prims(adjacencyMatrix);
        s.close();
    }
}