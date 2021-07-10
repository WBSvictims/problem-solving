class Solution {
    public int uniquePaths(int m, int n) {
        int t = m + n - 2;
        int max_n = Math.min(m-1,n-1);
        double res = 1.0;
        int temp = 1;
        while(t>max_n){
            res *= ((double)t /(double)temp);
            t--;
            temp++;
            
        }
        return (int) Math.round(res);   
    }
}