class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.removeLast() != '(') return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.removeLast() != '[') return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.removeLast() != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}