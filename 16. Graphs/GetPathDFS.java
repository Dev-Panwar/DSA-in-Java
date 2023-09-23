import java.util.Scanner;
public class GetPathDFS {

    public static void getPathDFS(int[][] adjancyMat, int x1, int x2) {
        // if (hasPath(adjancyMat, x1, x2)) {
            getPathDFS(adjancyMat, x1, x2, new boolean[adjancyMat.length], "");
        // }
    }
    
    public static void getPathDFS(int[][] adjancyMat, int currentIndex, int x2, boolean[] visited,
            String s) {
        visited[currentIndex] = true;
        // result.add(currentIndex);
        if (currentIndex == x2) {
            System.out.println(x2 + " " + s);
            return;
        }
        for (int i = 0; i < adjancyMat.length; i++) {
            if (adjancyMat[currentIndex][i] == 1 && !visited[i]) {
                getPathDFS(adjancyMat, i, x2, visited, currentIndex + " " + s);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] adjancyMat = new int[v][v];
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int l = sc.nextInt();
            adjancyMat[u][l] = 1;
            adjancyMat[l][u] = 1;
        }
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        getPathDFS(adjancyMat, x1, x2);
        sc.close();
        // // System.out.println(path);
        // if (path != null) {
        // for (int i = 0; i < path.size(); i++) {
        // // if (i > 0 && (path.get(i) == x1 || path.get(i) == x2)) {
        // // System.out.print(path.get(i) + " ");
        // // return;
        // // }
        // System.out.print(path.get(i) + " ");
        // }
        // }
    }

}
