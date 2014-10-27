/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        List<String> ops = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> value = new Stack<Integer>();
        for (String token : tokens) {
            if (ops.contains(token)) {
                if (value.size() < 2) {
                    return -1;
                }

                int op2 = value.pop();
                int op1 = value.pop();

                if (tokens[i].equals("+")) {
                    value.push(op1 + op2);
                } else if (tokens[i].equals("-")) {
                    value.push(op1 - op2);
                } else if (tokens[i].equals("*")) {
                    value.push(op1 * op2);
                } else if (tokens[i].equals("/")) {
                    // illegal divide
                    if (op2 == 0) {
                        return -1;
                    }

                    value.push(op1 / op2);
                }
            } else {
                // throw exception with non-integer value
                value.push(Integer.parseInt(token));
            }
        }

        return value.isEmpty() ? -1 : value.pop();
    }
}
