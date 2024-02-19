import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // read the input matrix
        Scanner scanner = new Scanner(System.in);
        int numOfRows = scanner.nextInt();
        int numOfCols = scanner.nextInt();
        int[][] matrix = new int[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // make a new (rotated) matrix
        int [][]rotated = new int[numOfCols][numOfRows];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                rotated[j][numOfRows - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[i].length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

