package Node;

import java.util.Scanner;

public class LinkedListUse {
    // Time Complexity O(n).....Much better
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
    //  Time Complexity O(n2).
    // public static Node<Integer> takeinput(){
    //     Node<Integer> head=null;
    //     Scanner s=new Scanner(System.in);
    //     int data=s.nextInt();
    //     while(data != -1){
    //         Node <Integer> newNode=new Node<Integer>(data);
    //         if(head==null){ // for first node
    //             head=newNode;
    //         }
    //         else{
    //             Node<Integer> temp=head;
    //             while(temp.next !=null){
    //                 temp=temp.next;
    //             }
    //             temp.next=newNode;
    //         }
    //         data=s.nextInt();
    //     }
    //     s.close();
    //     return head;
    // }
    public static void print(Node<Integer> head) {
        while(head != null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node<Integer> head=takeinput();
        print(head);

        // Node<Integer> node1=new Node<Integer>(10);
        // // System.out.println(node1.data);
        // // System.out.println(node1.next);
        // Node<Integer> node2=new Node<Integer>(20);
        // Node<Integer> node3=new Node<Integer>(30);
        // node1.next=node2;
        // node2.next=node3;
        // Node<Integer>head=node1;
        // print(head);
        // print(head);
       
        // System.out.println(node2);
        // System.out.println(node1.next);
    }
}
