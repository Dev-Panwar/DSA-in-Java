package CNProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> input) {
        int i;
		if(!input.isEmpty()){
            i=input.poll();
            reverseQueue(input);
            input.add(i);
        }
	}
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Queue<Integer> input=new LinkedList<>();
        for(int i=1;i<=5;i++){
             input.add(i);
        }
        int n=input.size();
        reverseQueue(input);
        for(int i=0; i < n ;i++){
            System.out.println(input.poll()+" ");
        }
        s.close();
    }
}
