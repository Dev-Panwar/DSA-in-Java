package CNProblem;

import java.util.Scanner;

public class MidOfLL {
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
       if(head==null || head.next==null){
        return head;
       }
       LinkedListNode<Integer> slow=head, fast=head;
       while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }
       return slow;
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
        head=midPoint(head);
        System.out.println(head.data);
    }
}
