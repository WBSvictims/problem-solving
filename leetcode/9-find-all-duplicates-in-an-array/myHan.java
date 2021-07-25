class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ret = new ArrayList();
        int N = nums.length;
        for(int i = 0; i < N; i++) {
            if(N < nums[i]) continue;
            int cur = nums[i] - 1;
            nums[i] = N + 2;
            while(nums[cur] <= N) {
                // System.out.print(String.format("  cur: %d  [", cur+1));
                // for(int v: nums) System.out.print(v + ", ");
                // System.out.println("]");
                int bef = cur;
                cur = nums[cur] - 1;
                nums[bef] = N + 1;
            }
            // System.out.print(String.format("cur: %d  [", cur+1));
            // for(int v: nums) System.out.print(v + ", ");
            // System.out.println("]");
            if(nums[cur] != N+2)
                ret.add(cur+1);
            else
                nums[cur] = N+1;
        }
        return ret;
    }
}