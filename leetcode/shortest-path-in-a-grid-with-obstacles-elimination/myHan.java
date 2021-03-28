class Solution {
    class State {
        public int r, c, k;
        public State(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
    
    private static final int[] dr = {0, 0, 1, -1};
    private static final int[] dc = {-1, 1, 0, 0};
    
    public int shortestPath(int[][] grid, int K) {
        int R = grid.length;
        int C = grid[0].length;
        Queue<State> q = new LinkedList<State>();
        int[][][] distance = new int[R][C][K+1];
        
        if(grid[0][0] == 0) {
            q.add(new State(0, 0, K));
            distance[0][0][K] = 1;
        }
        else if(0 <= K-1) {
            q.add(new State(0, 0, K-1));
            distance[0][0][K-1] = 1;
        }
        else return -1;
        
        while(0 < q.size()) {
            State cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int k = cur.k;
            
            for(int di = 0; di < 4; di++) {
                int nr = r + dr[di];
                int nc = c + dc[di];
                if(nr < 0 || R <= nr || nc < 0 || C <= nc) continue;
                
                int nk = k + (grid[nr][nc] == 0 ? 0 : -1);
                if(nk < 0) continue;
                
                if(distance[nr][nc][nk] != 0) continue;
                q.add(new State(nr, nc, nk));
                distance[nr][nc][nk] = distance[r][c][k] + 1;
            }
        }
        
        int ret = 0x3f3f3f3f;
        for(int l = 0; l <= K; l++) {
            if(distance[R-1][C-1][l] != 0) ret = Math.min(ret, distance[R-1][C-1][l]);
        }
        if(ret == 0x3f3f3f3f) return -1;
        return ret-1;
    }
}