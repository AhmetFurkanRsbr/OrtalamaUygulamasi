public class AktifKullanici {
    static String aktifKullaniciAd;
    static String aktifKullaniciSoyAd;
   static String aktifKullaniciKullaniciAdi;
   static String aktifKullaniciOkul;
   static String aktifKullaniciSinif;
   static String aktifKullaniciBolum;
   static int aktifKullaniciID;
   static int aktifKullaniciDersSayi;
   static  String aktifKullaniciParola;

   VeriTabaniIslemleri veriTabaniIslemleri=new VeriTabaniIslemleri();
    AktifKullanici(){
       veriTabaniIslemleri.kullaniciBilgileriAktar();
    }
    static void aktifKullaniciBilgileriSifirla(){
        aktifKullaniciKullaniciAdi="";
        aktifKullaniciAd="";
        aktifKullaniciID=0;
        aktifKullaniciSoyAd="";
        aktifKullaniciBolum="";
        aktifKullaniciSinif="";
        aktifKullaniciOkul="";
        aktifKullaniciDersSayi=0;
    }
}
