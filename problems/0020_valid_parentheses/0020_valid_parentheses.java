class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (top == '(' && c != ')'
                        || top == '{' && c != '}'
                        || top == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}