import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTheTicket {
    public static int buyTicket(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<input.length;i++){
            queue.add(i);
            pq.add(input[i]);
        }
        int time=0;
        while (!queue.isEmpty()){    //jab tak logon ki line khatam nhi ho jaati
            if (input[queue.peek()] < pq.peek()){    //agar line me sabse aage wala line me sabse bda nhi hai
                queue.add(queue.poll());             //toh aage wale ko line me sabse pichhe bhej  denge
            }
            else{                                    //line me aage wala sabse bada hai
                int idx = queue.poll();               //sabse aage wala
                pq.remove();
                time++;
                if (idx == k)             //sabse aage wala bada hai or wohi aadmi hai jiske liye hum time nikal rahe hain
                {
                    break;
                }
            }
        }
        return time;
	}
}

