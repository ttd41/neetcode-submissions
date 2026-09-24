class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1 + l2];
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int d1 = n1.charAt(i) - '0';
                int d2 = n2.charAt(j) - '0';
                res[i + j] += (d1 * d2);
                res[i + j + 1] += res[i + j] / 10;
                res[i + j] %= 10;
            }
        }

        StringBuilder resS = new StringBuilder();
        for (int i = l1 + l2 - 1; i >= 0; i--) {
            if (res[i] == 0 && resS.isEmpty()) continue;
            resS.append(res[i]);
        }


        return resS.toString();


        
    }
}
