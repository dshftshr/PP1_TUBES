package services;

import entity.Reservasi;

public class ReservasiStack {

    private Reservasi[] array;
    private int capacity, TOP;
    public final int MIN = -1;

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

    public void push(Reservasi reservasi) {
        if (isFull()) {
            System.out.println("Stack reservasi penuh! Tidak bisa menambah reservasi baru.");
        } else {
            TOP++;
            array[TOP] = reservasi;
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
        System.out.println("Kosong? " + isEmpty());
        System.out.println("Penuh? " + isFull());

        if (isEmpty()) {
            System.out.println("Belum ada reservasi yang dicatat.");
            return;
        }

        System.out.println("\nReservasi dari yang terbaru:");
        int i = TOP;
        while (i >= 0) {
            Reservasi reservasi = array[i];
            System.out.println((TOP - i + 1) + ". "
                    + reservasi.getPelanggan().getNama()
                    + " - Meja " + reservasi.getNomorMeja()
                    + " - Waktu: " + reservasi.getWaktu());
            i--;
        }
        System.out.println("==========================");
    }

    public void tampilkanSemua() {
        // TODO Auto-generated method stub

    }
}
