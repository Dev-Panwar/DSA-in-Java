import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
public class KSmallestElements {
    public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        for (; i < k; i++) {
            pq.add(input[i]);
        }
        for (i = k; i < input.length; i++) {
            if(input[i]<pq.peek()){
                pq.remove();
                pq.add(input[i]);
            }
        }
        ArrayList<Integer> output=new ArrayList<>();
        for (int j = 0; j < k; j++) {
            output.add(pq.remove());
        }
		return output;

	}
}
