class Solution {
    private static int compression(int a, int b) {
        return b * 2002 + a;
    }
    private static int[] extract(int a) {
        return new int[] { a % 2002, a / 2002 };
    }
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                matrix[r][c] += 1001;
            }
        }
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                int nr = c;
                int nc = N - 1 - r;
                
                int[] from = extract(matrix[r][c]);
                matrix[r][c] = from[1];
                matrix[nr][nc] = compression(matrix[nr][nc], from[0]);
                
                int[] fp1 = extract(matrix[r][c]);
                int[] fp2 = extract(matrix[nr][nc]);
            }
        }
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(2001 < matrix[r][c]) matrix[r][c] = matrix[r][c] / 2002;
                matrix[r][c] -= 1001;
            }
        }
    }
}