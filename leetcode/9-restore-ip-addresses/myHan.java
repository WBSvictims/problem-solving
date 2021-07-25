class Solution {
    private static boolean isValid(String s) {
        if(3 < s.length()) return false;
        if(s.equals("0")) return true;
        if(s.startsWith("0")) return false;
        if(s.length() <= 0) return false;
        int int_s = Integer.parseInt(s);
        if(0xff < int_s) return false;
        return true;
    }
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList();
        for(int a = 1; a <= 3 && a < s.length(); a++) {
            for(int b = a + 1; b <= a + 3 && b < s.length(); b++) {
                for(int c = b + 1; c <= b + 3 && c < s.length(); c++) {
                    if(
                        isValid(s.substring(c))
                        && isValid(s.substring(0, a))
                        && isValid(s.substring(a, b))
                        && isValid(s.substring(b, c))
                    ){
                        ret.add(String.format("%s.%s.%s.%s", s.substring(0, a), s.substring(a, b), s.substring(b, c), s.substring(c)));
                    }
                }
            }
        }
        return ret;
    }
}