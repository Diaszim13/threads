package dias.matheus;

import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplicationSerial {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escreva o tamanho da matriz");
        int Tam = sc.nextInt();
        double[][] matrixA = generateMatrix(Tam);
        double[][] matrixB = generateMatrix(Tam);
        double[][] result = new double[Tam][Tam];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < Tam; i++) {
            for (int j = 0; j < Tam; j++) {
                for (int k = 0; k < Tam; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de execução (Serial): " + (endTime - startTime) + " ms");
    }


    private static double[][] generateMatrix(int size) {
        double[][] matrix = new double[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextDouble();
            }
        }
        return matrix;
    }
}
