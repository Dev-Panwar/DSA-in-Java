//good question
import java.util.Scanner;
public class AllIndicesOfNum {
    
    public static int[] allIndexes(int input[], int x,int StartIndex) {
		if(StartIndex==input.length){
            return new int[0];
        }
        int smallAns[]=allIndexes(input, x, StartIndex+1);

        if(input[StartIndex]==x){
          int MyAns[]=new int[smallAns.length+1];
          MyAns[0]=StartIndex;
          for(int i=0;i<smallAns.length;i++){
            MyAns[i+1]=smallAns[i];
          }
          return MyAns;
        }
        else{
            return smallAns;
        }

	}

    public static int[] allIndexes(int input[], int x) {
	int Ans[]= allIndexes(input, x, 0);
        return Ans;
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
		int x = s.nextInt();
		int output[] = allIndexes(input, x);
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
}
