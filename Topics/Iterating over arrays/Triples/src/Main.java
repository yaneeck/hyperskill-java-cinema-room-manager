import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // read elements
        Scanner scanner = new Scanner(System.in);
        int numOfElements = scanner.nextInt();
        int[] elements = new int[numOfElements];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = scanner.nextInt();
        }

        int triples = 0;
        for (int i = 0; i < elements.length - 2; i++) {
            if (elements[i] == elements[i+1] - 1 && elements[i+1] == elements[i+2] - 1) {
                triples++;
            }
        }
        System.out.println(triples);
    }
}
