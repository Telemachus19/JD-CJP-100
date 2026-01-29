package Lab04;

class BadStringException extends Exception {
    public BadStringException(String message) {
        super(message);
    }
}

class StringPrinter {

    public void printStringIncludeITI(String s) throws BadStringException {
        if (!s.contains("ITI")) {
            throw new BadStringException("String must at least contain 'ITI'");
        }
        System.out.println("Check 1 Passed: String contains 'ITI'");
    }

    public void printStringIncludeNumber(String s) throws BadStringException {
        // Regex checking for at least one digit
        if (!s.matches(".*\\d.*")) {
            throw new BadStringException("String must at least contain a number");
        }
        System.out.println("Check 2 Passed: String contains a number");
    }

    public void printGoodStatement(String s) throws BadStringException {
        if (s.trim().split("\\s+").length < 2) {
            throw new BadStringException("String must at least contain two words");
        }
        System.out.println("Check 3 Passed: String contains at least two words");
    }
}

public class ExceptionExercise {
    public static void main(String[] args) {
        String input = "Hello World";

        StringPrinter printer = new StringPrinter();

        System.out.println("Validating: \"" + input + "\"\n");
        try {
            printer.printStringIncludeITI(input);
        } catch (BadStringException e) {
            System.err.println("printStringIncludeITI Failed: " + e.getMessage());
        }
        try {
            printer.printStringIncludeNumber(input);
        } catch (BadStringException e) {
            System.err.println("printStringIncludeNumber Failed: " + e.getMessage());
        }
        try {
            printer.printGoodStatement(input);
        } catch (BadStringException e) {
            System.err.println("printGoodStatement Failed: " + e.getMessage());
        }
    }
}
