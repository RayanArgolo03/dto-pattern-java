package services;

public class PrintService {

    public static <T extends Enum<T>> void printOptions(T[] enums) {
        for (T e : enums) System.out.println((e.ordinal() + 1) + " - " + e);
    }


}
