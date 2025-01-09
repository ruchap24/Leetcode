class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
         for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (sb.length() < s.length()) {
                continue;
            } else if (sb.toString().equals(s)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}