import java.util.Scanner;
public class StringToInt {
    // Method 1
    public static int convertStringToInt(String input){
		if(input.length()==1){
            return input.charAt(0)-'0';
        }
        int temp=convertStringToInt(input.substring(1));
          return (input.charAt(0)-'0')*power(10, input.length()-1)+temp;
	}
    public static int power(int x, int n) {
        if(n==0){
            return 1;
        }
        return x*power(x, n-1);
   }
//    method 1
public static int convertStringToInt2(String input){
    if(input.length()==1){
        return input.charAt(0)-'0';
    }
    int temp=convertStringToInt(input.substring(0, input.length()-1));
    return temp*10+(input.charAt(input.length()-1)-'0');

}
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
        s.close();
		System.out.println(convertStringToInt(input));
        System.out.println(convertStringToInt2(input));
	}
}
