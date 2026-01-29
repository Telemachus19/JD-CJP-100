package Lab05;

import java.util.function.Predicate;

public class StringTest {
    public static void main(String[] args) {
        StringUtils sUtils = new StringUtils();
        String string1 = "Hello";
        String string2 = "Java World";
        String longer = sUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("Longer string: " + longer);
        String first = sUtils.betterString(string1, string2, (s1, s2) -> true);
        System.out.println("First string: " + first);
        String alphabetical = sUtils.betterString(string1, string2, (s1, s2) -> s1.compareTo(s2) < 0);
        System.out.println("Alphabetically first: " + alphabetical);

        // Second Task
        Predicate<String> isOnlyAlphabets = sUtils::isAllLetters;
        System.out.println("Is '" + string1 + "' only alphabets? " + isOnlyAlphabets.test(string1));
        System.out.println("Is '" + string2 + "' only alphabets? " + isOnlyAlphabets.test(string2));

    }
}
