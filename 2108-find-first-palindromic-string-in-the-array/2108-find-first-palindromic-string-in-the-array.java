class Solution {
    public String firstPalindrome(String[] words) {
        // String res = "";
        for (int i = 0; i < words.length; i ++) {
            if (isPal(words[i]))
                return words[i];
        }
        return "";
    }
    
    private boolean isPal (String word) {
        int i = 0;
        int j = word.length() - 1;
        
        while (i < j) {
            if (word.charAt(i) != word.charAt(j))
                return false;
            i ++;
            j --;
        }
        return true;
    }
}