import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfElements = scanner.nextInt();

        int[] elements = new int[numOfElements];
        for (int i = 0; i < numOfElements; i++) {
            elements[i] = scanner.nextInt();
        }

        int maxProduct = 0, tmpProduct;
        for (int i = 0; i < numOfElements - 1; i++) {
            if (elements[i] >= 0 && elements[i+1] >= 0) {
                tmpProduct = elements[i] * elements[i + 1];
                if (tmpProduct > maxProduct)
                    maxProduct = tmpProduct;
            }
        }

        System.out.println(maxProduct);
    }
}