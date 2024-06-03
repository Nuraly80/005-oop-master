package com.epam.knight.view;

import java.util.Scanner;

public class ConsoleView {

    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void printMainMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Print knight stats");
        System.out.println("2. Show ammunition");
        System.out.println("3. Equip ammunition");
        System.out.println("4. Sort ammunition");
        System.out.println("5. Search ammunition");
        System.out.println("6. Exit");
        System.out.print("Choose option: ");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public String readLine() {
        return scanner.nextLine();
    }
}
