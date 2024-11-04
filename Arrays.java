import java.util.Random;
import java.util.Scanner;
public class Arrays {
    public static void main(String[] args) {
        Random random=new Random();
        double[][]matrix1=new double[3][3];
        double[][]matrix2=new double[3][3];
        double[][]product=new double[3][3];

        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                matrix1[i][j] = random.nextDouble();
            }
        }

        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                matrix2[i][j] = random.nextDouble();
            }
        }

        for (int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                for (int k=0;k<3;k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Matrix 2:");
        printMatrix(matrix2);

        System.out.println("Product of Matrix 1 and Matrix 2:");
        printMatrix(product);
    }


    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.2f", value);
            }
            System.out.println();
        }


    }
}
