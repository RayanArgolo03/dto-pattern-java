package services;

import java.util.Scanner;

public final class ReadService {

    private final static Scanner sc = new Scanner(System.in);

    public static <T extends Enum<T>> T readOption(Class<T> enumClass) {

        int total = enumClass.getEnumConstants().length;
        PrintService.printOptions(enumClass);

        System.out.print("Your choice: ");
        int choice = sc.nextInt();

        while (!validChoice(choice, total)) {
            System.out.println("Invalid!");
            PrintService.printOptions(enumClass);
            System.out.print("Your choice: ");
            choice = sc.nextInt();
        }

        return enumClass.getEnumConstants()[choice - 1];
    }

    public static String readString(String title) {
        System.out.println(title);
        return sc.next();
    }

    public static int readInt(String title) {
        System.out.println(title);
        return sc.nextInt();
    }

    private static boolean validChoice(int choice, int total) {
        return choice > 0 && choice <= total;
    }

}
