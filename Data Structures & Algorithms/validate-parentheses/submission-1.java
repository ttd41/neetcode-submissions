class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> hm = Map.of('}', '{', ']', '[', ')', '(');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (hm.containsKey(c)) {
                if (!stack.isEmpty() && stack.getLast() == hm.get(c)) {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }
}
