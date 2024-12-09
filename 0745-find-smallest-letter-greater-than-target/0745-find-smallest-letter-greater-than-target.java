class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        if(letters[0]>target)
        return letters[0];
        for(int i=1;i<n;i++){
            if(letters[i]>target)
            return letters[i];
        }
        return letters[0];
    }
}