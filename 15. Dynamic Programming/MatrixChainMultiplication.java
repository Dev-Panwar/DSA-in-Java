public class MatrixChainMultiplication {
    public static int mcm(int[] p){
		
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
        */
               int  n = p.length;
            int[][] storage = new int[p.length][p.length];
            for(int i =n-1;i>=0;i--) {
                for(int j=0;j<n;j++) {
                    if( i +1 < j ) {
                        int min = Integer.MAX_VALUE;
                        int minIndex = 0;
                        for(int k=i+1;k<j;k++) {
                            int c = storage[i][k] + storage[k][j] + p[i] * p[k] * p[j] ;
                            if(c < min) {
                                min = c;
                                minIndex = k;
                            }
                        }
                        storage[i][j] = min ;
                    }
                }
            }
            return storage[0][n-1];
        }
}
