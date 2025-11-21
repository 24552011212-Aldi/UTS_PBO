
// Kelas turunan kendaraan untuk mobil
public class mobil extends kendaraan {
   private final int jumlahPintu;
   private final String jenisTransmisi;
   private final double tarifHarian;

   // setter
   public mobil(String var1, String var2, int var3, int var4, String var5, double var6) {
      super(var1, var2, var3);
      this.jumlahPintu = var4;
      this.jenisTransmisi = var5;
      this.tarifHarian = var6;
   }

    // getter
   public int getJumlahPintu() {
      return this.jumlahPintu;
   }

   public String getJenisTransmisi() {
      return this.jenisTransmisi;
   }

   public double getTarifHarian() {
      return this.tarifHarian;
   }

   // Tampilkan info detail mobil
   @Override
   public void tampilkanInfo() {
      super.tampilkanInfo();
      System.out.println("Pintu: " + this.jumlahPintu + ", Transmisi: " + this.jenisTransmisi + ", Tarif: Rp" + this.tarifHarian);
   }

   // Fitur khusus: nyalakan AC mobil
   public void nyalakanAC() {
      System.out.println("AC Mobil " + this.getMerk() + " dinyalakan.");
   }
}
