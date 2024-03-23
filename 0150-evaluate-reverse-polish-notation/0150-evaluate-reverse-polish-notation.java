class Solution {
    public int evalRPN(String[] tokens) {
        String ops = "+-*/";
        Deque<String> stack = new LinkedList<>();
        for (String t : tokens) {
            if (!ops.contains(t)) stack.push(t);
            else {
                // System.out.println(stack);
                // System.out.println(t.equals("+"));
                String num2_str = stack.pop();
                String num1_str = stack.pop();
                int num1 = Integer.valueOf(num1_str);
                int num2 = Integer.valueOf(num2_str);
                if (t.equals("+")) stack.push(Integer.toString(num1+num2));
                else if (t.equals("-")) stack.push(Integer.toString(num1-num2));
                else if (t.equals("*")) stack.push(Integer.toString(num1*num2));
                else if (t.equals("/")) stack.push(Integer.toString(num1/num2));
            }
        }
        return Integer.valueOf(stack.pop());
    }
}