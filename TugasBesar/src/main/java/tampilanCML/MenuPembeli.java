package tampilanCML;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Pembeli;
import models.Properti;
import utils.PembeliDAO;
import utils.PropertiDAO;

public class MenuPembeli {

    public void menu(int idAkun) throws SQLException {
        Scanner scan = new Scanner(System.in);
        Properti properti = new Properti();
        Pembeli pembeli = new Pembeli();
        List<Properti> propertis = PropertiDAO.getSemuaProperti();
        List<Properti> matchProp = new ArrayList<>();
        PembeliDAO pembeliDao = new PembeliDAO();
        PropertiDAO propertiDao = new PropertiDAO();
        int choice;
        do {
            System.out.println("Menu Utama:");
            System.out.println("1. Tampilkan Seluruh Properti Tersedia");
            System.out.println("2. Filter Lokasi Properti");
            System.out.println("3. Beli Properti");
            System.out.println("4. Informasi Akun");
            System.out.println("5. Ubah informasi Akun");
            System.out.println("6. List Properti Saya");
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
                    properti.showList(matchProp);
                    break;
                case 2:
                    System.out.print("Masukan lokasi:");
                    String lokasi = scan.nextLine();
                    matchProp = properti.searchByLoc(propertis, lokasi);
                    properti.showList(matchProp);
                case 3:
                    //Menampilkan properti 
                    matchProp = properti.tersedia(propertis);
                    properti.showList(matchProp);
                    do {
                        System.out.println("Pilih id properti yang ingin dibeli:");
                        choice = scan.nextInt();
                        
                        properti=propertiDao.getProperti(choice);
                        if(choice==0){
                            properti.setKetersediaan("Terjual");
                        }
//                        System.out.println( "testttttt"+properti.getKetersediaan());
                        if (choice == properti.getPropertiId() && properti.getKetersediaan().equals("Tersedia")) {
                            System.out.println("Anda memilih properti dengan id " + properti.getPropertiId());
                            propertiDao.purchase(properti, choice, idAkun);
                        } else {
                            System.out.println("Masukan ID yang sesuai");
                        }
                    } while (choice != 0);
                    choice=9;
                    break;
                case 4:
                    System.out.println("### Informasi Akun Anda ###");
                    pembeli = pembeliDao.infoAkun(idAkun);
                    pembeli.showInfoAkun(pembeli);
                    break;
                case 5:
                    System.out.println("### Ubah Informasi Akun ###");
                    pembeli = pembeliDao.infoAkun(idAkun);
                    pembeli.inputData(pembeli);
                    pembeliDao.updatePembeli(pembeli);
                    break;
                case 6:
                    System.out.println("Properti yang dimiliki:");
                    matchProp = properti.myProp(propertis, idAkun);
                    properti.showList(matchProp);
                    break;
                case 0:
                    break;

            }
        } while (choice != 0);

    }
}
