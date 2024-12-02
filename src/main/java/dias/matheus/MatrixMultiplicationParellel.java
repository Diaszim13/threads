package dias.matheus;

import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplicationParellel {

    public static void main(String[] args) throws InterruptedException {

    Scanner sc = new Scanner(System.in);

    System.out.println("Escreva o tamanho da matriz");
    int Tam = sc.nextInt();
    double[][] matrixA = generateMatrix(Tam);
    double[][] matrixB = generateMatrix(Tam);
    double[][] result = new double[Tam][Tam];
    long startTime = System.currentTimeMillis();

    int numThreads = 8;
    Thread[] threads = new Thread[numThreads];

    int rowsPerThread = Tam / numThreads;

        for(int t = 0; t < numThreads; t++)
        {
            final int startRow = t * rowsPerThread;
            final int endRow = (t == numThreads - 1) ? Tam : startRow + rowsPerThread;

            threads[t] = new Thread(() -> {
                for (int i = startRow; i < endRow; i++) {
                    for (int j = 0; j < Tam; j++) {
                        for (int k = 0; k < Tam; k++) {
                            result[i][j] += matrixA[i][k] * matrixB[k][j];
                        }
                    }
                }
            });

            threads[t].start();
        }
            for (Thread thread : threads) {
            thread.join();
        }

    long endTime = System.currentTimeMillis();
        System.out.println("Tempo de execução (Paralelo): " + (endTime - startTime) / 1000 + " s");

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
