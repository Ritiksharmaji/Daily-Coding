package Advanced_DSA_1.Day_18_Bit_Manipulation.Assignment;
/*
Q3. Single Number III

 */

public class Assignment_3 {

    // check ith bit is set or not
    public static boolean checkSetBit(int num, int bit) {
        return (num & (1 << bit)) != 0;
    }

    // count frequency of target in array
    public static int countFreq(int[] a, int target) {
        int count = 0;
        for (int x : a) {
            if (x == target) count++;
        }
        return count;
    }

    // solve remaining 2 unique numbers after one unique is known
    public static int[] findTwoUnique(int[] a, int skipValue) {
        int xor = 0;
        boolean skipped = false;

        // XOR all elements except ONE occurrence of skipValue
        for (int x : a) {
            if (x == skipValue && !skipped) {
                skipped = true;   // skip only one occurrence
                continue;
            }
            xor ^= x;
        }

        // find first set bit in xor
        int position = 0;
        for (int i = 0; i < 32; i++) {
            if (checkSetBit(xor, i)) {
                position = i;
                break;
            }
        }

        int first = 0, second = 0;
        skipped = false;

        // divide remaining numbers into 2 groups
        for (int x : a) {
            if (x == skipValue && !skipped) {
                skipped = true;   // again skip only one occurrence
                continue;
            }

            if (checkSetBit(x, position)) {
                first ^= x;
            } else {
                second ^= x;
            }
        }

        return new int[]{first, second};
    }

    public static void findThreeUnique(int[] a) {
        int firstUnique = -1;

        //step-1: Try every bit position to isolate one unique number
        for (int bit = 0; bit < 32; bit++) {
            int candidate = 0;

            // XOR numbers whose bit 'bit' is set
            for (int x : a) {
                if (checkSetBit(x, bit)) {
                    candidate ^= x;
                }
            }

            // If candidate appears exactly once, we found one unique number
            if (candidate != 0 && countFreq(a, candidate) == 1) {
                firstUnique = candidate;
                break;
            }
        }

        if (firstUnique == -1) {
            System.out.println("No valid unique numbers found");
            return;
        }

        //step-2: Find remaining 2 unique numbers
        int[] remaining = findTwoUnique(a, firstUnique);

        System.out.println("Three unique numbers are:");
        System.out.println(firstUnique + " " + remaining[0] + " " + remaining[1]);
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 5, 6, 6, 1, 2, 2, 7};
        findThreeUnique(a);
    }
}