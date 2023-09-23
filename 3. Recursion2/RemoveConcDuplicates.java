import java.util.Scanner;

public class RemoveConcDuplicates {
    public static String removeConsecutiveDuplicates(String s) {
		if(s.length()<=1){
            return s;
        }
        String temp=removeConsecutiveDuplicates(s.substring(1));
        if(s.charAt(0)==temp.charAt(0)){
            return temp;
        }
        else{
            return s.charAt(0)+temp;
        }

	}
    static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
    	String input = s.nextLine();
    	System.out.println(removeConsecutiveDuplicates(input));
    }
}
