/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Timestamp;

/**
 *
 * @author usama
 */
public class Donasi {
    private int idDonasi;
    private int nominalDonasi;
    private int jumlahDonasi;
    private Timestamp waktuDonasi;
    private int banyakDonasi;
    private int idUser;

    public Donasi(int idDonasi, int nominalDonasi, int jumlahDonasi, Timestamp waktuDonasi, int banyakDonasi, int idUser) {
        this.idDonasi = idDonasi;
        this.nominalDonasi = nominalDonasi;
        this.jumlahDonasi = jumlahDonasi;
        this.waktuDonasi = waktuDonasi;
        this.banyakDonasi = banyakDonasi;
        this.idUser = idUser;
    }

    public Donasi() {
    }
    

    public int getIdDonasi() {
        return idDonasi;
    }

    public void setIdDonasi(int idDonasi) {
        this.idDonasi = idDonasi;
    }

    public int getNominalDonasi() {
        return nominalDonasi;
    }

    public void setNominalDonasi(int nominalDonasi) {
        this.nominalDonasi = nominalDonasi;
    }

    public int getJumlahDonasi() {
        return jumlahDonasi;
    }

    public void setJumlahDonasi(int jumlahDonasi) {
        this.jumlahDonasi = jumlahDonasi;
    }

    public Timestamp getWaktuDonasi() {
        return waktuDonasi;
    }

    public void setWaktuDonasi(Timestamp waktuDonasi) {
        this.waktuDonasi = waktuDonasi;
    }

    public int getBanyakDonasi() {
        return banyakDonasi;
    }

    public void setBanyakDonasi(int banyakDonasi) {
        this.banyakDonasi = banyakDonasi;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
}
