package Advanced_DSA_1.Day_16_Two_Dimensional.ClassVideo;
// Q-1:Search in a row wise Col wise sorted matrix(given a row wise and column wise sorted matrix search for a given elements)
public class Problem_1 {

    public static Boolean IsNumberAvailableInMatrix(int[][] matrix, int number) {
        int rows =0;
        int columns = matrix[0].length-1;
        while (columns >= 0 && rows <matrix.length ) {
            if(matrix[rows][columns] == number){
                return true;
            }else{
                if(matrix[rows][columns] > number){
                    columns--;
                }else if(matrix[rows][columns] < number){
                    rows++;
                }
            }
        }
        return false;
    }
    public static void main(String[] arges){

        int[][] matrix = {
                {-5, -2, 1, 13},
                {-4, 0, 3, 14},
                {-3, 2, 5, 18},
                {2, 6, 10, 20}
        };
        int number = 10;
        int number2 = 15;
        System.out.println("given number is there is a array or not:" + IsNumberAvailableInMatrix(matrix, number));
        System.out.println("given number is there is a array or not:" + IsNumberAvailableInMatrix(matrix, number2));
        }
    }

