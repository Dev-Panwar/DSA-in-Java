package Node;

import java.util.Scanner;

public class test {
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
   public static void fun(Node <Integer> start)
{
  if(start == null)
    return;
  System.out.print( start.data+" "); 

  if(start.next != null )
    fun(start.next.next);
  System.out.print(start.data+" ");
}
public static void main(String[] args) {
    Node<Integer> head=takeinput();
    fun(head);
}
}
