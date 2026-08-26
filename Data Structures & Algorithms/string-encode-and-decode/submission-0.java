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
        StringBuilder sb = new StringBuilder(str);
        while (!sb.isEmpty()) {
            int l = Integer.valueOf(sb.substring(0, 3));
            sb.delete(0, 3);
            res.add(sb.substring(0, l));
            sb.delete(0, l);
        }
        return res;
    }
}
