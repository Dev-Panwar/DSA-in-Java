import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<>();
        // By default max capacity is 10 elements but we can edit it by writing capacity in ()
        // Size is the number of elements currently present in array list. So initially size remains 0
        System.out.println("Initial Size is :"+list1.size());
        list1.add(15);
        list1.add(20);
        list1.add(25);
        list1.add(2, 29);
        System.out.println("Current size : " + list1.size());
        System.out.println("Element at index : "+list1.get(2));
        System.out.println("Elements are : ");
        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();
        list1.remove(2);
        list1.set(0, 1); //it replaces current element at given index with new elements without shifting and increasing size
        System.out.println("Elements are : ");

        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();
        System.out.println("Elements are : ");
        // Another way of printing
        for(int elem : list1){
            System.out.print(elem+" ");
        }
        System.out.println();
        System.out.print("index of 1 is ");
        System.out.println(list1.indexOf(1));
        



    }
}
