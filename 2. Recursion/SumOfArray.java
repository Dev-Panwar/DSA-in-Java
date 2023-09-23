import java.util.Scanner;

public class SumOfArray {

    public static int Sum(int input[]){
         if(input.length==0){
             return 0;
         }

         int SmallArray[]=new int[input.length-1];
         for(int i=1;i<input.length;i++){
             SmallArray[i-1]=input[i];
         }

         return input[0]+Sum(SmallArray);
    }
    public static void main(String[] args){
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
       int input[]=new int[n];
       for(int i=0;i<n;i++){
           input[i]=s.nextInt();
       }
       s.close();
       System.out.println(Sum(input));
    }
}
