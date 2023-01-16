import java.util.*;

public class Main {

    public static void main(String[] args) {

        String expression = "(()";
        removeInvalidParenthesis(expression);

        expression = ")()())";
        removeInvalidParenthesis(expression);

        expression = ")(()())";
        removeInvalidParenthesis(expression);

        expression = ")(";
        removeInvalidParenthesis(expression);
//
        expression = "())(()())(()";
        removeInvalidParenthesis(expression);

    }

    static boolean isValidString(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

    static void removeInvalidParenthesis(String str) {
        if (str.isEmpty()) {
            return;
        }

        HashSet<String> visitSet = new HashSet<String>();

        Queue<String> maintainQueue = new LinkedList<>();

        String temp;
        boolean level = false;

        maintainQueue.add(str);
        visitSet.add(str);

        while (!maintainQueue.isEmpty()) {
            str = maintainQueue.peek();
            maintainQueue.remove();
            if (isValidString(str)) {
                if (str.length() == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(str.length() + " - " + str);
                }

                level = true;
                break;
            }

            if (level) {
                continue;
            }

            for (int i = 0; i < str.length(); i++) {

                temp = str.substring(0, i) + str.substring(i + 1);
                if (!visitSet.contains(temp)) {
                    maintainQueue.add(temp);
                    visitSet.add(temp);
                }
            }
        }
    }


}
