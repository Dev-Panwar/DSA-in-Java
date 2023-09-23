import java.util.Scanner;

public class PrintPermutation {
    public static void FindPermutations(String str,String output) {
		if(str.length()==0){
            System.out.println(output);
            return;
        }
        for(int i=0;i<str.length();i++){
            String WeWant=str.substring(0, i)+str.substring(i+1, str.length());
            FindPermutations(WeWant, output+str.charAt(i));
        }

	}
    public static void FindPermutations(String str) {
		FindPermutations(str, "");

	}
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
        s.close();
		FindPermutations(input);
	}
}
