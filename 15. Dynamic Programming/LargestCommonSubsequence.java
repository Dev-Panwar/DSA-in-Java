public class LargestCommonSubsequence {
    public static int LCS(String s, String t){
         if(s.length()==0 || t.length()==0){
            return 0;
         }

         if(s.charAt(0)==t.charAt(0)){
            return 1+LCS(s.substring(1), t.substring(1));
         }
         else{
            int op1=LCS(s, t.substring(1));
            int op2=LCS(s.substring(1), t);
            // int op3=LCS(s.substring(1), t.substring(1));   //we can actually skip op3 because....when doing dry run we found that ultimately op1 and op2 does the job for op3 three also.
            return Math.max(op1,op2);
         }

    }

    public static int LCSM(String s, String t){
        int storage[][]=new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            for (int j = 0; j < t.length()+1; j++) {
                storage[i][j]=-1;
            }
        }
        return LCSM(s, t, storage);
    }
    private static int LCSM(String s, String t, int[][] storage) {
        int m=s.length();
        int n=t.length();
        if(storage[m][n]!=-1){
            return storage[m][n];
        }
        if( m==0 || n==0 ){
            storage[m][n]=0;
            return storage[m][n];
         }
         if(s.charAt(0)==t.charAt(0)){
            storage[m][n] = 1+LCSM(s.substring(1), t.substring(1),storage);
         }
         else{
            int op1=LCSM(s, t.substring(1),storage);
            int op2=LCSM(s.substring(1), t,storage);
            // int op3=LCSM(s.substring(1), t.substring(1),storage);   //we can actually skip op3 because....when doing dry run we found that ultimately op1 and op2 does the job for op3 three also.
            storage[m][n]= Math.max(op1, op2);
         }
       return storage[m][n]; 

    }
    public static int LCSDP(String s, String t){
        int m=s.length();
        int n=t.length();
        int storage[][]=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {   //when length of t is 0....making column 0
                storage[i][0]=0;
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {  //when length of s is 0...making row 0
                storage[0][i]=0;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(m-i)==t.charAt(n-j)){
                    storage[i][j]=1+storage[i-1][j-1];
                }
                else{
                    storage[i][j]=Math.max(storage[i][j-1], storage[i-1][j]);
                }
            }
        }
        return storage[m][n];
    }
    public static void main(String[] args) {
        String s="rgehrghgrhegherreredsj";
        String t="erergherghhgrehreeherr";
        System.out.println(LCSDP(s, t));
        System.out.println(LCSM(s, t));   //fast
        System.out.println(LCS(s, t));   //very very slow 
    }
}
