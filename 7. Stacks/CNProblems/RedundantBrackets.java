package CNProblems;

import java.util.Scanner;
import java.util.Stack;

public class RedundantBrackets {
    public static boolean checkRedundantBrackets(String expression) {
        //String pe Traverse karenge or sabko stack me store karenge jabtak ')' nhi aata or ye aate hi jabtak pop out
        // karenge jabtak '(' nhi aata or count karenge ki kitne pop out hue, ye count number of elements to braces hai..
        // agar count 0 ya 1 hua toh true nhi toh move on and sabse last me false
		Stack<Character> temp=new Stack<>();
        int count=Integer.MIN_VALUE;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)!=')'){
                temp.push(expression.charAt(i));
            }
            if(expression.charAt(i)==')'){
                if(temp.peek()=='('){
                    return true;
                }
            while(temp.peek()!='('){
                 count++;
                 temp.pop();
            }
            temp.pop();
            if(count==0|| count==1){
                return true;
            }
            
          }
          count=0;
        } 
        return false;
	}
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String input=s.nextLine();
        System.out.println(checkRedundantBrackets(input));
        s.close();
    }
}
