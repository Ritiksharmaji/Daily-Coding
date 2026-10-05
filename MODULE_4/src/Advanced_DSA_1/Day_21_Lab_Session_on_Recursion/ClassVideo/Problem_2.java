package Advanced_DSA_1.Day_21_Lab_Session_on_Recursion.ClassVideo;
/* Q-2: All indices of an array(given an array a of size n and target integer b,
return all indices where b is present in the array.
*/
public class Problem_2 {

    public static int[] allindex(int[] a, int b, int n) {

        int count = 0;

        // count occurrences
        for (int i = 0; i < n; i++) {
            if (a[i] == b) {
                count++;
            }
        }

        int[] result = new int[count];
        int j = 0;

        // store indices
        for (int i = 0; i < n; i++) {
            if (a[i] == b) {
                result[j] = i;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] a = {4,5,3,1,5,4,5};
        int b = 5;
        int n = a.length;

        int[] ans = allindex(a, b, n);

        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}