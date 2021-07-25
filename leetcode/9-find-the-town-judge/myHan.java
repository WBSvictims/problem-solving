class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ind = new int[n+1];
        int[] outd = new int[n+1];
        for(int[] t: trust) {
            outd[t[0]]++;
            ind[t[1]]++;
        }
        for(int i = 1; i <= n; i++) {
            if(outd[i] == 0 && ind[i] == n-1) return i;   
        }
        return -1;
    }
}