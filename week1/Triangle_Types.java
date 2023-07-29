import java.util.Scanner;

public class Triangle_Types {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            scanner.close();

            // Sorting the values in descending order
            if (a < b) {
                double temp = a;
                a = b;
                b = temp;
            }
            if (b < c) {
                double temp = b;
                b = c;
                c = temp;
            }
            if (a < b) {
                double temp = a;
                a = b;
                b = temp;
            }

            if (a >= (b + c)) {
                System.out.println("NAO FORMA TRIANGULO");
            } else {
                if (a * a == (b * b + c * c)) {
                    System.out.println("TRIANGULO RETANGULO");
                } else if (a * a > (b * b + c * c)) {
                    System.out.println("TRIANGULO OBTUSANGULO");
                } else {
                    System.out.println("TRIANGULO ACUTANGULO");
                }

                if (a == b && b == c) {
                    System.out.println("TRIANGULO EQUILATERO");
                } else if (a == b || b == c) {
                    System.out.println("TRIANGULO ISOSCELES");
                }
            }
        }
    }
