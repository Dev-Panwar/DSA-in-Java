import java.util.Scanner;

public class PairStar {
    public static String addStars(String s) {
	  if(s.length()<=1){
        return s;
      }
      if(s.charAt(0)==s.charAt(1)){
        return s.charAt(0)+"*"+addStars(s.substring(1));
      }
      String x=s.charAt(0)+addStars(s.substring(1));
      return x;
    }

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
        s.close();
		System.out.println(addStars(input));
	}
}
