import java.util.*;

public class Main {

    public static void main(String[] args) {

        String expression = "(()";
        Validator.ParenthesisValidator(expression);

        expression = ")()())";
        Validator.ParenthesisValidator(expression);

        expression = ")(()())";
        Validator.ParenthesisValidator(expression);

        expression = ")(";
        Validator.ParenthesisValidator(expression);

        expression = "())(()())(()";
        Validator.ParenthesisValidator(expression);


    }
}
