class Solution {
    public String pushDominoes(String dominoes) {
        char[] ret = dominoes.toCharArray();
        
        int[] when = new int[dominoes.length()];
        int[] q = new int[dominoes.length()];
        int front = 0, back = 0;
        
        for(int i = 0; i < dominoes.length(); i++){
            if(dominoes.charAt(i) != '.') {
                q[back++] = i;
            }
        }
        
        while(front != back) {
            int cur = q[front++];
            int nxt = cur - 1;
            if(ret[cur] == 'R')
                nxt = cur + 1;
            if(nxt < 0 || ret.length <= nxt)
                continue;
            
            if(ret[nxt] == '.') {
                ret[nxt] = ret[cur];
                when[nxt] = when[cur] + 1;
                q[back++] = nxt;
            }
            else if(ret[nxt] != ret[cur] && when[nxt] == when[cur] + 1) {
                ret[cur - 1] = '.';
            }
        }
        
        return new String(ret);
    }
}