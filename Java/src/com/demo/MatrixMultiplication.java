package com.demo;
import java.util.Random;

public class MatrixMultiplication {

    // Naive matrix multiplication
    static int[][] naiveMatrixMultiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // Strassen's matrix multiplication
    static int[][] strassenMatrixMultiply(int[][] A, int[][] B) {
        // Implement Strassen's algorithm here
        // ... (Code for Strassen's goes here, it's a bit more complex)
        return null;
    }

    // Generating random matrices for testing
    static int[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int rowsA = 250;
        int colsA = 250;
        int rowsB = 250;
        int colsB = 250;

        int[][] A = generateRandomMatrix(rowsA, colsA);
        int[][] B = generateRandomMatrix(rowsB, colsB);

        long startTimeNaive = System.currentTimeMillis();
        int[][] resultNaive = naiveMatrixMultiply(A, B);
        long endTimeNaive = System.currentTimeMillis();
        long totalTimeNaive = endTimeNaive - startTimeNaive;

        long startTimeStrassen = System.currentTimeMillis();
        int[][] resultStrassen = strassenMatrixMultiply(A, B);
        long endTimeStrassen = System.currentTimeMillis();
        long totalTimeStrassen = endTimeStrassen - startTimeStrassen;

        System.out.println("Naive time: " + (totalTimeNaive / 1000.0) + "s");
        System.out.println("Strassen's time: " + (totalTimeStrassen / 1000.0) + "s");
    }
} 