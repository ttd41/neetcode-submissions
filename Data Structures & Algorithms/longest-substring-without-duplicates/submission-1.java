class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int slow = 0, fast = 0;
        HashSet hs = new HashSet<>();
        int res = 0;
        while (fast < len) {
            char c = s.charAt(fast);
            while (hs.contains(c)) {
                hs.remove(s.charAt(slow));
                slow++;
            } 
            res = Math.max(res, fast - slow + 1);
            hs.add(s.charAt(fast));
            fast++;
            
        }

        return res;
    
    }
}
