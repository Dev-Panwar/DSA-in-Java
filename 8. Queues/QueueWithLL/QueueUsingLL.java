package QueueWithLL;

public class QueueUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;


    public QueueUsingLL() {
		size=0;
        front=null;
        rear=null;
	}
	
	public int getSize() { 
		return size;
    }

    public boolean isEmpty() { 
    	return(size==0);
    }

    public void enqueue(T data) {
        Node<T> newNode=new Node<T>(data);
        if(size==0){
            rear=newNode;
            front=newNode;
            size++;
        }
        else{
        rear.next=newNode;
        rear=newNode;  
        size++; 
        }
    }

    public T dequeue() throws QueueEmptyException {
    	if(size==0){
            throw new QueueEmptyException();
        }
        
        T temp=front.data;
        front=front.next;
        size--;
        return temp;
    }


    public T front() throws QueueEmptyException {
        if(size==0){
            throw new QueueEmptyException();
        }
    	return front.data;
    }
}
