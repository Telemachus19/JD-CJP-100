package Lab05;

import java.math.BigDecimal;

public class Complex<T extends BigDecimal> {

    private T realPart;
    private T imaginaryPart;

    public Complex(T real, T imaginary) {
        this.realPart = real;
        this.imaginaryPart = imaginary;
    }

    public T getRealPart() {
        return realPart;
    }

    public T getImaginaryPart() {
        return imaginaryPart;
    }

    public void setRealPart(T realPart) {
        this.realPart = realPart;
    }

    public void setImaginaryPart(T imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    public Complex<BigDecimal> add(Complex<?> other) {
        BigDecimal real1 = this.realPart;
        BigDecimal imag1 = this.imaginaryPart;

        BigDecimal real2 = (BigDecimal) other.realPart;
        BigDecimal imag2 = (BigDecimal) other.imaginaryPart;

        return new Complex<>(real1.add(real2), imag1.add(imag2));
    }

    public Complex<BigDecimal> subtract(Complex<?> other) {
        BigDecimal real1 = this.realPart;
        BigDecimal imag1 = this.imaginaryPart;

        BigDecimal real2 = (BigDecimal) other.realPart;
        BigDecimal imag2 = (BigDecimal) other.imaginaryPart;

        return new Complex<>(real1.subtract(real2), imag1.subtract(imag2));
    }

    public Complex<BigDecimal> multiply(Complex<?> other) {
        BigDecimal a = this.realPart;
        BigDecimal b = this.imaginaryPart;
        BigDecimal c = (BigDecimal) other.getRealPart();
        BigDecimal d = (BigDecimal) other.getImaginaryPart();

        // (ac - bd)
        BigDecimal ac = a.multiply(c);
        BigDecimal bd = b.multiply(d);
        BigDecimal newReal = ac.subtract(bd);

        // (ad + bc)
        BigDecimal ad = a.multiply(d);
        BigDecimal bc = b.multiply(c);
        BigDecimal newImag = ad.add(bc);

        return new Complex<>(newReal, newImag);
    }

    @Override
    public String toString() {
        if (imaginaryPart.compareTo(BigDecimal.ZERO) >= 0) {
            return realPart + " + " + imaginaryPart + "i";
        } else {
            return realPart + " - " + imaginaryPart.abs() + "i";
        }
    }

    public static void main(String[] args) {
        Complex<BigDecimal> c1 = new Complex<>(new BigDecimal("1.5"), new BigDecimal("2.0"));
        Complex<BigDecimal> c2 = new Complex<>(new BigDecimal("3.5"), new BigDecimal("4.0"));

        System.out.println("C1: " + c1);
        System.out.println("C2: " + c2);

        Complex<BigDecimal> sum = c1.add(c2);
        System.out.println("Sum: " + sum);

        Complex<BigDecimal> product = c1.multiply(c2);
        System.out.println("Product: " + product);
    }
}