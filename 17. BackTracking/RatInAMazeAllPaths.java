public class RatInAMazeAllPaths {
    public static void ratInAMaze(int[][] maze) {
        int n=maze.length;
        int path[][]=new int[n][n];
        printAllPaths(maze, 0, 0, path);
       
    }

    public static void printAllPaths(int[][] maze, int i, int j, int[][] path) {   // i, j shows current position of rat
        int n=maze.length;
        //checking if i,j cell is valid or not
        if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0|| path[i][j]==1){    //if any exists then maze not valid
              return;
        }
        //include the cell in current path
        path[i][j]=1;
        //destination cell
        if(i==n-1 && j==n-1){  // printing 1 path that we have found
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(path[r][c]+" ");
                }
                System.out.println();
            }
            System.out.println();
            path[i][j]=0;
            return;
        }

        //explore further in all directions
        //top
        printAllPaths(maze, i-1, j, path);
           
        //right
        printAllPaths(maze, i, j+1, path);
        
        //Down
       printAllPaths(maze, i+1, j, path);
        //left
        printAllPaths(maze, i, j-1, path);
        path[i][j]=0;           //after printing one path....we are backtracking i.e. clearing path so we can make another path
    }

    public static void main(String[] args) {
        int[][] maze={{1,1,0},{1,1,0},{1,1,1}};
        ratInAMaze(maze);
        
    }
}
