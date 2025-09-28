/*
Problem: Evaluate Reverse Polish Notation
LeetCode Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
Difficulty: Medium

Approach:
- Use a stack to process tokens one by one.
- If the token is a number, push it onto the stack.
- If the token is an operator (+, -, *, /), pop two numbers from the stack,
  apply the operator, and push the result back onto the stack.
- At the end, the stack contains the final result.

Time Complexity: O(n), where n is the number of tokens
Space Complexity: O(n), for the stack
*/


import java.util.*;

class reversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {  
                int b = stack.pop();
                int a = stack.pop();
                
                switch (token) {
                    case "+": 
                        stack.push(a + b);
                        break;
                    case "-": 
                        stack.push(a - b);
                        break;
                    case "*": 
                        stack.push(a * b);
                        break;
                    case "/": 
                        stack.push(a / b);  
                        break;
                }
            }
        }
        
        return stack.pop(); 
    }
}


