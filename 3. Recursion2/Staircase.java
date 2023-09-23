import java.util.Scanner;

public class Staircase {
    public static int staircase(int n){
		if(n<0){
          return 0; //base case
        }
      if(n==0){
        return 1; //if 0 stair then only one way...stay there.
      }
      int x=staircase(n-1);
      int y=staircase(n-2);
      int z=staircase(n-3);
       return x+y+z;
    
}

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
        s.close();
		System.out.println(staircase(n));
	}
}
