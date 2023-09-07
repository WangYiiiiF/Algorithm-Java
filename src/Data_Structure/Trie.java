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

        //加入word
        public void insert(String word){
            if(word == null){
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index, i;
            for(i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        //删除word
        public void delete(String word){
            if(search(word) != 0){
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass--;
                int index, i;
                for(i = 0; i < chs.length; i++){
                    index = chs[i] -'a';
                    if(--node.nexts[index].pass == 0){
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;

            }
        }

        //查询word加入过几次
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index, i;
            for(i = 0; i < chs.length; i++){
                index = chs[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }
    }
}
