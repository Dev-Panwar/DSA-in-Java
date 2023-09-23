import java.util.Scanner;

public class test {
    public static void main(String[] args){
     Scanner s=new Scanner(System.in);
     char ch=s.next().charAt(0);
     if(ch>='a'&& ch<='z'){
      System.out.println("Small");
     }
     else if(ch>='A'&&ch<='Z'){
      System.out.println("Capital");
     }
     else{
      System.out.println("-1");
     }
     s.close();

     
    }
}
