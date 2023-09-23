import java.util.Scanner;
public class CheckPallindrome {
    public static boolean isStringPalindrome(String input,int StartIndex,int LastIndex) {
	if(StartIndex==(input.length()-1)/2||StartIndex==LastIndex){
        return true;
    }
    if(input.charAt(StartIndex)!=input.charAt(LastIndex)){
       return false; 
    }
    boolean ans=isStringPalindrome(input,StartIndex+1,LastIndex-1);
    return ans;
	}
    public static boolean isStringPalindrome(String input) {
        boolean ans=isStringPalindrome(input,0,input.length()-1);
        return ans;
    }

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
        s.close();
		System.out.println(isStringPalindrome(input));
	}
}
