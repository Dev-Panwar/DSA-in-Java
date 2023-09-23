package CNProblem;

import java.util.Scanner;

public class ReverseLLRec {
    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
		if(head==null || head.next==null){
            return head;
        }
        LinkedListNode<Integer> reversedTail=head.next; // tail of reversed LL, eg 1->2->3->4 head.next means 2->3->4 sent to recursion and it reversed it as 4->3->2, so 2 is the reversedTail.
        LinkedListNode<Integer> smallHead=reverseLinkedListRec(head.next); // tail of reversed LL, eg 1->2->3->4 head.next means 2->3->4 sent to recursion and it reversed it as 4->3->2, so 2 is the reversedTail.
        reversedTail.next=head;
        head.next=null;
        return smallHead;
	}
    public static DoubleNode reverseLinkedListRec2(LinkedListNode<Integer> head) {
        if(head==null || head.next==null){
            DoubleNode ans=new DoubleNode();
            ans.head=head;
            ans.tail=head;
            return ans;
        }
        DoubleNode smallAns=reverseLinkedListRec2(head.next);
        smallAns.tail.next=head;
        head.next=null;
        
        DoubleNode ans=new DoubleNode();
        ans.head=smallAns.head;
        ans.tail=head;
        return ans;
    }
    public static LinkedListNode<Integer> reverseLinkedListRec3(LinkedListNode<Integer> head) {
		if(head==null || head.next==null){
            return head;
        }
        LinkedListNode<Integer> finalHead=reverseLinkedListRec3(head.next);
        LinkedListNode<Integer> temp=finalHead;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head.next=null;
        return finalHead;
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
    public static void print(LinkedListNode<Integer> head) {
        while(head != null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedListNode<Integer> head=takeinput();
        head=reverseLinkedListRec(head);
        System.out.println("Reversed by reverseLinkedListRec :");
        print(head);

        // head=reverseLinkedListRec3(head);       // for reverseLinkedListRec3 function/ method
        // System.out.println("Reversed by reverseLinkedListRec3 :");
        // print(head); 
        
        // DoubleNode ans=reverseLinkedListRec2(head);  // for reverseLinkedListRec2 function/ method
        // System.out.println("Reversed by reverseLinkedListRec2 :");
        // print(ans.head);
    }


}
 class DoubleNode{
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
 }