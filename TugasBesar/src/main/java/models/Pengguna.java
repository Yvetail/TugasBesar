package models;

import java.sql.Timestamp;
import java.util.Scanner;

public abstract class Pengguna {
    public int idUser;
    public String nama;
    public  String noHP;
    public String email;
    public String password;
    public java.sql.Timestamp tanggalDaftar;
    public String tipePengguna;
    Scanner scan = new Scanner(System.in);

    public Pengguna(int idUser, String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna) {
        this.idUser = idUser;
        this.nama = nama;
        this.noHP = noHP;
        this.email = email;
        this.password = password;
        this.tanggalDaftar = tanggalDaftar;
        this.tipePengguna = tipePengguna;
    }

    public Pengguna(int idUser) {
        this.idUser = idUser;
    }

    public Pengguna() {
    }

    public void display() {
        System.out.println("ID Pengguna: " + idUser);
        System.out.println("Nama: " + nama);
        System.out.println("Nomor HP: " + noHP);
        System.out.println("Email: " + email);
        System.out.println("Tanggal Daftar: " + tanggalDaftar);
        System.out.println("Tipe Pengguna: " + tipePengguna);
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(Timestamp tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }

    public String getTipePengguna() {
        return tipePengguna;
    }

    public void setTipePengguna(String tipePengguna) {
        this.tipePengguna = tipePengguna;
    }
    
    public void showInfoAkun(Pengguna akun){
        System.out.println("ID User :"+akun.getIdUser());
        System.out.println("Nama    :"+akun.getNama());
        System.out.println("No HP   :"+akun.getNoHP());
        System.out.println("Email   :"+akun.getEmail());
        System.out.println("Pass    :"+akun.getPassword());
        System.out.println("Daftar  :"+akun.getTanggalDaftar());
    }
  
    public void inputData(Pengguna akun){
        System.out.print("Nama ("+akun.getNama()+") :"); 
        akun.setNama(scan.next());
        System.out.print("No ("+akun.getNoHP()+") :"); 
        akun.setNoHP(scan.next());
        System.out.print("Email ("+akun.getEmail()+") :"); 
        akun.setEmail(scan.next());
        System.out.print("Password ("+akun.getPassword()+") :"); 
        akun.setPassword(scan.next());
    }
}
