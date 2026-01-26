package Lab02.StringExercises;

import java.util.StringTokenizer;

public class StringProcessor {
    public static void main(String[] args) {
        String sentence = "Java developers use Java to build Java applications, and Java is widely used in modern software development.";
        String targetWord = "Java";
        int count = 0;
        int index = 0;

        // First Method
        while ((index = sentence.indexOf(targetWord, index)) != -1) {
            count++;
            index += targetWord.length();
        }

        System.out.println("Total occurrences of \"" + targetWord + "\": " + count);

        // Second Method
        String[] splitting = sentence.split(targetWord);
        for (int i = 0; i < splitting.length; i++)
            System.out.println(splitting[i]);

        System.out.println("Total occurrences of \"" + targetWord + "\": " + (splitting.length - 1));

        System.out.println("\nTokens generated using \"" + targetWord + "\" as delimiter:");

        StringTokenizer tokenizer = new StringTokenizer(sentence, targetWord);

        while (tokenizer.hasMoreTokens()) {
            System.out.println("Token: [" + tokenizer.nextToken().trim() + "]");
        }
    }
}
