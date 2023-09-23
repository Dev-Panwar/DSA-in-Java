package CNProblem;

import java.util.Scanner;

public class PalindromeLL {
    LinkedListNode<Integer> reverse(LinkedListNode<Integer> node)
    {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = node;
        LinkedListNode<Integer> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if(head == null || head.next == null){ 
            return true;
        }
        LinkedListNode<Integer> prev=null, current=head;
        while(current.next!=null){
            prev=current;
            current=current.next;
        }
        if(head.data== current.data){
            prev.next=null;
            return isPalindrome(head.next);
        }
        else{
            return false;
        }
        
        
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
        boolean ans=isPalindrome(head);
        System.out.println(ans);
    }
}
