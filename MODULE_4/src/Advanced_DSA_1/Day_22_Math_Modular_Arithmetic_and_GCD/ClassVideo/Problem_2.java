package Advanced_DSA_1.Day_22_Math_Modular_Arithmetic_and_GCD.ClassVideo;
/*
Find GCD(A, B) = Largest number that divides both A and B.
 */
public class Problem_2 {

    public static int gcd(int A, int B) {
        A = Math.abs(A);
        B = Math.abs(B);

        while (B != 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(gcd(20, 65));
    }
}
