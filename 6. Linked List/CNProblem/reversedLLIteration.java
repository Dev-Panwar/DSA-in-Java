package CNProblem;

import java.util.Scanner;

public class reversedLLIteration {
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
    public static void print(LinkedListNode<Integer> head) {
        while(head != null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    public static LinkedListNode<Integer> reversedLLIt(LinkedListNode<Integer>  head) {
        if(head==null || head.next==null){
            return head;
        }
        LinkedListNode<Integer> prev=null,current=head,temp=null;
        while(current!=null){
             temp=current.next;
             current.next=prev; // we have to make backward connections
             prev=current;  // updating prev to current
             current=temp; // updating current
        }
        return prev;
    }
    public static void main(String[] args) {
        LinkedListNode<Integer> head=takeinput();
        head=reversedLLIt(head);
        print(head);
    }
}
