import java.util.HashMap;

public class MaxFreqNum {
    public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer, Integer> count= new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if(count.containsKey(arr[i])){
        count.put(arr[i], count.get(arr[i])+1);
        continue;
      }
         count.put(arr[i], 1);    
    }
    int max=0;
    int maxFreq=Integer.MIN_VALUE;
    
    for (int i = 0; i < arr.length; i++) {
        if(count.get(arr[i])>max){   //checking count of key with max count
          maxFreq=arr[i];
          max=count.get(arr[i]); //max count
        }
    }
    return maxFreq;
}
    public static void main(String[] args) {
        int arr[]={1,2,2,1};
        System.out.println(maxFrequencyNumber(arr));
    }
}
