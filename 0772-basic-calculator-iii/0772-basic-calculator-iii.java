class Solution {
    
    static Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    
    private String eval(String num1, String num2, String prev_op) {
        int n1 = Integer.valueOf(num1);
        int n2 = Integer.valueOf(num2);
        int res;
        if (prev_op.equals("+"))
            res = n1 + n2;
        else if (prev_op.equals("-"))
            res = n1 - n2;
        else if (prev_op.equals("*"))
            res = n1 * n2;
        else
            res = n1 / n2;
        return String.valueOf(res);
    }
    
    public int calculate(String s) {
        String currNum = "";
        s += "@";
        String prev_op = "+";
        Stack<String> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            System.out.println("curr = "+ curr);
            if (Character.isWhitespace(curr))
                continue;
            if (Character.isDigit(curr))
                currNum += curr;
            else if (curr == '(') {
                stack.push(prev_op);
                prev_op = "+";
            }
            else {
                System.out.println("curr = " + curr + " currNum = " + currNum);
                if (prev_op.equals("+") || prev_op.equals("-"))
                    stack.push(eval("0", currNum, prev_op));
                else if (prev_op.equals("*") || prev_op.equals("/"))
                    stack.push(eval(stack.pop(), currNum, prev_op));
                currNum = "";
                prev_op = String.valueOf(curr);
                if (curr == ')') {
                    int res = 0;
                    while (!ops.contains(stack.peek())) {
                        res += Integer.valueOf(stack.pop());
                    }
                    prev_op = stack.pop();
                    currNum = String.valueOf(res);
                }
            }
            System.out.println(stack);
        }
        int ans = 0;
        while (!stack.isEmpty())
            ans += Integer.valueOf(stack.pop());
        return ans;
    }
}
// stack<string>
// space: continue
// digit: compute currenNum
// non digit
// (: store prev_op, prev_op = +
// +-*/
// )
// store pre_op
// eval(num1, num2, op)