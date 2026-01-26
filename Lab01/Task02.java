public class Task02 {
	public static void main(String[] args) {
		if (args.length > 1 || args.length == 0) {
			System.out.println("Invalid Number of Arguments");
			return;
		}
		System.out.println(args[0]);
	}
}
