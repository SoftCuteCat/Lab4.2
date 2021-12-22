package com.company;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I will help you read the csv file and print the people or departments.");
        System.out.println("Please enter the full path to the file: ");
        String path = scanner.next();
        CSVReader csv = new CSVReader(path);
        try {
            csv.reading();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        int choice = 1;
        while (choice != 0) {
            System.out.println("What needs to be done?");
            System.out.println("1. Display all people on the screen;\n" +
                    "2. Display all divisions on the screen;\n" +
                    "0. Exit.");
            while (!scanner.hasNextInt()) {
                System.out.println("Please, insert only integer value!");
                scanner.next();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    List<Human> humans = csv.humans;
                    for (Human i: humans) {
                        System.out.println(i.toString());
                        System.out.println();
                    }
                    break;
                }
                case 2: {
                    Set<Division> div = csv.divisions;
                    for (Division i: div) {
                        System.out.println(i.toString());
                        System.out.println();
                    }
                    break;
                }
                case 0: {
                    break;
                }
                default: System.out.println("This numeric combination is not specified in the program!");
            }
        }
    }
}
