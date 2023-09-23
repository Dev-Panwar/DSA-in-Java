import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinPQComparator implements Comparator<Integer>{    // comparator min heap PQ


    public int compare(Integer o1, Integer o2) {                // -1 means same rehne do ...matlab pehle dusre se chhota hai toh rehne do. Comparator ese work karta hai
                                                                // 1 means opposite kardo ....dusre ko pehla kardo
        if(o1<o2){                
            return -1;            
        }
        if(o1>o2){
            return 1;          
        }
        else{
            return 0;
        }
    }
    
}

class MaxPQComparator implements Comparator<Integer>{    // comparator Max heap PQ


    public int compare(Integer o1, Integer o2) {
        if(o1<o2){
            return 1;
        }
        if(o1>o2){
            return -1;
        }
        else{
            return 0;
        }
    }
    
}

class MaxStringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
       if(o1.length()<o2.length()){    
        return 1;
       }
       if(o1.length()>o2.length()){
        return -1;
       }
       else{
        return 0;
       }
    }
    
}
class MinStringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
       if(o1.length()<o2.length()){
        return -1;
       }
       if(o1.length()>o2.length()){
        return 1;
       }
       else{
        return 0;
       }
    }
    
}


public class InbuiltPQ {
    public static void main(String[] args) {
        MinPQComparator minComparator=new MinPQComparator();
        MaxPQComparator maxComparator= new MaxPQComparator();
        MaxStringLengthComparator maxLengthComparator= new MaxStringLengthComparator();
        MinStringLengthComparator minLengthComparator= new MinStringLengthComparator();
          //for Min heap PQ,
        PriorityQueue<Integer> pq=new PriorityQueue<>(minComparator);
        //or
        PriorityQueue<Integer> pq1=new PriorityQueue<>();   //by default comparator store as natural sequence
        
        // for Max heap PQ,
        PriorityQueue<Integer> pq2=new PriorityQueue<>(maxComparator);
        // or
        PriorityQueue<Integer> pq21=new PriorityQueue<>(Collections.reverseOrder());  //reverse of default comparator
         
        // for heap Storing String according to length
        //length max to smaller
        PriorityQueue<String> pq3=new PriorityQueue<>(maxLengthComparator);
        // length small to max
        PriorityQueue<String> pq4=new PriorityQueue<>(minLengthComparator);


        //testing 
        int arr[]={5,1,9,2,0};
        String Array[]={"abcd","abc","ab","a",""};
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            pq1.add(arr[i]);
            pq2.add(arr[i]);
            pq21.add(arr[i]);
        }
        for (int i = 0; i < Array.length; i++) {
            pq3.add(Array[i]);
            pq4.add(Array[i]);
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.remove()+" ");
        }
      System.out.println();
      while (!pq1.isEmpty()) {
        System.out.print(pq1.remove()+" ");
      }
      System.out.println();
      while (!pq2.isEmpty()) {
         System.out.print(pq2.remove()+" ");
      }
      System.out.println();

      while (!pq21.isEmpty()) {
        System.out.print(pq21.remove()+" ");
     }
     System.out.println();

     while (!pq3.isEmpty()) {
        System.out.print(pq3.remove()+" ");
     }
     System.out.println();

     while (!pq4.isEmpty()) {
        System.out.print(pq4.remove()+" ");
     }
     System.out.println();
    }

 }

