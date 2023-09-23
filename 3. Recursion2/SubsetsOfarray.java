import java.util.Scanner;

public class SubsetsOfarray {
    public static int[][] subsets(int input[]) {
		return subsets(input, 0);
	}
    public static int[][] subsets(int input[], int si) {
        if(si>=input.length){
            int ans[][]=new int[1][0]; //empty 2d array
            return ans;
        }
        // small ans that gives ans using recursion
        int smallAns[][]=subsets(input,si+1);
        // ans array that has length 2x of small ans as it contain all elements of small ans and all elements with first element of input
        int ans[][]=new int[2*smallAns.length][];
        int k=0;
        for(int i=0;i<smallAns.length;i++){
            // Syntax to add/change size of column a particular row.....a 2d array with different number of columns  in each row is called as jagged array
            ans[i]=new int[smallAns[i].length]; //length of column
            for(int j=0;j<smallAns[i].length;j++){
                ans[i][j]=smallAns[i][j]; //copying small ans to ans
                
            }
            k++;
        }

        for(int i=0;i<smallAns.length;i++){
            // increasing number of columns in each row by 1
            ans[k+i]=new int[smallAns[i].length+1];
            // putting 1 in first column of each row after row number k
            ans[k+i][0]=input[si];
            for(int j=1;j<=smallAns[i].length;j++){
                ans[k+i][j]=smallAns[i][j-1]; //copying same elements again at just next index
            }

        }
        return ans;
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
            int output[][] = subsets(input);
            for(int i = 0; i < output.length; i++) {
                for(int j = 0; j < output[i].length; j++) {
                    System.out.print(output[i][j] + " ");
                }
                System.out.println();
            }
        }
	}

