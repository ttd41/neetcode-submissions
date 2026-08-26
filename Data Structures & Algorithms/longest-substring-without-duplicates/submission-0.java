class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int slow = 0, fast = 0;
        HashSet hs = new HashSet<>();
        int res = 0;
        while (fast < len) {
            char c = s.charAt(fast);
            if (!hs.contains(c)) {
                hs.add(c);
                res = Math.max(res, hs.size());
            } else {
                while (s.charAt(slow) != c) {
                    hs.remove(s.charAt(slow));
                    slow++;
                } 
                slow++;
            }
            fast++;
            
        }

        return res;
    
    }
}
