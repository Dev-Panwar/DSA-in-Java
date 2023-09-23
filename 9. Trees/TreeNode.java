import java.util.ArrayList;

public class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children; //saare children array list me store honge

    public TreeNode(T data){
        this.data=data;
        children=new ArrayList<>();
    }
}
