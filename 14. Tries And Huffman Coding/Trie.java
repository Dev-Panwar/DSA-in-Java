import java.util.ArrayList;

class TrieNode{
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data){
        this.data=data;
        this.isTerminating=false;
        children=new TrieNode[26]; //initially all null
        childCount=0;
    }
}

public class Trie{
       private TrieNode root;  //implementing for small alphabets only.

       public Trie(){
        root=new TrieNode('\0');  //fixed root. or start '\0' indicates null character.
       }

       private void add(TrieNode root, String word){
        if(word.length()==0){
            root.isTerminating=true;
            return;
        }
        int childIndex=word.charAt(0)-'a';   //gives the index to which child is to be added, eg 'a'-'a'=0 index 'd'-'a'=3rd index

        TrieNode child=root.children[childIndex];
        if(child==null){    //means uske childrens me esa koi character nhi hai. toh add karenge 
             child=new TrieNode(word.charAt(0));
             root.children[childIndex]=child;
             root.childCount++;
        }
        add(child, word.substring(1)); //we did for 1 letter and recursion will do for remaining. and add to child
           
       }

       public void add(String word){  // function user will see
              add(root, word);
       }

       public boolean search(String word){
          return search(root, word);
       }

    private boolean search(TrieNode root, String word) {
         if(word.length()==0){
            return root.isTerminating;  //agar terminating hai toh true warna false...or yaha takk aaya matlab baaki letters  present hai..par agar ye terminating nhi hai toh false hi hoga 
         }
         int childIndex=word.charAt(0)-'a';
         TrieNode child=root.children[childIndex];
         if(child==null){      //matlab word present nhi hai
            return false;
         }
         return search(child, word.substring(1)); //recursion call
         
    }
    public void remove(String word){
        remove(root,word);
    }

    private void remove(TrieNode root, String word) {
        if(word.length()==0){
            root.isTerminating=false;   //root ko terminating se hata denge...koi uss word ko search nhi kar paayega...ya bol sakte hain remove kardiya
            return;  
         }
         int childIndex=word.charAt(0)-'a';
         TrieNode child=root.children[childIndex];
         if(child==null){      
            return;
         }
         remove(child,word.substring(1));
         //code completed but to save space we perform things below.
         //we can remove child node only if it is non terminating and its num of children is zero
         if(!child.isTerminating && child.childCount==0){
            root.children[childIndex]=null; //deleting node which is not part of any other word and it as end and has no childrens
            child=null;
            root.childCount--;
         }
         //upar wala better hai kyuki hum har baar count nhi karne pad rahe childrens...jab add hote toh childCount ++ hota or delete ke time --
         //or
         //if we are not maintaining child count
        //  if(!child.isTerminating){
        //     int numChild=0;
        //     for (int i = 0; i < 26; i++) {
        //         if(child.children[i]!=null){
        //              numChild++;
        //         }
        //     }
        //     if(numChild==0){
        //         //means we can delete
        //         root.children[childIndex]=null; //deleting node which is not part of any other word and it as end and has no childrens
        //     child=null;
        //     }
        //  }
    }

    public int countWords() {
        return countWords(root);
	}
	
    private int countWords(TrieNode root)
    {
   int count = 0;

   if (root.isTerminating)
       count++;

   for (int i = 0; i < 26; i++) {
       if (root.children[i] != null)
           // you need to save the result of the recursive call
           count += countWords(root.children[i]);
    }
    return count;
    }

    public String reverse(String word) {
		
		String xString="";
		for(int i=word.length()-1;i>=0;i--) {
			xString+=word.charAt(i);
		}
		return xString;
		
	}
	public boolean isPalindromePair(ArrayList<String> words) {
		
		for(int i=0;i<words.size();i++) {
			
			String string = reverse(words.get(i));
			
			Trie suffixTrie = new Trie();
			for(int j=0;j<string.length();j++) {
				suffixTrie.add(string.substring(j));
                suffixTrie.add(string.substring(0,string.length()-j));
                //System.out.println(string.substring(j));
			}
			for(String word : words) {
				if(suffixTrie.search(word)) {
					return true;
				}
			}
			
			
		}
		return false;
		
	}

    public void autoComplete(ArrayList<String> input, String word,String output) {
          
    }
}

