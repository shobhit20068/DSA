package Stack;
import java.util.Stack;

public class InfixToPrefix {
    private static String reverseAndSwap(String str) {
        StringBuilder rev = new StringBuilder(str.length());
        for(int i = str.length()-1; i>=0; i--) {
            Character c = str.charAt(i);
            if(c == '(') {
                rev.append(')');
            }
            else if(c == ')') {
                rev.append('(');
            }
            else {
                rev.append(c);
            }
        }
        return rev.toString();
    }

    private static Boolean isOperator(char c) {
        return c == '+' || c == '*' || c == '/' || c == '-' || c == '^';
    }

    private static int precedence(char c) {
        if(c == '^') {
            return 3;
        }
        else if(c == '/' || c == '*') {
            return 2;
        }
        else if(c == '+' || c == '-') {
            return 1;
        }
        else {
            return -1;
        }
    }

    private static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(char c : exp.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            else if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove '('
                }
            }
            else if(isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.empty()){
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private static String infixToPrefix(String infix) {
        String revInfix = reverseAndSwap(infix);
        String postfix = infixToPostfix(revInfix);
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        String input1 = "x+y*z/w+u";
        String input2 = "a+b";
        String input3 = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPrefix(input1));
        System.out.println(infixToPrefix(input2));
        System.out.println(infixToPrefix(input3));
    }
}
    
