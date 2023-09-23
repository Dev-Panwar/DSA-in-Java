import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void SortKSorted(int arr[], int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        for (; i < k; i++) {    // adding first k positions.
            pq.add(arr[i]);   
        }
        for (; i < arr.length; i++) {
            arr[i-k]= pq.remove();       // it insert till n-k position in array
            pq.add(arr[i]);              //removed 1 so adding 1...because we want lowest of k elements.
        }
        for (int j = arr.length-k; j < arr.length; j++) {    // for remaining elements 
            arr[j]=pq.remove();
        }
    }

    public static void main(String[] args) {
        int arr[]={2,4,1,9,6,8};
        int k=3;
        SortKSorted(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
