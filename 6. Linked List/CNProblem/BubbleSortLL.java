package CNProblem;

import java.util.Scanner;

public class BubbleSortLL {
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
    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		if(head==null || head.next==null){
            return head;
        }
        for (int i = 0; i < length(head); i++) {
            LinkedListNode<Integer> prev=null,current=head,Next=current.next;
            while(current.next!=null){
                if(current.data > current.next.data){
                    if(prev==null){                   // let
                                                      // prev  curr  Next
                        current.next=Next.next;       //         4 -> 3 -> 2 -> 1
                        Next.next=current;            // after these 2 codes current and next is swapped
                        prev=Next;                    // prev   Next  curr
                        head=prev;                    //         3 ->  4 -> 2 -> 1
                    }                                 // for next iteration, next term becomes previous, and prev becomes head
                                                      // prev   curr  next
                    else{                             //   3 ->  4 -> 2 -> 1
                        Next=current.next;
                        prev.next=current.next;
                        current.next=Next.next;
                        Next.next=current;
                        prev=Next;
                    }
                }
                else{
                    prev=current;
                    current=current.next;
                }
            }
        }
        return head;
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
        head=bubbleSort(head);
        print(head);
    }
}
