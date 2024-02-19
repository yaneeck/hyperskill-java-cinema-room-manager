import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        // prepare background for the star
        String[][] star = new String[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                star[i][j] = ".";
            }
        }

        // draw the star
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == num / 2 || j == num / 2 || i == j || i == num - j - 1)
                    star[i][j] = "*";
            }
        }

        // print the star
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(star[i][j] + " ");
            }
            System.out.println();
        }
    }
}