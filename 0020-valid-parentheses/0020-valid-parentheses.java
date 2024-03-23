class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.addLast(')');
            else if (c == '[') stack.addLast(']');
            else if (c == '{') stack.addLast('}');
            else if (stack.isEmpty() || stack.getLast() != c) return false;
            else {stack.removeLast();}
        }
        return stack.isEmpty();
    }
}