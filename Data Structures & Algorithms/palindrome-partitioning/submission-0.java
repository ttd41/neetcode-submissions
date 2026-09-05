class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return res;
        
    }

    public void backtrack(String s, int index, List<String> prev) {
        if (index == s.length()) {
            res.add(new ArrayList<>(prev));
            return;
        }
        for (int j = index + 1; j <= s.length(); j++) {
            String sub = s.substring(index, j);
            if (isP(sub)) {
                prev.add(sub);
                backtrack(s, j, prev);
                prev.remove(prev.size() - 1);
            }
        }
        return;
    }

    public boolean isP(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }

        return l >= r;
    }
}
