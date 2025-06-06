import entity.*;
import services.*;
import Util.*;

import java.time.LocalDateTime;

public class RestoranMain {
    public static void main(String[] args) {
    	ReservasiStack stack = new ReservasiStack(10);
        boolean running = true;

        while (running) {
            MenuView.tampilkanMenu();
            int pilihan = InputUtil.inputInt("Pilih menu: ");

            switch (pilihan) {
            case 1:
                String nama = InputUtil.input("Nama Pelanggan: ");
                String noTelp = InputUtil.input("Nomor Telepon: ");
                int meja = InputUtil.inputInt("Nomor Meja: ");

                if (stack.isMejaSudahDipesan(meja)) {
                    System.out.println("Nomor meja tersebut sudah dipesan. Silakan pilih nomor meja lain.\n");
                    break;
                }

                LocalDateTime waktu = InputUtil.inputTanggalWaktu("Masukkan tanggal & waktu reservasi");
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
                    if (stack.isEmpty()) {
                        System.out.println("Belum ada reservasi yang bisa diperbarui.\n");
                        break;
                    }

                    stack.display(); // tampilkan semua untuk pilih index
                    int indexUpdate = InputUtil.inputInt("Pilih nomor reservasi yang ingin di-update (1-" + stack.ukuran() + "): ") - 1;

                    String namaUpdate = InputUtil.input("Nama baru: ");
                    String telpUpdate = InputUtil.input("Nomor telepon baru: ");
                    int mejaUpdate = InputUtil.inputInt("Nomor meja baru: ");
                    String tanggalUpdate = InputUtil.input("Masukkan tanggal (yyyy-MM-dd): ");
                    String jamUpdate = InputUtil.input("Masukkan jam (HH:mm): ");
                    LocalDateTime waktuUpdate = LocalDateTime.parse(tanggalUpdate + "T" + jamUpdate);

                    Reservasi reservasiBaru = new Reservasi(
                        new Pelanggan(namaUpdate, telpUpdate),
                        mejaUpdate,
                        waktuUpdate
                    );
                    stack.updateReservasi(indexUpdate, reservasiBaru);
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.\n");
            }
        }

        System.out.println("Terima kasih telah menggunakan sistem reservasi restoran.");
    }
}
