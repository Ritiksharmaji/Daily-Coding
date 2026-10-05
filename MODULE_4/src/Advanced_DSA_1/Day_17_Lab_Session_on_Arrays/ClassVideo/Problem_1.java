package Advanced_DSA_1.Day_17_Lab_Session_on_Arrays.ClassVideo;
// BF
public class Problem_1 {

//    public static void main(String[] args) {
//        int[] a = {2, 1, 3, 2, 1, 2, 4, 3, 2, 1, 3, 1};
//        int sum = 0;
//        int n = a.length;
//        for (int i = 1; i <= n-1; i++) {
//            int level = Math.min(Math.max(0, i - 1), Math.max(i + 1, n - 1));
//            int water = level - a[i];
//            sum += water;
//        }
//        System.out.print("total water is:"+ sum);
//    }
public static void main(String[] args) {
    int[] a = {2,1,3,2,1,2,4,3,2,1,3,1};
    int n = a.length;

    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    leftMax[0] = a[0];
    for(int i = 1; i < n; i++)
        leftMax[i] = Math.max(leftMax[i-1], a[i]);

    rightMax[n-1] = a[n-1];
    for(int i = n-2; i >= 0; i--)
        rightMax[i] = Math.max(rightMax[i+1], a[i]);

    int sum = 0;
    for(int i = 0; i < n; i++){
        int water = Math.min(leftMax[i], rightMax[i]) - a[i];
        if(water > 0) sum += water;
    }

    System.out.println("Total water: " + sum);
}
}
