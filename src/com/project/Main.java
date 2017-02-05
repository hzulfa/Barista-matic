package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BaristaMatic baristaMatic = new BaristaMatic();
        Scanner scanner = new Scanner(System.in);

        int ch = 'r';
        while (ch != 'q' && ch != 'Q'){
            switch (ch){
                case 'r':
                case 'R':
                    baristaMatic.stockInventory();
                    break;
                default:
                    baristaMatic.processInput(ch);
            }
            baristaMatic.inventory.printInventory();
            baristaMatic.inventory.printMenu();
            ch = scanner.next().charAt(0);
            scanner.reset();
        }
    }
}
