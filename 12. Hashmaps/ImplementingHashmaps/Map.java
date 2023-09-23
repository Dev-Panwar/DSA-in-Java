package ImplementingHashmaps;

import java.util.ArrayList;

public class Map<K,V> {
    ArrayList<MapNode<K,V>> buckets;
    int size;   // num of entries
    int numBuckets; // size of bucket

    public Map(){
        numBuckets=5;
        buckets=new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            buckets.add(null); //filling bucket initially with null to access any of its index like an array. otherwise every time we put something it will add at 0 then 1 then 2 so on
        }
    }
    
    private int getBucketIndex(K key){  //hash function
         int hashCode=key.hashCode();
         return hashCode % numBuckets;
    }
    
    public int size(){
        return size;
    }
    public V removeKey(K key){
        int bucketIndex=getBucketIndex(key);
        MapNode<K,V>head=buckets.get(bucketIndex);
        MapNode<K,V> prev=null;
        while(head!=null){              
            if (head.key.equals(key)){
                size--;
                if(prev==null){  //agar prev null hoga toh prev.next error dega and iska matlab ye bhi hai ki key LL ke first index pe hi hai toh hum seedha bucket ke uss index ko bolenge ki tu head.next ko point kar.
                    buckets.set(bucketIndex, head.next);
                }
                else{
                    prev.next=head.next;    //it disconnect node from LL 
                }
                return head.value;
            }
            prev=head;
            head=head.next;
        }
        return null;  //no such key
    }
    public V getValue(K key){
        int bucketIndex=getBucketIndex(key);
        MapNode<K,V>head=buckets.get(bucketIndex);
        while(head!=null){              
            if (head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;   //matlab koi key match nhi hui
    }
    public void insert(K key, V value){
        int bucketIndex=getBucketIndex(key);
        MapNode<K,V>head=buckets.get(bucketIndex);
        while(head!=null){               //agar key pehle se present hai
            if (head.key.equals(key)){
                head.value=value;
                return;
            }
            head=head.next;
        }
        //agar key pehle se present nhi hai toh
        head=buckets.get(bucketIndex);  //to restore head after last loop //currently ye null hoga. kyuki koi key hai hi nhi pehle se uss bucket index pe
        MapNode<K,V> newElement=new MapNode<K,V>(key, value);
        size++;
        newElement.next=head;      
        buckets.set(bucketIndex, newElement);  //is step ke baad bucket index is new Element ke head ko indicate karega.
        double LoadFactor=(1.0*size)/numBuckets; // otherwise integer/integer will give integer
        if(LoadFactor>0.7){
            rehash();
        }

    }
     public double loadFactor(){   //temporary function to show user the current load factor
        return (1.0*size)/numBuckets;
     }
    private void rehash() {
        System.out.println("Rehashing: buckets "+ numBuckets+" size "+size);
        ArrayList<MapNode<K,V>> temp=buckets; // purane bucket ko store kardiya
        buckets=new ArrayList<>(); //created new bucket
        for (int i = 0; i < 2*numBuckets; i++) {
            buckets.add(null);
        }
        size=0; //new size
        numBuckets *=2; //doubled the number of buckets
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K,V> head=temp.get(i);
            while(head!=null){
                K key=head.key;
                V value=head.value;
                insert(key, value);
                head=head.next;
            }
        }
    }
}
