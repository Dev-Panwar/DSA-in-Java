import java.util.Scanner;

public class PrintSubsetSumK {
    public static void printSubsetsSumTok(int input[], int k,int []output,int si) {
		if(si>=input.length){
            if(k==0){
                for(int i=0;i<output.length;i++){
                    System.out.print(output[i]+" ");
                }
                System.out.println();
                return;
            }
            else{
                return;
            }
        }
        int newOutput[]=new int[output.length+1];
        for(int i=0;i<output.length;i++){
            newOutput[i]=output[i];
        }
		newOutput[output.length]=input[si];
        printSubsetsSumTok(input, k, output, si+1);
        printSubsetsSumTok(input, k-input[si], newOutput, si+1);
	}
    public static void printSubsetsSumTok(int input[], int k) {
		printSubsetsSumTok(input, k, new int[0], 0);
	}
    static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		printSubsetsSumTok(input, k);
	}
}
