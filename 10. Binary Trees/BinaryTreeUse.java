import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
    public static void printTree(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        String toBePrinted=root.data+" ";
        if(root.left!=null){
            toBePrinted+="L: "+ root.left.data+",";
        }
        if(root.right!=null){
            toBePrinted+="R: "+ root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s=new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();
        System.out.println("Enter Root Data");
        int RootData=s.nextInt();
        if(RootData==-1){
            s.close();
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(RootData);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode=pendingNodes.poll();
            System.out.println("Enter Left Child Of "+ frontNode.data);
            int LeftChild=s.nextInt();
            if(LeftChild!=-1){
                BinaryTreeNode<Integer> child=new BinaryTreeNode<Integer>(LeftChild);
                pendingNodes.add(child);
                frontNode.left=child;
            }
            System.out.println("Enter Right Child Of "+ frontNode.data);
            int RightChild=s.nextInt();
            if(RightChild!=-1){
                BinaryTreeNode<Integer> child=new BinaryTreeNode<Integer>(RightChild);
                pendingNodes.add(child);
                frontNode.right=child;
            }
        }
        s.close();
        return root;

    }
    public static int height(BinaryTreeNode<Integer> root) {
		// if(root==null){
        //     return 0;
        // }
        // int height=1;
        // int LeftHeight=height+height(root.left);
        // int RightHeight=height+height(root.right);
        // if(LeftHeight>RightHeight){
        //     return LeftHeight;
        // }
        // else{
        //     return RightHeight;
        // }
        //upar wala bhi sahi hai
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return 1+Math.max(lh, rh);
	}
    public static int diameter(BinaryTreeNode<Integer> root) { //not best way...much higher time time complexity
        if(root==null){
            return 0;
        }
        int option1=height(root.left)+height(root.right);
        int option2=diameter(root.left);
        int option3=diameter(root.right);
        
        return 1+Math.max(option1, Math.max(option2, option3));
    }
    public static void inOrder(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
       inOrder(root.left);
       System.out.print(root.data+" ");
       inOrder(root.right);
    }
    public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
	}
    public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
	}
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		return buildTreeHelper(preOrder, inOrder, 0, inOrder.length-1, 0, preOrder.length-1);
	}
    public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int[] inOrder, int inS,int inE,int preS, int preE) {
		if(inS>inE){
            return null;
        }  
        int rootData=preOrder[preS];
        BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
        int rootIndex=0;
        for (int i = inS; i <=inE ; i++) {
            if(inOrder[i]==rootData){
               rootIndex=i;
               break;
            }
        }
        if(rootData==-1){
            return null;
        }
        int leftInS=inS;
        int leftInE=rootIndex-1;
        int leftPreS=preS+1;
        int leftPreE=leftInE-leftInS+leftPreS; 
        int rightInS=rootIndex+1;
        int rightInE=inE;
        int rightPreS=leftPreE+1;
        int rightPreE=preE;

        root.left=buildTreeHelper(preOrder, inOrder, leftInS, leftInE, leftPreS, leftPreE);
        root.right=buildTreeHelper(preOrder, inOrder, rightInS, rightInE, rightPreS, rightPreE);
        return root;

	}
    public static BinaryTreeNode<Integer> buildTree1(int[] postOrder, int[] inOrder) {
		return buildTree1Helper(postOrder, inOrder, 0, inOrder.length-1,0, postOrder.length-1);
	}
    public static BinaryTreeNode<Integer> buildTree1Helper(int[] postOrder, int[] inOrder,int inS,int inE, int postS,int postE) {
        if(inS>inE){
            return null;
        }  
        int rootData=postOrder[postE];
        BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(rootData);
        int rootIndex=0;
        for (int i = inS; i <=inE ; i++) {
            if(inOrder[i]==rootData){
               rootIndex=i;
               break;
            }
        }
        if(rootData==-1){
            return null;
        }
        int leftInS=inS;
        int leftInE=rootIndex-1;
        int leftPostS=postS;
        int leftPostE=leftInE-leftInS+leftPostS; 
        int rightInS=rootIndex+1;
        int rightInE=inE;
        int rightPostS=leftPostE+1;
        int rightPostE=postE-1;

        root.left=buildTreeHelper(postOrder, inOrder, leftInS, leftInE, leftPostS, leftPostE);
        root.right=buildTreeHelper(postOrder, inOrder, rightInS, rightInE, rightPostS, rightPostE);
        return root;
	}
    public static Pair<Integer,Integer> diameterBetter(BinaryTreeNode<Integer> root) {  //function for both height and diameter
        if(root == null){
            return new Pair<Integer,Integer>(0, 0);
        }
        Pair<Integer,Integer> lo=diameterBetter(root.left);
        Pair<Integer,Integer> ro=diameterBetter(root.right);
        int height=1+Math.max(lo.height, ro.height);
        int option1=lo.height+ro.height;
        int option2=lo.diameter;
        int option3=ro.diameter;
        int diameter=Math.max(option1, Math.max(option2, option3));
        Pair<Integer,Integer> output=new Pair<Integer,Integer>(height, diameter);
        return output;
    }
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		if(root==null){
            return;    //base case
        }
        BinaryTreeNode<Integer> temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
	}

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> pendingNodes=new LinkedList<>();
        pendingNodes.add(root);
        String toBePrinted;
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> frontNode=pendingNodes.poll();
            toBePrinted=frontNode.data+":L:";
            if(frontNode.left!=null){
                pendingNodes.add(frontNode.left);
                toBePrinted+=frontNode.left.data+",R:";
            }
            else{
                toBePrinted+= -1+",R:";
            }
            if(frontNode.right!=null){
                pendingNodes.add(frontNode.right);
                toBePrinted+=frontNode.right.data;
            }
            else{
                toBePrinted+= -1;
            }
            System.out.println(toBePrinted);
        }
	}
    public static void printLevelWise2(BinaryTreeNode<Integer> root) {
		if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size(); //important step to mark when to move to next line
            while(size--!=0){
                BinaryTreeNode<Integer> frontNode=q.poll();
                System.out.print(frontNode.data+" ");
                if(frontNode.left!=null){
                    q.add(frontNode.left);
                }
                if(frontNode.right!=null){
                    q.add(frontNode.right);
                }
            }
            System.out.println();

        }
	}
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		// Write your code here
             print(root,k,node);
	}
    
    public static int print(BinaryTreeNode<Integer> root,int k,int elem){
        if(root == null){
            return -1;
        }
        
        if(root.data == elem){
            printAtDepthK(root,k);
            return 0;
        }
        
        int ld = print(root.left,k,elem);
        
        int rd;
        if(ld == -1){
            rd = print(root.right,k,elem);
            if(rd == -1){
                return -1;
            }else if(rd + 1 == k){
                System.out.println(root.data+" ");
                return k;
            }else{
                printAtDepthK(root.left,k-rd-2);
                return rd+1;
            }
        }else if(ld + 1 == k){
            System.out.println(root.data+" ");
            return k;
        }else{
            printAtDepthK(root.right,k-ld-2);
            return ld+1;
        }
        
    }
    
    public static void printAtDepthK(BinaryTreeNode<Integer> root,int depth){
        if(root == null){
            return;
        }
        
        if(depth == 0 && root != null){
            System.out.println(root.data+" ");
            return;
        }
        
        printAtDepthK(root.left,depth-1);
        printAtDepthK(root.right,depth-1);
    }
    public static void printLevelWise1(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        queue.add(root.left);
        queue.add(root.right);
        if(queue.peek()!=null){
            System.out.print(queue.poll().data+" ");
        }
        else{
            queue.poll();
            System.out.println();
            queue.add(null);
        }
        if(queue.size()==1 && queue.peek()==null){
            return;
        }
        printLevelWise1(root.left);
        printTree(root.right);
    }
    public static Pair2<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root==null){
            return new Pair2<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Pair2<Integer,Integer> LeftPair=getMinAndMax(root.left);
        Pair2<Integer,Integer> RightPair=getMinAndMax(root.right);

        int minimum=Math.min(root.data, Math.min(LeftPair.minimum, RightPair.minimum));
        int maximum=Math.max(root.data, Math.max(LeftPair.maximum, RightPair.maximum));

        return new Pair2<>(minimum, maximum);
	}
    public static int countNodes(BinaryTreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int ans=1;
        ans+=countNodes(root.left);
        ans+=countNodes(root.right);
        return ans;
    }
   
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        boolean ans;
        ans=isNodePresent(root.left, x);
        if(ans==true){
            return true;
        }
        ans=isNodePresent(root.right, x);
        if(ans==true){
            return true;
        }
        return false;
	}
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root==null){
            return;
        }
        BinaryTreeNode<Integer> duplicate=new BinaryTreeNode<Integer>(root.data);
        BinaryTreeNode<Integer> temp=root.left;
        root.left=duplicate;
        duplicate.left=temp;
        insertDuplicateNode(temp);
        insertDuplicateNode(root.right);

    }
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root==null){
            return;
        }
        if(root.left!=null && root.right==null){
            System.out.print(root.left.data+" ");
        }
        if(root.left==null && root.right!=null){
            System.out.print(root.right.data+" ");
        }
        
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
        
        
	}
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        // Write your code here
        helper(root,k,"");
    }
    private static void helper(BinaryTreeNode<Integer> root,int k,String s){
        if(root==null)
            return;
        if(root.left==null && root.right==null && root.data==k)
        {
            System.out.println(s+root.data);
            return;
        }
        s=s+root.data+" ";
        
        helper(root.left,k-root.data,s);
        helper(root.right,k-root.data,s);
        
    }
    public static BinaryTreeNode<Integer> takeInput(Scanner s) {
        int rootData;
        System.out.println("Enter Root Data");
        rootData=s.nextInt();
        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);

        root.left=takeInput(s);
        root.right=takeInput(s);
        return root;
    }
    public static void main(String[] args) {
        // Scanner s=new Scanner(System.in);
        BinaryTreeNode<Integer> root=takeInputLevelWise();
        printLevelWise(root);
    }
}
class Pair2<T, U> {
    T minimum;
    U maximum;

    public Pair2(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}
