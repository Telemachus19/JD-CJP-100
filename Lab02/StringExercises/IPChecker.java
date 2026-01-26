package Lab02.StringExercises;

public class IPChecker {
    public static void main(String[] args) {
        if (args.length == 0 || args.length > 1) {
            System.out.println("Invalid Number of Arguments");
            return;
        }
        String ipAddress = args[0];
        String converter = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String regex = converter + "\\." + converter + "\\." + converter + "\\." + converter;
        if (ipAddress.matches(regex)) {
            System.out.println("Valid IP");
        } else {
            System.out.println("Invalid IP");
        }
        String[] split = ipAddress.split("\\.");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
