package CNProblem;

import java.util.Scanner;

public class DeleteNodeRec {
    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
    	if(pos==0 && head!=null){ //important
            return head.next;
        }
        if(head==null){ // if LL is empty or Pos > than LL size
            return head;
        }
        head.next=deleteNodeRec(head.next, pos-1);  
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
        head=deleteNodeRec(head, 3);
        print(head);
    }
}
