import java.util.HashMap;
import java.util.Set;

public class MapUse {    //using inbuilt maps
    public static void main(String[] args) {
        HashMap<String, Integer> map= new HashMap<>();
        // to insert value, if we add a value we a key that (key) if already exists then prev one deleted and new created
        map.put("Dev", 1);
        map.put("abc", 2);
        map.put("cd", 5);

        // size
        System.out.println("Size is "+ map.size());

        // check presence

        if(map.containsKey("Dev")){
            //to get value
            System.out.println("Value corresponding to Dev is "+ map.get("Dev"));
        }
        if(map.containsKey("xyz")){
            System.out.println("xyz is present");
        }
         //right way is writing like this because if it is present then only we are asking else without this and we are asking the value for unavailable key then we receive null pointer exception
        if(map.containsKey("abc")){
            int v=map.get("abc");
            System.out.println(v);
        }
          // to remove
        map.remove("cd");
        
        // expensive function O(n) (This function is accessed by value so it need to traverse all ), all other functions are O(1) which we access by keys
        
        if(map.containsValue(1)){
            System.out.println("1");
        }

        // traverse keys

        Set<String>keys= map.keySet();
        for (String str : keys) {
            System.out.print(str+" ");
        }

    }
}
