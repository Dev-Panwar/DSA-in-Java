package CNProblem;

import java.util.Scanner;

public class ReverseLL {
    public static void printReverse(LinkedListNode<Integer> root) {
		LinkedListNode<Integer> temp=root;
        
        if(temp==null){
            return;
        }
        
        printReverse(temp.next);
        System.out.print(temp.data+" ");
        

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
        LinkedListNode<Integer> head=takeinput();
        printReverse(head);
    }
}
