public class selectionsort {
    public static void selectionSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }  
      
}
public static void main(String[] args){
for(int n=10;n<=10000000;n=n*10){
    int arr[]=new int[n];
    for(int i=0;i<arr.length;i++){
        arr[i]=arr.length-i; // array has input 100,99,98,97,......till 0 (bad input)
    }
    long StartTime=System.currentTimeMillis();
    selectionSort(arr);
    long EndTime=System.currentTimeMillis();
    System.out.println("Time by Selection Sort For " + n + " is " + (EndTime-StartTime));


}
} 
}
