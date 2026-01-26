package Lab02.StringExercises;

public class LetterCheck {
    public static void main(String[] args) {
        String sentence = "I am a Student in Intake 49, with 1st Track in ITI.";
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (!(Character.isLetter(c) || Character.isWhitespace(c))) {
                count++;
            }
        }
        System.out.println("Count is " + count);
    }
}
