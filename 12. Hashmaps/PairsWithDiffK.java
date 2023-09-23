import java.util.HashMap;

public class PairsWithDiffK {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        if(k==0){
            int val=arr.length;
            return (val*(val-1))/2;
        }
		HashMap<Integer,Integer> map=new HashMap<>();
        int countPairs=0;
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
                continue;
              }
            map.put(arr[i], 1);
        }

        for (int i : arr) {
            if(map.get(i)!=0 && k!=0){
                 if(map.containsKey(i+k) && map.get(i+k)!=0){
                    countPairs+=map.get(i)*map.get(i+k);
                    map.put(i, 0);
                     continue;
                 }
                 if(map.containsKey(i-k) && map.get(i-k)!=0){
                    countPairs+=map.get(i)*map.get(i-k);
                    map.put(i,0);
                     continue;
                 }
                 
            }
            
        }
        return countPairs;
	}
}
