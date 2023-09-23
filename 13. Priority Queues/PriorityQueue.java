import java.util.ArrayList;

public class PriorityQueue { //Implementation Using Min heap.


    private ArrayList<Integer> heap;

    public PriorityQueue(){
        heap=new ArrayList<>();
    }

    boolean isEmpty(){
        return heap.size()==0;
    }

    int size(){
        return heap.size();
    }

    int getMin() throws PriorityQueueEmptyException{
        if(isEmpty()){
            throw new PriorityQueueEmptyException(); 
        }
        return heap.get(0);
    }

    void insert(int element){
        heap.add(element); //after insertion we doing upward heapify. to follow heap order property. (Min Heap)
        int childIndex=heap.size()-1;
        int parentIndex=(childIndex-1)/2;
       while (childIndex>0) {

        if(heap.get(childIndex)<heap.get(parentIndex)){
            int temp=heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            childIndex=parentIndex;
            parentIndex=(childIndex-1)/2;
        }
        else{
            return;
        }
        }
    }

    int removeMin() throws PriorityQueueEmptyException{
        if(isEmpty()){
            throw new PriorityQueueEmptyException(); 
        }
        int temp=heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int index=0; //jisko compare kar rahe hain
        int minIndex=index;
        int leftChildIndex=1;
        int RightChildIndex=2;

        while (leftChildIndex < heap.size()) {  // agar left child hoga tohi toh ye step karenge....warna koi matlab hi nhi...or humko left to right traverse.
            
            if (heap.get(leftChildIndex)<heap.get(minIndex)) {
                minIndex=leftChildIndex;
            }
            if(RightChildIndex< heap.size() && heap.get(RightChildIndex)<heap.get(minIndex)){   //left ki condition upar check ho chuki hai
                minIndex=RightChildIndex;
            }
            if(minIndex==index){
                break;
            }
            else{
                int temp1=heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp1);
                index=minIndex;
                leftChildIndex=2*index+1;
                RightChildIndex=2*index+2;

            }
        }
         return temp;

    }
}
