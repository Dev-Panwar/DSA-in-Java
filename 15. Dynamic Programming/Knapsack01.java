public class Knapsack01 {
    public static int knapsack(int []weights, int values[], int maxWeight){
        return knapsack(weights, values, maxWeight, 0);
    }

    private static int knapsack(int[] weights, int[] values, int maxWeight, int i) {
       if(i==weights.length || maxWeight==0){
            return 0;
       }

       if (weights[i]>maxWeight){
        return knapsack(weights, values, maxWeight, i+1);
       }
       else{
             //include this ith item
             int op1=values[i]+knapsack(weights, values, maxWeight-weights[i], i+1);
             // don't include
             int op2=knapsack(weights, values, maxWeight, i+1);
             return Math.max(op1, op2);
       }
    }
    public static int knapsackM(int []weights, int values[], int maxWeight){    //Memoization
          int storage[][]=new int[weights.length+1][maxWeight+1];
          for (int i = 0; i <= weights.length; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                storage[i][j]=-1;
            }
          }
        return knapsackM(weights, values, maxWeight, 0,storage);
    }

    private static int knapsackM(int[] weights, int[] values, int maxWeight, int i, int[][] storage) {
        if(i==weights.length || maxWeight==0){
            storage[i][maxWeight]=0;
            return storage[i][maxWeight];
       }
       if(storage[i][maxWeight]!=-1){
        return storage[i][maxWeight];
       }
       if (weights[i]>maxWeight){
        storage[i][maxWeight] = knapsackM(weights, values, maxWeight, i+1,storage);
        return storage[i][maxWeight];
       }
       else{
             //include this ith item
             int op1=values[i]+knapsackM(weights, values, maxWeight-weights[i], i+1,storage);
             // don't include
             int op2=knapsackM(weights, values, maxWeight, i+1,storage);
             storage[i][maxWeight] = Math.max(op1, op2);
             return storage[i][maxWeight];
       }
    }
    // public static int knapsackDP(int []weights, int values[], int maxWeight){
    //     int m=weights.length;
    //     int n=maxWeight;
    //     int storage[][]=new int [m+1][n+1];
    //     int i=0;
    //     if(i==n){
    //        for (int j = 0; j <= maxWeight; j++) {
    //            storage[i][j]=0;
    //        }
    //     }
    //     for ( i = 1; i <= m; i++) {
    //         for (int j = 0; j <= n; j++) {
    //             if (weights[i]>maxWeight){
    //                 storage[i][j]=storage[i+1][n]
    //                }
    //                else{
    //                      //include this ith item
    //                      int op1=values[i]+knapsack(weights, values, maxWeight-weights[i], i+1);
    //                      // don't include
    //                      int op2=knapsack(weights, values, maxWeight, i+1);
    //                      return Math.max(op1, op2);
    //                }
    //         }
    //     }
    // }

    public static void main(String[] args) {
        int weights[]={6,1,2,4,5,7};
        int values[]={10,5,4,8,6,9};
        int maxWeight=5;
        System.out.println(knapsackM(weights, values, maxWeight));
        System.out.println(knapsack(weights, values, maxWeight));
    }
}
