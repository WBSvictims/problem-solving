class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int[][] acc = new int[matrix.length+1][matrix[0].length+1];
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                acc[r+1][c+1] = matrix[r][c] + acc[r+1][c] + acc[r][c+1] - acc[r][c];
            }
        }
        for(int r1 = 0; r1 < matrix.length; r1++) {
            for(int c1 = 0; c1 < matrix[0].length; c1++) {
                for(int r2 = r1+1; r2 <= matrix.length; r2++) {
                    for(int c2 = c1+1; c2 <= matrix[0].length; c2++) {
                        if(acc[r2][c2] - acc[r2][c1] - acc[r1][c2] + acc[r1][c1] == target) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}