class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = -1;
        int[] maxFailGas = new int[2 * gas.length];
        for(int begin = 0; begin < gas.length; begin++) {
            int curGas = 0;
            int curCost = 0;
            boolean isPos = true;
            for(int i = begin; i <= begin + gas.length; i++) {
                if(curGas < curCost) {
                    isPos = false;
                    break;
                }
                curGas = curGas - curCost + gas[i % gas.length];
                curCost = cost[i % cost.length];
                if(curGas < maxFailGas[i]) {
                    isPos = false;
                    break;
                }
                maxFailGas[i] = curGas;
            }
            if(isPos) {
                ans = begin;
                break;
            }
        }
        return ans;
    }
}