package org.example.foobar;

import java.util.Scanner;

public class foobar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = num % 2;
        if (k == 0) System.out.println("foo <целое число, которое было задано>");
        else System.out.println("bar <целое число, которое было задано>");
    }
}