package CNProblems;

import java.util.Stack;

public class StockSpan {
    public static int[] stockSpan(int[] price) {
       Stack<Integer> stk=new Stack<>();
       int n=price.length;
       int[] output=new int[n];
       
       stk.push(0);
       output[0]=1;

       for(int i=1;i<n;++i){
        while(!stk.isEmpty() && price[stk.peek()]< price[i]){
            stk.pop();
        }
        if(stk.isEmpty()){
            output[i]=i+1;
        }
        else{
            output[i]=i-stk.peek();
        }
        stk.push(i);
       }
       return output;
	}
    public static void main(String[] args) {
        int input[]={100,80,60,70,60,75,85};
        int ans[]=stockSpan(input);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
}
