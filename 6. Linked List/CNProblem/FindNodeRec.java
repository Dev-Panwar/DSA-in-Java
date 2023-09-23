package CNProblem;

import java.util.Scanner;

public class FindNodeRec {
    public static int findNodeRec(LinkedListNode<Integer> head, int n) {
    	return findNodeRec1(head, n, 0);
	}

	public static int findNodeRec1(LinkedListNode<Integer> head, int n, int count) {
    	if(head==null){
            return -1;
        }
        if(head.data==n){
            return count;
        }
        
        int ans=findNodeRec1(head.next, n, count=count+1);
        return ans;
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
        int index=findNodeRec(head, 4);
        System.out.println(index);
    }
}
