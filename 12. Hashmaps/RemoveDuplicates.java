import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
    public static ArrayList<Integer> removeDuplicates(int[] input) {
        ArrayList<Integer> output= new ArrayList<>();
        HashMap<Integer, Boolean> seen= new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if(seen.containsKey(input[i])){
                continue;
            }
            output.add(input[i]);
            seen.put(input[i], true);
        }
        return output;
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4,4,4,4,1,1,2,6,7,8,7,8,3,9};
        ArrayList<Integer> output=removeDuplicates(arr);
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i)+" ");
        }
    }
}
