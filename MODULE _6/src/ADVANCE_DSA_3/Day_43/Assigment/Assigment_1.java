package ADVANCE_DSA_3.Day_43.Assigment;

public class Assigment_1 {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i != 0) {

            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 29;
        System.out.println(isPrime(n));
    }
}
