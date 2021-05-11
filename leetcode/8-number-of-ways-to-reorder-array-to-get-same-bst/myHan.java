class Solution {
    private static long MOD = 1000000007;
    private static class Node {
        public int v, l, r;
        public Node(int v) {
            this.v = v;
            this.l = -1;
            this.r = -1;
        }
    }
    private static long[] facs = new long[1001];
    
    static {
        Arrays.fill(facs, -1);
    }
    
    private static long fac(long n) {
        if(n == 0) return 1;
        int in = (int)n;
        if(facs[in] != -1) return facs[in];
        facs[in] = (fac(n-1) * n) % MOD;
        return facs[in];
    }
    
    private static long pow(long n, long k) {
        long ret = 1L;
        for(int i = 0; 0 < (k >> i); i++) {
            if(((k >> i) & 1) == 1) ret = (ret * n) % MOD;
            n = (n * n) % MOD;
        }
        return ret;
    }
    
    private static long div(long n, long d) {
        return (n * pow(d, MOD-2)) % MOD;
    }
    
    private static void insert(Node[] tree, int bck, int cur, int val) {
        if(val < tree[cur].v) {
            if(tree[cur].l == -1) {
                tree[cur].l = bck;
                tree[bck] = new Node(val);
            }
            else{
                insert(tree, bck, tree[cur].l, val);
            }
        }
        else {
            if(tree[cur].r == -1) {
                tree[cur].r = bck;
                tree[bck] = new Node(val);
            }
            else{
                insert(tree, bck, tree[cur].r, val);
            }
        }
    }
    private static Node[] build_tree(int[] nums) {
        Node[] tree = new Node[nums.length];
        tree[0] = new Node(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            insert(tree, i, 0, nums[i]);
        }
        return tree;
    }
    
    private static long[] calc(Node[] tree, int cur) {
        if(cur == -1) return new long[] {0, 1};
        long[] l = calc(tree, tree[cur].l);
        long[] r = calc(tree, tree[cur].r);
        return new long[] {
            l[0] + r[0] + 1,
            (l[1] * r[1] % MOD) * div(fac(l[0] + r[0]), fac(l[0]) * fac(r[0]) % MOD) % MOD
        };
    }
    public int numOfWays(int[] nums) {
        Node[] tree = build_tree(nums);
        long[] ret = calc(tree, 0);
        return (int)ret[1] - 1;
    }
}