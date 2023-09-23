import java.util.Collections;
import java.util.PriorityQueue;
public class KthLargest {
    public static int kthLargest(int n, int[] input, int k) {
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); //max heap pq
        for (int i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }

        for (int i = 1; i < k; i++) {    
            pq.remove();
        }
        return pq.remove();    //i==k
	}
}
