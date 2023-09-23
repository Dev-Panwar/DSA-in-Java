public class NthFibonacci {
    public static int fib(int n){      //by recursion
        if(n==0||n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fibM(int n) {       
        int storage[]=new int[n+1];

        for (int i = 0; i < storage.length; i++) {
            storage[i]=-1;
        }

        return fibM(n, storage);
    }

     public static int fibM(int n, int[] storage) {     //by Memoization
       if(n==0|| n==1){
        storage[n]=n;
        return storage[n];
       }

       if(storage[n]!=-1){
        return storage[n];
       }

       storage[n]=fibM(n-1, storage)+fibM(n-2, storage);
       return storage[n];
    }


    public static int fibDP(int n){       //By DP
        int storage[]=new int[n+1];
        storage[0]=0;
        storage[1]=1;

        for (int i = 2; i < storage.length; i++) {
            storage[i]=storage[i-1]+storage[i-2];
        }

        return storage[n];
    }

    public static void main(String[] args) {
        int n=44;
        System.out.println(fibDP(n));   //O(n)
        System.out.println(fibM(n));    //O(n)
        System.out.println(fib(n));   // O(2^n) very slow
    }
}
