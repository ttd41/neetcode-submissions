class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] charInter = new int[26][2];
        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            int ci = s.charAt(i) - 'a';
            if (charInter[ci][0] == 0) {
                charInter[ci][0] = i + 1;
            } 
            charInter[ci][1] = i + 1;
        }

        Arrays.sort(charInter, (a, b) -> (a[0] - b[0]));

        List<Integer> res = new ArrayList<>();
        int prevL = 1;
        int prevR = 1;
        for (int[] i: charInter) {
            if (i[0] == 0) continue;
            if (prevR < i[0]) {
                res.add(prevR - prevL + 1);
                prevL = i[0];
                prevR = i[1];
            } else {
                prevR = Math.max(i[1], prevR);
            }
        }
        res.add(prevR - prevL + 1);

        return res;
    }
}
