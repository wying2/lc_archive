class Solution {
    public int calculate(String s) {
        int currNum = 0;
        char pre_op = '+';
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i ++) {
            Character currChar = s.charAt(i);
            // System.out.println(currChar);
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + (currChar-'0');
            }
            // System.out.println((currChar-'0'));
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length()-1) {
                if (pre_op == '+')
                    stack.push(currNum);
                else if (pre_op == '-')
                    stack.push(-currNum);
                else if (pre_op == '*')
                    stack.push(stack.pop() * currNum);
                else if (pre_op == '/')
                    stack.push(stack.pop() / currNum);
                pre_op = currChar;
                currNum = 0;
            }
        }
        int res = 0;
        
        while (!stack.isEmpty())
            res += stack.pop();
        return res;
    }
}

// stack 3, 4
// num1 * num2 store before in stack
// -num2