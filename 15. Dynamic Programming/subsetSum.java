public class subsetSum {
    static boolean isSubsetPresent(int[] arr, int n, int sum) {

        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */

        boolean[][] dp=new boolean[n+1][sum+1];
            for(int i=0;i<=n;i++)
            {
                dp[i][0]=true;
            }
        for(int i=1;i<=sum;i++)
        {
            dp[0][i]=false;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(j<arr[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        boolean result=dp[n][sum];
        return result;
    }
}
