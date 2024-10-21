package tampilanCML;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Pembeli;
import models.Properti;
import utils.KontraktorDAO;
import utils.PembeliDAO;
import utils.PropertiDAO;

public class MenuAdmin {

    private Scanner scan ;
    private PropertiDAO propertiDao;
    private PembeliDAO pembeliDao;
    private KontraktorDAO kontraktorDao;
    Properti properti = new Properti();
    Pembeli pembeli = new Pembeli();
    List<Properti> matchProp = new ArrayList<>();
    List<Properti> propertis = PropertiDAO.getSemuaProperti();
    int choice;
    
    public MenuAdmin() {
        scan = new Scanner(System.in);
        propertiDao = new PropertiDAO();
        pembeliDao = new PembeliDAO();
        kontraktorDao = new KontraktorDAO();
    }

    public void menu(int idAkun) throws SQLException {
        int pilihan;
      do {
            System.out.println("Menu Admin:");
            System.out.println("1. Tambah Properti");
            System.out.println("2. Update Properti");
            System.out.println("3. Hapus Properti");
            System.out.println("4. Semua Informasi Properti");
            System.out.println("5. Tambah Akun Pembeli");
            System.out.println("6. Update Akun Pembeli");
            System.out.println("7. Hapus Akun Pembeli");
            System.out.println("8. Semua Informasi Akun Pembeli");
            System.out.println("9. Tambah Akun Kontraktor");
            System.out.println("10. Update Akun Kontraktor");
            System.out.println("11. Hapus Akun Kontraktor");
            System.out.println("12. Semua Informasi Akun Kontraktor");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scan.nextInt();

            switch (pilihan) {
                case 1:
                    // Tambah Properti
                    properti.addProperti();
                    propertiDao.tambahProperti(properti);
                    break;
                case 2:
                    System.out.println("#### List Properti ###");
                    propertis = PropertiDAO.getSemuaProperti();
                    for (Properti i : propertis) {
                        properti.displayProperti(i);
                    }
                    System.out.println("Pilih ID Properti yang akan diupdate :"); 
                    pilihan  = scan.nextInt();
                    properti.updateProperti();
                    propertiDao.updateProperti(properti, pilihan);
                    break;
                case 3:
                    System.out.println("#### List Properti ###");
                    propertis = PropertiDAO.getSemuaProperti();
                    for (Properti i : propertis) {
                        properti.displayProperti(i);
                    }
                    System.out.println("Pilih ID Properti yang akan dihapus :"); 
                    pilihan  = scan.nextInt();
                    propertiDao.hapusProperti(pilihan);
                    break;
                case 4:
                    propertis = PropertiDAO.getSemuaProperti();
                    for (Properti i : propertis) {
                        properti.displayProperti(i);
                    }
                    break;
                case 5:
                    
                    tambahAkunPembeli();
                    break;
                case 6:
                    idAkun=scan.nextInt();
                    System.out.println("### Ubah Akun Pembeli ###");
                    pembeli = pembeliDao.infoAkun(idAkun);
                    pembeli.inputData(pembeli);
                    pembeliDao.updatePembeli(pembeli);
                    updateAkunPembeli();
                    break;
                case 7:
                    // Hapus Akun Pembeli
                    hapusAkunPembeli();
                    break;
                case 8:
                    // Semua Informasi Akun Pembeli
                    semuaInformasiAkunPembeli();
                    break;
                case 9:
                    // Tambah Akun Kontraktor
                    tambahAkunKontraktor();
                    break;
                case 10:
                    // Update Akun Kontraktor
                    updateAkunKontraktor();
                    break;
                case 11:
                    // Hapus Akun Kontraktor
                    hapusAkunKontraktor();
                    break;
                case 12:
                    // Semua Informasi Akun Kontraktor
                    semuaInformasiAkunKontraktor();
                    break;
                case 0:
                    // Keluar dari Menu Admin
                    System.out.println("Terima kasih! Keluar dari Menu Admin.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                    break;
            }
        } while (pilihan != 0);
    }

//    // Implementasikan method-method untuk setiap pilihan menu di sini
//    // contoh:
//    private void tambahProperti() {
//    // Logika untuk menambah properti
//    System.out.println("Masukkan detail properti:");
//
//    // Membersihkan newline di buffer setelah nextInt() atau nextDouble()
//    scanner.nextLine();
//
//    System.out.print("Nama: ");
//    String nama = scanner.nextLine();
//
//    System.out.print("Deskripsi: ");
//    String deskripsi = scanner.nextLine();
//
//    System.out.print("Lokasi: ");
//    String lokasi = scanner.nextLine();
//
//    System.out.print("Harga: ");
//    double harga = scanner.nextDouble();
//
//    System.out.print("Panjang Rumah: ");
//    double panjangRumah = scanner.nextDouble();
//
//    System.out.print("Lebar Rumah: ");
//    double lebarRumah = scanner.nextDouble();
//
//    double luasRumah = lebarRumah * panjangRumah;
//
//    // Membersihkan newline di buffer setelah nextDouble()
//    scanner.nextLine();
//
//    System.out.print("Ketersediaan: ");
//    String ketersediaan = scanner.nextLine();
//
//    // Mendapatkan waktu saat ini untuk properti yang ditambahkan
//    Timestamp tanggalDaftar = new Timestamp(System.currentTimeMillis());
//
//    double jumlahDiFavoritkan = 0; // Sesuaikan dengan kebutuhan Anda
//
//    Properti p1 = new Properti(nama, deskripsi, lokasi, harga, panjangRumah, lebarRumah, luasRumah, jumlahDiFavoritkan, ketersediaan, tanggalDaftar);
//    pp1.tambahProperti(p1);
//    }

    private void updateProperti() {
        // Logika untuk mengupdate properti
    }

    private void hapusProperti() {
        // Logika untuk menghapus properti
    }

//    private void semuaInformasiProperti() {
//        // Logika untuk menampilkan semua informasi properti
//    }

    private void tambahAkunPembeli() {
        // Logika untuk menambah akun pembeli
    }

    private void updateAkunPembeli() {
        // Logika untuk mengupdate akun pembeli
    }

    private void hapusAkunPembeli() {
        // Logika untuk menghapus akun pembeli
    }

    private void semuaInformasiAkunPembeli() {
        // Logika untuk menampilkan semua informasi akun pembeli
    }

    private void tambahAkunKontraktor() {
        // Logika untuk menambah akun kontraktor
    }

    private void updateAkunKontraktor() {
        // Logika untuk mengupdate akun kontraktor
    }

    private void hapusAkunKontraktor() {
        // Logika untuk menghapus akun kontraktor
    }

    private void semuaInformasiAkunKontraktor() {
        // Logika untuk menampilkan semua informasi akun kontraktor
    }
}
