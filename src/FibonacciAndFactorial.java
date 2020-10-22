import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciAndFactorial {
    // Excercise 9.1

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.print("Enter a positive integer, or 0 to stop program: ");
            int N = in.nextInt();
            if (N == 0)
                break;
            else if (N < 0) {
                System.out.println("Negative numbers are not allowed.");
                continue;
            }
            BigInteger NBigInteger = BigInteger.valueOf(N);  // Convert to big integer
            System.out.println("factorial(" + N + ") is " + factorial(NBigInteger));
            if (N > 40) {
                System.out.println("N is too big to compute fibonacci(N) recursively");
            } else {
                System.out.println("fibonacci(" + N + ") is " +
                        fibonacci(N) + "   (recursively)");
            }
            System.out.println("fibonacci(" + N + ") is " +
                    nonRecursiveFibonacci(N) + "   (non-recursively)");
        }
    }


    static BigInteger nonRecursiveFibonacci(int N) {
        assert N >= 0 : "fibonacci(n) is only defined for non-negative n";
        if (N == 0 || N == 1) {
            return BigInteger.ONE;
        } else {
            BigInteger f0 = BigInteger.ONE;
            BigInteger f1 = BigInteger.ONE;
            for (int i = 2; i <= N; i++) {
                BigInteger fi = f0.add(f1);
                f0 = f1;
                f1 = fi;
            }
            return f1;  // Final return value of sequence
        }
    }


    static int fibonacci(int N) {
        assert N >= 0 : "fibonacci(n) is only defined for non-negative n";
        assert N <= 40 : "n is to large to compute fibonacci(N) recursively";
        if (N == 0 || N == 1) {
            return 1;
        } else {
            return fibonacci(N - 1) + fibonacci(N - 2);
        }
    }


    static BigInteger factorial(BigInteger N) {
        assert N.signum() >= 0 : "factorial(n) is only defined for non-negative n";
        if (N.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            BigInteger factorialOfNMinus1 = factorial(N.subtract(BigInteger.ONE));
            return N.multiply(factorialOfNMinus1);
        }
    }

}
