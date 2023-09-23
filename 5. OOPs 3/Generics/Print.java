package Generics;

import final_keyword.Vehicle;

public class Print {
    public static <T extends PrintInterface> void PrintArray(T a[]){
        for(int i=0;i<a.length;i++){
            a[i].print();
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Integer a[]=new Integer[10];
        // for(int i=0;i<10;i++){
        //     a[i]=i+1;
        // }
        // String s[]=new String[10];
        // for(int i=0;i<10;i++){
        //     s[i]="Dev";
        // }
        // PrintArray(a);
        // PrintArray(s);
        Vehicle v[]=new Vehicle[10];
        for(int i=0;i<10;i++){
            v[i]=new Vehicle(10);
        }
        PrintArray(v);
        Student s[]=new Student[10];
        for(int i=0;i<10;i++){
            s[i]=new Student();
        }
        PrintArray(s);
    }
}
