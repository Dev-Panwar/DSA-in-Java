import java.util.Scanner;

public class BinarySearch { // recursive
    public static int binarySearch(int input[], int element, int si,int ei) {
	if(si>ei){
        return -1;
    }
    int mid=(si+ei)/2;
    if(input[mid]==element){
        return mid;
    }
   else if(input[mid]>element){
    return binarySearch(input, element, si, mid-1);
    }
    else{
        return binarySearch(input, element, mid+1, ei);
    }
	}
    public static int binarySearch(int input[], int element) {
       return binarySearch(input, element,0,input.length-1);
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
		int element = s.nextInt();
		System.out.println(binarySearch(input, element));
	}
}
