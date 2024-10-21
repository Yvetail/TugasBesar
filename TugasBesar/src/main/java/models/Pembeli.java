package models;

import java.sql.Timestamp;

public class Pembeli extends Pengguna {

    private int jumlahTerbeli;
    private int favorit;

    public Pembeli(int idUser, String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna, int jumlahTerbeli, int favorit) {
        super(idUser, nama, noHP, email, password, tanggalDaftar, "Pembeli");
        this.jumlahTerbeli = jumlahTerbeli;
        this.favorit = favorit;
    }

    public Pembeli(int idUser) {
        super(idUser);
    }

    public Pembeli(int idUser, String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna) {
        super(idUser, nama, noHP, email, password, tanggalDaftar, tipePengguna);
    }

    public Pembeli(int idUSer, String tipePengguna) {
        this.idUser=idUSer;
        this.tipePengguna=tipePengguna;
    }

    public Pembeli() {
    }

    public boolean isValidPembeli(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(email) && enteredPassword.equals(password);
    }

    public int getJumlahTerbeli() {
        return jumlahTerbeli;
    }

    public void setJumlahTerbeli(int jumlahTerbeli) {
        this.jumlahTerbeli = jumlahTerbeli;
    }

    public int getFavorit() {
        return favorit;
    }

    public void setFavorit(int favorit) {
        this.favorit = favorit;
    }
    
//    public void showInfoAkun(Pembeli akun){
//        System.out.println("ID User :"+akun.getIdUser());
//        System.out.println("Nama    :"+akun.getNama());
//        System.out.println("No HP   :"+akun.getNoHP());
//        System.out.println("Email   :"+akun.getEmail());
//        System.out.println("Pass    :"+akun.getPassword());
//        System.out.println("Daftar  :"+akun.getTanggalDaftar());
//    }
}
