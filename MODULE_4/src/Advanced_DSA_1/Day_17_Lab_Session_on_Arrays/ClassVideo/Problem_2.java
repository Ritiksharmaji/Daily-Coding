package Advanced_DSA_1.Day_17_Lab_Session_on_Arrays.ClassVideo;
// Q-2: given a square matrix print its boundary elements(clockwise directions)
public class Problem_2 {

    public static void main(String[] args){
        int[][] A = {
                {1 ,2 ,3 ,4},
                {5, 6, 7 ,8},
                {9, 10, 11, 12},
                {13, 14, 15,16}
        };
        int n = A.length;
        // top row
        int i = 0, j = 0;
        for (int t = 1; t < n; t++) {
            System.out.print(A[i][j] + " ");
            j++;
        }

        // right column or last column
        for (int t = 1; t< n; t++) {
            System.out.print(A[i][j] + " ");
            i++;
        }

        // bottom row or last row
        for (int t = 1; t < n; t++) {
            System.out.print(A[i][j] + " ");
            j--;
        }

        // left column or first column
        for (int t = 1; t< n; t++) {
            System.out.print(A[i][j] + " ");
            i--;
        }
    }
}
