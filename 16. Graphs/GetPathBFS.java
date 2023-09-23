import java.util.*;

public class GetPathBFS {
    public static void main(String[] args){
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
         Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int edges[][]=new int[V][V];
        for(int i=0;i<E;i++){
            int sv=s.nextInt();
            int ev=s.nextInt();
            edges[sv][ev]=1;
            edges[ev][sv]=1;
        }
        int V1=s.nextInt();
        int V2=s.nextInt();
        boolean visited[]=new boolean[V];
        ArrayList<Integer> ans=getPathBFS(edges,visited,V1,V2);
        if(ans!=null){
            for(int elem:ans)
            {
                System.out.print(elem+" ");
            }
        }
        s.close();
    }
    public static ArrayList<Integer> getPathBFS(int[][] edges,boolean[] visited,int V1,int V2){
        //if start and end is same just ass v1 to answer arraylist and return it. 
        if(V1==V2)
        {
            ArrayList<Integer> ans=new ArrayList<Integer>();
            ans.add(V1);
            visited[V1]=true;
            return ans;
        }
        Queue<Integer> q=new LinkedList<Integer>(); //q for all vertices of graphs
        HashMap<Integer,Integer> h=new HashMap<>(); //an integer hashmap to know which the source and destination vertex
        ArrayList<Integer> ans=new ArrayList<>(); //an answer arraylist to store the answer
        q.add(V1); //add the source to the queue
        visited[V1]=true; //mark visited as true
        while(!q.isEmpty() ){
            int first=q.remove();
            for(int i=0;i<edges.length;i++){
                if(edges[first][i]==1 && !visited[i]){
                    visited[i]=true;
                    q.add(i);
                    h.put(i,first); //here we are connecting the start and destination vertex
                    if(i==V2)
                    {    ans.add(i);  //if end vertex matches i put it in arraylist output
                     while(!ans.contains(V1)){ //now we loop through hashmap until we reach the source

                         int b=h.get(i); //give the parent of i
                         ans.add(b); //add the parent to arraylist
                         i=b; //update i to b
                     }
                     return ans;
                    }
                }
            }
        }
        //if no route is found return null
        return null;
	}
}
