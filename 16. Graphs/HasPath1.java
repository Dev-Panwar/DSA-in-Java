import java.util.Scanner;
public class HasPath1 {
    public static boolean HasPathHelper(int edges[][], int v1, int v2, boolean[] visited){
        if(v1>=edges.length || v2>=edges.length){
            return false;
        }
        if(edges[v1][v2]==1 || edges[v2][v1]==1){
            return true;
        }
        visited[v1]=true;
        int n=edges.length;
        for (int i = 0; i < n; i++) { //poore edges ghumega
           if(edges[v1][i]==1 && !visited[i]){
               boolean ans=HasPathHelper(edges, i, v2, visited);
               if(ans==true){
                return true;
               }
           }
        }
        return false;
    }
    public static boolean HasPath(int edges[][], int v1, int v2) {
        boolean visited[]=new boolean [edges.length]; // ek row ke corresponding // total rows and columns n* n
        
               return HasPathHelper(edges, v1, v2, visited);

}
    
	public static void main(String[] args) {
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
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
        int v1=s.nextInt();
        int v2=s.nextInt();
        System.out.println(HasPath(edges,v1,v2));
        s.close();
	}
}
