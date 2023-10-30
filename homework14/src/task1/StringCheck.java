package task1;

import java.util.function.Predicate;

public class StringCheck {

    public static void main(String[] args) {
        Predicate<String> condition = str ->
                (str.startsWith("J") || str.startsWith("N")) && str.endsWith("A");

        System.out.println(condition.test("JANA"));  // true
        System.out.println(condition.test("NINA"));  // true
        System.out.println(condition.test("JAVA"));  // true
        System.out.println(condition.test("JONA"));  // true
        System.out.println(condition.test("JON"));   // false
    }
}

