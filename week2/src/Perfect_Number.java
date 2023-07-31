import java.util.Scanner;

public class Perfect_Number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int[] numeros = new int[n];
        boolean[] lista = new boolean[n];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            numeros[i] = num;

            for (int j = 1; j < num; j++) {
                if (num % j == 0) {
                    a += j;
                }
            }

            if (a == num) {
                lista[i] = true;
            } else {
                lista[i] = false;
            }

            a = 0;
        }

        for (int l = 0; l < n; l++) {
            if (lista[l]) {
                System.out.println(numeros[l] + " eh perfeito");
            } else {
                System.out.println(numeros[l] + " nao eh perfeito");
            }
        }
    }
}
