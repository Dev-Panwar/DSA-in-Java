package CNProblems;

import java.util.Scanner;
import java.util.Stack;

public class MinBracketReversal {
    public static int countBracketReversals(String input) {
        if(input.length()%2!=0)
        return -1;
    
    Stack<Character> stk=new Stack<>();
    
    for(int i=0;i<input.length();i++)
    {
        if(input.charAt(i)=='{')
        {
            stk.push('{');
        }
        else if(input.charAt(i)=='}')
        {
            if(stk.isEmpty() || stk.peek()=='}')
            {
                stk.push('}');
            }
            else if(stk.peek()=='{')
            {
                stk.pop();
            }

        }}
        int count=0;
        while(stk.size()!=0){
            char c1=stk.pop();
            char c2=stk.pop(); 

            if(c1==c2)
            {
                count++; // if both brackets are same then only one bracket need to reverse..eg {{ to become {} or }} to become {} 
            }

            if(c1!=c2){
                count++;    // }{ to {}
                count++;
            }}
        return count;
	}
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String input=s.nextLine();
        System.out.println(countBracketReversals(input));
        s.close();
    }
}
