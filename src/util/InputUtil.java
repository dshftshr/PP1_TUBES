package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int inputInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public static LocalDateTime inputTanggalWaktu(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        while (true) {
            System.out.print(prompt + " (format: yyyy-MM-dd HH:mm): ");
            String input = scanner.nextLine();
            try {
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Format tanggal tidak valid. Contoh: 2025-06-05 18:30");
            }
        }
    }
}
