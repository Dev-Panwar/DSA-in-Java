import java.util.Scanner;

public class QuickSort {
    public static int partition(int[] input,int si,int ei){
       int pivot=input[si];
       int count=0;
       for(int i=si+1;i<=ei;i++){
        if(input[i]<=pivot){
            count++;
        }
       }
       int pivotpos=si+count;
       input[si]=input[pivotpos];
       input[pivotpos]=pivot;

       while(si<pivotpos&&ei>pivotpos){
          if(input[si]<=pivot){
            si++;
          }
          else if(input[ei]>pivot){
            ei--;
          }
          else{
            int temp=input[si];
            input[si]=input[ei];
            input[ei]=temp;
          }
       }
       return pivotpos;
    }
    public static void quickSort(int[] input, int si, int ei) {
        if(si>=ei){
            return;
        }
        int pivotpos=partition(input, si, ei);
        quickSort(input, si, pivotpos-1);
        quickSort(input, pivotpos+1, ei);
    }

    public static void quickSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}
