import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = getMatrix();
        printMatrix(matrix);
        testAllZeros(matrix);
    }

    private static void testAllZeros(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println("For point " + i + ", " + j + ":\n" + PathFinder.findPath(i, j, matrix));
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    private static int[][] getMatrix() {
        int[][] result = new int[10][10];
        Random randomizer = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result[i][j] = randomizer.nextInt(2);
            }
        }
        return result;
    }
}