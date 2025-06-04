package entity;

public class Pelanggan {
    private String nama;
    private String noTelepon;

    public Pelanggan(String nama, String noTelepon) {
        this.nama = nama;
        this.noTelepon = noTelepon;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    @Override
    public String toString() {
        return nama + " (" + noTelepon + ")";
    }

    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }
}
