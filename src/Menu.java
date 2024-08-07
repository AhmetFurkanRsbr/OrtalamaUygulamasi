import java.util.Scanner;

public class Menu {
/*
    Scanner scanner =  new Scanner(System.in);
    static int dersSayisi1;
    String stringGirdiAl(){

        String stringGirdi="";
        try {
            stringGirdi = scanner.nextLine();
        }catch (Exception e){
            System.out.println("HTALI GİRİŞ");
            stringGirdiAl();
        }

    return stringGirdi;
    }

    int intGirdiAl(){

        int intDeger=0;
        try {
            intDeger = scanner.nextInt();
            scanner.nextLine();
        }catch (Exception e){
            System.out.println("HTALI GİRİŞ");
            scanner.nextLine();
            intDeger = intGirdiAl();
        }

        return intDeger;

    }

    public void giris(){


        System.out.println("\n\n\n- - - - - - - - - - ORTALAMA HESAPLAMA UYGULAMASİNA HOSGELDİNİZ - - - - - - - - - -\n\n ");
        //KİŞİ BİLGİLERİ ALMA KISMI

        Kisi kisi1 =new Kisi();

        try{
            System.out.print("İsminiz : ");
            kisi1.kisiAd=stringGirdiAl();
            System.out.print("Soyisminiz : ");
            kisi1.kisiSoyad=stringGirdiAl();
            String cevap="h";
            while (!cevap.equals("k")){
            System.out.println("Okulunuz Listede Var Mı ? (e/h) --> "+" ("+kisi1.okullar1+ ", " +kisi1.okullar2+")");
             cevap = stringGirdiAl();
            if(cevap.equals("h")){
                System.out.println("Okulunuzun Harf Sistemi Uygulamamızda Mevcut Olmadığı İçin Ortalamanızı Hesaplayamıyoruz.");
                System.out.println("İsterseniz kendi okulunuza harf aralığı benzer olan sistemimizdeki okullardan birini seçiniz.");
                System.out.println("Devam etmek istiyor musunuz? (e/h)");
                cevap=stringGirdiAl();
                if(cevap.equals("h")){
                    System.exit(1);
                }
            }
                System.out.print("Hangi Okulu Seçiyorsunuz? ( ");
                for (int i=0;i<kisi1.sistemdekiOkullar.length;i++){
                    System.out.print((i+1)+" ,");
                }
                System.out.print(" ) : ");

                int okulSira=intGirdiAl();
                if(kisi1.sistemdekiOkullar.length>=okulSira && okulSira>0){

                    switch(okulSira){
                        case 1: kisi1.okul=kisi1.okullar1;
                            break;
                        case 2: kisi1.okul=kisi1.okullar2;
                            break;

                    }
                    System.out.println("Seçtiğiniz Okul :"+kisi1.okul);
                cevap ="k";
                }else {
                    cevap="e";
                }

            }

            System.out.print("Okuduğunuz Bölüm Nedir : ");
            kisi1.kisiBolumu=stringGirdiAl();
            System.out.println("Mevcut Sınıfınız Hangisidir (0,1,2,3,4 )?"+"( "+ Kisi.kisiSinifi.HAZIRLIK+", "+ Kisi.kisiSinifi.BIRINCI_SINIF+", "+ Kisi.kisiSinifi.IKINCI_SINIF+", "+ Kisi.kisiSinifi.UCUNCU_SINIF+", "+ Kisi.kisiSinifi.DORDUNCU_SINIF+")");
            kisi1.kisiSinif=intGirdiAl();
            kisi1.kisiSinifiBelirle(kisi1.kisiSinif);
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print(kisi1.kisiAd+" "+kisi1.kisiSoyad+": Okulu --> "+kisi1.okul+" , Bölümü --> "+kisi1.kisiBolumu+" , Sınıfı --> "+kisi1.kisiSinifi1 +"\n\n\n");

        }catch (Exception e3) {
            System.out.println("HATAAAA!"+e3.getMessage());
        }

        //
        System.out.print("Toplam Ders Sayisi : ");

        dersSayisi1=intGirdiAl();

        Ders ders1 = new Ders();


        for (int i = 0; i < dersSayisi1; i++) {

            try {
                System.out.print("\n\nDers adini giriniz : ");
                ders1.dDersAdi[i] = stringGirdiAl();
                System.out.print("Ders AKTS'si giriniz : ");
                ders1.dDersAkts[i] = intGirdiAl();
                System.out.print("Vize notunuzu giriniz : ");
                ders1.dDersVizeNotu[i] = intGirdiAl();
                System.out.print("Final notunuzu giriniz : ");
                ders1.dDersFinalNotu[i] = intGirdiAl();
                System.out.print("Vize etki oranini giriniz : ");
                ders1.dDersVizeOrani[i] = intGirdiAl();
                System.out.print("Final etki oranini giriniz : ");
                ders1.dDersFinalOrani[i] = intGirdiAl();
            }catch (Exception e2){
                System.out.println("HATA"+e2.getMessage());
            }


            System.out.println("\n\n"+ders1.dDersAdi[i] + " dersinin not ortalaması : "+ders1.dersOrtalamaHesapla(i) +  " dir.\n");
        }
        System.out.println("\n\n\n\n\n");
        for(int i=0;i<dersSayisi1;i++){

            System.out.println((i+1)+". Ders: "+ders1.dDersAdi[i]+",   Akts: "+ders1.dDersAkts[i]+",   Geçme Durumu--> "+ ders1.dDersGecmeDurumu[i] +",   ortalama: "+ders1.dDersGecmeNotu[i]+",   4'lük sistem: "+ders1.dDortlukDersGecmeNotu[i]);

        }

         String formatliOrtalama =String.format("%.2f",ders1.donemOrtalamaHesapla());
         System.out.println("\n\nGENEL ORTALAMANIZ : "+formatliOrtalama);

    }
*/
}
