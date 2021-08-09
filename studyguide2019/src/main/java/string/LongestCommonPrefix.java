package string;

public class LongestCommonPrefix {


    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = l + (l + r)/2;//Avoiding overflow
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = low + (low + high) / 2; //Avoiding overflow
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }


    public String longestCommonPrefix5(String q, String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Trie trie = new Trie();
        for (int i = 1; i < strs.length ; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }

    class TrieNode {

        // R links to node children
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        // number of children non null links
        private int size;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node; //Calculate the index based on ASCII
            size++;
        }

        public int getLinks() {
            return size;
        }
        //assume methods containsKey, isEnd, get, put are implemented as it is described
        //in  https://leetcode.com/articles/implement-trie-prefix-tree/)

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        //assume methods insert, search, searchPrefix are implemented as it is described
        //in  https://leetcode.com/articles/implement-trie-prefix-tree/)

        public void insert(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }

            TrieNode pointer = root;
            for (int i = 0; i < word.length(); ++i) {
                char cur = word.charAt(i);

                if (!pointer.containsKey(cur)) {
                    pointer.put(cur, new TrieNode());
                }
                pointer = pointer.get(cur);
            }
            pointer.setEnd();
        }


        private String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                    prefix.append(curLetter);
                    node = node.get(curLetter);
                }
                else
                    return prefix.toString();

            }
            return prefix.toString();
        }
    }
}
