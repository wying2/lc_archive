class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String higherPriorityPair = x > y ? "ab" : "ba";
        String lowerPriorityPair = higherPriorityPair.equals("ab") ? "ba" : "ab";
        String stringAfterFirstPass = removeSubString(s, higherPriorityPair);
        int higherBias = x > y ? x : y;
        int lowerBias = x > y ? y : x;
        totalScore += higherBias * (s.length() - stringAfterFirstPass.length()) / 2;
        String stringAfterSecPass = removeSubString(stringAfterFirstPass, lowerPriorityPair);
        totalScore += lowerBias * (stringAfterFirstPass.length() - stringAfterSecPass.length()) / 2;
        return totalScore;
    }
    
    String removeSubString (String inputString, String pairToRemove) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputString.length(); i ++) {
            char curr = inputString.charAt(i);
            if (curr == pairToRemove.charAt(1) && 
                !stack.isEmpty() && 
                stack.peek() == pairToRemove.charAt(0)) {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }
        StringBuilder rem = new StringBuilder();
        while (!stack.isEmpty()) {
            rem.append(stack.pop());
        }
        return rem.reverse().toString();
    }
} 