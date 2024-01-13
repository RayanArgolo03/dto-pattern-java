package services;

public class PrintService {

    public static <T extends Enum<T>> void printOptions(Class<T> enumClass) {
        T[] enumConstants = enumClass.getEnumConstants();
        int i = 1;
        for (T enumm : enumConstants) System.out.println((i++) + " - " + enumm);
    }


}
