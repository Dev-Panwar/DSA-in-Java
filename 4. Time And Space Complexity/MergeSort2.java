// import java.util.Scanner;

public class MergeSort2 {
    // merge sort is easier than merge sort2.
    public static void merge(int[] input, int si,int ei){
        int mid=(si+ei)/2;
        int[] ans=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid&&j<=ei){
            if(input[i]<=input[j]){
                ans[k]=input[i];
                i++;
                k++;
            }
            else{
                ans[k]=input[j];
                j++;
                k++;
            }
        }
            while(i<=mid){
                ans[k]=input[i];
                i++;
                k++;
            }
            while(j<=ei){
                ans[k]=input[j];
                j++;
                k++;
             }
             for(int index=0;index<ans.length;index++){
                input[si+index]=ans[index];
             }
    }
    public static void mergeSort(int[] input, int si, int ei){
        if(si>=ei){
            return;
        }
        int mid=(si+ei)/2;
        mergeSort(input, si, mid);
        mergeSort(input, mid+1, ei);
        merge(input, si, ei);
    }


    // public static int[] takeInput() {
	// 	Scanner s = new Scanner(System.in);
	// 	int size = s.nextInt();
	// 	int arr[] = new int[size];
	// 	for (int i = 0; i < size; i++) {
	// 		arr[i] = s.nextInt();
	// 	}
	// 	s.close();
	// 	return arr;
	// }
	
	// public static void printArray(int input[]) {
	// 	for(int i = 0; i < input.length; i++) {
	// 		System.out.print(input[i] + " ");
	// 	}
	// }
	
	public static void main(String[] args) {
		for(int n=10;n<=10000000;n=n*10){
            int arr[]=new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i]=arr.length-i; // array has input 100,99,98,97,......till 0 (bad input)
            }
            long StartTime=System.currentTimeMillis();
            mergeSort(arr, 0, arr.length-1);
            long EndTime=System.currentTimeMillis();
            System.out.println("Time by Merge Sort For " + n + " is " + (EndTime-StartTime));
        }
        
        
	}
	
}


