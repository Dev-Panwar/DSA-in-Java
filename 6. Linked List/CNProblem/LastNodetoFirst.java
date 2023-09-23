package CNProblem;

import java.util.Scanner;

public class LastNodetoFirst {
    public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		LinkedListNode<Integer> temp=head;
		LinkedListNode<Integer> savehead=head;
        if(temp==null || n==0){
            return head;
        }
        int count=1;
        while(temp.next!=null){ 
            temp=temp.next;
            count++;
        }
        LinkedListNode <Integer> tail=temp; //tail of old list
        temp=head;
        int StartIndex=count-n; //for new LL
        int i=0;
        while(i<StartIndex-1){ // to reach index just before start index 
            temp=temp.next;
            i++;
        }
        head=temp.next; //head of new list
        temp.next=null; //to end the list otherwise print infinite times
        tail.next=savehead; //at last connecting tail of old LL to Old Head of old LL 
        return head;
        
	}
    public static void print(LinkedListNode<Integer> head) {
        while(head != null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
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
        head=appendLastNToFirst(head, 3);
        print(head);

        
    }
}
