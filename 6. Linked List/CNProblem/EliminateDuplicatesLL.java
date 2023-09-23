package CNProblem;

import java.util.Scanner;

public class EliminateDuplicatesLL {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		if(head == null || head.next == null)
            return head;
 
        LinkedListNode<Integer> prev = head;    
        LinkedListNode<Integer> p = head.next;
 
        while(p != null){
            if(p.data.compareTo(prev.data) == 0)//compare non primitive dataType like this not using == (VERY IMPORTANT THING TO NOTE)
            {
                prev.next = p.next;
                p = p.next;
            }
            else{
                prev = p;
                p = p.next; 
            }
        }
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
        head=removeDuplicates(head);
        print(head);

        
    }
}
