package ADVANCE_DSA_3.Day_43.ClassVideo;
/*
Q-2: check given number is prime number  or not
 */
public class Problem_2 {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 29;
        System.out.println(isPrime(n));
    }
}
