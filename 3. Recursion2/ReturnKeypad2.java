import java.util.Scanner;

public class ReturnKeypad2 {
    public static String helper(int n){
        if(n==0||n==1){
           String ans="";
           return ans;
        }
        if(n==2){
           String ans="abc";
           return ans;
        }
        if(n==3){
           String ans="def";
           return ans;
        }
        if(n==4){
           String ans="ghi";
           return ans;
        }
        if(n==5){
           String ans="jkl";
           return ans;
        }
        if(n==6){
           String ans="mno";
           return ans;
        }
        
        if(n==7){
           String ans="pqrs";
           return ans;
        }
        if(n==8){
           String ans="tuv";
           return ans;
        }
       
        else{
           String ans="wxyz";
           return ans;
        }
   
   
       }
    public static void printKeypad(int input,String OutputSoFar){
		if(input==0){
           System.out.println(OutputSoFar);
           return;
        }
        String CharAtNum=helper(input%10);
        printKeypad(input/10, CharAtNum.charAt(0)+OutputSoFar);
        printKeypad(input/10, CharAtNum.charAt(1)+OutputSoFar);
        printKeypad(input/10, CharAtNum.charAt(2)+OutputSoFar);
        if(CharAtNum.length()==4){
            printKeypad(input/10, CharAtNum.charAt(3)+OutputSoFar);

        }
		
	}
    public static void printKeypad(int input){
		printKeypad(input,"");
		
	}

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
        s.close();
		printKeypad(input);
	}
}
