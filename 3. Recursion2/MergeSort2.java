import java.util.Scanner;

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


    public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		return arr;
	}
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		
		mergeSort(input,0,input.length-1);
		printArray(input);
	}
	
}


