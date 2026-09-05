class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        
        backtrack(0, new StringBuilder(), n);

        return res;
    }

    public void backtrack(int open, StringBuilder sb, int n) {
        if (sb.length() == 2 * n) {
            if (open == 0)
                res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            backtrack(open + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open > 0) {
            sb.append(')');
            backtrack(open - 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}
