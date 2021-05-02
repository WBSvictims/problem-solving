class Solution {
    private static int move(int val, int loc, int dir) {
        char[] sval = {
            (char)((val / 1000) % 10 + '0'),
            (char)((val / 100) % 10 + '0'),
            (char)((val /10) % 10 + '0'),
            (char)(val % 10 + '0')
        };
        sval[loc] = (char)( (sval[loc] - '0' + dir + 10) % 10 + '0' );
        return Integer.parseInt(new String(sval));
    }
    public int openLock(String[] deadends, String target) {
        int itarget = Integer.parseInt(target);
        boolean[] isDeadend = new boolean[10000];
        for(String s: deadends) {
            isDeadend[Integer.parseInt(s)] = true;
        }
        if(isDeadend[0]) return -1;
        
        int[] distance = new int[10000];
        boolean[] isVisit = new boolean[10000];
        int[] q = new int[10000];
        int qfront = 0, qback = 0;
        
        isVisit[0] = true;
        q[qback++] = 0;
        
        boolean cut = false;
        while(qfront < qback) {
            if(cut) break;
            int cur = q[qfront++];
            for(int i = 0; i < 4; i++) {
                int nxt1 = move(cur, i, 1);
                int nxt2 = move(cur, i, -1);
                
                if(!isVisit[nxt1] && !isDeadend[nxt1]) {
                    isVisit[nxt1] = true;
                    distance[nxt1] = distance[cur] + 1;
                    q[qback++] = nxt1;
                    cut = cut || (nxt1 == itarget);
                }
                if(!isVisit[nxt2] && !isDeadend[nxt2]) {
                    isVisit[nxt2] = true;
                    distance[nxt2] = distance[cur] + 1;
                    q[qback++] = nxt2;
                    cut = cut || (nxt2 == itarget);
                }
            }
        }
        return isVisit[itarget] ? distance[itarget] : -1;
    }
}