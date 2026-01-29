package Lab05;

import java.util.function.BiPredicate;

public class StringUtils {
    public String betterString(String s1, String s2, BiPredicate<String, String> condition) {
        if (condition.test(s1, s2)) {
            return s1;
        } else {
            return s2;
        }
    }

    public boolean isAllLetters(String s) {
        if (s == null || s.isEmpty())
            return false;

        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

}