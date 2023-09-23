import java.util.Scanner;
public class countZeroes {
    public static int countZerosRec(int input){
		if(input==0){ //just to handle 0 
            return 1;
        }
        if(input<10){ //actual base case
            return 0;
        }
        int zeroes=countZerosRec(input/10);
        if(input%10==0){
           return zeroes=zeroes+1;
        }
        else{
           return zeroes; 
        }
    }
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
        s.close();
		System.out.println(countZerosRec(n));
	}
}
