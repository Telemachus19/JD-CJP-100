public class Task03 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid number of arguments");
            return;
        }
        if (args[0].matches("^\\d+$") == true) {
            int number = Integer.parseInt(args[0]);
            String value = args[1];
            for (int i = 0; i < number; i++) {
                System.out.println(value);
            }
        } else {
            System.out.println("First Argument Must be a number");
        }
    }
}
