class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            int l = s.length();
            for (int i = 0; i < 3 - String.valueOf(l).length(); i++) {
                sb.append(0);
            }
            sb.append(l);
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); ) {
            int l = Integer.valueOf(str.substring(i, i + 3));
            res.add(str.substring(i + 3, i + 3 + l));
            i = i + 3 + l;
        }
        return res;
    }
}
