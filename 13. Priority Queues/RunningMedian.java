import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void findMedian(int arr[])  {
        
        if(arr.length==0){
            return;
        }
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        //see Aproach in notebook if doubt
        //same approach as said in hint video.
          PriorityQueue<Integer> pqMax=new PriorityQueue<>(Collections.reverseOrder()); //max heap pq.
        PriorityQueue<Integer> pqMin=new PriorityQueue<>();      //min heap pq
        pqMax.add(arr[0]);
        System.out.print(arr[0]+" ");
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<pqMax.peek()){
                pqMax.add(arr[i]);

                if(pqMax.size()>pqMin.size()+1){
                    pqMin.add(pqMax.remove());
                }
            }
            else{
                pqMin.add(arr[i]);
                if(pqMin.size()>pqMax.size()+1){
                    pqMax.add(pqMin.remove());
                }
            }
            int median;
            if((pqMax.size()+pqMin.size())%2==0){
                 median=(pqMax.peek()+pqMin.peek())/2;
            }
            else{
                if(pqMax.size()>pqMin.size()){
                    median=pqMax.peek();
                }
                else{
                    median=pqMin.peek();
                }
            }
            System.out.print(median+" ");
        }
    }
}
