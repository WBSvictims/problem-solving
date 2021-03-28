class Solution {
    private static int[] count = new int[100001];
    private static int[] ltor = new int[100000];
    private static int[] rtol = new int[100000];
    
    private static void init() {
        Arrays.fill(count, 0);
        Arrays.fill(ltor, -1);
        Arrays.fill(rtol, -1);
    }
    
    public int findLatestStep(int[] arr, int m) {
        init();
        int ret = -1;
        for(int step = 1; step <= arr.length; step++) {
            int i = arr[step-1]-1;
            int l = i;
            if(0 <= i-1 && rtol[i-1] != -1) l = rtol[i-1];
            int r = i;
            if(i+1 < arr.length && ltor[i+1] != -1) r = ltor[i+1];
            count[i - l]--;
            count[r - i]--;
            count[r - l + 1]++;
            ltor[l] = r;
            rtol[r] = l;
            
            if(0 < count[m]) ret = step;
        }
        return ret;
    }
}