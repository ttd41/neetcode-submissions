class Solution {
    public boolean isPalindrome(String s) {
        String ss = convertS(s);
        int len = ss.length();
        int st = 0, ed = len - 1;
        while (st < ed) {
            if (ss.charAt(st) == ss.charAt(ed)) {
                st++;
                ed--;
            } else {
                return false;
            }
        }

        return true;
        
    } 

    public String convertS(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }
            if (c >= 'A' && c <= 'Z') {
                sb.append((char)('a' + (c - 'A')));
            }
            if (c >= '0' && c <= '9') {
                sb.append(c - '0');
            }
        }

        return sb.toString();
    }
}
