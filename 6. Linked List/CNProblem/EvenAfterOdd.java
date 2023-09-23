package CNProblem;

import java.util.Scanner;

public class EvenAfterOdd {
    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		if(head==null|| head.next==null){
            return head;
        }
        LinkedListNode<Integer> OddH=null,OddT=null,EvenT=null,EvenH=null;
        // 2 alag list banayenge even and odd k liye.
        while(head!=null){       //saare nodes pe traverse karenge or odd ko odd me or even ko even me daalte jaayenge....
            if(head.data%2==0){
                if(EvenH==null){
                    EvenH=head;
                    EvenT=head;                  
                }
                else{
                    EvenT.next=head;
                    EvenT=head;
                    
                }
            }
            else{
                if(OddH==null){
                    OddH=head;
                    OddT=head;
                    
                }
                else{
                    OddT.next=head;
                    OddT=head;
                }
            }
            head=head.next;
        }
        OddT.next=null;
        EvenT.next=null;
        if(EvenH==null){
           return OddH;
        }
        if(OddH==null){
           return EvenH;
        }
        else{
            OddT.next=null; // dono list ko end karne ke liye ye do steps jaroori hai
           EvenT.next=null;
            OddT.next=EvenH;  // dono ko merge kiya
            return OddH;
        }
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
        head=evenAfterOdd(head);
        print(head);
    }
}
