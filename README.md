# TugasBesar
Apapun

## MySQL Query
CREATE DATABASE IF NOT EXISTS revisi;
USE revisi;

CREATE TABLE IF NOT EXISTS Pengguna (
    idUser INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    noHP VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    tanggalDaftar TIMESTAMP,
    tipePengguna VARCHAR(20) NOT NULL,
    waktuDonasi TIMESTAMP,
    link VARCHAR(255),
    jumlahTerbeli INT,
    favorit INT
);

CREATE TABLE IF NOT EXISTS Properti (
    propertiId INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    deskripsi TEXT,
    lokasi VARCHAR(255),
    harga DOUBLE,
    panjangRumah DOUBLE,
    lebarRumah DOUBLE,
    luasRumah DOUBLE,
    jumlahDiFavoritkan DOUBLE,
    idUser INT,
    ketersediaan VARCHAR(20),
    waktuDitambahkan TIMESTAMP,
    FOREIGN KEY (idUser) REFERENCES Pengguna(idUser)
);
