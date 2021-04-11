class Solution {
public:
    double nthPersonGetsNthSeat(int n) {
        if(n == 1) return 1.0;
        
        long double acc_already = 1.0 / n;
        for(int left = n - 1; 1 < left; left--) {
            acc_already += acc_already / left;    
        }
        
        return acc_already;
    }
};