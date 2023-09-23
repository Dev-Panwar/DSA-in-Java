import java.util.Scanner;

public class FindUnique {
    public static int findUnique(int[] arr) {
        int ans=0;
		for(int i=0;i<arr.length;i++){
            ans=ans^arr[i];
        }
        return ans;
	}

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        int ans[]=new int[test];
       for(int i=0;i<test;i++){
            int size=s.nextInt();
            int arr[]=new int[size];
            for(int j=0;j<arr.length;j++){
                arr[j]=s.nextInt();
            }

          ans[i]=findUnique(arr);
         
       }
        s.close();
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}

