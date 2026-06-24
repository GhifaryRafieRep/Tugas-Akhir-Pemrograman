import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        PanenService service =
                new PanenService();

        service.muat();

        int pilih = 0;

        do {

            try {

                System.out.println(
                        "\n=== APLIKASI HASIL PANEN ===");

                System.out.println("1. Tambah");
                System.out.println("2. Tampil");
                System.out.println("3. Ubah");
                System.out.println("4. Hapus");
                System.out.println("5. Cari");
                System.out.println("6. Simpan");
                System.out.println("0. Keluar");

                System.out.print(
                        "Pilih: ");

                pilih =
                        Integer.parseInt(
                                input.nextLine()
                        );

                switch (pilih) {

                    case 1:

                        System.out.print("Kode: ");
                        String kode =
                                input.nextLine();

                        System.out.print("Komoditas: ");
                        String kom =
                                input.nextLine();

                        System.out.print("Jumlah: ");
                        int jumlah =
                                Integer.parseInt(
                                        input.nextLine()
                                );

                        System.out.print("Harga: ");
                        double harga =
                                Double.parseDouble(
                                        input.nextLine()
                                );

                        service.tambah(
                                new HasilPanen(
                                        kode,
                                        kom,
                                        jumlah,
                                        harga
                                )
                        );

                        break;

                    case 2:

                        service.tampil();

                        break;

                    case 3:

                        System.out.print("Kode dicari: ");

                        kode =
                                input.nextLine();

                        System.out.print(
                                "Komoditas baru: ");

                        kom =
                                input.nextLine();

                        System.out.print(
                                "Jumlah baru: ");

                        jumlah =
                                Integer.parseInt(
                                        input.nextLine()
                                );

                        System.out.print(
                                "Harga baru: ");

                        harga =
                                Double.parseDouble(
                                        input.nextLine()
                                );

                        if (service.ubah(
                                kode,
                                kom,
                                jumlah,
                                harga)) {

                            System.out.println(
                                    "Berhasil diubah");

                        } else {

                            System.out.println(
                                    "Data tidak ditemukan");
                        }

                        break;

                    case 4:

                        System.out.print(
                                "Kode hapus: ");

                        kode =
                                input.nextLine();

                        if (service.hapus(kode)) {

                            System.out.println(
                                    "Berhasil dihapus");

                        } else {

                            System.out.println(
                                    "Data tidak ditemukan");
                        }

                        break;

                    case 5:

                        System.out.print(
                                "Kode cari: ");

                        kode =
                                input.nextLine();

                        HasilPanen p =
                                service.cari(kode);

                        if (p != null) {

                            System.out.println(
                                    p.getKode()
                                            + " "
                                            + p.getKomoditas()
                            );

                        } else {

                            System.out.println(
                                    "Tidak ditemukan");
                        }

                        break;

                    case 6:

                        service.simpan();

                        break;

                    case 0:

                        service.simpan();

                        System.out.println(
                                "Program selesai");

                        break;

                    default:

                        System.out.println(
                                "Menu tidak tersedia");
                }

            } catch (Exception e) {

                System.out.println(
                        "Input tidak valid!");
            }

        } while (pilih != 0);

    }
}