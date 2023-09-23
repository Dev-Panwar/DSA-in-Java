package CNProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseFirstKElements {
   
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        int size=input.size();
        Stack<Integer> stack=new Stack<>();
        for(int i=1;i<=k;i++){
            stack.push(input.poll());
        }
        for(int i=1;i<=k;i++){
            input.add(stack.pop());
        }
        for(int i=1; i<=size-k;i++){
             input.add(input.poll());
        }
        return input;
	}

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Queue<Integer> input=new LinkedList<>();
        for(int i=1;i<=5;i++){
             input.add(i);
        }
        int n=input.size();
        input=reverseKElements(input, 3);
        for(int i=0; i < n ;i++){
            System.out.print(input.poll()+" ");
        }
        System.out.println();
        s.close();
    }
}
