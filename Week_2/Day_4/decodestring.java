class Solution {
    public String decodeString(String s) {
        int[] i = {0}; // acts as pass-by-reference
        return decode(s, i);
    }

    private String decode(String s, int[] i) {
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (i[0] < s.length()) {
            char c = s.charAt(i[0]);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                i[0]++;
            } else if (c == '[') {
                i[0]++;
                String inner = decode(s, i);

                for (int k = 0; k < num; k++) {
                    result.append(inner);
                }
                num = 0;
            } else if (c == ']') {
                i[0]++;
                return result.toString();
            } else {
                result.append(c);
                i[0]++;
            }
        }

        return result.toString();
    }
}