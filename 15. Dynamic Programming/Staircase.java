public class Staircase {
    public static long staircase(int n) {
		if(n<0){
          return 0; //base case
        }
      if(n==0){
        return 1; //if 0 stair then only one way...stay there.
      }
      long x=staircase(n-1);
      long y=staircase(n-2);
      long z=staircase(n-3);
       return x+y+z;

	}
    public static long staircaseM(int n) {
        long storage[]=new long[n+1];
        for (int i = 0; i < storage.length; i++) {
            storage[i]=-1;
        }
        return staircaseM(n,storage);
    }
    private static long staircaseM(int n, long[] storage) {
        if(n<0){
            storage[0]=0;
            return storage[0];
        }
        if(n==0){
            storage[n]=1;
            return storage[n];
        }
        if(storage[n]!=-1){
            return storage[n];
        }
        storage[n]=staircaseM(n-1,storage)+staircaseM(n-2,storage)+staircaseM(n-3,storage);
        return storage[n];
    }

    public static long staircaseDP(int n){
        long storage[]=new long[n+1];
        storage[0]=1;
        if(n>0){
            storage[1]=1;   //number of ways for 1 stairs
        }
        if(n>1){
            storage[2]=2;   //number of ways for 2 stairs
        }
        if(n>2){
            storage[3]=4;   //number of ways for 3 stairs    steps pattern ---> 1,1,1 or 1,2 or 2,1 or 3 
        }
        for (int i = 4; i <= n; i++) {
            storage[i]=storage[i-1]+storage[i-2]+storage[i-3];
        } 
         return storage [n];    
     }
 }
