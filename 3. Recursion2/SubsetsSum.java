import java.util.Scanner;

public class SubsetsSum {
    public static int[][] subsetsSumK(int input[], int k,int si) {
		if(si>=input.length){
            if(k==0){
                return new int[1][0];
            }
            else{
                return new int[0][0];
            }
        }
        int output1[][]=subsetsSumK(input, k-input[si], si+1);
        int output2[][]=subsetsSumK(input, k, si+1);
        int finalOutput[][]=new int[output1.length+output2.length][];
         int a=0;
        for(int i=0;i<output2.length;i++){
            finalOutput[i]=new int[output2[i].length];
            for(int j=0;j<output2[i].length;j++){
                finalOutput[i][j]=output2[i][j];
            }
           a++;
        }
        for(int i=0;i<output1.length;i++){
            finalOutput[a+i]=new int[output1[i].length+1];
            finalOutput[a+i][0]=input[si];
            for(int j=1;j<=output1[i].length;j++){
                finalOutput[a+i][j]=output1[i][j-1];
            }
        }
        return finalOutput;

	}
    public static int[][] subsetsSumK(int input[], int k) {
		return subsetsSumK(input, k, 0);

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
		int output[][] = subsetsSumK(input, k);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
}
