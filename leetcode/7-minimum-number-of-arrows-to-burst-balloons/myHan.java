class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        
        Arrays.sort(points, (u, v) -> Integer.compare(u[1], v[1]));
        int last = points[0][1];
        int ans = 1;
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= last) continue;
            last = points[i][1];
            ans++;
        }
        
        return ans;
    }
}