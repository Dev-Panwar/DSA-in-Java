package CNProblem.CircularSinglyLL;

import java.util.Scanner;

public class CircularSinglyLL {
    public static LinkedListNode<Integer> takeinput() {
        LinkedListNode<Integer> head=null,tail=null;
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        while(data!=-1){
            LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(data);
            if(head==null){
                head=newNode;
                tail=newNode;
            }
            else{
                tail.next=newNode;
                tail=newNode;
            }
            data=s.nextInt();
        }
        tail.next=head;
        s.close();
        return head;
    }
    public static void print(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp=head;
        while(temp.next!=head){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedListNode<Integer> head=takeinput();
        print(head);
    }
}
