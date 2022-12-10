package main.com.ljg.leetcode;

public class LC208 {
    class Trie {

        Trie[] tChilds;
        boolean isEnd;

        public Trie() {
            tChilds = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (t.tChilds[index] == null) {
                    t.tChilds[index] = new Trie();
                }
                t = t.tChilds[index];
            }
            t.isEnd = true;
        }

        public boolean search(String word) {
            Trie t = this;
            int i = 0;
            while (i < word.length()) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (t.tChilds[index] == null || (i == word.length() - 1 && t.tChilds[index].isEnd == false)) {
                    System.out.println(c);
                    return false;
                }
                t = t.tChilds[index];
                i++;
            }
            return true;
        }

        public boolean startsWith(String prefix) {
            Trie t = this;
            int i = 0;
            while (i < prefix.length()) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if (t.tChilds[index] == null) {
                    return false;
                }
                t = t.tChilds[index];
                i++;
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
