public class CheckSorted {
   //method 1 
    public static boolean CheckSorted_1(int input[]){

        if(input.length<=1){
            return true;
        }
       
        int SmallInput[]=new int[input.length-1];
        for(int i=1;i<input.length;i++){
            SmallInput[i-1]=input[i];
        }

        boolean smallAns=CheckSorted_1(SmallInput);
        if(!smallAns){ //not true or false...agar smaller hi true nhi hai toh larger bhi nhi hoga
          return false;
        }
        if(input[0]<=input[1]){ //here when small ans is sorted we check first 2 number of array before saying it is sorted. like input is 2,1,3,6,9 and small is 1,3,6,9
            return true;
        }else{
            return false;
        }
    }
// method 2
public static boolean CheckSorted_2(int input[]){

    if(input.length<=1){
        return true;
    }
   if(input[0]>input[1]){
       return false;
   }

    int SmallInput[]=new int[input.length-1];
    for(int i=1;i<input.length;i++){
        SmallInput[i-1]=input[i];
    }

    boolean smallAns=CheckSorted_2(SmallInput);
      return smallAns; //agar small sorted hai toh ye parent ko true return karega ..isi tarah last me agar true hoga toh true return ho jayega
}
// method 3
public static boolean CheckSortedBetter(int input[], int startIndex){
    // it is just an upgraded version of method 2...here we save space by not creating the array again n again and maintaining start index
    // base case is related to the variable which changes again nd again....like in method 1,2 new array is made so base case is related to its length
    // here base case is related to start index
    if(startIndex>=input.length-1){
        return true;
    }
    if(input[startIndex]>input[startIndex+1]){
        return false;
    }
    boolean Ans=CheckSortedBetter(input, startIndex+1);
    return Ans;
}
    public static void main(String[] args){
        int input[]={2,1,3,6,9};
        System.out.println(CheckSorted_1(input));
        System.out.println(CheckSorted_2(input));
        System.out.println(CheckSortedBetter(input, 0));
    }
}
