import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {
    public static ArrayList<Integer> kLargest(int input[], int k) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        for (; i < k; i++) {
            pq.add(input[i]);
        }
        for (i = k; i < input.length; i++) {
            if(input[i]>pq.peek()){
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
