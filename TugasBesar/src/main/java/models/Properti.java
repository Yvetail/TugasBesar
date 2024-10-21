package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.PropertiDAO;

public class Properti {

    private int propertiId;
    private String nama;
    private String deskripsi;
    private String lokasi;
    private double harga;
    private double panjangRumah;
    private double lebarRumah;
    private double luasRumah;
    private double jumlahDiFavoritkan;
    private int idUser; // Menunjukkan pemilik Properti
    private String ketersediaan;
    private Timestamp waktuDitambahkan; // Tambahkan atribut waktuDitambahkan
    public Scanner scan = new Scanner(System.in);

    // Constructor
    public Properti(String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, double jumlahDiFavoritkan, String ketersediaan, Timestamp waktuDitambahkan, Integer idUser) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = panjangRumah * lebarRumah;
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
        this.ketersediaan = ketersediaan;
        this.waktuDitambahkan = waktuDitambahkan; // Inisialisasi atribut waktuDitambahkan
        this.idUser = idUser;
    }

    public Properti(int propertiId, String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, double jumlahDiFavoritkan, String ketersediaan, Timestamp waktuDitambahkan, int idUser) {
        this.propertiId = propertiId;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = luasRumah;
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
        this.ketersediaan = ketersediaan;
        this.waktuDitambahkan = waktuDitambahkan;
        this.idUser = idUser;
    }

     public Properti(int propertiId, String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, String ketersediaan) {
        this.propertiId = propertiId;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = luasRumah;
        this.ketersediaan= ketersediaan;
    }
    
    public Properti(String nama, String deskripsi, String lokasi, double harga, double panjangRumah, double lebarRumah, double luasRumah, double jumlahDiFavoritkan, String ketersediaan, Timestamp waktuDitambahkan) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.harga = harga;
        this.panjangRumah = panjangRumah;
        this.lebarRumah = lebarRumah;
        this.luasRumah = panjangRumah * lebarRumah;
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
        this.ketersediaan = ketersediaan;
        this.waktuDitambahkan = waktuDitambahkan; // Inisialisasi atribut waktuDitambahkan
    }
    

    public Properti() {
    }

    // Getter and Setter for waktuDitambahkan
    public Timestamp getWaktuDitambahkan() {
        return waktuDitambahkan;
    }

    public void setWaktuDitambahkan(Timestamp waktuDitambahkan) {
        this.waktuDitambahkan = waktuDitambahkan;
    }

    public int getPropertiId() {
        return propertiId;
    }

    public void setPropertiId(int propertiId) {
        this.propertiId = propertiId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getPanjangRumah() {
        return panjangRumah;
    }

    public void setPanjangRumah(double panjangRumah) {
        this.panjangRumah = panjangRumah;
    }

    public double getLebarRumah() {
        return lebarRumah;
    }

    public void setLebarRumah(double lebarRumah) {
        this.lebarRumah = lebarRumah;
    }

    public double getLuasRumah(double panjangRumah, double lebarRumah) {
        return luasRumah = panjangRumah * lebarRumah;
    }

    public void setLuasRumah(double luasRumah) {
        this.luasRumah = luasRumah;
    }

    public double getJumlahDiFavoritkan() {
        return jumlahDiFavoritkan;
    }

    public void setJumlahDiFavoritkan(double jumlahDiFavoritkan) {
        this.jumlahDiFavoritkan = jumlahDiFavoritkan;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getKetersediaan() {
        return ketersediaan;
    }

    public void setKetersediaan(String ketersediaan) {
        this.ketersediaan = ketersediaan;
    }

//    public void displayProperti() {
//        //System.out.println("ID Properti: " + propertiId);
//        System.out.println("Nama: " + nama);
//        System.out.println("Deskripsi: " + deskripsi);
//        System.out.println("Lokasi: " + lokasi);
//        System.out.println("Harga: " + harga);
//        System.out.println("Panjang Rumah: " + panjangRumah);
//        System.out.println("Lebar Rumah: " + lebarRumah);
//        System.out.println("Luas Rumah: " + luasRumah);
//        System.out.println("Jumlah di Favoritkan: " + jumlahDiFavoritkan);
//        System.out.println("ID Pemilik Properti: " + idUser);
//        System.out.println("Ketersediaan: " + ketersediaan);
//        System.out.println("Waktu Ditambahkan: " + waktuDitambahkan);
    public void displayProperti(Properti i) { //i digunakan untuk nilai increment(indeks) list properti
        System.out.println("ID Properti: " + i.getPropertiId());
        System.out.println("Nama: " + i.getNama());
        System.out.println("Deskripsi: " + i.getDeskripsi());
        System.out.println("Lokasi: " + i.getLokasi());
        System.out.println("Harga: " + i.getHarga());
        System.out.println("Panjang Rumah: " + i.getPanjangRumah());
        System.out.println("Lebar Rumah: " + i.getLebarRumah());
        System.out.println("Luas Rumah: " + i.getLuasRumah(i.getPanjangRumah(), i.getLebarRumah()));
//        System.out.println("Jumlah di Favoritkan: " + jumlahDiFavoritkan);
       System.out.println("ID Pemilik Properti: " + i.getIdUser());
        System.out.println("Ketersediaan: " + i.getKetersediaan());
        System.out.println("Waktu Ditambahkan: " + i.getWaktuDitambahkan());
        System.out.println("");
    }

    public void addProperti() {
        System.out.println("Nama: ");
        nama = scan.nextLine();
        setNama(nama);
        System.out.println("Deskripsi: ");
        deskripsi = scan.nextLine();
        setDeskripsi(deskripsi);
        System.out.println("Lokasi: ");
        lokasi = scan.next();
        setLokasi(lokasi);
        System.out.println("Harga: ");
        harga = scan.nextInt();
        setHarga(harga);
        System.out.println("Panjang Rumah: ");
        panjangRumah = scan.nextInt();
        setPanjangRumah(panjangRumah);
        System.out.println("Lebar Rumah: ");
        lebarRumah = scan.nextInt();
        setLebarRumah(lebarRumah);
//        System.out.println("ID Pemilik Properti: " + idUser);
//        System.out.println("Ketersediaan: " + ketersediaan);
//        System.out.println("Waktu Ditambahkan: " + waktuDitambahkan);
    }

    public void updateProperti() {
        // Note : Tambahkan tampilan data awal terlebih dahulu sesuai id
        System.out.println("Nama: ");
        nama = scan.nextLine();
        setNama(nama);
        System.out.println("Deskripsi: ");
        deskripsi = scan.nextLine();
        setDeskripsi(deskripsi);
        System.out.println("Lokasi: ");
        lokasi = scan.nextLine();
        setLokasi(lokasi);
        System.out.println("Harga: " + harga);
        harga = scan.nextInt();
        setHarga(harga);
        System.out.println("Panjang Rumah: ");
        panjangRumah = scan.nextInt();
        setPanjangRumah(panjangRumah);
        System.out.println("Lebar Rumah: ");
        lebarRumah = scan.nextInt();
        setLebarRumah(lebarRumah);
        System.out.println("ID Pemilik Properti: ");
        idUser = scan.nextInt();
        setIdUser(idUser);
        System.out.println("Ketersediaan: " + ketersediaan);
        ketersediaan = scan.next();
        setKetersediaan(ketersediaan);
        //System.out.println("Waktu Ditambahkan: " + waktuDitambahkan);
    }

    public List searchByLoc(List<Properti> propertis, String lokasi) {
        propertis = PropertiDAO.getSemuaProperti();
        List<Properti> matchLoc = new ArrayList<>();
        for (Properti iterasi : propertis) {
            if (iterasi.getLokasi().compareToIgnoreCase(lokasi)==0) {
                matchLoc.add(iterasi);
            }
        }
        return matchLoc;

    }
    
    public List tersedia(List<Properti> propertis) {
        propertis = PropertiDAO.getSemuaProperti();
        List<Properti> avaible = new ArrayList<>();
        for (Properti iterasi : propertis) {
            if (iterasi.getKetersediaan().equals("Tersedia")) {
                avaible.add(iterasi);
            }
        }
        return avaible;
    }
    
    public List myProp(List<Properti> propertis, int idAkun) {
        propertis = PropertiDAO.getSemuaProperti();
        List<Properti> mine = new ArrayList<>();
        for (Properti iterasi : propertis) {
            if (iterasi.getIdUser()==idAkun) {
                mine.add(iterasi);
            }
        }
        return mine;
    }
    
    public void showList(List<Properti> listProperti){
        Properti properti = new Properti();
        for (Properti i : listProperti) {
                        properti.displayProperti(i);
                    }
    }
}
