
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import models.Properti;
import tampilanCML.MenuAdmin;
import tampilanCML.MenuKontraktor;
import tampilanCML.MenuPembeli;
import utils.PropertiDAO;
import utils.BaseDAO;
import models.Admin;
import models.Kontraktor;
import models.Pembeli;
import utils.KontraktorDAO;
import utils.PembeliDAO;

public class ProjectProperti {

    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        BaseDAO conn = new BaseDAO();
        PropertiDAO propertiDao = new PropertiDAO();
        PembeliDAO pembeliDao = new PembeliDAO();
        KontraktorDAO kontrkatorDao = new KontraktorDAO();
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuPembeli menuPembeli = new MenuPembeli();
        MenuKontraktor menuKontraktor = new MenuKontraktor();
        Admin admin = new Admin();
        Kontraktor kontraktor = new Kontraktor();
        Pembeli pembeli = new Pembeli();
        Properti properti = new Properti();
        List<Properti> propertis = PropertiDAO.getSemuaProperti();

        int choice;
        do {
            System.out.println("Menu Utama:");
            System.out.println("1. Informasi Properti");
            System.out.println("2. Sign Up");
            System.out.println("3. Sign In");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");

            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    // Panggil method atau tampilkan informasi properti
                    System.out.println("Anda memilih Informasi Properti.");
                    propertis = PropertiDAO.getSemuaProperti();
                    for (Properti i : propertis) {
                        properti.displayProperti(i);
                    }
                    break;
                case 2:
                    // Panggil method atau tampilkan proses sign up
                    System.out.println("Anda memilih Sign Up.");
                    System.out.println("1. Pembeli");
                    System.out.println("2. Kontraktor");
                    int signUpChoice = scan.nextInt();
                    scan.nextLine(); //pembersihan buffer
                    switch (signUpChoice) {
                        case 1:
                            // Proses sign up sebagai Pembeli
                            System.out.println("Anda memilih Sign Up sebagai Pembeli.");
                            // Tambahkan proses sign up Pembeli di sini
                            System.out.println("Masukkan data Pembeli:");

                            System.out.print("Nama: ");
                            String nama = scan.nextLine();
                            pembeli.setNama(nama);

                            System.out.print("Nomor HP: ");
                            String noHP = scan.nextLine();
                            pembeli.setNoHP(noHP);

                            System.out.print("Email: ");
                            String email = scan.nextLine();
                            pembeli.setEmail(email);

                            System.out.print("Password: ");
                            String password = scan.nextLine();
                            pembeli.setPassword(password);
                            pembeliDao.tambahPembeli(pembeli);

                            break;
                        case 2:
                            // Proses sign up sebagai Kontraktor
                            System.out.println("Anda memilih Sign Up sebagai Kontraktor.");
                            // Tambahkan proses sign up Kontraktor di sini
                            System.out.println("Masukkan data Kontraktor:");

                            System.out.print("Nama: ");
                            nama = scan.nextLine();
                            kontraktor.setNama(nama);

                            System.out.print("Nomor HP: ");
                            noHP = scan.nextLine();
                            kontraktor.setNoHP(noHP);

                            System.out.print("Email: ");
                            email = scan.nextLine();
                            kontraktor.setEmail(email);
                            System.out.print("Password: ");
                            password = scan.nextLine();
                            kontraktor.setPassword(password);
                            kontrkatorDao.tambahKontraktor(kontraktor);
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                            break;
                    }
                    break;
                case 3:
                    // Panggil method atau tampilkan proses sign in
                    System.out.println("Anda memilih Sign In.");
                    System.out.print("Masukkan email: ");
                    String email = scan.next();
                    System.out.print("Masukkan password: ");
                    String password = scan.next();
                    Pembeli akunNow = new Pembeli();
                    akunNow = conn.login(email, password);
                    if (akunNow.getTipePengguna().equals("Admin")) {
                        System.out.println("Anda berhasil sign in sebagai Admin.");
                        menuAdmin.menu(akunNow.getIdUser());
                    } else if (akunNow.getTipePengguna().equals("Pembeli")) {
                        System.out.println("Anda berhasil sign in sebagai Pembeli.");
                        menuPembeli.menu(akunNow.getIdUser());
                    } else if (akunNow.getTipePengguna().equals("Kontraktor")) {
                        System.out.println("Anda berhasil sign in sebagai Kontraktor.");
                        menuKontraktor.menu(akunNow.getIdUser());
                    } else {
                        // Sign in gagal
                        System.out.println("Sign in gagal. Email atau password salah.");
                    }

                    break;

                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                    break;
            }
        } while (choice != 0);

        scan.close();
    }
}
