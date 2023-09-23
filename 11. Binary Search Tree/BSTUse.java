import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// import java.util.LinkedList;

public class BSTUse {
    
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root==null){
            return false;
        }
        if(root.data==k){
           return true;
        }
        if(k>root.data){
            boolean ans=searchInBST(root.right, k);
            if(ans==true){
                return true;
            }
        }
        else{
            boolean ans=searchInBST(root.left, k);
            if(ans==true){
                return true;
            }
        }
        return false;
	}
    public static int maximum(BinaryTreeNode<Integer>root) {
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
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
    public static int minimum(BinaryTreeNode<Integer>root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }
    public static boolean isBST(BinaryTreeNode<Integer> root) {    //O(n*h)
        if(root==null){
            return true;
        }
        int leftMax=maximum(root.left);
        int rightMin=minimum(root.right);

        if(root.data<=leftMax){
            return false;
        }
        if(root.data>rightMin){
            return false;
        }

        boolean isLeftBST=isBST(root.left);
        boolean isRightBST=isBST(root.right);

        if(isLeftBST&&isRightBST){
            return true;
        }
        else{
            return false;
        }
    }
    public static Triplet<Boolean,Integer,Integer> isBST2(BinaryTreeNode<Integer> root) {   //O(n)
        if(root==null){
            return new Triplet<Boolean,Integer,Integer>(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Triplet<Boolean,Integer,Integer> LeftOutput=isBST2(root.left);
        Triplet<Boolean,Integer,Integer> RightOutput=isBST2(root.right);

        int min=Math.min(root.data, Math.min(LeftOutput.minimum, RightOutput.minimum));
        int max=Math.max(root.data, Math.max(LeftOutput.maximum, RightOutput.maximum));

        boolean isBST= (root.data>LeftOutput.maximum)&&(root.data<=RightOutput.minimum)&&(LeftOutput.isBST&&RightOutput.isBST); //ye saari agar true hogi toh BST me true Jayega warna false;
        return new Triplet<Boolean,Integer,Integer>(isBST, min, max);
    }
    
    public static boolean isBST3(BinaryTreeNode<Integer>root, int min, int max) {    //min and max is range of allowed value for node.....outside this then false
        if(root==null){
            return true;
        }

        if(root.data>max || root.data<min){
            return false;
        }

        boolean isLeftOk=isBST3(root.left, min, root.data-1);
        boolean isRightOk=isBST3(root.right, root.data, max);

        return isLeftOk && isRightOk; //dono true toh true warna false
    }
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
			return SortedArrayToBST(arr, n, 0 , arr.length);
    }
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n,int si, int ei){
              if(si>ei || n==0){
                return new BinaryTreeNode<Integer>(null);
              }
              int mid=(ei-si)/2;
              BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(arr[mid]);
                BinaryTreeNode<Integer> LeftTree=SortedArrayToBST(arr, n, 0,mid-1);
                BinaryTreeNode<Integer> RightTree=SortedArrayToBST(arr, n, mid+1, ei);
                
                root.left=LeftTree;
                root.right=RightTree;
                return root;
    }
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
          return constructLinkedListHelper(root).head;
	}
    public static PairOfNodeElem constructLinkedListHelper(BinaryTreeNode<Integer> root) {
       if(root==null){
        PairOfNodeElem pair=new PairOfNodeElem();
        return pair;
       }

       LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(root.data);
       PairOfNodeElem leftList=constructLinkedListHelper(root.left);
       PairOfNodeElem rightList=constructLinkedListHelper(root.right);
       PairOfNodeElem pair=new PairOfNodeElem();
       if(leftList.tail!=null){
        leftList.tail.next=newNode;
       }
       newNode.next=rightList.head;

       if(leftList.head!=null){
        pair.head=leftList.head;
       }
       else{
        pair.head=newNode;
       }

       if(rightList.tail!=null){
        pair.tail= rightList.tail;
       }
       else{
        pair.tail=newNode;
       }
    return pair;
 
	}
    public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data) {  //finds data path for Binary Tree not BST
        if(root==null){
            return null;
        }
        if(root.data==data){
            ArrayList<Integer> output=new ArrayList<>();
            output.add(root.data);
            return output;
        }
        ArrayList<Integer> LeftOutput=getRootToNodePath(root.left, data);
        if(LeftOutput!=null){
            LeftOutput.add(root.data);
            return LeftOutput;
        }
        ArrayList<Integer> RightOutput=getRootToNodePath(root.right, data);
        if(RightOutput!=null){
            RightOutput.add(root.data);
            return RightOutput;
        }
        else{
            return null;
        }
    }
    static BinaryTreeNode<Integer> getLCAHelper(BinaryTreeNode<Integer> root, int a, int b) {
          if(root==null){
            return null;
          }
          if(root.data==a || root.data==b){
            return root;
          }

          BinaryTreeNode<Integer> LeftLCA= getLCAHelper(root.left, a, b);
          BinaryTreeNode<Integer> RightLCA= getLCAHelper(root.right, a, b);

          if(LeftLCA==null && RightLCA==null){
            return null;
          }
          else if(LeftLCA==null){
            return RightLCA;
          }
          else if(RightLCA==null){
            return LeftLCA;
          }
          else{
            return root;
          }
		
	}
    
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		if(root==null){
            return null;
        }
        if(root.data==data){
            ArrayList<Integer> output=new ArrayList<>();
            output.add(root.data);
            return output;
        }
        if(root.data>data){
        ArrayList<Integer> LeftOutput=getPath(root.left, data);
        if(LeftOutput!=null){
            LeftOutput.add(root.data);
            return LeftOutput;
        }
    }
    if(root.data<data){
    ArrayList<Integer> RightOutput=getPath(root.right, data);
        if(RightOutput!=null){
            RightOutput.add(root.data);
            return RightOutput;
        }
    }

    return null;
}
static void pairSum(BinaryTreeNode<Integer> root, int sum) {
    ArrayList<Integer> output=new ArrayList<>();
    convertToArray(root, output);
    Collections.sort(output);  //function to sort an arraylist;

    int i=0,j=output.size()-1;
    while(i<j){
        if(output.get(i)+output.get(j)==sum){
            //if duplicate elements are present;
            int countI=1,countJ=1;
            // count the number of times the first element is present.
            int k=i+1;
            while(output.get(k)==output.get(i)){
                countI++;
                k++;
            }
             
            // count the number of times 2nd element is present;
            k=j-1;
            while(output.get(k)==output.get(j)){
                countJ++;
            }

            //print the pair count times
            int count=countI*countJ;
            while(count>0){
                System.out.println(output.get(i)+" "+output.get(j));
                count--;
            }
            i+=countI;  //skipping the iteration to save time as we printed already till number of times and elements is present.
            j-=countJ;  
        }
        else if(output.get(i)+ output.get(j)>sum){
            j--;
        }
        else{
            i++;
        }
    }
}

     public static void convertToArray(BinaryTreeNode<Integer> root, ArrayList<Integer> output) {
        if(root==null){
            return;
        }
         output.add((root.data));
         convertToArray(root.left, output);
         convertToArray(root.right, output);
    }
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){ //k1 and k2 inclusive
			if(root==null){
                return;
            }
            int max=Math.max(k1, k2);
            int min=Math.min(k1, k2);
            if(root.data==max || root.data==min){
                System.out.print(root.data+" ");
            }
            if(root.data<max){
                System.out.print(root.data+" ");
                elementsInRangeK1K2(root.right, k1, k2);
            }
            if(root.data>min){
                System.out.print(root.data+" ");
                elementsInRangeK1K2(root.left, k1, k2);
                
            }
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

    public static void main(String[] args) {
      
    }
}
class PairOfNodeElem{

    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
}