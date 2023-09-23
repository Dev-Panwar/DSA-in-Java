package CNProblem;

import java.util.Scanner;

public class Swap2Nodes {
    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		if(i==j){
            return head;
        }
        LinkedListNode <Integer> temp=head, prev=null, p1=null,c1=null,p2=null,c2=null;
        int pos=0;
        while(temp!=null){
            if(pos==i){
                p1=prev;
                c1=temp;
            }
            if(pos==j){
                p2=prev;
                c2=temp;
            }
            prev=temp;
            temp=temp.next;
            ++pos;
        }
        if(p1!=null){
            p1.next=c2;
        }
        else{
            head=c2; // if i==0
        }
        if(p2!=null){
            p2.next=c1; 
        }
        else{
            head=c2; // j==0
        }
        LinkedListNode<Integer> temp1=c2.next;
        c2.next=c1.next;
        c1.next=temp1;
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
        head=swapNodes(head, 2, 4);
        print(head);
    }
}
