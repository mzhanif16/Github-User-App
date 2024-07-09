# GitHub User App

![License](https://img.shields.io/badge/license-MIT-blue.svg)

## Deskripsi Singkat
My GitHub User adalah aplikasi Android yang memungkinkan pengguna untuk mencari informasi pengguna GitHub, melihat repositori mereka, dan mencari pengguna lainnya. Aplikasi ini dibangun dengan menggunakan arsitektur bersih dan modularisasi untuk meningkatkan skalabilitas dan maintainability.

## Daftar Isi
- [Fitur](#fitur)
- [Arsitektur](#arsitektur)
- [Instalasi](#instalasi)
- [Penggunaan](#penggunaan)
- [Kontribusi](#kontribusi)
- [Lisensi](#lisensi)
- [Kontak](#kontak)

## Fitur
- Mendapatkan informasi pengguna GitHub.
- Melihat daftar repositori pengguna.
- Mencari pengguna GitHub berdasarkan nama pengguna.

## Arsitektur
Aplikasi ini mengikuti prinsip arsitektur bersih dan modularisasi. Struktur utama terdiri dari:
- **Data Layer**: Berisi implementasi sumber data seperti API dan database lokal.
- **Domain Layer**: Berisi use case dan repository interface.
- **Presentation Layer**: Berisi ViewModel dan UI (Activity, Fragment).

### Modul
- **app**: Modul utama yang mengikat semua modul lainnya.
- **core**: Berisi logika bisnis dan utilitas bersama.
  - **navigation**: Modul untuk navigasi antar layar.
  - **designsystem**: Berisi komponen UI bersama.
  - **domain**: Berisi use case dan entitas domain.
- **feature**: Berisi fitur-fitur utama aplikasi seperti pencarian pengguna, informasi pengguna, dan repositori.

## Instalasi
### Prasyarat
- Android Studio 4.0 atau lebih baru
- JDK 8 atau lebih baru

### Langkah-langkah
1. Clone repositori:
    ```sh
    git clone https://github.com/mzhanif16/Github-User-App.git
    ```
2. Buka proyek di Android Studio.
3. Sinkronkan proyek dengan Gradle.

## Penggunaan
### Menjalankan Aplikasi
Setelah instalasi, jalankan aplikasi di Android Studio dengan memilih perangkat emulator atau perangkat fisik.

### Konfigurasi API
Anda perlu menyediakan token GitHub API di file `local.properties`:

### Fitur Utama
1. **Mencari Pengguna**:
   - Buka aplikasi dan masukkan nama pengguna GitHub di kolom pencarian.
   - Tekan tombol cari untuk melihat hasilnya.

2. **Melihat Informasi Pengguna**:
   - Klik pada hasil pencarian untuk melihat detail informasi pengguna.

3. **Melihat Repositori**:
   - Di halaman detail pengguna, Anda dapat melihat daftar repositori mereka.

## Lisensi
Proyek ini dilisensikan di bawah lisensi MIT. Lihat file [LICENSE](LICENSE) untuk informasi lebih lanjut.

