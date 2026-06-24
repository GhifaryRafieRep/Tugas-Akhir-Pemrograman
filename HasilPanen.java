public class HasilPanen {

    private String kode;
    private String komoditas;
    private int jumlah;
    private double harga;

    public HasilPanen() {
    }

    public HasilPanen(String kode, String komoditas, int jumlah, double harga) {
        this.kode = kode;
        this.komoditas = komoditas;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(String komoditas) {
        this.komoditas = komoditas;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return kode + ";" + komoditas + ";" + jumlah + ";" + harga;
    }
}