public class BalancedBSTs {
    public static long NumBalancedBSTs(int height,int mod){  //recursion
        if(height==0 || height==1){
            return 1;
        }
        long x=NumBalancedBSTs(height-1, mod);
        long y=NumBalancedBSTs(height-2, mod);
        
        return (x*x+2*x*y)%mod;
    }
     
    public static long NumBalancedBSTs(int height){
          int mod=(int)Math.pow(10, 9)+7;
          return NumBalancedBSTs(height, mod);
    }

    public static long NumBalancedBSTsM(int height){
         long storage[]=new long[height+1];
         for (int i = 0; i < storage.length; i++) {
            storage[i]=-1;
         }
         int mod=(int)Math.pow(10, 9)+7;
         return NumBalancedBSTsM(height, mod,storage);
 
    }
     
    private static long NumBalancedBSTsM(int height, int mod,long storage[]) {  //Memoization
        if(height==0 || height==1){
            storage[height]=1;
            return storage[height];
        }
        long x=NumBalancedBSTsM(height-1, mod,storage);
        long y=NumBalancedBSTsM(height-2, mod,storage);
        storage[height]=(x*x+2*x*y)%mod;
        return storage[height];


    }

    public static long NumBalancedBSTsDP(int height){
         if (height==0){
            return 1;
         }
         long storage[]=new long[height+1];
         storage[0]=storage[1]=1;
         int mod=(int)Math.pow(10, 9)+7;
         for (int i = 2; i <= height; i++) {
            long temp1=(long)(storage[i-1]*storage[i-1]);   // x*x
            temp1=temp1%mod;
            long temp2=(long)(2*(storage[i-1]*storage[i-2]));   // 2*x*y
            temp2=temp2%mod;
            storage[i]=(temp1+temp2)%mod;
         }
         return storage[height];
    }


    public static void main(String[] args) {
        int height=10;
        System.out.println(NumBalancedBSTsDP(height));
        System.out.println(NumBalancedBSTsM(height));
        System.out.println(NumBalancedBSTs(height));
    }
}
