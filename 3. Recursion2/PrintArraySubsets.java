import java.util.Scanner;

public class PrintArraySubsets {
    public static void printSubsets(int input[],int si,int [] output) {
		if(si>=input.length){
            for(int i=0;i<output.length;i++){
           System.out.print(output[i]+" ");
            }
            System.out.println();
            return;
        }
        int [] newOutput=new int[output.length+1];
        for(int i=0;i<output.length;i++){
            newOutput[i]=output[i];
        }
        newOutput[output.length]=input[si];

        printSubsets(input,si+1,output);
       
        printSubsets(input,si+1,newOutput);
        

	}
    public static void printSubsets(int input[]) {
		printSubsets(input, 0, new int[0]);

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
	
	public static void main(String[] args) {
		int[] input = takeInput();
		printSubsets(input);
	}
}
