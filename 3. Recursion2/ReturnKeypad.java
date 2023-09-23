import java.util.Scanner;

public class ReturnKeypad {
    public static String helper(int n){
     if(n==0||n==1){
        String ans="";
        return ans;
     }
     if(n==2){
        String ans="abc";
        return ans;
     }
     if(n==3){
        String ans="def";
        return ans;
     }
     if(n==4){
        String ans="ghi";
        return ans;
     }
     if(n==5){
        String ans="jkl";
        return ans;
     }
     if(n==6){
        String ans="mno";
        return ans;
     }
     
     if(n==7){
        String ans="pqrs";
        return ans;
     }
     if(n==8){
        String ans="tuv";
        return ans;
     }
    
     else{
        String ans="wxyz";
        return ans;
     }


    }
    public static String[] keypad(int n){
		if(n==0){
            String ans[]={""};
            return ans;
        }

        String smallAns[]=keypad(n/10);
        String helper=helper(n%10); // to get characters assosiated to respective number
        String ans[]=new String[helper.length()*smallAns.length];
        int count=0;
        for(int i=0;i<smallAns.length;i++){
            for(int j=0;j<helper.length();j++){
                ans[count]=smallAns[i]+helper.charAt(j);
                count++;
            }
        }
        return ans;
	}
    

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
        s.close();
		String output[] = keypad(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}
