class Solution {
public:
    int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ret = 0;
        for(int i = 0; z >> i; i++) {
            ret += (z >> i) & 1;
        }
        return ret;
    }
};