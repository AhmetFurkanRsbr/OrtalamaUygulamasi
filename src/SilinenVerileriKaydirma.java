import java.sql.*;

public class SilinenVerileriKaydirma {
    VeriTabaniIslemleri vt2 = new VeriTabaniIslemleri();
    boolean silinenVerileriKaydirmaDurumu=false;

    void kisiIDOneKaydir(int i){
        if(!vt2.baglanmaDurumu){
            try {
                vt2.msqlBaglan();
                vt2.baglanmaDurumu=true;
            } catch (SQLException e) {
                vt2.baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }

        try {
            String kisiIsimSql = "(SELECT kisi_isim from kisi_bilgileri where kisi_id = "+i+" )";
            String kisiSoyisimSql = "(SELECT kisi_soyisim from kisi_bilgileri where kisi_id = "+i+" )";

            String sqlKisiBilgisiKaydir =" insert into kisi_bilgileri(kisi_id,kisi_isim,kisi_soyisim) values " +
                    "("+(i-1)+","+kisiIsimSql+","+kisiSoyisimSql+" )";



           PreparedStatement statKisiBilgiKaydir = vt2.baglan.prepareStatement(sqlKisiBilgisiKaydir);
           statKisiBilgiKaydir.executeUpdate();


           String sinifSql="(select kisi_sinif from egitim_bilgileri where kisi_idf = "+i+" )";
           String bolumSql="(select kisi_bolum from egitim_bilgileri where kisi_idf = "+i+" )";
           String okulSql="(select kisi_okul from egitim_bilgileri where kisi_idf = "+i+" )";


           String sqlEgitimBilgisiKaydir = " insert into egitim_bilgileri(kisi_idf,kisi_sinif,kisi_bolum,kisi_okul) values "+
                   "("+(i-1)+","+sinifSql+" ,"+bolumSql+" ,"+okulSql+" )";

           PreparedStatement statEgitimBilgiKaydir = vt2.baglan.prepareStatement(sqlEgitimBilgisiKaydir);
            statEgitimBilgiKaydir.executeUpdate();



            vt2.kullaniciBilgileriSistemeKayitEtVeSil(i);
            vt2.kisiOrtalamaBilgileriKaydirVeSil(i);
            System.out.println("bittii");

          /*
            String sqlKullaniciBilgisiKaydir ="insert into kullanici_bilgileri(kullanici_ad,kullanici_parola,kisi_idf) values "+
                    "("+AktarilacakKullanici.guncellenecekKullaniciAdi+" , "+AktarilacakKullanici.guncellenecekKullaniciParola+" , "+(i-1)+" )";

            PreparedStatement statKullaniciBilgiKaydir = vt2.baglan.prepareStatement(sqlKullaniciBilgisiKaydir);
            statKullaniciBilgiKaydir.executeUpdate();

            System.out.println("BURADA BİTTİ");
            */
            /*
           String sqlidOncekineAtama = "insert into kisi_id from kisi_bilgileri where kisi_id = "+i+" ;";
            PreparedStatement statIDoncekiAtama = vt2.baglan.prepareStatement(sqlidOncekineAtama);
            statIDoncekiAtama.executeUpdate();

            String sqlKisiAdOncekineAtama = "insert into kisi_isim from kisi_bilgileri where kisi_id =(SELECT kisi_isim from kisi_bilgileri where kisi_id = "+i+" ) ";
            PreparedStatement statKisiIsimOncekiAtama = vt2.baglan.prepareStatement(sqlKisiAdOncekineAtama);
            statKisiIsimOncekiAtama.executeUpdate();

            String sqlKisiSoyisimOncekineAtama = "insert into kisi_soyisim from kisi_bilgileri where kisi_id =(SELECT kisi_soyisim from kisi_bilgileri where kisi_id = "+i+" ) ";
            PreparedStatement statKisiSoyIsimOncekiAtama = vt2.baglan.prepareStatement(sqlKisiSoyisimOncekineAtama);
            statKisiSoyIsimOncekiAtama.executeUpdate();


            String sqlKisiIDoncekineEgitimAtama="insert into kisi_idf from egitim_bilgileri where kisi_id = "+i+" ;";
            PreparedStatement statIDoncekiEgitimAtama = vt2.baglan.prepareStatement(sqlKisiIDoncekineEgitimAtama);
            statIDoncekiEgitimAtama.executeUpdate();

            String sqlSinifoncekineEgitimAtama="insert into kisi_sinif from egitim_bilgileri where kisi_id = "+i+" ;";
            PreparedStatement statIDoncekiEgitimAtama = vt2.baglan.prepareStatement(sqlKisiIDoncekineEgitimAtama);
            statIDoncekiEgitimAtama.executeUpdate();

            String sqlKullaniciAdOncekineAtama = "insert into kullanici from_kisi_bilgileri where kisi_id =(SELECT kisi_isim from kisi_bilgileri where kisi_id = "+i+" ) ";
            PreparedStatement statKullaniciAdOncekiAtama = vt2.baglan.prepareStatement(sqlKullaniciAdOncekineAtama);
            statKullaniciAdOncekiAtama.executeUpdate();
               */
        }catch (SQLException b){
            System.out.println("ıd öncekine ataması yapılırken oluşan hata "+b.getMessage());
        }
    }



    void silinecekKisiyiSil(boolean geciciSilme){
        System.out.println("HUHU");
        if(!vt2.baglanmaDurumu) {

            try {
                vt2.msqlBaglan();
                vt2.baglanmaDurumu = true;
            } catch (SQLException e) {
                vt2.baglanmaDurumu = false;
                System.out.println("Silinen verileri kaydırırken bağlanma hatası");
                throw new RuntimeException(e);
            }

            silinecekKisiyiSil(geciciSilme);
        }

        else if(geciciSilme){
            System.out.println("hayır BURDAYIM");
            Statement stat2;
            try {
                stat2=vt2.baglan.createStatement();
                System.out.println("NEEEEEEEE");
                String sqlGeciciSilinecekKisiSil =
                        "delete from not_bilgileri  where kisi_idf = "+SilinecekBilgiler.geciciSilinecekKisiID+" ;" +
                        "delete from ders_bilgileri where kisi_idf = "+SilinecekBilgiler.geciciSilinecekKisiID+" ;" +
                        "delete from egitim_bilgileri where kisi_idf = "+SilinecekBilgiler.geciciSilinecekKisiID+";" +
                        "delete from kisi_bilgileri where kisi_id = "+SilinecekBilgiler.geciciSilinecekKisiID+";";

                //"delete from kullanici_bilgileri where kisi_idf = "+SilinecekBilgiler.geciciSilinecekKisiID+";" +

                PreparedStatement gecicisilmeStatement = vt2.baglan.prepareStatement(sqlGeciciSilinecekKisiSil);
                gecicisilmeStatement.executeUpdate();

                System.out.println("BAŞARIYLA SİLİNDİ");

            }catch (SQLException A){
                System.out.println("silinecek gecici kişi silinirken oluşan hata "+A.getMessage());
            }

        }
        else{
            System.out.println("BURDAYIM");
            Statement stat;
            try {
                stat=vt2.baglan.createStatement();
                System.out.println("NEEEEEEEE");
                String sqlSilinecekKisiSil = "delete from kisi_ortalama_bilgileri where kisi_idf = "+SilinecekBilgiler.silinecekKisiId+";"+
                        "delete from ders_ortalama_bilgileri where kisi_idf = "+SilinecekBilgiler.silinecekKisiId+";"+
                        "delete from not_bilgileri  where kisi_idf = "+SilinecekBilgiler.silinecekKisiId+" ;" +
                        "delete from ders_bilgileri where kisi_idf = "+SilinecekBilgiler.silinecekKisiId+" ;" +
                        "delete from egitim_bilgileri where kisi_idf = "+SilinecekBilgiler.silinecekKisiId+";" +
                        "delete from kullanici_bilgileri where kisi_idf = "+SilinecekBilgiler.silinecekKisiId+";" +
                        "delete from kisi_bilgileri where kisi_id = "+SilinecekBilgiler.silinecekKisiId+";";


                PreparedStatement silmeStatement = vt2.baglan.prepareStatement(sqlSilinecekKisiSil);
                silmeStatement.executeUpdate();

                System.out.println("BAŞARIYLA SİLİNDİ");

            }catch (SQLException A){
                System.out.println("silinecek kişi silinirken oluşan hata "+A.getMessage());
            }
        }


    }

    void kisiNotveDersBilgisiKaydet(int anlikKisiID){
        AktifKullanici.aktifKullaniciID=anlikKisiID;
        vt2.kisininKayitliDersleriniGetir();
       // for(int j=0;j<AktifKullanici.aktifKullaniciDersSayi;j++){

           String sqlNotBilgisiGuncelle ="update not_bilgileri set kisi_idf = "+(anlikKisiID-1)+" where kisi_idf = "+anlikKisiID+";";

            PreparedStatement statNotBilgiGuncelle ;
            try {
                statNotBilgiGuncelle = vt2.baglan.prepareStatement(sqlNotBilgisiGuncelle);
                statNotBilgiGuncelle.executeUpdate();
                System.out.println(". başarıyla not bilgisi güncellendi");
            } catch (SQLException e) {
                System.out.println(". başarısız not bilgi güncellemesi "+e.getMessage());
                throw new RuntimeException(e);
            }

        String sqlDersBilgisiGuncelle ="update ders_bilgileri set kisi_idf = "+(anlikKisiID-1)+" where kisi_idf = "+anlikKisiID+";";
            PreparedStatement statDersBilgiGuncelle ;
            try {
                statDersBilgiGuncelle = vt2.baglan.prepareStatement(sqlDersBilgisiGuncelle);
                statDersBilgiGuncelle.executeUpdate();
                System.out.println(". başarıyla DERS bilgisi güncellendi");
            } catch (SQLException e) {
                System.out.println(". başarısız DERS bilgi güncellemesi "+e.getMessage());
                throw new RuntimeException(e);
            }


            /*

             String sqlNotBilgisiGetir ="select Top 1 * from not_bilgileri where kisi_idf = "+anlikKisiID+" order by not_id ;";
            String sqlDersBilgisiGetir ="select Top 1 * from ders_bilgileri where kisi_idf ="+anlikKisiID+" order by not_id ;";
            try {
                ResultSet resultSetNotGetir = vt2.stat.executeQuery(sqlNotBilgisiGetir);
                if(resultSetNotGetir.next()){
                  GuncellenicekBilgiler.guncellenicekNotId = resultSetNotGetir.getInt("not_id");
                    GuncellenicekBilgiler.guncellenicekVizeNotu = resultSetNotGetir.getInt("vize_notu");
                    GuncellenicekBilgiler.guncellenicekFinalNotu = resultSetNotGetir.getInt("final_notu");
                    GuncellenicekBilgiler.guncellenicekVizeEtkiO = resultSetNotGetir.getInt("vize_etkiO");
                    GuncellenicekBilgiler.guncellenicekFinalEtkiO = resultSetNotGetir.getInt("final_etkiO");
                    GuncellenicekBilgiler.guncellenecekDersId = resultSetNotGetir.getInt("ders_idf");
                    GuncellenicekBilgiler.guncellenecekKisiId = resultSetNotGetir.getInt("kisi_idf");

                    System.out.println("notid:"+GuncellenicekBilgiler.guncellenicekNotId);
                    System.out.println("final_notı"+GuncellenicekBilgiler.guncellenicekFinalNotu);

                }resultSetNotGetir.close();

                try {
                    ResultSet resultSetDersGetir = vt2.stat.executeQuery(sqlDersBilgisiGetir);
                    if(resultSetDersGetir.next()){
                        GuncellenicekBilgiler.guncellenecekDersId = resultSetDersGetir.getInt("ders_id");
                        GuncellenicekBilgiler.guncellenicekDersIsmi = resultSetDersGetir.getString("ders_isim");
                        GuncellenicekBilgiler.guncellenicekDersAkts = resultSetDersGetir.getInt("ders_akts");
                        GuncellenicekBilgiler.guncellenecekKisiId = resultSetDersGetir.getInt("kisi_idf");

                    }resultSetDersGetir.close();
                }catch (SQLException M){
                    System.out.println("DERS NOT BİLGİLERİ KAYIT HATASI "+M.getMessage());
                }

                try {//silme
                    String NotSil ="delete not_bilgileri where not_id ="+GuncellenicekBilgiler.guncellenicekNotId+";";
                    String DersSil ="delete ders_bilgileri where ders_id ="+GuncellenicekBilgiler.guncellenecekDersId+";";

                    PreparedStatement statNotsil =vt2.baglan.prepareStatement(NotSil);
                    statNotsil.executeUpdate();

                    PreparedStatement statDerssil =vt2.baglan.prepareStatement(DersSil);
                    statDerssil.executeUpdate();


                }catch (SQLException d){
                    System.out.println("DERS NOT SİLME HATASI"+d.getMessage());
                }
/*
                try {

                    String sqlEgitimBilgisiKaydir ="insert into ders_bilgileri(ders_id,ders_isim,ders_akts,kisi_idf) values "+
                            "("+(GuncellenicekBilgiler.guncellenecekDersId-1)+","+sinifSql+","+bolumSql+","+okulSql+" )";

                    PreparedStatement statEgitimBilgiKaydir = vt2.baglan.prepareStatement(sqlEgitimBilgisiKaydir);
                    statEgitimBilgiKaydir.executeUpdate();

                }catch (SQLException F){
                    System.out.println("ders not ekleme hatası"+F.getMessage());
                }
                  */ /*
             } catch (SQLException e) {
                throw new RuntimeException(e);
             }
                */
      //  }
    }

    boolean SilinenVerileriKaydir(){

        if(!vt2.baglanmaDurumu){
            try {
                vt2.msqlBaglan();
                vt2.baglanmaDurumu=true;
            } catch (SQLException e) {
                vt2.baglanmaDurumu=false;
                System.out.println("Silinen verileri kaydırırken bağlanma hatası");
                throw new RuntimeException(e);
            }
        }

        silinecekKisiyiSil(false);
        System.out.println("KİŞİ SİLİNDİ ŞİMDİ SONRAKİ VERİLER KAYDEDİLEREK AKTARIM BAŞLIYACAK");

        for(int i=(SilinecekBilgiler.silinecekKisiId+1);i<= vt2.enYuksekKisiId();i++){
            System.out.println("i durumu :"+i);
            kisiIDOneKaydir(i);
           // kisiKullaniciBilgisiGuncelle(i);
            SilinecekBilgiler.geciciSilinecekKisiID=i;
            kisiNotveDersBilgisiKaydet(i);

            silinecekKisiyiSil(true);

            if(i==vt2.enYuksekKisiId()){
                System.out.println("son kişii");
                SilinecekBilgiler.geciciSilinecekKisiID=i;
                silinecekKisiyiSil(true);
            }

        }

        System.out.println("Silinecek kisi ıd :"+SilinecekBilgiler.silinecekKisiId);
        System.out.println("Silinecek soyisim : "+GuncellenicekBilgiler.guncellenecekKisiSoyisim);

        return silinenVerileriKaydirmaDurumu;
    }


}
