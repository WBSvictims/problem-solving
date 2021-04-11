#include <algorithm>
#include <cstdio>
using namespace std;

class Solution {
private:
    const int MOD = 1000000007;
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {
        vector<int> sorted_nums1(nums1.begin(), nums1.end());
        sort(sorted_nums1.begin(), sorted_nums1.end());
        
        int md = 0;
        for(int i = 0; i < nums1.size(); i++) {
            int candidate = lower_bound(sorted_nums1.begin(), sorted_nums1.end(), nums2[i]) - sorted_nums1.begin();
            md = max({
                md,
                abs(nums1[i] - nums2[i]) - abs(sorted_nums1[min(candidate, (int)sorted_nums1.size()-1)] - nums2[i]),
                abs(nums1[i] - nums2[i]) - abs(sorted_nums1[max(candidate-1, 0)] - nums2[i])
            });
        }
        
        int total_sum = 0;
        for(int i = 0; i < nums1.size(); i++) {
            total_sum = (total_sum + abs(nums1[i] - nums2[i])) % MOD;
        }
        
        return (total_sum + MOD - md) % MOD;
    }
};