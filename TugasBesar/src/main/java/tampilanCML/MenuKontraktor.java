package tampilanCML;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Pembeli;
import models.Properti;
import utils.PembeliDAO;
import utils.PropertiDAO;

public class MenuKontraktor {

    public void menu(int idAkun) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Properti properti = new Properti();
        Pembeli pembeli = new Pembeli();
        List<Properti> propertis = PropertiDAO.getSemuaProperti();
        List<Properti> matchProp = new ArrayList<>();
        PembeliDAO pembeliDao = new PembeliDAO();
        int choice;
        do {
            System.out.println("Menu Utama:");
            System.out.println("1. Tampilkan Seluruh Properti Tersedia");
            System.out.println("2. Filter Lokasi Properti");
            System.out.println("3. Beli Properti");
            System.out.println("4. Informasi Akun");
            System.out.println("5. List Properti Saya");
            System.out.println("0. Log Out");
            System.out.print("Pilihan Anda: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
//                    propertis = PropertiDAO.getSemuaProperti();
//                    for (Properti i : propertis) {
//                        properti.displayProperti(i);
//                    }
                    matchProp = properti.tersedia(propertis);
                    for (Properti i : matchProp) {
                        properti.displayProperti(i);
                    }
                    break;
                case 2:
                    System.out.print("Masukan lokasi:");
                    String lokasi = scan.nextLine();
                    matchProp = properti.searchByLoc(propertis, lokasi);
                    for (Properti i : matchProp) {
                        properti.displayProperti(i);
                    }
                    break;
                case 4:
                    System.out.println("### Informasi Akun Anda ###");
                    pembeli = pembeliDao.infoAkun(idAkun);
                    pembeli.showInfoAkun(pembeli);
                    break;
                case 0:
                    break;

            }
        } while (choice != 0);

    }
}
