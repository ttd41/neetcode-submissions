class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);


        int s = hand[0];
        int e = hand[hand.length - 1];
        Map<Integer, Integer> counts = new TreeMap<>();
        Map<Integer, Integer> ends = new HashMap<>();
        int activeSet = 0;
        int prev = 0;

        for (int i = 0; i < hand.length; i++) {
            int c = counts.getOrDefault(hand[i], 0);
            counts.put(hand[i], c + 1);
        }

        for (Map.Entry<Integer,Integer> entry: counts.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();

            if (activeSet != 0 && (key != prev + 1 || count < activeSet)) {
                return false;
            }

            int newSets = count - activeSet;
            ends.put(key + groupSize - 1, newSets);

            activeSet = count;

            if (ends.containsKey(key)) {
                activeSet -= ends.get(key);
            }

            prev = key;
        }

        return activeSet == 0;
    }
}
