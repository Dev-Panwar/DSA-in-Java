import java.util.HashMap;

public class PairSum {
    public static int PairSum1(int[] input, int size) {
		if (size==0){
            return 0;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        // for(int key:input){
        //     if(map.containsKey(key)){
        //     	map.put(key,map.get(key)+1);
        // 	}
        //     else{
        //         map.put(key,1);
        //     }   
        // }
        //or 
        for (int i = 0; i < input.length; i++) {
            if(map.containsKey(input[i])){
                map.put(input[i], map.get(input[i])+1);
                continue;
              }
            map.put(input[i], 1);
        }
        int countPairs=0;
        for (Integer i: map.keySet())
        {
            if (map.containsKey(-i) && i!=0){
            	countPairs=countPairs+(map.get(i)*map.get(-i));  
                map.put(i, 0);
                map.put(-i, 0); 
            }
            
        }

        if (map.containsKey(0)){

            int val=map.get(0);
            countPairs=countPairs+(val*(val-1))/2;
        }
        return countPairs;
	}
}
