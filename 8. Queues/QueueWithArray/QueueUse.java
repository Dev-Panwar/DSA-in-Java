package QueueWithArray;

public class QueueUse {
    public static void main(String[] args) {
        QueueUsingArray queue=new QueueUsingArray(3);
        for(int i=1;i<=5;i++){
             try {
                queue.enqueue(i);
            } catch (QueueFullException e) {
                // we never reach here for the given loop/condition
            }
        }
        while(!queue.isEmpty()){
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                // we never reach here for the given loop/condition
            }
        }
    }
}
