import entity.*;
import services.*;
import util.*;

import java.time.LocalDateTime;

public class RestoranMain {
    public static void main(String[] args) {
        ReservasiStack stack = new ReservasiStack(0);
        boolean running = true;

        while (running) {
            MenuView.tampilkanMenu();
            int pilihan = InputUtil.inputInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    String nama = InputUtil.input("Nama Pelanggan: ");
                    String noTelp = InputUtil.input("Nomor Telepon: ");
                    int meja = InputUtil.inputInt("Nomor Meja: ");
                    LocalDateTime waktu = LocalDateTime.now();
                    stack.push(new Reservasi(new Pelanggan(nama, noTelp), meja, waktu));
                    System.out.println("Reservasi berhasil ditambahkan.\n");
                    break;

                case 2:
                    Reservasi dibatalkan = stack.pop();
                    if (dibatalkan != null) {
                        System.out.println("Reservasi dibatalkan: " + dibatalkan + "\n");
                    } else {
                        System.out.println("Tidak ada reservasi yang bisa dibatalkan.\n");
                    }
                    break;

                case 3:
                    Reservasi terakhir = stack.peek();
                    if (terakhir != null) {
                        System.out.println("Reservasi terakhir: " + terakhir + "\n");
                    } else {
                        System.out.println("Belum ada reservasi.\n");
                    }
                    break;
          
                case 4:
                    System.out.println("\n=== Semua Reservasi ===");
                    stack.tampilkanSemua();
                    System.out.println();
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        }

        System.out.println("Terima kasih telah menggunakan sistem reservasi restoran.");
    }
}
