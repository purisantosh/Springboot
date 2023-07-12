package org.example;

import java.io.BufferedReader;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        out.println("Enter Values");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = getC(a, b);
        out.println(c);


    }

    public static int getC(int a, int b) {
        int c = a + b;
        return c;
    }
}
