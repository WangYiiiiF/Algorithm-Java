package Data_Structure;

public class Trie {

    //前缀树节点描述
    public static class TrieNode{
        public int pass; //经过该点的次数
        public int end; //该点作为尾节点的次数
        public TrieNode[] nexts; //该节点后连接各个的节点数目

        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class trie{
        private TrieNode root;
        public trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for(int i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }
    }
}
