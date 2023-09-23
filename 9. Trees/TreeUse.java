import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {

    public static TreeNode<Integer> takeinput(Scanner s) {
        int n;
        System.out.println("Enter Next Node data : ");
        n=s.nextInt();
        TreeNode<Integer> root=new TreeNode<Integer>(n);
        System.out.println("Enter number of children for : "+ n);
        int childCount=s.nextInt();
        for(int i=0;i < childCount;i++){
            TreeNode<Integer> child=takeinput(s);
            root.children.add(child);
        }
        return root;
    }
    public static TreeNode<Integer> takeinputLevelWise() {
       Scanner s= new Scanner(System.in);
       System.out.println("Enter root data ");
       int rootData=s.nextInt();
       Queue<TreeNode<Integer>> pendingNodes=new LinkedList<>();
        TreeNode<Integer> root= new TreeNode<Integer>(rootData);
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> frontNode=pendingNodes.poll();
            System.out.println("Enter Number Of children of "+ frontNode.data);
            int numChildren=s.nextInt();
            for (int i = 0; i < numChildren; i++) {
                System.out.println("Enter "+ (i+1) +"th Child of " + frontNode.data);
                int child=s.nextInt();
                TreeNode<Integer> childNode=new TreeNode<Integer>(child);
                frontNode.children.add(childNode);
                pendingNodes.add(childNode);
            }
        } 
        s.close();
        return root;
    }
    public static void printPreOrder(TreeNode<Integer> root){
		if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        for (int i = 0; i < root.children.size(); i++) {
            printPreOrder(root.children.get(i));
        }
	}
     // public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
	// 	if(root==null){
    //         return root;
    //     }
    //     if(root.children.size()==0){
    //         return root;
    //     }
    //     TreeNode<Integer> ans=root;
    //     int sum=root.data;
    //     for (int i = 0; i < root.children.size(); i++) {
    //         sum+=root.children.get(i).data;
    //     }
    //     for (int i = 0; i < root.children.size(); i++) {
    //         TreeNode<Integer> x=maxSumNode(root.children.get(i));
    //         int xSum=x.data;
    //         for (int j = 0; j < x.children.size(); j++) {
    //             xSum+=x.children.get(j).data;
    //         }
    //         if(xSum>sum){
    //             ans=x;
    //         }
    //     }
    //     return ans;
	// }
     //Ya toh upar wala Aproach Karo ya niche wala....Time And Space Complexity niche wale ki achhi hai...
    //upar wale main, for loop me children ke children ka sum wapas se nikalna pad raha hai...jabki recursion uss sum ko nikal chuka hai
    // humne ye mehnat bachane ke liye ek class bna li or return type wo class bna diya...jis se wo x ka ek object ban jaayega and uska sum bhi usme rahega
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
          return maxSumNodeHelper(root).ans;
    }
    //helper
    public static SumNode<Integer> maxSumNodeHelper(TreeNode<Integer> root){
         if(root==null){
            SumNode<Integer> ans=new SumNode<>(null, Integer.MIN_VALUE);
            return ans;
         }
         int sum=root.data;
         for (int i = 0; i < root.children.size(); i++) {
            sum+=root.children.get(i).data;
         }
         SumNode<Integer> ans=new SumNode<>(root, sum);
         for (int i = 0; i < root.children.size(); i++) {
            SumNode<Integer> childAns=maxSumNodeHelper(root.children.get(i));
            if(childAns.sum>sum){
                ans=childAns;
            }
         }
         return ans;
    }
   
    public static void print(TreeNode<Integer> root) {
        String s=root.data +" :";
        for(int i=0; i<root.children.size(); i++){
            s=s+root.children.get(i).data +", ";
        }
        System.out.println(s);
        for(int i=0; i<root.children.size(); i++){
            print(root.children.get(i));
        }
    }
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
            if(root1.data!=root2.data){
                return false;
            }
            if(root1.children.size()!=root2.children.size()){
                return false;
            }
            for (int i = 0; i < root1.children.size(); i++) {
                boolean ans=checkIdentical(root1.children.get(i), root2.children.get(i));
                if(ans==false){
                    return false;
                }
            }
            return true;
	}
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
	        if(root==null){
                return root;
            }
            TreeNode<Integer> max=null;
            if(root.data>n){
                max=root;
            }
            for(int i=0;i<root.children.size();i++){
                TreeNode<Integer> temp= findNextLargerNode(root.children.get(i), n);
                if(temp!=null && temp.data>n){
                    if(max!=null){
                        if(temp.data<max.data){
                            max=temp;
                        }
                    }
                    else{
                        max=temp;
                    }
                }
            }
            return max;
    }
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
           return findSecondLargestHelper(root).secondMax;
	}
    public static RecordMax<Integer> findSecondLargestHelper(TreeNode<Integer> root){
          if(root==null){
            RecordMax<Integer> output=new RecordMax<>(null, null);
            return output;
          }
          RecordMax<Integer> output=new RecordMax<>(root, null);

          for (int i = 0; i < root.children.size(); i++) {
            RecordMax<Integer> childPair=findSecondLargestHelper(root.children.get(i));
            if(childPair.max.data>output.max.data){
                if(childPair.secondMax==null|| childPair.secondMax.data<output.max.data){
                    output.secondMax=output.max;
                    output.max=childPair.max;
                }
                else{
                    output.max=childPair.max;
                    output.secondMax=childPair.secondMax;
                }
            }
            else if(output.max.data!=childPair.max.data && (output.secondMax==null || childPair.max.data> output.secondMax.data)){
                 output.secondMax=childPair.max;
            }
          }
          return output;
	}
    public static void replaceWithDepthValue(TreeNode<Integer> root){
            replaceWithDepthValueHelper(root, 0);		
	}
    public static void replaceWithDepthValueHelper(TreeNode<Integer> root,int depth){
            if(root==null){
                return;
            }
            root.data=depth;
            for (int i = 0; i < root.children.size(); i++) {
                replaceWithDepthValueHelper(root.children.get(i), depth+1);
            }
	}
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
           if(root==null){
            return false;
           }
          if(root.data==x){
            return true;
          }

          for (int i = 0; i < root.children.size(); i++) {
                checkIfContainsX(root.children.get(i), x);
          }
          return true;
          
	}
    public static void printLevelWise(TreeNode<Integer> root) {
        if(root == null)
        {
            return;
        }
        
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-- > 0)
            {
                TreeNode<Integer> node = q.poll();
                System.out.print(node.data+ " ");
                
                for(int i=0;i<node.children.size();i++)
                {
                    q.add(node.children.get(i));
                }  
           }
           System.out.println();            
        }

        
    }
    public static int largest(TreeNode<Integer> root) {
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int ans=root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int childLargest=largest(root.children.get(i));
            if(childLargest>ans){
                ans=childLargest;
            }
        }
        return ans;
    }
    public static int numNodeGreater(TreeNode<Integer> root,int x, int count){	
            if(root==null){
                return 0;
            }

            if(root.data>x){
                count=count+1;
            }
            for (int i = 0; i < root.children.size(); i++) {
                count=numNodeGreater(root.children.get(i), x, count);
            }
            return count;
	}
    public static int sumOfAllNode(TreeNode<Integer> root){
	       if(root==null){
            return 0;
           }
           int sum=root.data;
           for (int i = 0; i < root.children.size(); i++) {
                sum+=sumOfAllNode(root.children.get(i));
           }
           return sum;
	}
    public static int countLeafNodes(TreeNode<Integer> root, int count){
           if(root==null){
            return 0;
           }
           if(root.children.size()==0){
            count = 1;
           }
           for (int i = 0; i < root.children.size(); i++) {
            count = countLeafNodes(root.children.get(i), count);
           }
           return count;

	}
    public static void printAtK(TreeNode<Integer> root, int k) {
        if(k<0){
            return;
        }
        if(k==0){
            System.out.print(root.data);
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            printAtK(root.children.get(i), k-1);
        }
    }
    public static int getHeight(TreeNode<Integer> root){
		if(root==null){
            return 0;
        }
        int temp=0,height=0;
        if(root.children.size()==0){   //agar root ke children nhi honge toh directly 1 return kardenge(height =1 root ki hogi)
            return 1;
        }
        
        for(int i=0;i<root.children.size();i++){
            temp = getHeight(root.children.get(i));
            if(temp>height){
                height=temp;
            }
        }
        return height+1;  // children ki size +1 for connecting to parent.
	}
    public static int NumNodes(TreeNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int count=1;
        for (int i = 0; i < root.children.size(); i++) {
            count+=NumNodes(root.children.get(i));
        }
        return count;
    }
    public static void main(String[] args) {
    //     Scanner s=new Scanner(System.in);
    //    TreeNode<Integer> root=takeinput(s);
       TreeNode<Integer> root=takeinputLevelWise();
    //    printLevelWise(root);
    //    System.out.println(NumNodes(root));
    // System.out.println(sumOfAllNode(root));
    System.out.println(getHeight(root));
    }
}
class SumNode<T>{
    TreeNode<T> ans;
    T sum;
 public SumNode(TreeNode<T> ans, T sum){
    this.ans=ans;
    this.sum=sum;
 }

}
class RecordMax<T>{
    TreeNode<T> max;
    TreeNode<T> secondMax;

    public RecordMax(TreeNode<T> max, TreeNode<T> secondMax){
        this.max=max;
        this.secondMax=secondMax;
    }
}