package com.productShop.util;

import java.util.Scanner;

public class ScannerConnection {
    private static Scanner scanner;

    private ScannerConnection(){};
    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
