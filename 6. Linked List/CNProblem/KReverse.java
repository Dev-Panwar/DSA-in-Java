package CNProblem;

import java.util.Scanner;

public class KReverse {
    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        
        if(k==0||k==1){
            return head;
        }
        
        
        LinkedListNode<Integer> head1=head,tail1=head,head2=null;
        int count=1;
        while(count!=k && tail1.next!=null){
            tail1=tail1.next;
            ++count;
        }
        
        head2=tail1.next;
        tail1.next=null;
        head1=reverseLinkedListRec(head1);
        tail1=head1;
        while(tail1.next!=null){
            tail1=tail1.next;
        }
        tail1.next=kReverse(head2, k);
        return head1;
	}
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
        head=kReverse(head, 2);
        print(head);
    }
}
