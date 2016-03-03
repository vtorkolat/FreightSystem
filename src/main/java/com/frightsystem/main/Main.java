package com.frightsystem.main;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        PrintWriter out = new PrintWriter(System.out, true);

        out.print(str);
    }
}
