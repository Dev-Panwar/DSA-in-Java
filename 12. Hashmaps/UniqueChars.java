import java.util.HashMap;

public class UniqueChars {
    public static String uniqueChar(String str){
		String output="";
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
                continue;
              }
            map.put(str.charAt(i), 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i))>0){
                output+=str.charAt(i);
                map.put(str.charAt(i), 0);
            }
        }
        return output;
	}
}
