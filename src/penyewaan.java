
// Representasi transaksi penyewaan
public class penyewaan {
   private final int idPenyewaan;
   private final pelanggan pelanggan;
   private final kendaraan kendaraan;
   private final int durasiHari;
   private final double totalBiaya;

   // setter
   public penyewaan(int var1, pelanggan var2, kendaraan var3, int var4) {
      this.idPenyewaan = var1;
      this.pelanggan = var2;
      this.kendaraan = var3;
      this.durasiHari = var4;
      this.kendaraan.setTersedia(false);
      this.totalBiaya = this.hitungTotalBiaya();
   }

   // getter
   public int getIdPenyewaan() {
      return this.idPenyewaan;
   }

   public pelanggan getPelanggan() {
      return this.pelanggan;
   }

   public kendaraan getKendaraan() {
      return this.kendaraan;
   }

   public int getDurasiHari() {
      return this.durasiHari;
   }

   public double getTotalBiaya() {
      return this.totalBiaya;
   }

   // Hitung total biaya sewa
   private double hitungTotalBiaya() {
      double var1 = 0.0;
      if (this.kendaraan instanceof mobil) {
         var1 = ((mobil)this.kendaraan).getTarifHarian();
      } else if (this.kendaraan instanceof motor) {
         var1 = ((motor)this.kendaraan).getTarifHarian();
      }

      return var1 * (double)this.durasiHari;
   }

   // Tampilkan detail transaksi penyewaan
   public void tampilkanDetailPenyewaan() {
      System.out.println("\n--- Detail Penyewaan No. " + this.idPenyewaan + " ---");
      System.out.print("Pelanggan: ");
      this.pelanggan.tampilkanProfil();
      System.out.print("Kendaraan: ");
      this.kendaraan.tampilkanInfo();
      System.out.println("Durasi Sewa: " + this.durasiHari + " Hari");
      System.out.println("Total Biaya: Rp" + this.totalBiaya);
      System.out.println("------------------------------------");
   }

   // Cek status aktif penyewaan
   public void cekStatusPelanggan() {
      if (this.pelanggan.getNama() != null && !this.kendaraan.isTersedia()) {
         System.out.println("Status Penyewaan: Aktif. Pelanggan " + this.pelanggan.getNama() + " sedang menyewa.");
      } else {
         System.out.println("Status Penyewaan: Tidak aktif atau sudah selesai.");
      }

   }
}
