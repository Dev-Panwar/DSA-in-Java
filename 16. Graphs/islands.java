public class islands {
    public static  void  numConnected(int edges[][], int sv, boolean visited[]) {  //sv= starting vertex
        visited[sv]=true;
        int n=edges.length;
        for (int i = 0; i < n; i++) { //poore edges ghumega
           if(edges[sv][i]==1 && !visited[i]){
               numConnected(edges, i, visited);
           }
        }
   }

   public static int numConnected(int edges[][], int n){
       boolean visited[]=new boolean [edges.length]; // ek row ke corresponding // total rows and columns n* n
       int count=0;
       for (int i = 0; i < edges.length; i++) {
           if(!visited[i]){
               numConnected(edges, i, visited);
               count++;
           }
       }
             return count;
   }
}
