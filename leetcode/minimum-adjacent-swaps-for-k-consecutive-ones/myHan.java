class Solution {
    private static long INF = 0x3fffffffffffffL;
    public int minMoves(int[] nums, int k) {
        long[] left = new long[nums.length+1];
        long[] right = new long[nums.length+2];
        long[] q = new long[nums.length];
        int fnt = 0, bck = 0, move = 0;
        int leftCount = k / 2;
        int rightCount = k / 2 + k % 2;
        if(leftCount == 0) left[0] = 0;
        else left[0] = INF;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                q[bck++] = i;
            }
            else {
                move += bck - fnt;
            }
            if(bck - fnt == leftCount + 1) {
                move -= Math.abs(i - q[fnt]) - bck + fnt + 1;
                fnt++;
            }
            if(bck - fnt != leftCount) left[i+1] = INF;
            else left[i+1] = move;
        }
        fnt = bck = move = 0;
        if(rightCount == 0) right[nums.length+1] = 0;
        else right[nums.length+1] = INF;
        for(int i = nums.length-1; 0 <= i; i--) {
            if(nums[i] == 1) {
                q[bck++] = i;
            }
            else {
                move += bck - fnt;
            }
            if(bck - fnt == rightCount + 1) {
                move -= Math.abs(i - q[fnt]) - bck + fnt + 1;
                fnt++;
            }
            if(bck - fnt != rightCount) right[i+1] = INF;
            else right[i+1] = move;
        }
        long ret = INF;
        for(int i = 0; i <= nums.length; i++) {
            ret = Math.min(ret, left[i] + right[i+1]);
        }
        return (int)ret;
    }
}

