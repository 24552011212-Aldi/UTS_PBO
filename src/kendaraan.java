
// Kelas dasar untuk semua kendaraan
public class kendaraan {
   private final String merk;
   private final String model;
   private final int tahunProduksi;
   private boolean isTersedia;

   // Konstruktor: inisialisasi data kendaraan
   public kendaraan(String var1, String var2, int var3) {
      this.merk = var1;
      this.model = var2;
      this.tahunProduksi = var3;
      this.isTersedia = true;
      System.out.println("-> Kendaraan " + var1 + " " + var2 + " berhasil dibuat.");
   }

   public String getMerk() {
      return this.merk;
   }

   public String getModel() {
      return this.model;
   }

   public int getTahunProduksi() {
      return this.tahunProduksi;
   }

   // Mengecek apakah kendaraan tersedia
   public boolean isTersedia() {
      return this.isTersedia;
   }

   // Mengubah status ketersediaan kendaraan
   public void setTersedia(boolean var1) {
      this.isTersedia = var1;
   }

   // Menampilkan info detail kendaraan
   public void tampilkanInfo() {
      System.out.println("Merk: " + this.merk + ", Model: " + this.model + ", Tahun: " + this.tahunProduksi);
      System.out.println("Status: " + (this.isTersedia ? "Tersedia" : "Sedang disewa"));
   }
}
