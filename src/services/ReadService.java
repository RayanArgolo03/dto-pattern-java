package services;

import java.util.Scanner;

public final class ReadService {

    private final static Scanner sc = new Scanner(System.in);

    private ReadService() {
    }

    public static <T extends Enum<T>> T readEnum(Class<T> enumClass) {

        T[] enums = enumClass.getEnumConstants();
        int total = enums.length;

        PrintService.printOptions(enums);

        System.out.print("Your choice: ");
        int choice = sc.nextInt();

        while (!validChoice(choice, total)) {
            System.out.println("Invalid!");
            PrintService.printOptions(enums);
            System.out.print("Your choice: ");
            choice = sc.nextInt();
        }

        return enums[choice - 1];
    }

    public static String readString(String title) {
        System.out.print(title + ":");
        return sc.next();
    }

    public static int readInt(String title) {
        System.out.print(title + ":");
        return sc.nextInt();
    }

    private static boolean validChoice(int choice, int total) {
        return choice > 0 && choice <= total;
    }

}
