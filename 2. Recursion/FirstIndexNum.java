import java.util.Scanner;
public class FirstIndexNum {
    public static int firstIndex(int input[], int x, int StartIndex ) {
	  if(StartIndex==input.length){
        return -1;
      }
      if(input[StartIndex]==x){
        return StartIndex;
      }
      int Ans=firstIndex(input, x, StartIndex+1);
      return Ans;
		
	}
    public static int firstIndex(int input[], int x) {
		return firstIndex(input, x, 0);
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
		System.out.println(firstIndex(input, x));
	}
}