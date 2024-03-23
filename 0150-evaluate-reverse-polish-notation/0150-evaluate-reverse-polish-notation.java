class Solution {
    public int evalRPN(String[] tokens) {
        String ops = "+-*/";
        Deque<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            if (!ops.contains(t)) stack.push(Integer.valueOf(t));
            else {
                // System.out.println(stack);
                // System.out.println(t.equals("+"));
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (t.equals("+")) stack.push(num1+num2);
                else if (t.equals("-")) stack.push(num1-num2);
                else if (t.equals("*")) stack.push(num1*num2);
                else if (t.equals("/")) stack.push(num1/num2);
            }
        }
        return stack.pop();
    }
}