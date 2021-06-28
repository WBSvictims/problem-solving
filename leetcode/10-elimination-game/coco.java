class Solution {
        public int lastRemaining(int n) {
            int start = 1;
            int dir = 1;
            int step = 1;
            while(n>1){
                if(dir == 1 || (dir == -1 && n%2 == 1)){
                    start += step;
                }
                step *= 2;
                dir *= -1;
                n /= 2;
            }
            return start;
        }
    }