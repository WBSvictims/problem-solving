class Solution {
    public int waysToMakeFair(int[] nums) {
        //idx => 0, 1, [2, 3, ...] l + 2, l + 3
        int[] acc = new int[nums.length+4];
        int[] racc = new int[nums.length+4];
        
        for(int i = 2; i <= nums.length; i++) {
            acc[i] = acc[i-2] + nums[i-2];
        }
        for(int i = nums.length + 1; 2 <= i; i--) {
            racc[i] = racc[i+2] + nums[i-2];
        }
        int ret = 0;
        for(int i = 2; i < nums.length + 2; i++) {
            if(acc[i-1] + racc[i+2] == acc[i-2] + racc[i+1]) ret++;
        }
        return ret;
    }
}