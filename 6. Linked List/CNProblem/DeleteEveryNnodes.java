package CNProblem;

import java.util.Scanner;

public class DeleteEveryNnodes {
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		if(head==null){
            return head;
        }
        if (N==0){
            return head;
        }
        if(M==0){
            return null;
        }
        int count1=1; // count for M elements to skip/keep
        int count2=1;  // count for N elements to delete
        LinkedListNode<Integer> temp1=head, temp2=head;  //temp 1 traversal wale nodes ko rakhna hai hain temp2 walo ko delete 
        while(temp1!=null && temp2!=null){   
            count1=1;
            count2=1;
            while(count1!=M && temp1!=null){   //maintaining count;
                temp1=temp1.next;
                ++count1;
            }
            if(temp1==null){          
                return head;     // temp1 traverse the elements we want to print, so no steps required.
            }
            temp2=temp1.next;     // temp2 will be in continuation to temp1 and we delete/ skip M nodes 
            while(count2!=N && temp2!=null){
                 temp2=temp2.next;
                 ++count2;
            }
            if(temp2==null){
                temp1.next=null; //important... temp2 traverse over the node we don't want in final list so,
                 return head;     //if temp2 becomes null before count, make our temp1.next==null so that compiler not print M elements because after this next command i.e. temp.next=temp2.next will not execute
            }
            temp1.next=temp2.next;  //just next node will be connected to temp1 to disconnect M nodes from list
            temp1=temp2.next;

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
        head=skipMdeleteN(head, 2, 3);
        print(head);
    }
}
