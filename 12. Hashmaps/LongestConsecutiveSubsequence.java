import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSubsequence {
    //approach, first is with sorting array then applying loop thats easy.....but we have to do it with Hashmaps
    // first we put elements in hashmap thinking that there is no duplicate, we take a maxStart variable to save our max start, and maxLen
    // then we use a for loop again over array and first check if this element is already in a sequence or not by true/false true means not there in any sequence
    // then we take currStart=arr[i] and currLen=1, and flag=true; and map.put(arr[i],false) to say that this element is already used in a sequence so for loop will not work for it again
    //then make a ahead (7,8,9)variable= arr[i]+1, and loop while(flag==true) and if map.containsAhead, update currLen+1 put ahead=false, and update ahead++ if ahead key not present then flag=0,
    //then again set flag= true do the same for before (7,6,5) elements 
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashMap<Integer, Integer> lenMap = new HashMap<>();
        for (int i=0;i<arr.length;i++)
        {
            map.put(arr[i],true);    //first put all true, we have to ignore duplicates here
        }
        int maxStart=-1,maxLen=0;
        // boolean startCheck=true;
        
        for (int i: arr)
        {
            if (map.get(i))   //when elements is true
            {
                int currStart=i,currLen=1;
                boolean flag=true;
                map.put(i,false);
                
                int ahead=i+1;   //let start is 7 then ahead is 8  
                while(flag)       // for element ahead start
                {
                    if(map.containsKey(ahead))
                    {
                        //System.out.println(ahead+" is included in sequence and status updates to false");
                        currLen=currLen+1;
                        map.put(ahead,false);
                        ahead=ahead+1;
                        //System.out.println("Current length of sequence: "+currLen);
                    }
                    else
                    {
                     	flag=false;   
                    }
                }
               flag=true; 
               int before=i-1;
                while(flag)    //for elements before start
                {
                    if(map.containsKey(before))
                    {
                        //System.out.println(before+" is included in sequence and status updates to false");
                        currLen=currLen+1;
                        currStart=before;
                        map.put(before,false);
                        before=before-1;
                        //System.out.println("Current length of sequence: "+currLen);
                    }
                    else
                    {
                     	flag=false;   
                    }
                }
               
               System.out.println();
               if (currLen>=maxLen)
               {
                   maxLen=currLen;
                   maxStart=currStart;   
                   lenMap.put(maxStart,maxLen); 
               }
            }
            
        }
        
        
        for (int i=0;i<arr.length;i++)
        {
            if (lenMap.containsKey(arr[i]) && lenMap.get(arr[i])>=maxLen)
            {
                maxStart=arr[i];
                maxLen=lenMap.get(arr[i]);
                break;
            }
        }
        output.add(maxStart);   //adding max start
        output.add(maxStart+maxLen-1); //adding last of max subsequence to output
        return output;
    }
}
