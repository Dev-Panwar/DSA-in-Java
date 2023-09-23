public class PrintSubSequences2 {
    public static void PrintSubsequences(String input, String OutputSoFar){
        if(input.length()==0){
            System.out.println(OutputSoFar);
            return;
        }

        // when 1st element is not included in output String
        PrintSubsequences(input.substring(1), OutputSoFar);
        // when 1st element is included in output String
        PrintSubsequences(input.substring(1), OutputSoFar+input.charAt(0));


    }
    public static void PrintSubsequences(String input){
        PrintSubsequences(input, "");
    }

    public static void main(String[] args){
        PrintSubsequences("xyz");
    }
}
