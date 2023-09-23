package Generics;

public class PairUse {
    public static void main(String[] args) {
        Pair <Integer, String> p1=new Pair<Integer,String>(1, "Dev");
        p1.setSecond("Dev Panwar");
        System.out.println(p1.getSecond());
        int a=10;
        int b=12;
        int c=29;
        Pair<Integer, Integer> Internal=new Pair<>(a,b);
        Pair<Pair<Integer,Integer>,Integer> p3=new Pair<>(Internal, c);
        System.out.println(p3.getSecond()); // c
        System.out.println(p3.getFirst().getFirst());  //a
        System.out.println(p3.getFirst().getSecond()); //b
        

    }
}
