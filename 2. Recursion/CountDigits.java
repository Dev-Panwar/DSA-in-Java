import java.util.Scanner;
public class CountDigits {
    public static int count(int n){
		if(n==0){
            return 0;
        }
        return 1+count(n/10);
}
public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    s.close();
    System.out.println(count(n));
}
}
