import java.util.*;

public class BalancedBrackets {
    public String checkBrackets(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.empty()) return "NO";
                char topChar = stack.pop();
                if ((ch == ')' && topChar != '(') ||
                        (ch == ']' && topChar != '[') ||
                        (ch == '}' && topChar != '{')) return "NO";
            }
        }
        return stack.isEmpty() ? "YES" : "NO";

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BalancedBrackets checker = new BalancedBrackets();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String s = scanner.nextLine();
            String result = checker.checkBrackets(s);
            System.out.println(result);
        }
        scanner.close();

    }


}
