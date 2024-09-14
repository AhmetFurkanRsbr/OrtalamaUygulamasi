import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrtalamaHesapla {
    VeriTabaniIslemleri vt =new VeriTabaniIslemleri();
    static float  geciciDersAktsToplam=0.0f;
    static float anlikDortlukDersGecmeNotu=0.0f;
    static float donemOrtalamasi4=0.0f;
    static float anlikDonemOrtalamasi=0.0f;
    static float donemOrtalamasi100=000.0f;
    static int dersAkts=0;
    static float derstenGecmeNotu100 = 0.0f;
    static boolean dersGecmeDurumu = false;
    static String dersGecmeDurumuString="BELİRSİZ";
    static float dortlukDersGecmeNotu=0.0f;
    static int toplamDonemAkts=0;
    static int kisiGenelDersSayisi=0;
    static int kisiDonemDersSayisi=0;
    static float toplamDonemDortlukGecmeNotu=0.0f;
    static float toplamAkts_GecmeNotCarpimi=0.0f;
    static float yeniDonemOrtalamasi4 =0.0f;

    OkulHarfNotlari okulHarfNotlari =new OkulHarfNotlari();
int donemAktsHesapla(int kisiId,int alindigiDonem){
    String sqlDonemAkts = "select sum(ders_akts),alindigi_donem from ders_bilgileri where kisi_idf = "+kisiId+" and alindigi_donem = "+alindigiDonem+" group by alindigi_donem ;";
    ResultSet resultSetAktsHesap = null;
    try {
        resultSetAktsHesap = vt.stat.executeQuery(sqlDonemAkts);
        if(resultSetAktsHesap.next()){
            toplamDonemAkts=resultSetAktsHesap.getInt(1);
            System.out.println("Toplam dönem akts : "+toplamDonemAkts);
        }resultSetAktsHesap.close();

    } catch (SQLException e) {
        System.out.println("DÖNEM AKTS HESAPLANIRKEN OLUŞAN HATA "+e.getMessage());
        throw new RuntimeException(e);
    }

    return toplamDonemAkts;
}

    float donemToplamGecmeNotuHesapla4(int kisiId,int alindigiDonem){
        String sqlDonemToplam4gecmeNotu = "select sum(dersten_gecme_notu4),alindigi_donem from ders_ortalama_bilgileri  where kisi_idf = "+kisiId+" and alindigi_donem = "+alindigiDonem+" group by alindigi_donem;";
        ResultSet resultSetToplamGecmeNotHesap = null;
        try {
            resultSetToplamGecmeNotHesap = vt.stat.executeQuery(sqlDonemToplam4gecmeNotu);
            if(resultSetToplamGecmeNotHesap.next()){
                toplamDonemDortlukGecmeNotu=resultSetToplamGecmeNotHesap.getFloat(1);

            }resultSetToplamGecmeNotHesap.close();

        } catch (SQLException e) {
            System.out.println("DÖNEM toplam dersten geçme notu 4 lük HESAPLANIRKEN OLUŞAN HATA "+e.getMessage());
            throw new RuntimeException(e);
        }
    return toplamDonemDortlukGecmeNotu;
    }

    float Akts_GecmeNotCarpimiHesapla(int kisiId,int alindigiDonem){

    return toplamAkts_GecmeNotCarpimi;
    }

    int dersAktsGetir(int sira,int kisiId,int alindigiDonem){
        String sqlAnlikAktsGetir = "select ders_akts from ders_bilgileri where kisi_idf = "+kisiId+" and alindigi_donem = "+alindigiDonem+" order by ders_id;";
        ResultSet resultSetAnlikAkts = null;
        try {
            resultSetAnlikAkts = vt.stat.executeQuery(sqlAnlikAktsGetir);

            for (int i = 0; i < sira; i++) {
                if (!resultSetAnlikAkts.next()) {
                    System.out.println("İstenilen sıradaki satır bulunamadı.");
                }
            }

            if(resultSetAnlikAkts.next()){
                dersAkts=resultSetAnlikAkts.getInt(1);
                System.out.println((sira+1)+". ders akts : "+dersAkts);
            }resultSetAnlikAkts.close();

        } catch (SQLException e) {
            System.out.println("DÖNEM anlık akts  HESAPLANIRKEN OLUŞAN HATA "+e.getMessage());
            throw new RuntimeException(e);
        }

    return dersAkts;
    }

    float dersDortlukGecmeNotuGetir(int sira,int kisiId,int alindigiDonem){
        String sqlAnlikGecmeNotu4 = "select dersten_gecme_notu4 from ders_ortalama_bilgileri  where kisi_idf = "+kisiId+" and alindigi_donem = "+alindigiDonem+" order by ders_idf ;";
        ResultSet resultSetAnlikGecmeNot4 = null;
        try {
            resultSetAnlikGecmeNot4 = vt.stat.executeQuery(sqlAnlikGecmeNotu4);

            for(int i=0;i<sira;i++){
                if (!resultSetAnlikGecmeNot4.next()){
                    System.out.println("belirtilen sırada bulunamadı");
                }
            }

            if(resultSetAnlikGecmeNot4.next()){

                anlikDortlukDersGecmeNotu=resultSetAnlikGecmeNot4.getInt(1);
                System.out.println((sira+1)+". ders dortluk not : "+anlikDortlukDersGecmeNotu);
            }resultSetAnlikGecmeNot4.close();

        } catch (SQLException e) {
            System.out.println("DÖNEM anlık GEÇME NOTU 4  HESAPLANIRKEN OLUŞAN HATA "+e.getMessage());
            throw new RuntimeException(e);
        }
    return anlikDortlukDersGecmeNotu;
    }

    float anlikDonemOrtalamasiHesapla(int kisiId,int alindigiDonem,int kalan){
        geciciDersAktsToplam  += MenuGui.akts * ( MenuGui.vizeNotu * (MenuGui.vizeEtkiOrani/100) ) + ( MenuGui.finalNotu * (MenuGui.finalEtkiOrani/100) );

         if(kalan==1){
             anlikDonemOrtalamasi = geciciDersAktsToplam/MenuGui.dersSayisi;
         }
      return anlikDonemOrtalamasi;
    }

    int kisiDonemDersSayisiHesapla(int kisiId,int alindigiDonem){
        String sqlDonemDersSayisi = "select count(*) from ders_ortalama_bilgileri where kisi_idf = "+kisiId+" and  alindigi_donem = "+alindigiDonem+" group by alindigi_donem ;";
        ResultSet resultSetkisiDonemDers = null;
        try {
            resultSetkisiDonemDers = vt.stat.executeQuery(sqlDonemDersSayisi);
            if(resultSetkisiDonemDers.next()){
                kisiDonemDersSayisi=resultSetkisiDonemDers.getInt(1);
                System.out.println(" dönem ders sayısı : "+kisiDonemDersSayisi);
            }resultSetkisiDonemDers.close();

        } catch (SQLException e) {
            System.out.println("DÖNEM ders sayısı  HESAPLANIRKEN OLUŞAN HATA "+e.getMessage());
            throw new RuntimeException(e);
        }

        return kisiDonemDersSayisi;
    }
    float yeniDonemOrtalamasiHesapla(int kisiId,int donem){

    //donemOrtalamaHesapla(kisiId,donem);
    int yenitoplamDonemAkts = MenuGui.akts + toplamDonemAkts;
    float yeniToplamAkts_GecmeNotCarpimi = (MenuGui.akts * dortlukDersGecmeNotu) + (toplamAkts_GecmeNotCarpimi);
    yeniDonemOrtalamasi4 = (yeniToplamAkts_GecmeNotCarpimi/yenitoplamDonemAkts);
        System.out.println("yeni yno : "+yeniDonemOrtalamasi4);


     return yeniDonemOrtalamasi4;
    }

    float donemOrtalamaHesapla(int kisi_id,int donem){

        toplamAkts_GecmeNotCarpimi=0.0f;
        anlikDortlukDersGecmeNotu=0.0f;
        dersAkts=0;
        donemOrtalamasi4=0.0f;
        toplamDonemAkts = donemAktsHesapla(kisi_id,donem);

         kisiDonemDersSayisi=kisiDonemDersSayisiHesapla(kisi_id,donem);

        System.out.println("kisi dönem ders sayısı : "+kisiDonemDersSayisi);
      for(int siradakiDers=0;siradakiDers<kisiDonemDersSayisi;siradakiDers++){

          dersAkts = dersAktsGetir(siradakiDers,kisi_id,donem);

          anlikDortlukDersGecmeNotu = dersDortlukGecmeNotuGetir(siradakiDers,kisi_id,donem);
          toplamAkts_GecmeNotCarpimi += (dersAkts*anlikDortlukDersGecmeNotu);

      }

        donemOrtalamasi4 = ( toplamAkts_GecmeNotCarpimi / (toplamDonemAkts) );
        System.out.println("donem ortalaması 4 : "+donemOrtalamasi4);

      return donemOrtalamasi4;
    }

    void genelOrtalamaHesapla(){

    }


    float dersOrtalamasiHesapla(int VizeNotu,int FinalNotu,int akts,int VizeEtki,int FinalEtki){
        derstenGecmeNotu100 = (float) ((VizeNotu * VizeEtki / 100.0) + (FinalNotu * FinalEtki / 100.0));
        if(derstenGecmeNotu100>=50){
            dersGecmeDurumu=true;
            dersGecmeDurumuString="Geçti";
        }else {
            dersGecmeDurumu=false;
            dersGecmeDurumuString="Kaldı";
        }
        dortlukDersGecmeNotu = okulHarfNotlari.dortlukSistemdeOrtalamaDonustur(derstenGecmeNotu100,AktifKullanici.aktifKullaniciOkul);


        return dortlukDersGecmeNotu;
    }

}
