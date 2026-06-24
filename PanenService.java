import java.io.*;
import java.util.ArrayList;

public class PanenService {

    private ArrayList<HasilPanen> daftar = new ArrayList<>();
    private final String FILE = "data_panen.txt";

    public void tambah(HasilPanen p) {
        daftar.add(p);
    }

    public void tampil() {

        if (daftar.isEmpty()) {
            System.out.println("Data kosong.");
            return;
        }

        System.out.println("\n=== DATA HASIL PANEN ===");

        for (HasilPanen p : daftar) {

            System.out.println(
                    p.getKode() + " | " +
                    p.getKomoditas() + " | " +
                    p.getJumlah() + " kg | Rp" +
                    p.getHarga()
            );
        }
    }

    public HasilPanen cari(String kode) {

        for (HasilPanen p : daftar) {

            if (p.getKode().equalsIgnoreCase(kode)) {
                return p;
            }
        }

        return null;
    }

    public boolean hapus(String kode) {

        HasilPanen p = cari(kode);

        if (p != null) {
            daftar.remove(p);
            return true;
        }

        return false;
    }

    public boolean ubah(
            String kode,
            String komoditas,
            int jumlah,
            double harga
    ) {

        HasilPanen p = cari(kode);

        if (p != null) {

            p.setKomoditas(komoditas);
            p.setJumlah(jumlah);
            p.setHarga(harga);

            return true;
        }

        return false;
    }

    public void simpan() {

        try {

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(FILE)
                    );

            for (HasilPanen p : daftar) {

                bw.write(p.toString());

                bw.newLine();
            }

            bw.close();

            System.out.println("Data berhasil disimpan.");

        } catch (IOException e) {

            System.out.println("Gagal menyimpan.");
        }
    }

    public void muat() {

        try {

            File file = new File(FILE);

            if (!file.exists())
                return;

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(FILE)
                    );

            String baris;

            while ((baris = br.readLine()) != null) {

                String[] d =
                        baris.split(";");

                daftar.add(
                        new HasilPanen(
                                d[0],
                                d[1],
                                Integer.parseInt(d[2]),
                                Double.parseDouble(d[3])
                        )
                );
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Gagal memuat data.");
        }
    }

}