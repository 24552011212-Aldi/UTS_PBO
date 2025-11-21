
// Kelas turunan kendaraan untuk motor
public class motor extends kendaraan {
   private final String jenisMotor;
   private final int kapasitasMesin;
   private final double tarifHarian;

   //  setter
   public motor(String var1, String var2, int var3, String var4, int var5, double var6) {
      super(var1, var2, var3);
      this.jenisMotor = var4;
      this.kapasitasMesin = var5;
      this.tarifHarian = var6;
   }

   // getter
   public String getJenisMotor() {
      return this.jenisMotor;
   }

   public int getKapasitasMesin() {
      return this.kapasitasMesin;
   }

   public double getTarifHarian() {
      return this.tarifHarian;
   }

   // Tampilkan info detail motor
   @Override
   public void tampilkanInfo() {
      super.tampilkanInfo();
      System.out.println("Tipe: " + this.jenisMotor + ", Kapasitas: " + this.kapasitasMesin + "cc, Tarif: Rp" + this.tarifHarian);
   }

   // Fitur khusus: pesan helm
   public void pasangHelm() {
      System.out.println("Pastikan helm telah terpasang sebelum berkendara dengan " + this.getModel() + ".");
   }
}
