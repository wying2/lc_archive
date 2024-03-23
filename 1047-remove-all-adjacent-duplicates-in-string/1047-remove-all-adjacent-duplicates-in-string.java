class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        if (s == "") return "";
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek()) stack.push(c);
            else stack.pop();
        }
        String res = "";
        while(!stack.isEmpty())
            res = stack.pop() + res;
        return res;
    }
}