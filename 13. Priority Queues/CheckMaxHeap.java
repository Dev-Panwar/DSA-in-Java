import java.util.Collections;
import java.util.PriorityQueue;

public class CheckMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); //max heap pq
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if(pq.remove()!=arr[i]){
                 return false;
            }
        }
        return true;
	}
}
