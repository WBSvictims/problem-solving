class Solution {
    public boolean validPalindrome(String s) {
        return isCheck(s, 0, s.length() - 1, 0);
    }
    
    public boolean isCheck(String s, int l, int r, int count){
        if(count > 1) return false;
        while(l<=r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return isCheck(s, l+1,r, count+1) || isCheck(s, l,r -1, count+1) ;
                
            }
        }
        return true;

    }
}