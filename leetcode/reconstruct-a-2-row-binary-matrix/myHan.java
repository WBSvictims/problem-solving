class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        ArrayList<Integer>[] ret = new ArrayList[2];
        ret[0] = new ArrayList<Integer>(colsum.length);
        ret[1] = new ArrayList<Integer>(colsum.length);
        int u = upper, l = lower;
        for(int i = 0; i < colsum.length; i++) {
            switch(colsum[i]) {
                case 2:
                    if(0 < u && 0 < l){
                        ret[0].add(1);
                        ret[1].add(1);
                        u--;
                        l--;
                    }
                    else return new ArrayList<List<Integer>>();
                    break;
                case 1:
                    if(l < u && 0 < u) {
                        ret[0].add(1);
                        ret[1].add(0);
                        u--;
                    }
                    else if(0 < l) {
                        ret[0].add(0);
                        ret[1].add(1);
                        l--;
                    }
                    else return new ArrayList<List<Integer>>();
                    break;
                case 0:
                    ret[0].add(0);
                    ret[1].add(0);    
                    break;
            }
        }
        if(l == 0 && u == 0) return Arrays.asList(ret);
        else return new ArrayList<List<Integer>>();
    }
}