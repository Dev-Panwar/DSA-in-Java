import java.util.Scanner;

public class CheckNumber {
    public static boolean checkNumber(int input[], int x){
        if(input.length==0){
            return false;
        }
        if(input[0]==x){
            return true;
        }

        int SmallArray[]=new int[input.length-1];
        for(int i=1;i<input.length;i++){
            SmallArray[i-1]=input[i];
        }
       boolean ans=checkNumber(SmallArray, x);
       return ans;
    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int input[]=new int[n];
        for(int i=0;i<n;i++){
            input[i]=s.nextInt();
        }
        int x=s.nextInt();
        s.close();
        System.out.println(checkNumber(input, x));
    }
}
