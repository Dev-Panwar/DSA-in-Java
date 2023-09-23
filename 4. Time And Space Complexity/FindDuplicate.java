import java.util.Scanner;

public class FindDuplicate {
    public static int findDuplicate(int[] arr) {
        int sum=0;
		for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        int n=arr.length;
        int sum2=((n-2)*(n-1))/2;
        int ans=sum-sum2;
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

          ans[i]=findDuplicate(arr);
         
       }
        s.close();
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
