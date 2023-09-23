public class checkArrayRotation {
    public static int arrayRotateCheck(int[] arr){
     
    	for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]<arr[i]){
                return i+1;
            }
        }
        return 0;
    }
   
}
