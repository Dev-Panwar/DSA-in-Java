// package StackUsingLL;

public class Stack<T> {
      private int size;
     private Node<T> head;

    public Stack() {
        size=0;
        head=null;
    }

    public int getSize() { 
        return size+1;
    }

    public boolean isEmpty() {
        return (size==0);
    }

    public void push(T element) {
        Node<T> temp=head;
        head =new Node<>(element);
        head.next=temp;
        size++;
    }

    public T pop() throws StackEmptyException {
        if(head==null){
            StackEmptyException e= new StackEmptyException();
            throw e;
        }
        T temp=head.data;
        head=head.next;
        return temp;
        
    }

    public T top() throws StackEmptyException {
        if(head==null){
            StackEmptyException e= new StackEmptyException();
            throw e;
        }
        return head.data;
    }
}
