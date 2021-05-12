class Solution {
    private static int[] count(String s) {
        int[] ret = new int[26];
        for(char c : s.toCharArray()) {
            ret[c - 'a'] += 1;
        }
        return ret;
    }
    private static int[] union(int[] c1, int[] c2) {
        int[] ret = new int[26];
        for(int i = 0; i < 26; i++)
            ret[i] = Math.max(c1[i], c2[i]);
        return ret;
    }
    public List<String> wordSubsets(String[] A, String[] B) {
        ArrayList<String> ret = new ArrayList();
        
        int[] union_count = new int[26];
        for(String b: B) {
            int[] cnt = count(b);
            union_count = union(union_count, cnt);
        }
        for(String a: A) {
            int[] cnt = count(a);
            boolean isInclude = true;
            for(int i = 0; i < 26; i++) {
                isInclude = isInclude && union_count[i] <= cnt[i];
            }
            if(isInclude){
                ret.add(a);
            }
        }
        
        return ret;
    }
}