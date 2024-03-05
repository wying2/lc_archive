class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        def evaluate(x, y, operator):
            if operator == "+":
                return x
            if operator == "-":
                return -x
            if operator == "*":
                return x * y
            if operator == "/":
                ax = abs(x)
                ay = abs(y)
                val = ax // ay
                if (ax != x) != (ay != y):
                    return -val
                return val
        
        stack = []
        curr = 0
        prev_op = "+"
        s += "@"
        for c in s:
            if c.isdigit():
                curr = curr * 10 + int(c)
            elif c == "(":
                stack.append(prev_op)
                prev_op = "+"
            else:
                if prev_op in "*/":
                    stack.append(evaluate(stack.pop(), curr, prev_op))
                else:
                    stack.append(evaluate(curr, 0, prev_op))
                curr = 0
                prev_op = c
                if c == ")":
                    while type(stack[-1]) == int:
                        curr += stack.pop()
                    prev_op = stack.pop()
        print(stack)
        return sum(stack)