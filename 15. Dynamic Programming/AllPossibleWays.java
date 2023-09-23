public class AllPossibleWays { //easy
    public static int allWays(int x, int n) {
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */

        return allWays(x,n,1);
	}
	public static int allWays(int x, int n,int num) {

		int val = x -(int)Math.pow(num,n);
		if(val==0){
			return 1;
		}
		if(val<0){
			return 0;
		}
		return allWays(x,n,num+1)  + allWays(val,n,num+1); 
        
    }
}
