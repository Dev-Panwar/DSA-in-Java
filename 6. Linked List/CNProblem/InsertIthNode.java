package CNProblem;

import java.util.Scanner;

public class InsertIthNode {
    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos,int element) {
        if(pos==0){
            LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(element);
            newNode.next=head;
            return newNode;
        }
        if(head==null){
            System.out.println("Pos out of LL Size or LL is null");
            return head;
        }
        head.next=insert(head.next, pos-1, element); // we are forwarding LL from second node onwards so connecting it with first
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
        head=insert(head,5,10);
        print(head);
    }
}
