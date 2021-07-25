class Solution {
    private static int[] countChars(char[] s) {
        int[] counts = new int[256];
        for(char ch: s) {
            counts[ch]++;
        }
        return counts;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rcount = countChars(ransomNote.toCharArray());
        int[] mcount = countChars(magazine.toCharArray());
        
        for(int i = 0; i < 256; i++) {
            if (mcount[i] < rcount[i]) return false;
        }
        return true;
    }
}