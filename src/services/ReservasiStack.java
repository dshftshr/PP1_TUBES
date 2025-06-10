package services;

import entity.Reservasi;
import entity.Pelanggan;
import java.time.format.DateTimeFormatter;

public class ReservasiStack {
    private Reservasi[] array;
    private int capacity, TOP;
    public final int MIN = -1;
    private final int MAX_MEJA = 25; // [BARU] Batas maksimum nomor meja

    public ReservasiStack(int capacity) {
        array = new Reservasi[capacity];
        this.capacity = capacity;
        TOP = MIN;
    }

    public boolean isEmpty() {
        return TOP == MIN;
    }

    public boolean isFull() {
        return TOP >= capacity - 1;
    }

    // public boolean push(Reservasi reservasi) { // [UBAH: void → boolean]
    // if (isFull()) {
    // System.out.println("Stack reservasi penuh! Tidak bisa menambah reservasi
    // baru.");
    // return false; // [BARU]
    // } else {
    // TOP++;
    // array[TOP] = reservasi;
    // return true; // [BARU]
    // }
    // }

    // max meja
    public boolean push(Reservasi reservasi) {
        if (isFull()) {
            System.out.println("Stack reservasi penuh! Tidak bisa menambah reservasi baru.");
            return false;
        } else if (reservasi.getNomorMeja() < 1 || reservasi.getNomorMeja() > MAX_MEJA) { // [BARU]
            System.out.println("Nomor meja harus antara 1 sampai " + MAX_MEJA + ".");
            return false;
        } else if (isMejaSudahDipesan(reservasi.getNomorMeja())) { // [BARU]
            System.out.println("Nomor meja tersebut sudah dipesan. Silakan pilih nomor meja lain.");
            return false;
        } else {
            TOP++;
            array[TOP] = reservasi;
            return true;
        }
    }

    public Reservasi pop() {
        if (isEmpty()) {
            System.out.println("Tidak ada reservasi yang bisa dibatalkan.");
            return null;
        } else {
            Reservasi temp = array[TOP];
            TOP--;
            return temp;
        }
    }

    public Reservasi peek() {
        if (isEmpty()) {
            System.out.println("Belum ada reservasi.");
            return null;
        } else {
            return array[TOP];
        }
    }

    public int ukuran() {
        return TOP + 1;
    }

    public void clear() {
        TOP = MIN;
        System.out.println("Semua reservasi telah dibatalkan.");
    }

    public void display() {
        System.out.println("\n=== DAFTAR RESERVASI ===");
        System.out.println("Jumlah reservasi: " + ukuran());

        if (isEmpty()) {
            System.out.println("Belum ada reservasi yang dicatat.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("\nReservasi dari yang terbaru:");
        int i = TOP;
        while (i >= 0) {
            Reservasi reservasi = array[i];
            System.out.println((TOP - i + 1) + ". " +
                    reservasi.getPelanggan().getNama() +
                    " - Meja " + reservasi.getNomorMeja() +
                    " - Waktu: " + reservasi.getWaktu().format(formatter));
            i--;
        }
        System.out.println("==========================");
    }

    public boolean isMejaSudahDipesan(int nomorMeja) {
        for (int i = 0; i <= TOP; i++) {
            if (array[i].getNomorMeja() == nomorMeja) {
                return true;
            }
        }
        return false;
    }

    public void updateReservasi(int index, Reservasi reservasiBaru) {
        if (index < 0 || index > TOP) {
            System.out.println("Index tidak valid.");
            return;
        }
        array[index] = reservasiBaru;
        System.out.println("Reservasi berhasil diperbarui.\n");
    }

    // [BARU] Cari reservasi berdasarkan nama / telepon / alamat
    // public void cariReservasi(String keyword) {
    // boolean ditemukan = false;
    //
    // for (int i = TOP; i >= 0; i--) {
    // Reservasi r = array[i];
    // Pelanggan p = r.getPelanggan();
    // String gabungan = (p.getNama() + " " + p.getNoTelepon() + " ").toLowerCase();
    // // p.getAlamat()
    //
    // if (gabungan.contains(keyword.toLowerCase())) {
    // System.out.println("- " + r);
    // ditemukan = true;
    // }
    // }
    //
    // if (!ditemukan) {
    // System.out.println("Tidak ditemukan reservasi dengan kata kunci tersebut.");
    // }
    // }

    public void tampilkanSemua() {
        display();
    }
}