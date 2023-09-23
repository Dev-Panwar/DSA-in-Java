package CNProblem;

import java.util.Scanner;

public class FindNode {
    public static int findNode(LinkedListNode<Integer> head, int n) {
	     LinkedListNode<Integer> temp=head;
         if(temp==null){
            return -1;
         }
         int count = 0;
         while(temp != null){
            if(temp.data==n){
                return count;
            }
            count++;
            temp=temp.next;       
         }
         return -1;
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
        print(head);
        int n=findNode(head, 30);
        System.out.println(n);
    }
}
