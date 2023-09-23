

public class BinarySearchTree {
    private BinaryTreeNode<Integer> root;

    public  void deleteData(int data) {
       root = deleteDataHelper(data, root);
    }
    
    private BinaryTreeNode<Integer> deleteDataHelper(int data, BinaryTreeNode<Integer> root){
          if(root==null){
            return null;
          }
         if(root.data<data){
            root.left=deleteDataHelper(data, root.left);
            return root;
         }
         else if(data>root.data){
            root.right=deleteDataHelper(data, root.right);
            return root;
         }
         else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                BinaryTreeNode<Integer> minNode=root.right;
                while (minNode.left!=null) {
                    minNode=minNode.left;
                }
                root.data=minNode.data;
                root.right=deleteDataHelper(minNode.data, root.right);
                return root;
            }
         }
    }
    public  void insertData(int data){
        root = insertDataHelper(root, data);
    }
    private BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int data){
            if(root==null){
                BinaryTreeNode<Integer> newRoot=new BinaryTreeNode<Integer>(data);
                return newRoot;
            }
            if(data>root.data){
                root.right = insertDataHelper(root.right, data);
            }
            else{
               root.left = insertDataHelper(root.left, data);
            }
            return root;
    }
    

    public boolean hasData(int data) {
        return hasDataHelper(data, root);
    }
    private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root){
        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }
        else if(data>root.data){
            return hasDataHelper(data, root.right);
        }
        else{
            return hasDataHelper(data, root.left);
        }
    }
    public void print(){
        printTree(root);
    }
    private static void printTree(BinaryTreeNode<Integer> root) {
        if(root==null){
            return;
        }
        String toBePrinted=root.data+":";
        if(root.left!=null){
            toBePrinted+="L:"+ root.left.data+",";
        }
        if(root.right!=null){
            toBePrinted+="R:"+ root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }
}
