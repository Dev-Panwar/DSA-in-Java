public class RatInAMaze {
    
    public static boolean ratInAMaze(int[][] maze) {
        int n=maze.length;
        int path[][]=new int[n][n];
        return solveMaze(maze,0,0,path);
    }

    public static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {   // i, j shows current position of rat
        int n=maze.length;
        //checking if i,j cell is valid or not
        if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0|| path[i][j]==1){    //if any exists then maze not valid
              return false;
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
            return true;
        }

        //explore further in all directions
        //top
        if(solveMaze(maze, i-1, j, path)){
            return true;
        }
        //right
        if(solveMaze(maze, i, j+1, path)){
            return true;
        }
        //Down
        if(solveMaze(maze, i+1, j, path)){
            return true;
        }
        //left
        if(solveMaze(maze, i, j-1, path)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze={{1,1,0},{1,1,0},{1,1,1}};
        boolean pathPossible=ratInAMaze(maze);
        System.out.println(pathPossible);
    }

   
}
