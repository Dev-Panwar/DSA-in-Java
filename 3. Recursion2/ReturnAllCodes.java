import java.util.Scanner;

public class ReturnAllCodes {
    public static char helper(int n){
        char ans=(char) ('a'+n-1);
        return ans;
    }
    public static  String[] getCode(String input){
		if(input.length()==0){
            String Ans[]={""};
            return Ans;
        }
        String smallAns[]=getCode(input.substring(1));
        char firstchar=helper(input.charAt(0)-'0');
        for(int i=0;i<smallAns.length;i++){
            smallAns[i]=firstchar+smallAns[i];
        }
       
        String smallAns1[]=new String[0];
        if(input.length()>=2){
            int ch1=input.charAt(0)-'0';
            int ch2=input.charAt(1)-'0';
            int ch3=(ch1*10)+ch2;
            if(ch3>=10&&ch3<=26){
                char first2char=helper(ch3);
                smallAns1=getCode(input.substring(2));
                for(int i=0;i<smallAns1.length;i++){
                    smallAns1[i]=first2char+smallAns1[i];
                }
            }
        }
        String Ans[]=new String[smallAns.length+smallAns1.length];
            int k=0;
            for(int i=0;i<smallAns.length;i++){
                Ans[k]=smallAns[i];
                k++;
            }
        for(int i=0;i<smallAns1.length;i++){
            Ans[k]=smallAns1[i];
            k++;
        }
        return Ans;
		
	}
   
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
        s.close();
		String output[] = getCode(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}
