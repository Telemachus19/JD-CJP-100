package Lab03;

import java.util.function.Function;

class Coefficients {
    private final double a;
    private final double b;
    private final double c;

    public Coefficients(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}

interface Roots {

    void printRoots();
}

class RealRoots implements Roots {
    private final double root1;
    private final double root2;

    public RealRoots(double root1, double root2) {
        this.root1 = root1;
        this.root2 = root2;
    }

    public RealRoots(double root) {
        this.root1 = root;
        this.root2 = root;
    }

    public RealRoots() {
        this.root1 = Double.NaN;
        this.root2 = Double.NaN;
    }

    public double getRoot1() {
        return root1;
    }

    public double getRoot2() {
        return root2;
    }

    @Override
    public String toString() {
        if (root1 == root2) {
            return String.format("Root:%.2f", root1);
        } else {
            return String.format("Root 1 = %.2f, Root 2 = %.2f", root1, root2);
        }
    }

    @Override
    public void printRoots() {
        System.out.println(this.toString());
    }
}

class ComplexRoots implements Roots {
    private final double realPart;
    private final double imaginaryPart;

    public ComplexRoots(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return String.format("Roots:%n x1 = %.2f + %.2fi%n x2 = %.2f - %.2fi",
                realPart, imaginaryPart, realPart, imaginaryPart);
    }

    @Override
    public void printRoots() {
        System.out.println(this.toString());
    }
}

class QuadraticSolverFunction implements Function<Coefficients, Roots> {

    @Override
    public Roots apply(Coefficients coeffs) {
        double a = coeffs.getA();
        double b = coeffs.getB();
        double c = coeffs.getC();
        double discriminant = (b * b) - (4 * a * c);

        if (discriminant > 0) {
            double r1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double r2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new RealRoots(r1, r2);
        } else if (discriminant == 0) {
            double r = -b / (2 * a);
            return new RealRoots(r);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(Math.abs(discriminant)) / (2 * a);
            return new ComplexRoots(realPart, imaginaryPart);
        }
    }
}

public class QuadraticEquationSolver {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid Number of Arguments");
            return;
        }
        String regex = "^[-]?\\d+(\\.\\d+)*";
        if (!args[0].matches(regex) || !args[1].matches(regex) || !args[2].matches(regex)) {
            System.out.println("Accept Numbers only");
            return;
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        if (a == 0) {
            System.out.println("Linear Equations are not allowed");
            return;
        }
        Coefficients coeffs = new Coefficients(a, b, c);
        QuadraticSolverFunction solver = new QuadraticSolverFunction();
        Roots roots = solver.apply(coeffs);
        System.out.println(roots);
    }
}
