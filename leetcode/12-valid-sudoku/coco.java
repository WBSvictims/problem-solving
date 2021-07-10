class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] check = {0,0,0,0,0,0,0,0,0,0};
        
        
        //check horizontal
        for(int i=0; i<9; i++){
            Arrays.fill(check, 0);
            for(int j=0;j<9;j++){
                if(Character.isDigit(board[i][j])){
                    int num = board[i][j] - '0';
                    if(num > 9) 
                        return false;
                    check[num - 1] += 1;
                    if(check[num - 1] >1) 
                        return false;
                }
                
            } 
        }
        //check vertical
        for(int i=0; i<9; i++){
            Arrays.fill(check, 0);
            for(int j=0;j<9;j++){
                if(Character.isDigit(board[j][i])){
                    int num = board[j][i] - '0';
                    if(num > 9) 
                        return false;
                    check[num - 1] += 1;
                    if(check[num - 1] >1) 
                        return false;
                }
                
            } 
        }
        //check sub-boxes
        for(int i=0; i<3; i++){
            for(int j=0;j<3;j++){
                Arrays.fill(check, 0);
                for(int p=0;p<3;p++){
                    for(int q=0;q<3; q++){
                        if(Character.isDigit(board[i*3 + p][j*3 + q])){
                            int num = board[i*3 + p][j*3 + q] - '0';
                            if(num > 9) 
                                return false;
                            check[num - 1] += 1;
                            if(check[num - 1] >1) 
                                return false;
                        }
                    }
                }
                
                
            } 
        }
        return true;
    }
}