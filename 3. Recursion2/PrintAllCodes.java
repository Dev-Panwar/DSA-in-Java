import java.util.Scanner;

public class PrintAllCodes {
    public static char helper(int n){
        return (char)('a'+n-1);
    }
    public static void printAllPossibleCodes(String input,String output) {
		if(input.length()==0){
            System.out.println(output);
            return;
        }
        // for first call
       char firstchar=helper(input.charAt(0)-'0');
       printAllPossibleCodes(input.substring(1),output+firstchar);
       
    //   for 2nd call
     if(input.length()>=2){
        int ch1=input.charAt(0)-'0';
        int ch2=input.charAt(1)-'0';
        int ch3=(10*ch1)+ch2;
        if(ch3>=10&&ch3<=26){
            char first2char=helper(ch3);
            printAllPossibleCodes(input.substring(2),output+first2char);
        }
     }
return;

	}
    public static void printAllPossibleCodes(String input) {
       printAllPossibleCodes(input, "");
	}
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
        s.close();
		printAllPossibleCodes(input);
	}
}
