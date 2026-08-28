class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> dq = new ArrayDeque<>();
        Set<String> ops = Set.of("+", "-", "*", "/");

        for (String s: tokens) {
            if (ops.contains(s)) {
                int a = Integer.valueOf(dq.pop());
                int b = Integer.valueOf(dq.pop());
                switch (s) {
                    case "+":
                        dq.push(String.valueOf(a + b));
                        break;
                    case "-":
                        dq.push(String.valueOf(b - a));
                        break;
                    case "*":
                        dq.push(String.valueOf(a * b));
                        break;
                    case "/":
                        dq.push(String.valueOf(b / a));
                        break;
                }
            } else {
                dq.push(s);
            }
        }

        return Integer.valueOf(dq.pop());
    }
}
