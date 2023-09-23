package Kruskals;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int source;
    int dest;
    int weight;
    @Override
    public int compareTo(Edge o) {
       return this.weight - o.weight; //for ascending    //if want descending then o.weight - this.weight 
    }

    
}

public class Graphs {
    
    public static int findParent(int v, int parent[]) { //to get parent of a vertex
        if(parent[v]==v){
            return v;
        }
        return findParent(parent[v], parent);
        
    }
    public static void Kruskals(Edge input[], int n) {
        Arrays.sort(input);  //input is of type Edge..which is user defined so we used comparable in edge class
        Edge[] output=new Edge[n-1];

        int parent[]=new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }

        int count=0;
        int i=0;
        while (count!=n-1) {  //Edges in MST=n-1
            Edge currentEdge=input[i];   

            int sourceParent=findParent(currentEdge.source, parent);   //parent of V1
            int destParent=findParent(currentEdge.dest, parent);     //parent of V2

            if(sourceParent != destParent){       //to make sure there is no cycle....is is find union Algo
                output[count]=currentEdge;
                count++;
                parent[sourceParent]=destParent;
            }
            i++;
        }
        for (int j = 0; j < n-1; j++) {
            if(output[j].source<output[j].dest){     //question's demand to print like this
                System.out.println(output[j].source+" "+output[j].dest+" "+output[j].weight);
            }
            else{
                System.out.println(output[j].dest+" "+output[j].source+" "+output[j].weight);
            }
        }

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();  //vertices
        int E=s.nextInt();  // num edges

        Edge input[]=new Edge[E]; //Size of Edge array....initially all indexes null
        for (int i = 0; i < E; i++) {
            input[i]=new Edge(); //we have to call constructor for every edge...as all are different
            input[i].source=s.nextInt();
            input[i].dest=s.nextInt();
            input[i].weight=s.nextInt();
        }
        Kruskals(input, n);
        s.close();
    }
}
