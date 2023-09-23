package CNProblem;

import java.util.Scanner;

public class LLSize {
    public static int length(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp=head;
        if(head==null){
            return 0;
        }
        int count=1; // for running loop there should be atleast 1 node
        while(temp.next != null){
            count++;
            temp=temp.next;
        }
        return count;
	}
    public static LinkedListNode<Integer> takeinput(){
        LinkedListNode<Integer> head=null, tail=null;
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        while(data != -1){
            LinkedListNode <Integer> newNode=new LinkedListNode<Integer>(data);
            if(head==null){ // for first node
                head=newNode;
                tail=newNode;
            }
            else{
               tail.next=newNode;
               tail=newNode;
               
            }
            data=s.nextInt();
        }
        s.close();
        return head;
    }
    public static void main(String[] args) {
        LinkedListNode<Integer> test=takeinput();
        System.out.println(length(test));
    }
}
