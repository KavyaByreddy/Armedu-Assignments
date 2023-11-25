package com.demo;
public class RotateMatrix {
    
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int layers = n / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                
                // left to top
                matrix[first][i] = matrix[last - offset][first];
                
                // bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];
                
                // right to bottom
                matrix[last][last - offset] = matrix[i][last];
                
                // top to right
                matrix[i][last] = top;
            }
        }
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        System.out.println("Input matrix:");
        printMatrix(mat);
        
        rotateMatrix(mat);
        
        System.out.println("\nOutput matrix:");
        printMatrix(mat);
    }
}
