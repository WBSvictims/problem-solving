class Solution {
    private int[] manacher(String s) {
        StringBuilder builder = new StringBuilder();
        for(char ch: s.toCharArray()) {
            builder.append('_');
            builder.append(ch);
        }
        builder.append('_');
        char[] ms = builder.toString().toCharArray();
        int[] ret = new int[ms.length];
        ret[0] = 0;
        for(int i = 1, p = 0; i < ms.length; i++) {
            if(i < ret[p] + p) ret[i] = Math.min(ret[p] + p - i, ret[2 * p - i]);
            while(0 <= i - ret[i] - 1 && i + ret[i] + 1 < ms.length && ms[i - ret[i] - 1] == ms[i + ret[i] + 1]) ret[i]++;
        }
        return ret;
    }
    public boolean checkPartitioning(String s) {
        int[] r = manacher(s);
        boolean[][] memoization = new boolean[s.length()+1][4];
        memoization[0][0] = true;
        for(int i = 1; i <= s.length(); i++) {
            int j = i * 2 - 1;
            for(int k = 0; k <= j; k++) {
                if(j <= k + r[k]) {
                    int p = (2 * k - j) / 2;
                    memoization[i][1] = memoization[i][1] || memoization[p][0];
                    memoization[i][2] = memoization[i][2] || memoization[p][1];
                    memoization[i][3] = memoization[i][3] || memoization[p][2];
                }
            }
        }
        return memoization[s.length()][3];
    }
}