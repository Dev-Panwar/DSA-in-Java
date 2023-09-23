import java.util.HashMap;

public class PrintIntersection {
    public static void printIntersection(int[] arr1,int[] arr2){
		HashMap<Integer,Integer> first= new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            if(first.containsKey(arr1[i])){
                first.put(arr1[i], first.get(arr1[i])+1);
                continue;
              }
            first.put(arr1[i], 1);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(first.containsKey(arr2[i])){
                if(first.get(arr2[i])!=0){
                    System.out.println(arr2[i]);
                    first.put(arr2[i], first.get(arr2[i])-1);
                }
            }
            continue;
        }
	}
    
}
