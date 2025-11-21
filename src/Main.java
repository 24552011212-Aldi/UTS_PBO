import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// Kelas utama aplikasi rental kendaraan
public class Main {
   private static final List<kendaraan> daftarKendaraan = new ArrayList<>();
   private static final List<pelanggan> daftarPelanggan = new ArrayList<>();
   private static final List<penyewaan> daftarPenyewaan = new ArrayList<>();
   private static int idPelangganCounter = 1;
   private static int idPenyewaanCounter = 1;
   private static final Scanner scanner = new Scanner(System.in);


   // Entry point aplikasi
   public static void main(String[] var0) {
      initializeData();

      int var1;
      do {
         tampilkanMenu();
         System.out.print("Pilih opsi (1-7): ");
         var1 = scanner.nextInt();
         scanner.nextLine();
         switch (var1) {
            case 1 -> tambahData();
            case 2 -> tampilkanData();
            case 3 -> cariData();
            case 4 -> ubahStatusKendaraan();
            case 5 -> cekStatusPenyewaan();
            case 6 -> buatPenyewaan();
            case 7 -> System.out.println(" Terima kasih, program berakhir.");
            default -> System.out.println(" Opsi tidak valid. Coba lagi.");
         }

         System.out.println("\n------------------------------------\n");
      } while(var1 != 7);

   }

   // Inisialisasi data awal (dummy)
   private static void initializeData() {
      daftarKendaraan.add(new mobil("Toyota", "Avanza", 2020, 4, "Automatic", 350000.0));
      daftarKendaraan.add(new mobil("Honda", "Jazz", 2018, 5, "Manual", 300000.0));
      daftarKendaraan.add(new motor("Yamaha", "Nmax", 2021, "Matic", 155, 120000.0));
      daftarPelanggan.add(new pelanggan(idPelangganCounter++, "Budi Santoso", "08123456789"));
      daftarPelanggan.add(new pelanggan(idPelangganCounter++, "Ani Lestari", "08567890123"));
      pelanggan var0 = (pelanggan)daftarPelanggan.get(0);
      kendaraan var1 = (kendaraan)daftarKendaraan.get(0);
      daftarPenyewaan.add(new penyewaan(idPenyewaanCounter++, var0, var1, 3));
   }

   // Menampilkan menu utama
   private static void tampilkanMenu() {
      System.out.println("--- SISTEM RENTAL KENDARAAN ---");
      System.out.println("1. Tambah Kendaraan Baru");
      System.out.println("2. Tampilkan Semua Data");
      System.out.println("3. Cari Kendaraan Berdasarkan Model");
      System.out.println("4. Ubah Status Ketersediaan");
      System.out.println("5. Cek Status Penyewaan");
      System.out.println("6. Buat Penyewaan Baru");
      System.out.println("7. Keluar Program");
   }

   // tambah kendaraan baru
   private static void tambahData() {
      System.out.println("\n--- TAMBAH KENDARAAN BARU ---");
      System.out.println("Tambah (1) Mobil atau (2) Motor?");
      int var0 = scanner.nextInt();
      scanner.nextLine();
      System.out.print("Merk: ");
      String var1 = scanner.nextLine();
      System.out.print("Model: ");
      String var2 = scanner.nextLine();
      System.out.print("Tahun Produksi: ");
      int var3 = scanner.nextInt();
      scanner.nextLine();
      double var6;
       switch (var0) {
           case 1 -> {
               System.out.print("Jumlah Pintu: ");
               int var4 = scanner.nextInt();
               scanner.nextLine();
               System.out.print("Jenis Transmisi: ");
               String var5 = scanner.nextLine();
               System.out.print("Tarif Harian: ");
               var6 = scanner.nextDouble();
               scanner.nextLine();
               mobil var8 = new mobil(var1, var2, var3, var4, var5, var6);
               daftarKendaraan.add(var8);
               System.out.println(" ✅ Mobil baru berhasil ditambahkan!");
           }
           case 2 -> {
               System.out.print("Jenis Motor (Matic/Sport/Bebek): ");
               String var9 = scanner.nextLine();
               System.out.print("Kapasitas Mesin (cc): ");
               int var10 = scanner.nextInt();
               scanner.nextLine();
               System.out.print("Tarif Harian: ");
               var6 = scanner.nextDouble();
               scanner.nextLine();
               motor var11 = new motor(var1, var2, var3, var9, var10, var6);
               daftarKendaraan.add(var11);
               System.out.println(" ✅ Motor baru berhasil ditambahkan!");
           }
           default -> System.out.println(" ❌ Pilihan jenis tidak valid.");
       }

   }

   // tampilkan semua data kendaraan & penyewaan
   private static void tampilkanData() {
      System.out.println("\n--- DAFTAR SEMUA KENDARAAN ---");
      if (daftarKendaraan.isEmpty()) {
         System.out.println("Belum ada kendaraan terdaftar.");
      } else {
         Iterator<kendaraan> var0 = daftarKendaraan.iterator();

         while(var0.hasNext()) {
            kendaraan var1 = (kendaraan)var0.next();
            var1.tampilkanInfo();
            System.out.println("------------------------------------");
         }

         System.out.println("\n--- DAFTAR PENYEWAAN AKTIF ---");
          for (penyewaan var2 : daftarPenyewaan) {
              var2.tampilkanDetailPenyewaan();
              System.out.println("------------------------------------");
          }

      }
   }

   // cari kendaraan berdasarkan model
   private static void cariData() {
      System.out.print("\nMasukkan Model Kendaraan yang dicari: ");
      String var0 = scanner.nextLine();
      boolean var1 = false;
   Iterator<kendaraan> var2 = daftarKendaraan.iterator();

      while(var2.hasNext()) {
         kendaraan var3 = (kendaraan)var2.next();
         if (var3.getModel().equalsIgnoreCase(var0)) {
            System.out.println("\n✅ Kendaraan ditemukan:");
            var3.tampilkanInfo();
            var1 = true;
            break;
         }
      }

      if (!var1) {
         System.out.println("\n❌ Kendaraan dengan model '" + var0 + "' tidak ditemukan.");
      }

   }

   // Handler ubah status ketersediaan kendaraan
   private static void ubahStatusKendaraan() {
      System.out.print("\nMasukkan Model Kendaraan yang akan diubah statusnya: ");
      String var0 = scanner.nextLine();
      kendaraan var1 = null;
   Iterator<kendaraan> var2 = daftarKendaraan.iterator();

      while(var2.hasNext()) {
         kendaraan var3 = (kendaraan)var2.next();
         if (var3.getModel().equalsIgnoreCase(var0)) {
            var1 = var3;
            break;
         }
      }

      if (var1 != null) {
         System.out.println("Status saat ini: " + (var1.isTersedia() ? "Tersedia" : "Sedang disewa"));
         System.out.print("Ubah ke status Tersedia (y/n)? ");
         String var4 = scanner.nextLine();
         if (var4.equalsIgnoreCase("y")) {
            var1.setTersedia(true);
            System.out.println("✅ Status " + var1.getModel() + " berhasil diubah menjadi TERSEDIA.");
         } else if (var4.equalsIgnoreCase("n")) {
            var1.setTersedia(false);
            System.out.println("✅ Status " + var1.getModel() + " berhasil diubah menjadi TIDAK TERSEDIA.");
         } else {
            System.out.println("Pilihan tidak valid. Status tidak diubah.");
         }
      } else {
         System.out.println("❌ Kendaraan tidak ditemukan.");
      }

   }

   // Handler cek status penyewaan berdasarkan ID
   private static void cekStatusPenyewaan() {
      System.out.print("Masukkan ID Penyewaan yang akan dicek: ");
      int var0 = scanner.nextInt();
      scanner.nextLine();
      boolean var1 = false;
   Iterator<penyewaan> var2 = daftarPenyewaan.iterator();

      while(var2.hasNext()) {
         penyewaan var3 = (penyewaan)var2.next();
         if (var3.getIdPenyewaan() == var0) {
            var3.cekStatusPelanggan();
            var1 = true;
            break;
         }
      }

      if (!var1) {
         System.out.println("❌ Penyewaan dengan ID " + var0 + " tidak ditemukan.");
      }

   }

   // Handler buat penyewaan baru
   private static void buatPenyewaan() {
      System.out.println("\n--- BUAT PENYEWAAN BARU ---");
      System.out.println("Pelanggan yang tersedia:");
   Iterator<pelanggan> var0 = daftarPelanggan.iterator();

      PrintStream var10000;
      while(var0.hasNext()) {
         pelanggan var1 = (pelanggan)var0.next();
         var10000 = System.out;
         int var10001 = var1.getIdPelanggan();
         var10000.println("- ID " + var10001 + ": " + var1.getNama());
      }

      System.out.print("Masukkan ID Pelanggan: ");
      int var7 = scanner.nextInt();
      scanner.nextLine();
      System.out.println("Kendaraan yang tersedia (Model):");
   Iterator<kendaraan> var8 = daftarKendaraan.iterator();

      while(var8.hasNext()) {
         kendaraan var2 = (kendaraan)var8.next();
         if (var2.isTersedia()) {
            var10000 = System.out;
            String var14 = var2.getModel();
            var10000.println("- " + var14 + " (" + var2.getMerk() + ")");
         }
      }

      System.out.print("Masukkan Model Kendaraan yang akan disewa: ");
      String var9 = scanner.nextLine();
      System.out.print("Durasi Sewa (hari): ");
      int var10 = scanner.nextInt();
      scanner.nextLine();
      pelanggan var3 = null;
   Iterator<pelanggan> var4 = daftarPelanggan.iterator();

      while(var4.hasNext()) {
         pelanggan var5 = (pelanggan)var4.next();
         if (var5.getIdPelanggan() == var7) {
            var3 = var5;
            break;
         }
      }

      kendaraan var11 = null;
   Iterator<kendaraan> var12 = daftarKendaraan.iterator();

      while(var12.hasNext()) {
         kendaraan var6 = (kendaraan)var12.next();
         if (var6.getModel().equalsIgnoreCase(var9) && var6.isTersedia()) {
            var11 = var6;
            break;
         }
      }

      if (var3 != null && var11 != null) {
         penyewaan var13 = new penyewaan(idPenyewaanCounter++, var3, var11, var10);
         daftarPenyewaan.add(var13);
         System.out.println("✅ Penyewaan berhasil dibuat!");
         var13.tampilkanDetailPenyewaan();
      } else {
         System.out.println("❌ Gagal membuat penyewaan. Pelanggan tidak ditemukan atau Kendaraan tidak tersedia.");
      }

   }

}
