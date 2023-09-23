public class Subsequences {

    public static String[] findSubsequences(String input){
        if(input.length()==0){
            String ans[]={""};
            return ans;
        }
        String smallAns[]=findSubsequences(input.substring(1));
        String ans[]=new String[2*smallAns.length];
        int k=0;
        for(int i=0;i<smallAns.length;i++){
            ans[i]=smallAns[i];
            k++;
        }
        for(int i=0;i<smallAns.length;i++){
            // ans[i+smallAns.length]=input.charAt(0)+ smallAns[i]; or
            ans[k]=input.charAt(0)+smallAns[i];
            k++;
        }
        return ans;
    }
    public static void main(String[] args){
        String input="xyz";
        String ans[]=findSubsequences(input);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
