package com.basic.java.coding_test;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int i2 = 0;
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
        }
		if (scanner.hasNextInt()) {
			i2 = scanner.nextInt();;
		}

		if ((i > 0) && (i2 > 0)) {
			System.out.println("1");
		} else if(((i > 0) && (i2 < 0))) {
			System.out.println("4");
		} else if (((i < 0) && (i2 < 0))) {
			System.out.println("3");
		} else {
			System.out.println("2");
		}
		
    }
}
