class Solution {
    private static final int[] dr = {0, 0, 1, 1, 1, -1, -1, -1};
    private static final int[] dc = {1, -1, -1, 0, 1, -1, 0, 1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0 || grid[grid.length-1][grid[0].length-1] != 0) return -1;
        int[][] q = new int[grid.length * grid[0].length][2];
        int qfnt = 0, qbck = 0;
        int[][] distance = new int[grid.length][grid[0].length];
        for(int[] d: distance) Arrays.fill(d, -1);
        
        q[qbck][0] = 0;
        q[qbck++][0] = 0;
        distance[0][0] = 1;
        
        while(0 < qbck - qfnt) {
            int r = q[qfnt][0];
            int c = q[qfnt++][1];
            
            for(int di = 0; di < dr.length; di++) {
                int nr = r + dr[di];
                int nc = c + dc[di];
                if(nr < 0 || grid.length <= nr || nc < 0 || grid[0].length <= nc || grid[nr][nc] != 0 || distance[nr][nc] != -1) continue;
                q[qbck][0] = nr;
                q[qbck++][1] = nc;
                distance[nr][nc] = distance[r][c] + 1;
            }
        }
        
        return distance[grid.length-1][grid[0].length-1];
    }
}