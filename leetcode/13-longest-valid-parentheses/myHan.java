class Solution {
    private static class Height implements Comparable<Height> {
        public int h, l;
        public Height(int h, int l) {
            this.h = h;
            this.l = l;
        }
        @Override
        public int compareTo(Height height) {
            if (this.h < height.h) {
                return -1;
            } else if (this.h == height.h) {
                return 0;
            } else {
                return 1;
            }
        }
        public String toString() {
            return String.format("(h: %d, l: %d)", h, l);
        }
    }
    public int longestValidParentheses(String s) {
        int[] acc = new int[s.length()+1];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                acc[i+1] = acc[i] + 1;
            }
            else {
                acc[i+1] = acc[i] - 1;
            }
        }
        Height[] heights = new Height[acc.length];
        for(int i = 0; i < acc.length; i++) {
            heights[i] = new Height(acc[i], i);
        }
        Arrays.sort(heights, Collections.reverseOrder());
        
        int maxLen = 0;
        int[] toEnd = new int[acc.length];
        int[] toBegin = new int[acc.length];
        int[][] leftEnd = new int[acc.length][2];
        int[][] rightEnd = new int[acc.length][2];
        for(int i = 0; i < acc.length; i++){
            toEnd[i] = -1;
            toBegin[i] = -1;
            leftEnd[i][1] = 30001;
            rightEnd[i][1] = 30001;
        }
        
        for(int i = 0; i < heights.length; i++) {
            int curh = heights[i].h;
            int l = heights[i].l;
            if(l + 1 < toEnd.length && toEnd[l+1] != -1)
                toEnd[l] = toEnd[l+1];
            else
                toEnd[l] = l;
            if(0 < l - 1 && toBegin[l-1] != -1)
                toBegin[l] = toBegin[l-1];
            else
                toBegin[l] = l;
            toEnd[toBegin[l]] = toEnd[l];
            toBegin[toEnd[l]] = toBegin[l];
            if(rightEnd[toBegin[l]][1] != curh || rightEnd[toBegin[l]][0] < l) {
                rightEnd[toBegin[l]][0] = l;
                rightEnd[toBegin[l]][1] = curh;
            }
            if(leftEnd[toBegin[l]][1] != curh || l < leftEnd[toBegin[l]][0]) {
                leftEnd[toBegin[l]][0] = l;
                leftEnd[toBegin[l]][1] = curh;
            }
            if(leftEnd[toBegin[l]][1] == curh && rightEnd[toBegin[l]][1] == curh)
                maxLen = Math.max(maxLen, rightEnd[toBegin[l]][0] - leftEnd[toBegin[l]][0]);
            // System.out.println(
            //     String.format(
            //         "%s %d -> %d, %d -> %d (%d:%d ~ %d:%d)",
            //         heights[i].toString(),
            //         toBegin[l],
            //         toEnd[toBegin[l]],
            //         toEnd[l],
            //         toBegin[toEnd[l]],
            //         leftEnd[toBegin[l]][0],
            //         leftEnd[toBegin[l]][1],
            //         rightEnd[toBegin[l]][0],
            //         rightEnd[toBegin[l]][1]
            //     )
            // );
        }
        
        return maxLen;
    }
}