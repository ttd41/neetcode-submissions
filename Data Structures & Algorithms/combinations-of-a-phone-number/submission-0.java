class Solution {

    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }

        backtrack(digits, 0, new StringBuilder());
        return res;
        
    }

    public void backtrack(String digits, int index, StringBuilder sb) {
        if (sb.length() == digits.length() && index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        String chars = digitToChar[num];
        for (char c: chars.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;


    }
}
