package CNProblem;

import java.util.Scanner;

public class Merge2SortedLL {
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
       
        LinkedListNode<Integer> l1=head1,l2=head2, current=null,newHead=null;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        while(l1!=null && l2!=null){
            if(newHead==null){
                if(l1.data<=l2.data){
                    newHead=l1;
                    current=l1;
                    l1=l1.next;
                }
                else{
                    newHead=l2;
                    current=l2;
                    l2=l2.next;
                }
            }
            else{
                if(l1.data<=l2.data){
                    current.next=l1; //current element ke next me l1 ko link kiya 
                    current=l1; // fir l1 ko current bna diya
                    l1=l1.next;
                }
                else{
                     current.next=l2;
                        current=l2;
                        l2=l2.next;
                }
            }
        }
        if(l1==null){
            current.next=l2;
        }
        if(l2==null){
            current.next=l1;
        }
        return newHead;


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
        LinkedListNode<Integer> head1=takeinput();
        LinkedListNode<Integer> head2=takeinput();
        LinkedListNode<Integer> finalHead=mergeTwoSortedLinkedLists(head1, head2);
        print(finalHead);
    }
}
