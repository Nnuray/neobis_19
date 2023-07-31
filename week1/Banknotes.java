import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int notes = scanner.nextInt();
        scanner.close();

        System.out.println(notes);
        System.out.printf("%d nota(s) de R$ 100,00%n", notes / 100);
        int aux = notes % 100;
        System.out.printf("%d nota(s) de R$ 50,00%n", aux / 50);
        aux %= 50;
        System.out.printf("%d nota(s) de R$ 20,00%n", aux / 20);
        aux %= 20;
        System.out.printf("%d nota(s) de R$ 10,00%n", aux / 10);
        aux %= 10;
        System.out.printf("%d nota(s) de R$ 5,00%n", aux / 5);
        aux %= 5;
        System.out.printf("%d nota(s) de R$ 2,00%n", aux / 2);
        aux %= 2;
        System.out.printf("%d nota(s) de R$ 1,00%n", aux);
    }
}
