import java.util.Arrays;
import java.util.Scanner;

public class ArrayIntersection {
    public static void intersection(int[] arr1, int[] arr2) {
	   Arrays.sort(arr1);
       Arrays.sort(arr2);
       int i=0, j=0;
       while(i<arr1.length&&j<arr2.length){
            if(arr1[i]==arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j]){
                i++;
            }
            else{
                j++;
            }
       }
	}
    // public static void takeinput(int [] arr){
    //     Scanner s=new Scanner(System.in);
    //     for(int i=0;i<arr.length;i++){
    //         arr[i]=s.nextInt();
    //     }
    //     s.close();
    // }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        for(int i=0;i<test;i++){
             int n1=s.nextInt();
             int arr1[]=new int[n1];
             for(int j=0;j<arr1.length;j++){
                arr1[j]=s.nextInt();
         }
             int n2=s.nextInt();
             int arr2[]=new int[n2];
             for(int j=0;j<arr2.length;j++){
                arr2[j]=s.nextInt();
         }
             intersection(arr1, arr2);
             
        }
        s.close();
    }
}
