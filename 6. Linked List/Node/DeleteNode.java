package Node;

import java.util.Scanner;

public class DeleteNode {
    public static Node<Integer> takeinput(){
        Node<Integer> head=null, tail=null;
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        while(data != -1){
            Node <Integer> newNode=new Node<Integer>(data);
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
    public static void print(Node<Integer> head) {
        while(head != null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        Node<Integer> temp=head;
        if(temp==null){
            return temp;
        }
        if(pos==0){
            return temp.next;
        }
		int i=0;
        while( temp!=null && i<pos-1 ){
            temp=temp.next;
            i++;
        }
        if(temp==null){
            return head;
        }
        if(temp.next != null){
        temp.next=temp.next.next;
        }
        return head;
	}
    public static void main(String[] args) {
        Node<Integer> head=takeinput();
        head=deleteNode(head, 3);
        print(head);
    }
}
