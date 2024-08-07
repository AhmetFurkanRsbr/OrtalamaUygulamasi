public class Ders {
    /*
String dersGecmeDurumuString;
    boolean dersGecmeDurumu;
    float dortlukDersGecmeNotu;
    String dersAd;
    int dersAkts;
    int vizeNotu;
    int finalNotu;
    int vizeOrani;
    int finalOrani;
    float dersGecmeNotu;
    float dersOrtalamasi;
    int dersSayisi= Menu.dersSayisi1;
    int toplamAkts;
    String []dDersAdi = new String[dersSayisi];
    int []dDersAkts = new int[dersSayisi];
    int []dDersFinalNotu = new int[dersSayisi];
    int []dDersVizeNotu = new int[dersSayisi];
    int []dDersVizeOrani = new int[dersSayisi];
    int []dDersFinalOrani = new int[dersSayisi];
    float []dDersGecmeNotu = new float[dersSayisi];
    float []dDortlukDersGecmeNotu = new float[dersSayisi];
    String []dDersGecmeDurumu = new String[dersSayisi];
//-----------------------------------------------------------------------------------------------------------------------
    int toplamAktsHesapla(){
        for(int i=0;i<dersSayisi;i++) {
            dersAkts=dDersAkts[i];
            toplamAkts += dDersAkts[i];
        }
        this.toplamAkts=toplamAkts;
        return toplamAkts;
    }
    float dersOrtalamasiHesapla(int VizeNotu,int FinalNotu,int akts,int VizeEtki,int FinalEtki){
        dersGecmeNotu = (float) ((VizeNotu * VizeEtki / 100.0) + (FinalNotu * FinalEtki / 100.0));
        if(dersGecmeNotu>=50){
            dersGecmeDurumu=true;
            dersGecmeDurumuString="Geçti";
        }else {
            dersGecmeDurumu=false;
            dersGecmeDurumuString="Kaldı";
        }
        dortlukDersGecmeNotu = okulHarfNotlari2.dortlukSistemdeOrtalamaDonustur(dersGecmeNotu);

        return dortlukDersGecmeNotu;
    }
    float dersOrtalamaHesapla(int i){

            dersAkts = dDersAkts[i];
            dersAd = dDersAdi[i];
            finalNotu = dDersFinalNotu[i];
            vizeNotu = dDersVizeNotu[i];
            finalOrani = dDersFinalOrani[i];
            vizeOrani = dDersVizeOrani[i];
            dersGecmeNotu = (float) ((vizeNotu * vizeOrani / 100.0) + (finalNotu * finalOrani / 100.0));
            dDersGecmeNotu[i] = dersGecmeNotu;
            if(dDersGecmeNotu[i]>=50){
                dersGecmeDurumu=true;
                dDersGecmeDurumu[i]="Geçti";
            }else {
                dersGecmeDurumu=false;
                dDersGecmeDurumu[i]="Kaldı";
            }
        dDortlukDersGecmeNotu[i] = okulHarfNotlari2.dortlukSistemdeOrtalamaDonustur(dDersGecmeNotu[i]);
        return dersGecmeNotu;
    }

    OkulHarfNotlari okulHarfNotlari2 =new OkulHarfNotlari();

    float donemOrtalamaHesapla() {

        float dersKrediliToplam=0;
        for (int j = 0; j < dersSayisi; j++){

           /*
           dortlukDersGecmeNotu = okulHarfNotlari2.dortlukSistemdeOrtalamaDonustur(dDersGecmeNotu[j]);
           System.out.println((j+1)+". DERSİN GEÇME NOTU : "+dDersGecmeNotu[j]);
           System.out.println("Dörtlük geçme notu : "+dortlukDersGecmeNotu);

            *//*
           dersKrediliToplam += dDortlukDersGecmeNotu[j] * dDersAkts[j];
            //System.out.println("Ders kredili Toplam : "+dersKrediliToplam);
        }
        toplamAktsHesapla();
         dersOrtalamasi = dersKrediliToplam / (float) toplamAkts;
    return dersOrtalamasi;
    }

//-----------------------------------------------------------------------------------------------------------------------
*/
}

