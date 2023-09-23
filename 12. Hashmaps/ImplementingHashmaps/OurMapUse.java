package ImplementingHashmaps;

public class OurMapUse {
    public static void main(String[] args) {
        Map<String, Integer> map=new Map<>();
        for (int i = 0; i < 20; i++) {
            map.insert("abc"+i, 1+i);  //inserting like abc1,abc2,abc3...... with values 1,2,3,4,.....
            System.out.println("i = "+i+" if = "+ map.loadFactor());

        }
        map.removeKey("abc3");
        map.removeKey("abc5");
        
        for (int i = 0; i < 20; i++) {
            System.out.println("abc"+i+":"+map.getValue("abc"+i));
        }
    }
}
