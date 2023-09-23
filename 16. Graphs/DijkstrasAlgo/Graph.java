package DijkstrasAlgo;

import java.util.Scanner;

public class Graph {

    public static void Dijkstras(int[][]adjacencyMatrix) {
        int v=adjacencyMatrix.length;  //num of vertices
        boolean visited[]=new boolean[v];
        int distance[]=new int[v];
        distance[0]=0;
        for (int i = 1; i < v; i++) {
            distance[i]=Integer.MAX_VALUE;
        }

        for (int i = 0; i < v-1; i++) {
            // find vertex with min distance
            int minVertex=findMinVertex(distance, visited);
            visited[minVertex]=true;
            // explore neighbors of min vertex
            for (int j = 0; j < v; j++) {
                if(adjacencyMatrix[minVertex][j]!=0 && !visited[j] && distance[minVertex]!=Integer.MAX_VALUE){  //means neighbor hai and unvisited hai and distance infinity nhi hai 
                    int newDist=distance[minVertex]+adjacencyMatrix[minVertex][j];
                    if(newDist<distance[j]){
                        distance[j]=newDist;
                    }
                }
            }

        }
        //printing // printing like vertices and min distance to reach there from source i.e. 0
        for (int i = 0; i < v; i++) {
            System.out.println(i+" "+distance[i]);
        }
    }

    private static int findMinVertex(int[] distance, boolean[] visited) {   //regarding distance
        int minVertex=-1; //let
        for (int i = 0; i < distance.length; i++) {
         if(!visited[i] &&( minVertex==-1 || distance[i]<distance[minVertex])){ //initially for -1 distance array will show array out of bounds so we wrote this in or
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
            int distance=s.nextInt();
            adjacencyMatrix[v1][v2]=distance;
            adjacencyMatrix[v2][v1]=distance;
        }
        Dijkstras(adjacencyMatrix);
        s.close();
    }
}
