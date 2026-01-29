package Lab03;

import java.util.function.Function;

class celsiusToFahrenheit implements Function<Double, Double> {
    @Override
    public Double apply(Double t) {
        return (t * 1.8) + 32;
    }
}

public class ClesiusConverter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid Number of Arguments (Only 1 is allowed)");
            return;
        }
        if (!args[0].matches("^[-]?\\d+(\\.\\d+)*")) {
            System.out.println("Only Numbers are allowed");
            return;
        }
        celsiusToFahrenheit ctf = new celsiusToFahrenheit();
        System.out.println("Temperature Converter");
        double inputCelsius = Double.parseDouble(args[0]);
        double resultFahrenheit = ctf.apply(inputCelsius);
        System.out.printf("%.2f°C is equal to %.2f°F%n", inputCelsius, resultFahrenheit);
    }
}
