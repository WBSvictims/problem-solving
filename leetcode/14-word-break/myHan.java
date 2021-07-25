class Solution {
    private static class Trie {
        public boolean isEnd;
        public Trie[] nxt;
        Trie() {
            this.isEnd = false;
            this.nxt = new Trie[0x100];
        }
    }
    private static void addToTrie(Trie trie, char[] s) {
        Trie cur = trie;
        for(char ch: s) {
            if(cur.nxt[ch] == null) cur.nxt[ch] = new Trie();
            cur = cur.nxt[ch];
        }
        cur.isEnd = true;
    }
    private static List<Integer> findCandidates(Trie trie, char[] s, int offset) {
        Trie cur = trie;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = offset; i < s.length; i++) {
            char ch = s[i];
            if(cur.nxt[ch] == null) return ret;
            cur = cur.nxt[ch];
            if(cur.isEnd) ret.add(i+1);
        }
        return ret;
    }
    private static boolean isAvailable(char[] s, Trie trie, boolean[] memoization, boolean[] isAlready, int i) {
        if(isAlready[i]) return memoization[i];
        if(i == s.length) {
            isAlready[i] = true;
            memoization[i] = true;
            return true;
        }
        
        isAlready[i] = true;
        memoization[i] = findCandidates(trie, s, i)
            .stream()
            .map(j -> isAvailable(s, trie, memoization, isAlready, j))
            .anyMatch(res -> res);
        
        return memoization[i];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        wordDict.forEach(word -> addToTrie(trie, word.toCharArray()));
        return isAvailable(s.toCharArray(), trie, new boolean[s.length()+1], new boolean[s.length()+1], 0);
    }
}