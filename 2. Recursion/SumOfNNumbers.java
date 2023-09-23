import java.util.Scanner;

public class SumOfNNumbers {
    public static int Sum(int n){
        if(n==1){
            return 1;
        }
        return n+Sum(n-1);
    }

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        s.close();
        System.out.println(Sum(n));
    }
}
