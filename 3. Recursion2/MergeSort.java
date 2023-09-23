import java.util.Scanner;

public class MergeSort {
	public static void merge(int[] p1,int[] p2, int[] input){
       int a=p1.length;
	   int b=p2.length;
	   int[] ans=new int[a+b];
	   int i=0;
	   int j=0;
	   int k=0;

	   while(i<a&&j<b){
		if(p1[i]<=p2[j]){
			ans[k]=p1[i];
			i++;
			k++;
		}
		else if(p1[i]>p2[j]){
			ans[k]=p2[j];
			j++;
			k++;
		}

		}
		while(i<a){
			ans[k]=p1[i];
			i++;
			k++;
		}
		while(j<b){
			ans[k]=p2[j];
			j++;
			k++;
		}
		// important step....as this is void function.....to reflect ans in original input this is must
		for(i=0;i<ans.length;i++){
			input[i]=ans[i];
		}

	   }


	
    public static void mergeSort(int[] input){
		if(input.length<=1){
			return;
		}
		int mid=input.length/2;
		int[] p1=new int[mid];
		int[] p2=new int[input.length-p1.length];
		for(int i=0;i<p1.length;i++){
			p1[i]=input[i];
		}
		int a=0;
		for(int i=mid;i<input.length;i++){
           p2[a]=input[i];
		   a++;
		}
		mergeSort(p1);
		mergeSort(p2);
	    merge(p1, p2, input);
		

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
		
		mergeSort(input);
		printArray(input);
	}
	
}
