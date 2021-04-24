class Solution {
    private static double[] pop(double[] nums, int idx) {
        double[] ret = new double[nums.length-1];
        for(int i = 0; i < idx; i++)
            ret[i] = nums[i];
        for(int i = idx+1; i < nums.length; i++) {
            ret[i-1] = nums[i];
        }
        return ret;
    }
    private static double[] push(double[] stk, int end, double val) {
        double[] ret = stk.clone();
        ret[end] = val;
        return ret;
    }
    private static double[] operate(int op, double[] stk, int end) {
        double[] ret = stk.clone();
        switch(op) {
            case 0:
                ret[end - 2] = ret[end-1] + ret[end-2];
                break;
            case 1:
                ret[end - 2] = ret[end-1] - ret[end-2];
                break;
            case 2:
                ret[end - 2] = ret[end-1] * ret[end-2];
                break;
            case 3:
                ret[end - 2] = ret[end-1] / ret[end-2];
                break;
        }
        return ret;
    }
    private static boolean solve(double[] stk, int end, double[] nums) {
        if(end == 1 && nums.length == 0) {
            return stk[0] < 24 + 1e-6 && 24 - 1e-6 < stk[0];
        }
        else if(end <= 1) {
            boolean ret = false;
            for(int i = 0; i < nums.length; i++)
                ret = ret || solve(push(stk, end, nums[i]), end+1, pop(nums, i));
            return ret;
        }
        else {
            boolean ret = false;
            for(int i = 0; i < nums.length; i++)
                ret = ret || solve(push(stk, end, nums[i]), end+1, pop(nums, i));
            for(int i = 0; i < 4; i++)
                ret = ret || solve(operate(i, stk, end), end-1, nums.clone());
            return ret;
        }
    }
    public boolean judgePoint24(int[] nums) {
        double[] dnums = new double[nums.length];
        for(int i = 0; i < nums.length; i++)
            dnums[i] = nums[i];
        return solve(new double[4], 0, dnums);
    }
}