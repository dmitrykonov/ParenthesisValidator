import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Validator {

    static void ParenthesisValidator(String str) {

        HashSet<String> visitSet = new HashSet<String>();

        Queue<String> maintainQueue = new LinkedList<>();

        String temp;

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

                break;
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
}
