class Solution {
    public int myAtoi(String str) {
        int num = 0;
        int sign = 1;
        String s = str.trim();
        int idx = 0;
        if (idx < s.length() && s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (idx < s.length() && s.charAt(idx) == '+') {
            idx++;
        }
        for (int i = idx; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break; 
            }
            int digit = c - '0';
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
        }
        return num * sign;
    }
}