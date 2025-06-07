package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Reservasi {
    private Pelanggan pelanggan;
    private int nomorMeja;
    private LocalDateTime waktu;

    public Reservasi(Pelanggan pelanggan, int nomorMeja, LocalDateTime waktu) {
        this.pelanggan = pelanggan;
        this.nomorMeja = nomorMeja;
        this.waktu = waktu;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public int getNomorMeja() {
        return nomorMeja;
    }

    public LocalDateTime getWaktu() {
        return waktu;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Reservasi oleh " + pelanggan +
               ", Meja: " + nomorMeja +
               ", Waktu: " + waktu.format(formatter);
    }
}
