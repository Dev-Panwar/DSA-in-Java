package CNProblem;

import java.util.Scanner;

public class LLithIndex {
    public static void printIthNode(LinkedListNode<Integer> head, int i){
        LinkedListNode<Integer> temp=head;
		int count=0;
        while(count !=i && temp!= null){
            temp=temp.next;
            count++;
        }
        if(count ==i && temp!=null){
        System.out.println(temp.data);
        }
        
	}
    // public static int length(LinkedListNode<Integer> head){
	// 	LinkedListNode<Integer> temp=head;
    //     if(head==null){
    //         return 0;
    //     }
    //     int count=1; // for running loop there should be atleast 1 node
    //     while(temp.next != null){
    //         count++;
    //         temp=temp.next;
    //     }
    //     return count;
	// }
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
        LinkedListNode<Integer> test=takeinput();
        printIthNode(test, 4);
    }
}
