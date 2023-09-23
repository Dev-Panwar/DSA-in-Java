// package StackUsingLL;

public class StackUse {
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack <Integer>();
        for(int i=1;i<=5;i++){
            stack.push(i); //if(size==length) then push throws StackFullException and main not catching it so it also throws
        }

        while(!stack.isEmpty()){    
            try {
                System.out.println(stack.pop());
             } 
             catch (StackEmptyException e) { //thrown by pop when size==0
                // we never reach here for while(!stack.isEmpty)
            }
        }
        
    }
}
