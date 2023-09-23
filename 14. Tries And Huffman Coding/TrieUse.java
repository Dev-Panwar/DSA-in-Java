public class TrieUse {
    public static void main(String[] args) {
        Trie t= new Trie();
        t.add("dev");
        t.add("panwar");
        System.out.println(t.search("dev"));
        t.remove("dev");
        System.out.println(t.search("dev"));

    }
}
