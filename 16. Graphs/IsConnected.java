import java.util.Scanner;

public class IsConnected {
    public static  void  IsConnectedHelper(int edges[][], int sv, boolean visited[]) {  //sv= starting vertex
        // System.out.println(sv);
        visited[sv]=true;
        int n=edges.length;
        for (int i = 0; i < n; i++) { //poore edges ghumega
           if(edges[sv][i]==1 && !visited[i]){
               IsConnectedHelper(edges, i, visited);
           }
        }
   }

   public static void IsConnected1(int edges[][]){
       if(edges.length==0){
           System.out.println("true");
           return;
       }
       boolean visited[]=new boolean [edges.length]; // ek row ke corresponding // total rows and columns n* n
         IsConnectedHelper(edges, 0, visited);
           
         for (int i = 0; i < visited.length; i++) {
            if(visited[i]==false){
                System.out.println("false");
                return;
            }
         }
         System.out.println("true");
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
     IsConnected1(edges);
    s.close();
}
}
