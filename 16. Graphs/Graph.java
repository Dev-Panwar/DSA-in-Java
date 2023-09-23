import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Graph {
      //DFS (Depth first Search) traversal print
    public static  void  printDFSHelper(int edges[][], int sv, boolean visited[]) {  //sv= starting vertex
         System.out.println(sv);
         visited[sv]=true;
         int n=edges.length;
         for (int i = 0; i < n; i++) { //poore edges ghumega
            if(edges[sv][i]==1 && !visited[i]){
                printDFSHelper(edges, i, visited);
            }
         }
    }

    public static void printDFS(int edges[][]){
        boolean visited[]=new boolean [edges.length]; // ek row ke corresponding // total rows and columns n* n
        for (int i = 0; i < edges.length; i++) {
            if(!visited[i]){
                printDFSHelper(edges, i, visited);
            }
        }

    }

    public static void printBFS(int edges[][]){
        boolean visited[]=new boolean [edges.length]; // ek row ke corresponding // total rows and columns n* n
        for (int i = 0; i < edges.length; i++) {
            if(!visited[i]){
                printBFSHelper(edges, i, visited);
            }
        }
    }
    
    public static void printBFSHelper(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> q= new LinkedList<>();
        q.add(sv);  // adding starting vertex to queue
        int n=edges.length;
        visited[sv]=true;
        
        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.println(front);
            for (int i = 0; i < n; i++) {
                if(edges[front][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(); //no. of vertices
        int e=s.nextInt(); //no. of edges

        int edges[][]=new int [n][n];
        for (int i = 0; i < e; i++) {
            int fv=s.nextInt();
            int sv=s.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;

        }
        System.out.println("DFS");
         printDFS(edges);
         System.out.println("BFS");
         printBFS(edges);
        s.close();
    }
}
