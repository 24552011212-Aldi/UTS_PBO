
// Representasi data pelanggan
public class pelanggan {
   private final int idPelanggan;
   private final String nama;
   private final String nomorTelepon;

   // setter
   public pelanggan(int var1, String var2, String var3) {
      this.idPelanggan = var1;
      this.nama = var2;
      this.nomorTelepon = var3;
   }

   // getter
   public int getIdPelanggan() {
      return this.idPelanggan;
   }

   public String getNama() {
      return this.nama;
   }

   public String getNomorTelepon() {
      return this.nomorTelepon;
   }

   // Tampilkan profil pelanggan
   public void tampilkanProfil() {
      System.out.println("\nID Pelanggan: " + this.idPelanggan + ", Nama: " + this.nama + ", Telp: " + this.nomorTelepon);
   }
}
