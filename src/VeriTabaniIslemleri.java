import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class VeriTabaniIslemleri {
    static int enYuksekOrtalamaId=0;
    boolean baglanmaDurumu = false;
    Connection baglan = null;
    Statement stat;
    public boolean veriGirmeDurumu=false;
    boolean sistemdekiKullanicilardanFarkliMi=false;
    int enYuksekKisiId=-1;
    boolean isKullaniciGirisiDogruMu=false;
    String kullanici;
    boolean dersBilgileriAktarmaDurumu=false;
    boolean kisininKayitliDersGetirmeDurumu=false;
    boolean isGecerliDonemdeYnoKayitYok=true;
    String []cekilenDers = new String[50];
    boolean dersSilmeDurumu=false;
    static int AnlikdersId;
    boolean silinecekKullanicininBilgileriniCekmeDurumu=false;
    boolean guncellenicekKullaniclarinBilgileriniCekmeDurumu=false;
    boolean dersVeNotguncellemeDurumu=false;
    boolean enYuksekDersSorgulamasi=false;
   static int gecerliDonem=0;
   static float yeniGno=0.0f;
   static float aktifGno=0.0f;
    //static float yeniYno=0.0f;
    //static float aktifYno=0.0f;


    public  VeriTabaniIslemleri(){
        try {
            msqlBaglan();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

      }//Ortalama_Uygulamasi1
      boolean msqlBaglan() throws SQLException{

              String baglantiUrl =  "jdbc:sqlserver://localhost:1433;" +
                      "databaseName=Ortalama_Uygulamasi;integratedSecurity=false;" +
                      "encrypt=true;trustServerCertificate=true;" +
                      "user=sa;password=afr1234r";

              if(!baglanmaDurumu) {

                  try {
                      try {
                          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                      } catch (ClassNotFoundException e) {
                          throw new RuntimeException(e);
                      }

                      baglan = DriverManager.getConnection(baglantiUrl);
                      stat = baglan.createStatement();

                      baglanmaDurumu = true;
                      System.out.println("baglanti kuruldu");

                  } catch (SQLException e) {
                      System.out.println("bAGLANTI KURULAMADI");
                      System.out.println(e.getMessage());
                      baglanmaDurumu = false;

                  }
              }


        return baglanmaDurumu;
      }
  /*
      public boolean veriTabaniBaglan(){

        String url = "jdbc:postgresql://localhost:5432/ortalama_uygulamasi3?user=postgres&password=afr1234r";
          try {
              baglan = DriverManager.getConnection(url);
              baglanmaDurumu=true;
          }catch (SQLException sqlException1){
              sqlException1.printStackTrace();
              baglanmaDurumu=false;
          }
              return baglanmaDurumu;
      }
*/


      public  boolean kullaniciVerisiGir(String kullanici_adi,String kisi_parola,int kisi_id){
        if(!this.baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }

          }else {
              String sqlKullaniciBilgiGirmeParametreli2 = "INSERT INTO kullanici_bilgileri (kullanici_ad,kullanici_parola,kisi_idf) VALUES (" +
                      "?,?,?); ";

              try {

                  PreparedStatement parametreliStatement3 = baglan.prepareStatement(sqlKullaniciBilgiGirmeParametreli2);

                  parametreliStatement3.setString(1,kullanici_adi);
                  parametreliStatement3.setString(2,kisi_parola);
                  parametreliStatement3.setInt(3,kisi_id);

                  parametreliStatement3.executeUpdate();
                  parametreliStatement3.close();


          }catch (SQLException HATA3){
                  System.out.println("Kullanıcı Bilgileri Aktarılırken Oluşan Hata "+HATA3.getMessage());
              }
          }
      return veriGirmeDurumu=true;
    }

    public boolean veriyiParametreIleGir(int kisi_id,String kisi_isim,String kisi_soyisim,String kullanici_adi,String kisi_parola,String kisi_sinif,String kisi_bolum,String kisi_okul){


        if(!this.baglanmaDurumu){
            try {
                msqlBaglan();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else {
            String sqlVeriGirmeKoduParametreli2 = "INSERT INTO kisi_bilgileri (kisi_id,kisi_isim,kisi_soyisim) VALUES (" +
                    "?,?,?); ";
            String sqlVeriGirmeKoduParametreli3 = "INSERT INTO egitim_bilgileri (kisi_idf,kisi_sinif,kisi_bolum,kisi_okul) VALUES (" +
                    "?,?,?,?); ";

            try {
                PreparedStatement parametreliStatement = baglan.prepareStatement(sqlVeriGirmeKoduParametreli2);

                parametreliStatement.setInt(1,kisi_id);
                parametreliStatement.setString(2, kisi_isim);
                parametreliStatement.setString(3, kisi_soyisim);

                parametreliStatement.executeUpdate();

                PreparedStatement parametreliStatement2 = baglan.prepareStatement(sqlVeriGirmeKoduParametreli3);

                parametreliStatement2.setInt(1,kisi_id);
                parametreliStatement2.setString(2, kisi_sinif);
                parametreliStatement2.setString(3, kisi_bolum);
                parametreliStatement2.setString(4, kisi_okul);

                parametreliStatement2.executeUpdate();



                    veriGirmeDurumu=kullaniciVerisiGir(kullanici_adi,kisi_parola,kisi_id);


            } catch (SQLException sqlException5) {

                veriGirmeDurumu = false;
                throw new RuntimeException(sqlException5);
            }
            try {
                baglan.close();
                baglanmaDurumu=false;
            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }
        return veriGirmeDurumu;
    }
    public int enYuksekKisiId(){

        if(!this.baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }else {

            String sorguSql = "SELECT MAX(kisi_id) FROM kisi_bilgileri";
            try {
                Statement statement = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery(sorguSql);

                if (resultSet.next()) {
                    enYuksekKisiId = resultSet.getInt(1);
                    if(resultSet.getInt(1)==0 ){
                        enYuksekKisiId=0;
                    }
                }else {
                    enYuksekKisiId = 0;
                }
                resultSet.close();
                statement.close();

            } catch (SQLException sqlException5) {
                System.out.println("En yüksek id belirlenirken oluşan sql hatası!! :" + sqlException5.getMessage());
            }

            System.out.println("en yüksek id: "+enYuksekKisiId);

        }
        return enYuksekKisiId;
    }
    public boolean sistemdekiKullanicilardanFarkliMi(){
        if(!this.baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return sistemdekiKullanicilardanFarkliMi;
    }

    public boolean kullaniciGirisiDogruMu(String kullaniciAdi,String parola) {
        String sqlSorgusu = "SELECT COUNT(*) FROM kullanici_bilgileri WHERE kullanici_ad = '"+kullaniciAdi+"' AND kullanici_parola = '"+parola+"' ;";

        if(!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        try {
            Statement statement = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sqlSorgusu);


            if (resultSet.next()){

            if (resultSet.getInt(1) == 1) {
                isKullaniciGirisiDogruMu = true;
                kullanici=kullaniciAdi;
                AktifKullanici.aktifKullaniciKullaniciAdi=kullanici;

            } else {
                isKullaniciGirisiDogruMu = false;
            }
        }
            baglan.close();
            resultSet.close();
            statement.close();
            baglanmaDurumu=false;

        } catch (SQLException sqlException5) {

            System.out.println("Kullanıcı sorgulanırken oluşan sql hatası!! :" + sqlException5.getMessage());
        }
        return isKullaniciGirisiDogruMu;
    }
    public void kullaniciBilgileriAktar(){

        if(!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }

        try {

            Statement statement2 = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sqlKullaniciIDFiAlma ="SELECT kisi_idf FROM kullanici_bilgileri WHERE kullanici_ad = '"+this.kullanici+"' ;";
            ResultSet resultSetCekilenID = statement2.executeQuery(sqlKullaniciIDFiAlma);

            if (resultSetCekilenID.next()){
                AktifKullanici.aktifKullaniciID = resultSetCekilenID.getInt(1);
            }
            resultSetCekilenID.close();


            String sqlKullaniciIsimAlma ="SELECT kisi_isim FROM kisi_bilgileri inner join kullanici_bilgileri on kisi_bilgileri.kisi_id=kullanici_bilgileri.kisi_idf " +
                    "where kullanici_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
            String sqlKullaniciSoyAdiAlma ="SELECT kisi_soyisim FROM kisi_bilgileri inner join kullanici_bilgileri on kisi_bilgileri.kisi_id=kullanici_bilgileri.kisi_idf " +
                    "where kullanici_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
            String sqlKullaniciSinifiAlma ="SELECT kisi_sinif FROM egitim_bilgileri inner join kisi_bilgileri on egitim_bilgileri.kisi_idf=kisi_bilgileri.kisi_id " +
            "where egitim_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
            String sqlKullaniciBolumAlma ="SELECT kisi_bolum FROM egitim_bilgileri inner join kisi_bilgileri on egitim_bilgileri.kisi_idf=kisi_bilgileri.kisi_id " +
                    "where egitim_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
            String sqlKullaniciOkuluAlma ="SELECT kisi_okul FROM egitim_bilgileri inner join kisi_bilgileri on egitim_bilgileri.kisi_idf=kisi_bilgileri.kisi_id " +
                    "where egitim_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";

            /*
            String sqlKullaniciIsimAlma ="SELECT kisi_isim FROM kisi_bilgileri WHERE kullanici_ad = '"+this.kullanici+"' ;";
            String sqlKullaniciSoyAdiAlma ="SELECT kisi_soyisim FROM kisi_bilgileri WHERE kullanici_ad = '"+this.kullanici+"' ;";
            String sqlKullaniciSinifiAlma ="SELECT kisi_sinif FROM kisi_bilgileri WHERE kullanici_ad = '"+this.kullanici+"' ;";
            String sqlKullaniciBolumAlma ="SELECT kisi_bolum FROM kisi_bilgileri WHERE kullanici_ad = '"+this.kullanici+"' ;";
            String sqlKullaniciOkuluAlma ="SELECT kisi_okul FROM kisi_bilgileri WHERE kullanici_ad = '"+this.kullanici+"' ;";
            */

            ResultSet resultSetCekilenIsim = statement2.executeQuery(sqlKullaniciIsimAlma);
            if (resultSetCekilenIsim.next()){
                AktifKullanici.aktifKullaniciAd=resultSetCekilenIsim.getString(1);

            }
                resultSetCekilenIsim.close();

            ResultSet resultSetCekilenSOYAD = statement2.executeQuery(sqlKullaniciSoyAdiAlma);
            if (resultSetCekilenSOYAD.next()){
                AktifKullanici.aktifKullaniciSoyAd=resultSetCekilenSOYAD.getString(1);
            }resultSetCekilenSOYAD.close();


            ResultSet resultSetCekilenSINIF = statement2.executeQuery(sqlKullaniciSinifiAlma);
            if (resultSetCekilenSINIF.next()) {
                AktifKullanici.aktifKullaniciSinif= resultSetCekilenSINIF.getString(1);
            }resultSetCekilenSINIF.close();

            ResultSet resultSetCekilenBOLUM = statement2.executeQuery(sqlKullaniciBolumAlma);
            if (resultSetCekilenBOLUM.next()) {
                AktifKullanici.aktifKullaniciBolum=resultSetCekilenBOLUM.getString(1);
            }resultSetCekilenBOLUM.close();


            ResultSet resultSetCekilenOKUL = statement2.executeQuery(sqlKullaniciOkuluAlma);
             if (resultSetCekilenOKUL.next()) {
                AktifKullanici.aktifKullaniciOkul=resultSetCekilenOKUL.getString(1);
            }resultSetCekilenOKUL.close();

            baglan.close();
            statement2.close();
            baglanmaDurumu=false;
            /*
            System.out.println("İSİM: "+AktifKullanici.aktifKullaniciAd);
            System.out.println("SOYİSİM: "+AktifKullanici.aktifKullaniciSoyAd);
            System.out.println("KULLANICI ADI: "+AktifKullanici.aktifKullaniciKullaniciAdi);
            System.out.println("ID: "+AktifKullanici.aktifKullaniciID);
            System.out.println("SNIF: "+AktifKullanici.aktifKullaniciSinif);
            System.out.println("BOLUM: "+AktifKullanici.aktifKullaniciBolum);
            System.out.println("OKUL: "+AktifKullanici.aktifKullaniciOkul);
            */
        } catch (SQLException sqlException5) {
            System.out.println("Kullanıcı bilgileri sisteme yönlendirilirken oluşan sql hatası!! :" + sqlException5.getMessage());
        }

    }
    int kisininDonemdekiDersSayisiniGetir(int sorgulanicakDonem){
          int donemdekiDersSayisi=0;
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
           try {
               String sqlDonemdekiDersSayisiniGetir="  select count(*) from ders_bilgileri where alindigi_donem = "+sorgulanicakDonem+" and kisi_idf = "+AktifKullanici.aktifKullaniciID+" ;";
               Statement stat3 =  baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               ResultSet resultSetCekilenDonemDersSayisi = stat3.executeQuery(sqlDonemdekiDersSayisiniGetir);
               while (resultSetCekilenDonemDersSayisi.next()){
                   donemdekiDersSayisi = resultSetCekilenDonemDersSayisi.getInt(1);
                   //System.out.println("Donemdeki Ders Sayısı : "+donemdekiDersSayisi);
               }
               resultSetCekilenDonemDersSayisi.close();
           }catch (SQLException e){
               System.out.println("Donemdeki Ders Sayısı Bulunurken oluşan sql hatası : "+e.getMessage());
            }

          return donemdekiDersSayisi;
    }

    ArrayList<String> kisininDonemdekiDersIsimleriniGetir(int sorgulanicakDonem,int dersSayisi,ArrayList<String> kisiDonemdekiDersIsimleriAR){
       kisiDonemdekiDersIsimleriAR.clear();
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        try {
                String sqlDonemdekiDersIsimleriGetir="select ders_isim from ders_bilgileri where alindigi_donem = "+sorgulanicakDonem+" and kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
                Statement stat3 =  baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSetCekilenDonemDersIsimleri = stat3.executeQuery(sqlDonemdekiDersIsimleriGetir);


                while (resultSetCekilenDonemDersIsimleri.next()){

                     kisiDonemdekiDersIsimleriAR.add(resultSetCekilenDonemDersIsimleri.getString(1));

                }
                resultSetCekilenDonemDersIsimleri.close();

        }catch (SQLException e){
            System.out.println("Donemdeki İsimleri Bulunurken oluşan sql hatası : "+e.getMessage());
        }

        return kisiDonemdekiDersIsimleriAR;
    }
    int dersDonemBilgisiGetir(String dersIsmi){
        int dersinAlindigiDonem=0;
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        try {
            String sqlDersinDoneminiGetir="select alindigi_donem from ders_bilgileri where ders_isim = '"+dersIsmi+"' and kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
            Statement stat3 =  baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSetCekilenDersinDonemi = stat3.executeQuery(sqlDersinDoneminiGetir);


            while (resultSetCekilenDersinDonemi.next()){
                 dersinAlindigiDonem = resultSetCekilenDersinDonemi.getInt(1);
            }
            resultSetCekilenDersinDonemi.close();

        }catch (SQLException e){
            System.out.println("Dersin Dönem Bilgisi Getirilirken Oluşan Sql Hatası : "+e.getMessage());
        }

        return dersinAlindigiDonem;
    }


    ArrayList dersinBilgileriniGetir(String dersIsmi,ArrayList dersinBilgileriAR){

        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        try {

            dersinBilgileriAR.clear();

            String sqlDersinBilgileriniGetir = "select ders_akts,vize_notu,final_notu,vize_etkiO,final_etkiO,dersten_gecme_durumu,dersten_gecme_notu100,dersten_gecme_notu4,ders_bilgileri.alindigi_donem,ders_harf_notu from not_bilgileri inner join ders_bilgileri on ders_idf = ders_id inner join ders_ortalama_bilgileri on ders_ortalama_bilgileri.ders_idf = ders_bilgileri.ders_id  where ders_bilgileri.ders_isim = '"+dersIsmi+"' and not_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";

            Statement stat3 =  baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSetCekilenDersVerileri = stat3.executeQuery(sqlDersinBilgileriniGetir);


            while (resultSetCekilenDersVerileri.next()){

                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getInt("alindigi_donem"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getInt("ders_akts"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getFloat("vize_notu"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getFloat("final_notu"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getInt("vize_etkiO"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getInt("final_etkiO"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getFloat("dersten_gecme_notu100"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getFloat("dersten_gecme_notu4"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getString("dersten_gecme_durumu"));
                dersinBilgileriAR.add(resultSetCekilenDersVerileri.getString("ders_harf_notu"));


                //     System.out.println("Donemdeki "+getirilicekVeriIsmi+" : "+kisiDonemdekiIstenilenVeriAR.get(index));

            }
            resultSetCekilenDersVerileri.close();

        }catch (SQLException e){
            System.out.println("Dersin Bilgileri Getirilirken Oluşan Sql Hatası : "+e.getMessage());
        }

       return dersinBilgileriAR;
    }


   ArrayList<Integer> kisininDonemdekiDersVerisiniGetir(int sorgulanicakDonem,int dersSayisi,ArrayList<Integer> kisiDonemdekiIstenilenVeriAR,String istenilenVeriIsmi){

       if (!baglanmaDurumu){
           try {
               msqlBaglan();
               baglanmaDurumu=true;
           } catch (SQLException e) {
               baglanmaDurumu=false;
               throw new RuntimeException(e);
           }
       }
       try {
           String getirilicekVeriIsmi="";
           String sqlDonemdekiDersBilgisiGetir="";
           kisiDonemdekiIstenilenVeriAR.clear();

           switch (istenilenVeriIsmi){
               case "vize":
                   getirilicekVeriIsmi="vize_notu";
                   sqlDonemdekiDersBilgisiGetir="select "+getirilicekVeriIsmi+" from not_bilgileri inner join ders_bilgileri on ders_idf=ders_id where ders_bilgileri.alindigi_donem = "+sorgulanicakDonem+" and not_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";

                   break;
               case "final":
                   getirilicekVeriIsmi="final_notu";
                   sqlDonemdekiDersBilgisiGetir="select "+getirilicekVeriIsmi+" from not_bilgileri inner join ders_bilgileri on ders_idf=ders_id where ders_bilgileri.alindigi_donem = "+sorgulanicakDonem+" and not_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
                   break;
               case "vizeEtki":
                   getirilicekVeriIsmi="vize_etkiO";
                   sqlDonemdekiDersBilgisiGetir="select "+getirilicekVeriIsmi+" from not_bilgileri inner join ders_bilgileri on ders_idf=ders_id where ders_bilgileri.alindigi_donem = "+sorgulanicakDonem+" and not_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
                   break;
               case "finalEtki":
                   getirilicekVeriIsmi="final_etkiO";
                   sqlDonemdekiDersBilgisiGetir="select "+getirilicekVeriIsmi+" from not_bilgileri inner join ders_bilgileri on ders_idf=ders_id where ders_bilgileri.alindigi_donem = "+sorgulanicakDonem+" and not_bilgileri.kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
                   break;
               case "akts":
                   getirilicekVeriIsmi="ders_akts";
                   sqlDonemdekiDersBilgisiGetir="select ders_akts from ders_bilgileri where alindigi_donem = "+sorgulanicakDonem+" and kisi_idf = "+AktifKullanici.aktifKullaniciID+";";
                   break;
               default:
                   System.out.println("hatalı veri ismi");
                   break;
           }

           Statement stat3 =  baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet resultSetCekilenDonemDersVerileri = stat3.executeQuery(sqlDonemdekiDersBilgisiGetir);


               while (resultSetCekilenDonemDersVerileri.next()){
                       kisiDonemdekiIstenilenVeriAR.add(resultSetCekilenDonemDersVerileri.getInt(1));
                  //     System.out.println("Donemdeki "+getirilicekVeriIsmi+" : "+kisiDonemdekiIstenilenVeriAR.get(index));

               }
               resultSetCekilenDonemDersVerileri.close();


       }catch (SQLException e){
           System.out.println("Donemdeki İstenilen Veriler Bulunurken oluşan sql hatası : "+e.getMessage());
       }

       return kisiDonemdekiIstenilenVeriAR;
   }

    int dersIdBul(String anlikDersIsim){
        AnlikdersId=0;
        kullanici=AktifKullanici.aktifKullaniciKullaniciAdi;
        if(!baglanmaDurumu){
            try {
                msqlBaglan();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                Statement stat3 =  baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String sqlDersIDiAlma ="select ders_id from ders_bilgileri where ders_isim ='"+anlikDersIsim+"' and " +
                        "kisi_idf = (SELECT kisi_idf FROM kullanici_bilgileri WHERE kullanici_ad = '"+AktifKullanici.aktifKullaniciKullaniciAdi+"'); ";
                ResultSet resultSetCekilenDersID = stat3.executeQuery(sqlDersIDiAlma);
                while (resultSetCekilenDersID.next()){
                    AnlikdersId = resultSetCekilenDersID.getInt(1);
                    //System.out.println("BURDAKİ DERSıd : "+AnlikdersId);
                }
                resultSetCekilenDersID.close();

            }catch(SQLException a){
                AnlikdersId=0;
                System.out.println("DersID Bulunurken oluşan sql hatası : "+a.getMessage());
            }

        }

        try {
            Statement stat3 = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sqlDersIDiAlma = "select ders_id from ders_bilgileri where ders_isim ='" + anlikDersIsim + "' and " +
                    "kisi_idf = (SELECT kisi_idf FROM kullanici_bilgileri WHERE kullanici_ad = '" + AktifKullanici.aktifKullaniciKullaniciAdi + "'); ";
            ResultSet resultSetCekilenDersID = stat3.executeQuery(sqlDersIDiAlma);
            while (resultSetCekilenDersID.next()) {
                AnlikdersId = resultSetCekilenDersID.getInt(1);
                //System.out.println("BURDAKİ DERSıd : " + AnlikdersId);
            }
            resultSetCekilenDersID.close();
        }catch (SQLException F){
            AnlikdersId=0;
            System.out.println("dersss id alınırken oluşann sql hatası : "+F.getMessage());
        }

        return AnlikdersId;
    }
    boolean kisininKayitliDersleriniGetir(){

        if(!baglanmaDurumu){
            try {
                msqlBaglan();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            if(baglan==null || baglan.isClosed()){
                msqlBaglan();
            }

            System.out.println(baglan);
            Statement statement = baglan.createStatement();

            String sqlKullaniciKayitliDersSayisi = "SELECT COUNT(*) FROM ders_bilgileri WHERE kisi_idf = '" + AktifKullanici.aktifKullaniciID + "'";
            ResultSet resultSetCekilenDersSayisi = statement.executeQuery(sqlKullaniciKayitliDersSayisi);

            if (resultSetCekilenDersSayisi.next()) {
                int kisininKayitliDersSayisi = resultSetCekilenDersSayisi.getInt(1);
                AktifKullanici.aktifKullaniciDersSayi = kisininKayitliDersSayisi;
              //  System.out.println("Ders sayınız: " + kisininKayitliDersSayisi);


                String sqlKullaniciKayitliDersAlma = "SELECT ders_isim FROM ders_bilgileri WHERE kisi_idf = '" + AktifKullanici.aktifKullaniciID + "'";
                ResultSet resultSetCekilenDers = statement.executeQuery(sqlKullaniciKayitliDersAlma);
                for(int k=0;k<cekilenDers.length;k++){
                    cekilenDers[k]="";
                }
                int i = 0;
                while (resultSetCekilenDers.next()) {
                    cekilenDers[i] = resultSetCekilenDers.getString("ders_isim");
                    i++;
                }
                resultSetCekilenDers.close();
            }
            resultSetCekilenDersSayisi.close();
             statement.close();

            kisininKayitliDersGetirmeDurumu=true;
        } catch (SQLException e) {
            System.out.println("Ders bilgileri uygulamaya aktarılırken oluşan hata: " + e.getMessage());
            kisininKayitliDersGetirmeDurumu=false;
            return false;
        }
            return kisininKayitliDersGetirmeDurumu;
    }

    int enYuksekDersIdGetir(){
          String maxDersIDSql ="SELECT MAX(ders_id) from ders_bilgileri ;";
          int maxdersId=0;
        try {
            ResultSet resultSetMaxDersId = stat.executeQuery(maxDersIDSql);
            if(resultSetMaxDersId.next()){
                maxdersId=resultSetMaxDersId.getInt(1);
            }
            resultSetMaxDersId.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return maxdersId;
    }
    int enYuksekOrtalamaId(){
        if(!this.baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }else {

            String sorguOrtalamaEnyuksekSql = "SELECT MAX(kisi_ortalama_id) FROM kisi_ortalama_bilgileri";
            try {
                Statement statementOrtalamaId = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSetOrtalamaId = statementOrtalamaId.executeQuery(sorguOrtalamaEnyuksekSql);

                if (resultSetOrtalamaId.next()) {
                    enYuksekOrtalamaId = resultSetOrtalamaId.getInt(1);
                    if(resultSetOrtalamaId.getInt(1)==0 ){
                        enYuksekOrtalamaId=0;
                    }
                }else {
                    enYuksekOrtalamaId = 0;
                }
                resultSetOrtalamaId.close();
                statementOrtalamaId.close();

            } catch (SQLException sqlException5) {
                System.out.println("En yüksek ortalama id belirlenirken oluşan sql hatası!! :" + sqlException5.getMessage());
            }

            System.out.println("en yüksek  ortalama id: "+enYuksekOrtalamaId);

        }

        return enYuksekOrtalamaId;
    }

    boolean gecerliDonemdeYnoOrtalamaKaydiVarMi(int gecerliDonem){

        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }

        try {

            String sqlDonemdeKayitliYnoGetir = "select donem_ortalamasi from  kisi_ortalama_bilgileri  where kisi_idf = "+AktifKullanici.aktifKullaniciID+" and alindigi_donem = "+gecerliDonem+" ;";


            Statement statementDonemdeKayitliYnoGetir = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSetDonemdeKayitliYnoGetir = statementDonemdeKayitliYnoGetir.executeQuery(sqlDonemdeKayitliYnoGetir);

            if (resultSetDonemdeKayitliYnoGetir.next() && (resultSetDonemdeKayitliYnoGetir.getInt(1)>0)) {

                isGecerliDonemdeYnoKayitYok=false;

            }else {
                isGecerliDonemdeYnoKayitYok=true;

            }
            resultSetDonemdeKayitliYnoGetir.close();

        }catch (SQLException e){
            System.out.println("Geçerli dönemde yno kaydı varmı diye sorgulanırken oluşan sql hatası "+e.getMessage());
        }

            return  isGecerliDonemdeYnoKayitYok;
    }
    void donemeYnoKaydiEkle(int gecerliDonem,float gno,float yno){
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        enYuksekOrtalamaId=enYuksekOrtalamaId()+1;
        String sqlDonemeYnoGnoEkle = "insert into kisi_ortalama_bilgileri(kisi_ortalama_id,alindigi_donem,donem_ortalamasi,genel_ortalamasi,kisi_idf) values ("+enYuksekOrtalamaId+","+gecerliDonem+","+yno+","+gno+","+AktifKullanici.aktifKullaniciID+") ;";
        try {

            PreparedStatement StatDonemeYnoGnoEkle = baglan.prepareStatement(sqlDonemeYnoGnoEkle);
            StatDonemeYnoGnoEkle.executeUpdate();
            System.out.println("Gno-yno doneme ekleme başarıyla gerçekleşti");
        } catch (SQLException e) {
            System.out.println("Gno-yno doneme eklenirken oluşan sql hatası "+e.getMessage());
            throw new RuntimeException(e);
        }

    }


    void gnoYnoGuncelle(int kisiId,int gecerliDonem,float gno,float yno){

          isGecerliDonemdeYnoKayitYok = gecerliDonemdeYnoOrtalamaKaydiVarMi(gecerliDonem);

          if (isGecerliDonemdeYnoKayitYok){
              System.out.println("yno eklenmeli");
              donemeYnoKaydiEkle(gecerliDonem,gno,yno);
              gnoYnoGuncelle(kisiId,gecerliDonem,gno,yno);

          }else {
              System.out.println("yno kaydı var");

              String sqlGnoYnoGuncelle = "update kisi_ortalama_bilgileri set alindigi_donem = "+gecerliDonem+" ,genel_ortalamasi = "+gno+", donem_ortalamasi = "+yno+" where kisi_idf = "+kisiId+" and alindigi_donem ="+gecerliDonem+" ;";
              try {
                  PreparedStatement StatGnoYnoGuncelle = baglan.prepareStatement(sqlGnoYnoGuncelle);
                  StatGnoYnoGuncelle.executeUpdate();
                  System.out.println("Gno-Yno güncelleme başarıyla gerçekleşti");
              } catch (SQLException e) {

                  JOptionPane.showMessageDialog(null,"Gno-Yno güncellenirken oluşan sql hatası");
                  System.out.println("Gno-Yno güncellenirken oluşan sql hatası "+e.getMessage());
                  throw new RuntimeException(e);
              }
          }
    }

    void sistemdekiGnoGuncelle(int kisiId,String gno,String gnoGercerliDonemString,int eskiGecerliDonem,String eskiGno){
        float guncellenicekGno=Float.parseFloat(gno);
        int guncelgnoGecerliDonem = Integer.parseInt(gnoGercerliDonemString);

        enYuksekOrtalamaId=enYuksekOrtalamaId();

        String sqlGnoGuncelle = "update kisi_ortalama_bilgileri set alindigi_donem = "+guncelgnoGecerliDonem+" ,genel_ortalamasi = "+guncellenicekGno+" where kisi_idf = "+kisiId+" and alindigi_donem ="+eskiGecerliDonem+" and genel_ortalamasi = "+eskiGno+" ;";
        try {
            PreparedStatement StatGnoGuncelle = baglan.prepareStatement(sqlGnoGuncelle);
            StatGnoGuncelle.executeUpdate();
            System.out.println("Gno güncelleme başarıyla gerçekleşti");
        } catch (SQLException e) {
            System.out.println("Gno güncellenirken oluşan sql hatası "+e.getMessage());
            throw new RuntimeException(e);
        }


    }
    void yeniGnoHesapla(int kisiId,int anlikDonem,float yno,float eskiYno){
          aktifGno = gnoVarsaGetir(kisiId);

          if(anlikDonem>gecerliDonem){
              yeniGno = (aktifGno+yno)/(gecerliDonem+1);
          }
          if(anlikDonem<=gecerliDonem){
              yeniGno = (aktifGno - eskiYno + yno) / gecerliDonem ;
          }

    }

    float eskiGnoGetir(int kisiId,int alindigiDonem){

        String sqlEskiGnoGetir = "SELECT top 1 genel_ortalamasi FROM kisi_ortalama_bilgileri where kisi_idf = "+kisiId+" and  alindigi_donem = "+alindigiDonem+" ";

        float getirilenGno=0.0f;
        try {
            Statement statementEskiGnoGetir = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSetEskiGnoGetir = statementEskiGnoGetir.executeQuery(sqlEskiGnoGetir);

            if (resultSetEskiGnoGetir.next()) {
                getirilenGno = resultSetEskiGnoGetir.getFloat(1);
            }resultSetEskiGnoGetir.close();

        }catch (SQLException g){
            System.out.println("Gösterilcek eski gno getirilirken oluşamn hata "+g.getMessage());
        }
        return getirilenGno;
    }


    float gnoVarsaGetir(int kisiId){
        String sqlGnoGetir = "SELECT top 1 genel_ortalamasi FROM kisi_ortalama_bilgileri where kisi_idf = "+kisiId+" order by alindigi_donem desc ";
        String sqlGnoGecerliDonemGetir ="SELECT top 1 alindigi_donem FROM kisi_ortalama_bilgileri where kisi_idf = "+kisiId+" order by alindigi_donem desc ";
        float gosterilcekGno=0.0f;
        try {
            Statement statementGnoGetir = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSetGnoGetir = statementGnoGetir.executeQuery(sqlGnoGetir);

            if (resultSetGnoGetir.next()) {
                gosterilcekGno = resultSetGnoGetir.getFloat(1);
            }resultSetGnoGetir.close();

            try {
                Statement statementGecerliDonemGetir = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSetGecerliDonemGetir = statementGecerliDonemGetir.executeQuery(sqlGnoGecerliDonemGetir);

                if (resultSetGecerliDonemGetir.next()) {
                   gecerliDonem = resultSetGecerliDonemGetir.getInt(1);
                }resultSetGecerliDonemGetir.close();
            }catch (SQLException M){
                System.out.println("Geçerli dönem getirilirken oluşan hata "+M.getMessage());
            }

        }catch (SQLException g){
            System.out.println("Gösterilcek gno getirilirken oluşamn hata "+g.getMessage());
        }
        return gosterilcekGno;
    }


    void sistemeGnoEkle(int kisiId,String gno,String gnoGercerliDonemString){
          float girelecekGno=Float.parseFloat(gno);
          int gnoGecerliDonem = Integer.parseInt(gnoGercerliDonemString);

          enYuksekOrtalamaId=enYuksekOrtalamaId()+1;

         String sqlGnoEkle = "insert into kisi_ortalama_bilgileri(kisi_ortalama_id,alindigi_donem,genel_ortalamasi,kisi_idf) values ("+enYuksekOrtalamaId+","+gnoGecerliDonem+","+girelecekGno+","+kisiId+") ;";
        try {
            PreparedStatement StatGnoEkle = baglan.prepareStatement(sqlGnoEkle);
            StatGnoEkle.executeUpdate();
            System.out.println("Gno ekleme başarıyla gerçekleşti");
        } catch (SQLException e) {
            System.out.println("Gno eklenirken oluşan sql hatası "+e.getMessage());
            throw new RuntimeException(e);
        }

    }

    boolean dersBilgileriGir(int donem,String dersIsim,int akts,int vizeNotu,int vizeEtkiOrani,int finalNotu,int finalEtkiOrani,String ders_harf_notu){

        int kisi_idf=0;
        int yeniDersId=0;
        if(!baglanmaDurumu){
            try {
                msqlBaglan();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            String sqlDersBilgisiGir =" insert into ders_bilgileri(ders_id,alindigi_donem,ders_isim,ders_akts,kisi_idf) VALUES (" +
                    "?,?,?,?,?); ";
            String sqlNotBilgileriGir= "insert into not_bilgileri(not_id,vize_notu,final_notu,vize_etkiO,final_etkiO,ders_idf,kisi_idf) VALUES (" +
                    "?,?,?,?,?,?,?); ";
            PreparedStatement parametreliStatDers = baglan.prepareStatement(sqlDersBilgisiGir);

            kisi_idf = AktifKullanici.aktifKullaniciID;
            yeniDersId =enYuksekDersIdGetir()+1;

            parametreliStatDers.setInt(1,yeniDersId);
            parametreliStatDers.setInt(2,donem);
            parametreliStatDers.setString(3,dersIsim);
            parametreliStatDers.setInt(4,akts);
            parametreliStatDers.setInt(5,kisi_idf);

            parametreliStatDers.executeUpdate();

            PreparedStatement parametreliStatNot =baglan.prepareStatement(sqlNotBilgileriGir);

            dersIdBul(dersIsim);

            int ders_idf = dersIdBul(dersIsim);



            parametreliStatNot.setInt(1,yeniDersId);
            parametreliStatNot.setInt(2,vizeNotu);
            parametreliStatNot.setInt(3,finalNotu);
            parametreliStatNot.setInt(4,vizeEtkiOrani);
            parametreliStatNot.setInt(5,finalEtkiOrani);
            parametreliStatNot.setInt(6,ders_idf);
            parametreliStatNot.setInt(7,kisi_idf);
            parametreliStatNot.executeUpdate();

            dersBilgileriAktarmaDurumu=true;
        }catch (SQLException e){
            dersBilgileriAktarmaDurumu=false;
            System.out.println("ders bilgierli eklenirken oluşan hata"+e.getMessage());
        }
        try {
            String sqlDersBilgisiGir =" insert into ders_ortalama_bilgileri(ders_ortalama_id,dersten_gecme_notu100,dersten_gecme_notu4,dersten_gecme_durumu,ders_idf,alindigi_donem,kisi_idf,ders_harf_notu) VALUES (" +
                    "?,?,?,?,?,?,?,?); ";

            PreparedStatement parametreliStatDersOrtBilgi =baglan.prepareStatement(sqlDersBilgisiGir);

            parametreliStatDersOrtBilgi.setInt(1,yeniDersId);
            parametreliStatDersOrtBilgi.setFloat(2,OrtalamaHesapla.derstenGecmeNotu100);
            parametreliStatDersOrtBilgi.setFloat(3,OrtalamaHesapla.dortlukDersGecmeNotu);
            parametreliStatDersOrtBilgi.setString(4,OrtalamaHesapla.dersGecmeDurumuString);
            parametreliStatDersOrtBilgi.setInt(5,yeniDersId);
            parametreliStatDersOrtBilgi.setInt(6,donem);
            parametreliStatDersOrtBilgi.setInt(7,kisi_idf);
            parametreliStatDersOrtBilgi.setString(8,ders_harf_notu);

            parametreliStatDersOrtBilgi.executeUpdate();

        }catch (SQLException d){
            System.out.println("Ortalama bilgileri aktarılırken oluşan hata "+d.getMessage());
        }
        try {
            baglan.close();
            baglanmaDurumu=false;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

            return dersBilgileriAktarmaDurumu;
    }
    boolean guncellenicekKullaniclarinBilgileriniCekme(String dersIsim){
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        Statement statement;
        try {
            statement = baglan.createStatement();

            String sqlGuncellenicekDersAkts = "SELECT ders_akts from ders_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and ders_isim = '"+dersIsim+"';";
            ResultSet resultSetGCekilenDersAkts = statement.executeQuery(sqlGuncellenicekDersAkts);

            if (resultSetGCekilenDersAkts.next()) {
                GuncellenicekBilgiler.guncellenicekDersAkts = resultSetGCekilenDersAkts.getInt(1);
            }
            resultSetGCekilenDersAkts.close();

            String sqlGuncellenicekDersVize = "SELECT vize_notu from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select TOP 1 ders_id from ders_bilgileri where ders_isim = '"+dersIsim+"' and kisi_idf="+AktifKullanici.aktifKullaniciID +");";


            ResultSet resultSetGCekilenDersVize = statement.executeQuery(sqlGuncellenicekDersVize);

            if(resultSetGCekilenDersVize.next()) {
                GuncellenicekBilgiler.guncellenicekVizeNotu= resultSetGCekilenDersVize.getInt(1);

            }
            resultSetGCekilenDersVize.close();

            String sqlGuncellenicekDersFinal = "SELECT final_notu from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+dersIsim+"' and kisi_idf="+AktifKullanici.aktifKullaniciID +");";

            ResultSet resultSetGCekilenDersFinal = statement.executeQuery(sqlGuncellenicekDersFinal);

            if (resultSetGCekilenDersFinal.next()) {
                GuncellenicekBilgiler.guncellenicekFinalNotu = resultSetGCekilenDersFinal.getInt(1);

            }
            resultSetGCekilenDersFinal.close();

            String sqlGuncellenicekDersVizeEtkiO = "SELECT vize_etkiO from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+dersIsim+"' and kisi_idf="+AktifKullanici.aktifKullaniciID +");";

            ResultSet resultSetGCekilenDersVizeEtkiO = statement.executeQuery(sqlGuncellenicekDersVizeEtkiO);

            if (resultSetGCekilenDersVizeEtkiO.next()) {
                GuncellenicekBilgiler.guncellenicekVizeEtkiO = resultSetGCekilenDersVizeEtkiO.getInt(1);

            }
            resultSetGCekilenDersVizeEtkiO.close();

            String sqlGuncellenicekDersFinalEtkiO = "SELECT final_etkiO from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+dersIsim+"' and kisi_idf="+AktifKullanici.aktifKullaniciID +");";

            ResultSet resultSetGCekilenDersFinalEtkiO = statement.executeQuery(sqlGuncellenicekDersFinalEtkiO);

            if (resultSetGCekilenDersFinalEtkiO.next()) {
                GuncellenicekBilgiler.guncellenicekFinalEtkiO = resultSetGCekilenDersFinalEtkiO.getInt(1);
            }
            resultSetGCekilenDersFinalEtkiO.close();


            guncellenicekKullaniclarinBilgileriniCekmeDurumu=true;
        }catch (SQLException d){
            guncellenicekKullaniclarinBilgileriniCekmeDurumu=false;
            System.out.println("Guncellenicek veriler Çekilirkenki sql hatası "+d.getMessage());
        }
          return guncellenicekKullaniclarinBilgileriniCekmeDurumu;
    }


    boolean silinecekKullanicininBilgileriniCekme(String dersIsim){
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        Statement statement;
        try {
             statement= baglan.createStatement();

             String sqlSilinecekDersAkts = "SELECT ders_akts from ders_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and ders_isim = '"+dersIsim+"';";
             ResultSet resultSetCekilenDersAkts = statement.executeQuery(sqlSilinecekDersAkts);

            if (resultSetCekilenDersAkts.next()) {
                SilinecekBilgiler.silinecekDersAkts = resultSetCekilenDersAkts.getInt(1);
            }
            resultSetCekilenDersAkts.close();

            String sqlSilinecekDersVize = "SELECT vize_notu from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"' and kisi_idf="+AktifKullanici.aktifKullaniciID +");";

            ResultSet resultSetCekilenDersVize = statement.executeQuery(sqlSilinecekDersVize);


            if(resultSetCekilenDersVize.next()) {
                SilinecekBilgiler.silinecekVizeNotu = resultSetCekilenDersVize.getInt(1);

            }
            resultSetCekilenDersVize.close();

            String sqlSilinecekDersFinal = "SELECT final_notu from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"' and kisi_idf="+AktifKullanici.aktifKullaniciID +");";

            ResultSet resultSetCekilenDersFinal = statement.executeQuery(sqlSilinecekDersFinal);

            if (resultSetCekilenDersFinal.next()) {
                SilinecekBilgiler.silinecekFinalNotu = resultSetCekilenDersFinal.getInt(1);

            }
            resultSetCekilenDersFinal.close();

            String sqlSilinecekDersVizeEtkiO = "SELECT vize_etkiO from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"' and kisi_idf="+AktifKullanici.aktifKullaniciID +");";

            ResultSet resultSetCekilenDersVizeEtkiO = statement.executeQuery(sqlSilinecekDersVizeEtkiO);

            if (resultSetCekilenDersVizeEtkiO.next()) {
                SilinecekBilgiler.silinecekVizeEtkiO = resultSetCekilenDersVizeEtkiO.getInt(1);

            }
            resultSetCekilenDersVizeEtkiO.close();

            String sqlSilinecekDersFinalEtkiO = "SELECT final_etkiO from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"' and kisi_idf="+AktifKullanici.aktifKullaniciID +");";

            ResultSet resultSetCekilenDersFinalEtkiO = statement.executeQuery(sqlSilinecekDersFinalEtkiO);

            if (resultSetCekilenDersFinalEtkiO.next()) {
                SilinecekBilgiler.silinecekFinalEtkiO = resultSetCekilenDersFinalEtkiO.getInt(1);
            }
            resultSetCekilenDersFinalEtkiO.close();

        silinecekKullanicininBilgileriniCekmeDurumu=true;
        } catch (SQLException e) {
            silinecekKullanicininBilgileriniCekmeDurumu=false;
            throw new RuntimeException(e);
        }

          return silinecekKullanicininBilgileriniCekmeDurumu;
    }
    boolean dersVeNotSil(){
          if (!baglanmaDurumu){
              try {
                  msqlBaglan();
                  baglanmaDurumu=true;
              } catch (SQLException e) {
                  baglanmaDurumu=false;
                  throw new RuntimeException(e);
              }
          }

        try {
            String sqlNotSilme ="DELETE FROM not_bilgileri where not_id = " +
                    "(SELECT not_id from not_bilgileri where ders_idf ="+dersIdBul(SilinecekBilgiler.silinecekDersIsmi)+"" +
                    "AND kisi_idf = "+AktifKullanici.aktifKullaniciID+");";
            PreparedStatement parametreliStatNotSilme   = baglan.prepareStatement(sqlNotSilme);
            parametreliStatNotSilme.executeUpdate();

            String sqlDersOrtlamaBilgileriSilme ="DELETE FROM ders_ortalama_bilgileri where ders_idf = " +
                    " "+dersIdBul(SilinecekBilgiler.silinecekDersIsmi)+";";

            PreparedStatement parametreliStatOrtalamaBilgisiSilme   = baglan.prepareStatement(sqlDersOrtlamaBilgileriSilme);
            parametreliStatOrtalamaBilgisiSilme.executeUpdate();

            String sqlDersSilme1 ="DELETE FROM ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"' and ders_id = " +
                    " "+dersIdBul(SilinecekBilgiler.silinecekDersIsmi)+";";

            String sqlDersSilme ="DELETE FROM ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"' and ders_id = " +
                    "(SELECT not_id from not_bilgileri where ders_idf ="+dersIdBul(SilinecekBilgiler.silinecekDersIsmi)+"" +
                    "AND kisi_idf = "+AktifKullanici.aktifKullaniciID+");";
            PreparedStatement parametreliStatDersSilme   = baglan.prepareStatement(sqlDersSilme1);
            parametreliStatDersSilme.executeUpdate();
            kisininKayitliDersleriniGetir();

            dersSilmeDurumu=true;
        } catch (SQLException e) {
            dersSilmeDurumu=false;
            throw new RuntimeException("Ders silme sql hatası"+e);
        }

        return dersSilmeDurumu;
    }
boolean dersVeNotguncelle(){
    if (!baglanmaDurumu){
        try {
            msqlBaglan();
            baglanmaDurumu=true;
        } catch (SQLException e) {
            baglanmaDurumu=false;
            throw new RuntimeException(e);
        }
    }

    try {

                String sqlNotGuncelle = "UPDATE not_bilgileri SET vize_notu = ?, final_notu = ?, vize_etkiO = ? , final_etkiO = ?" +
                " WHERE ders_idf = ? AND kisi_idf = ?";

                String sqlDersGuncelle = "UPDATE ders_bilgileri SET ders_akts = ? WHERE ders_isim = ?";

        PreparedStatement parametreliStatNotGuncelleme = baglan.prepareStatement(sqlNotGuncelle);
        parametreliStatNotGuncelleme.setInt(1,GuncellenicekBilgiler.guncelVizeNotu);
        parametreliStatNotGuncelleme.setInt(2,GuncellenicekBilgiler.guncelFinalNotu);
        parametreliStatNotGuncelleme.setInt(3,GuncellenicekBilgiler.guncelVizeEtkiO);
        parametreliStatNotGuncelleme.setInt(4,GuncellenicekBilgiler.guncelFinalEtkiO);
        parametreliStatNotGuncelleme.setInt(5,dersIdBul(GuncellenicekBilgiler.guncelDersIsmi));
        parametreliStatNotGuncelleme.setInt(6,AktifKullanici.aktifKullaniciID);

        parametreliStatNotGuncelleme.executeUpdate();

        PreparedStatement preparedStatementDersGuncelleme =baglan.prepareStatement(sqlDersGuncelle);
        preparedStatementDersGuncelleme.setInt(1,GuncellenicekBilgiler.guncelDersAkts);
        preparedStatementDersGuncelleme.setString(2,GuncellenicekBilgiler.guncellenicekDersIsmi);

        preparedStatementDersGuncelleme.executeUpdate();

        dersVeNotguncellemeDurumu=true;
    } catch (SQLException e) {
        dersVeNotguncellemeDurumu=false;
        throw new RuntimeException("Ders Güncelleme sql hatası"+e);
    }
     return dersVeNotguncellemeDurumu;
    }
    boolean enYuksekSorgulariYap(String SorgulanilanDers){
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        Statement statement;
        try {
            statement = baglan.createStatement();

            String sqlAlinanEnYuksekVize = "SELECT TOP 1  MAX(vize_notu) AS enYuksekV ,kisi_idf FROM not_bilgileri WHERE ders_idf IN(SELECT ders_id FROM ders_bilgileri WHERE ders_isim = '"+SorgulanilanDers+"') GROUP BY kisi_idf Order By enYuksekV desc;";
            ResultSet resultSetCekilenEnYuksekVize = statement.executeQuery(sqlAlinanEnYuksekVize);

            if (resultSetCekilenEnYuksekVize.next()) {

                EnYuksekBilgileri.enYuksekVizeNotu = resultSetCekilenEnYuksekVize.getInt(1);
            }

            resultSetCekilenEnYuksekVize.close();

            String sqlAlinanEnYuksekFinal = "SELECT TOP 1 MAX(final_notu) AS enYuksekF ,kisi_idf FROM not_bilgileri WHERE ders_idf IN(SELECT ders_id FROM ders_bilgileri WHERE ders_isim = '"+SorgulanilanDers+"') GROUP BY kisi_idf Order By enYuksekF desc;";
            ResultSet resultSetCekilenEnYuksekFinal = statement.executeQuery(sqlAlinanEnYuksekFinal);


            if (resultSetCekilenEnYuksekFinal.next()) {
                EnYuksekBilgileri.enYuksekFinalNotu = resultSetCekilenEnYuksekFinal.getInt(1);
            }
            resultSetCekilenEnYuksekFinal.close();

            String sqlDersiAlanSayisi ="select count(*) AS dersiAlanSayisi,ders_isim from ders_bilgileri Group by ders_isim having ders_isim ='"+SorgulanilanDers+"' Order by dersiAlanSayisi ;";

            ResultSet resultSetDersiAlanSayisi = statement.executeQuery(sqlDersiAlanSayisi);

            if (resultSetDersiAlanSayisi.next()) {
                EnYuksekBilgileri.enyVDersiAlanSayisi= resultSetDersiAlanSayisi.getInt(1);
                EnYuksekBilgileri.enyFDersiAlanSayisi = resultSetDersiAlanSayisi.getInt(1);
            }
            resultSetDersiAlanSayisi.close();

            String sqlEnYuksekFalanKisi ="select concat(kisi_isim,' ',kisi_soyisim) from kisi_bilgileri where kisi_id = (SELECT Top 1 kisi_idf FROM not_bilgileri WHERE ders_idf IN(SELECT ders_id FROM ders_bilgileri WHERE ders_isim = '"+SorgulanilanDers+"') GROUP BY kisi_idf Order By Max(final_notu) desc );";
            ResultSet resultSetEnYuksekFalanKisi=statement.executeQuery(sqlEnYuksekFalanKisi);
            if(resultSetEnYuksekFalanKisi.next()){
                EnYuksekBilgileri.enYuksekFNotuAlan=resultSetEnYuksekFalanKisi.getString(1);
            }
            resultSetEnYuksekFalanKisi.close();

            String sqlEnYuksekValanKisi ="select concat(kisi_isim,' ',kisi_soyisim) from kisi_bilgileri where kisi_id = (SELECT Top 1 kisi_idf FROM not_bilgileri WHERE ders_idf IN(SELECT ders_id FROM ders_bilgileri WHERE ders_isim = '"+SorgulanilanDers+"') GROUP BY kisi_idf Order By Max(vize_notu) desc );";
            ResultSet resultSetEnYuksekValanKisi=statement.executeQuery(sqlEnYuksekValanKisi);
            if(resultSetEnYuksekValanKisi.next()){
                EnYuksekBilgileri.enYuksekVNotuAlan=resultSetEnYuksekValanKisi.getString(1);
            }
            resultSetEnYuksekValanKisi.close();



            enYuksekDersSorgulamasi=true;
        }catch (SQLException H){
            enYuksekDersSorgulamasi=false;
            System.out.println("En yüksek bilgileri aranırken oluşan sql hatası :"+H.getMessage());
        }

            return enYuksekDersSorgulamasi;
    }
    void kisiOrtalamaBilgileriKaydirVeSil(int kullaniciId){
          String sqlKisiOrtalamaBilgileriKaydir ="update kisi_ortalama_bilgileri set kisi_idf = "+(kullaniciId-1)+" where kisi_idf = "+kullaniciId+" ;";
          String sqlDersOrtalamaBilgileriKaydir ="update ders_ortalama_bilgileri set kisi_idf = "+(kullaniciId-1)+"where kisi_idf = "+kullaniciId+" ;";

        PreparedStatement ptkisiOrtalamaBilgGuncelle= null;
        PreparedStatement ptDersOrtalamaBilgGuncelle= null;
        try {
            ptkisiOrtalamaBilgGuncelle = baglan.prepareStatement(sqlKisiOrtalamaBilgileriKaydir);
            ptkisiOrtalamaBilgGuncelle.executeUpdate();

            ptDersOrtalamaBilgGuncelle = baglan.prepareStatement(sqlDersOrtalamaBilgileriKaydir);
            ptDersOrtalamaBilgGuncelle.executeUpdate();

        } catch (SQLException e) {
            System.out.println("KİŞİ - DERS ORTALAMA BİLGİLERİ KAYDIRILIRKEN OLUŞAN HATA "+e.getMessage());
            throw new RuntimeException(e);
        }


    }

    void kullaniciBilgileriSistemeKayitEtVeSil(int kullaniciID){
        String sqlkullaniciAdi ="select kullanici_ad from kullanici_bilgileri where kisi_idf = "+kullaniciID+";";
        String sqlParola ="select kullanici_parola from kullanici_bilgileri where kisi_idf = "+kullaniciID+";";

        //String SQLKullaniciSil="delete from kullanici_bilgileri where kisi_idf = "+kullaniciID+";";

        ResultSet resultSetGeciciKullaniciAd= null;

        try {

            resultSetGeciciKullaniciAd = stat.executeQuery(sqlkullaniciAdi);

            if(resultSetGeciciKullaniciAd.next()){
                AktarilacakKullanici.guncellenecekKullaniciAdi =resultSetGeciciKullaniciAd.getString(1);
                System.out.println("as");
            }
            resultSetGeciciKullaniciAd.close();

            try {
                ResultSet resultSetGeciciParola;
                resultSetGeciciParola=stat.executeQuery(sqlParola);

                if(resultSetGeciciParola.next()){
                    AktarilacakKullanici.guncellenecekKullaniciParola =resultSetGeciciParola.getString(1);
                    System.out.println("sa");
                }
                resultSetGeciciParola.close();
            }catch (SQLException H){
                System.out.println("parola kaydedilirken oluşan hata "+H.getMessage());
            }
            try {
                String SQLKullaniciKaydir="update kullanici_bilgileri set kisi_idf = "+(kullaniciID-1)+"  where kisi_idf = "+kullaniciID+";";
                PreparedStatement ptKullaniciGuncelle= baglan.prepareStatement(SQLKullaniciKaydir);
                ptKullaniciGuncelle.executeUpdate();
            }catch (SQLException j){
                System.out.println("kullanici bilgisi kaydırılırken oluşan hata"+j.getMessage());
            }

            System.out.println("p");
          //  PreparedStatement ptsil= baglan.prepareStatement(SQLKullaniciSil);
            // ptsil.executeUpdate();
            System.out.println("d");

        } catch (SQLException e) {
            System.out.println("güncellenicek kullanıcı adı sisteme kayıt edilirken veya silinirken oluşan hata"+e.getMessage());
            throw new RuntimeException(e);
        }

    }
    int kisiVizeFinalNotuGetir(String dersIsim,boolean isVize){
          int gonderilcekNot=0;
          if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        Statement statement;
        try {
            statement = baglan.createStatement();

           if (isVize){
               String sqlGosterilecekVizeNotu = "SELECT vize_notu from not_bilgileri where kisi_idf =" + AktifKullanici.aktifKullaniciID + " and " +
                       "ders_idf = (select TOP 1 ders_id from ders_bilgileri where ders_isim = '" + dersIsim + "' and kisi_idf=" + AktifKullanici.aktifKullaniciID + ");";


               ResultSet resultSetGCekilenDersVize = statement.executeQuery(sqlGosterilecekVizeNotu);

               if (resultSetGCekilenDersVize.next()) {
                   gonderilcekNot = resultSetGCekilenDersVize.getInt(1);

               }
               resultSetGCekilenDersVize.close();
           }else {
               String sqlGosterilecekFinalNotu = "SELECT final_notu from not_bilgileri where kisi_idf =" + AktifKullanici.aktifKullaniciID + " and " +
                       "ders_idf = (select TOP 1 ders_id from ders_bilgileri where ders_isim = '" + dersIsim + "' and kisi_idf=" + AktifKullanici.aktifKullaniciID + ");";


               ResultSet resultSetGCekilenDersFinal = statement.executeQuery(sqlGosterilecekFinalNotu);

               if (resultSetGCekilenDersFinal.next()) {
                   gonderilcekNot=  resultSetGCekilenDersFinal.getInt(1);

               }
               resultSetGCekilenDersFinal.close();
           }
        }catch (SQLException e){
            System.out.println("Kişinin vize notu , final notu çekilirken oluşan sql hatası + "+e.getMessage());
        }
        return gonderilcekNot;
    }
    int kisiVizeFinalBasariSirasiPaylastigiKisiSayisiGetirme(int kisininVizeVeyaFinalNotu,String dersIsim,boolean isVize){
          int basariSirasiPaylasilanKisiSayisi=0;
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        Statement statement;
        try {
            statement = baglan.createStatement();

            if (isVize) {
                String sqlVizeBasariSirasiPaylasilanKisiSayisiHesapla ="SELECT COUNT(*) FROM not_bilgileri WHERE ders_idf IN ( SELECT ders_id FROM ders_bilgileri WHERE ders_isim = '"+dersIsim+"') AND vize_notu = "+kisininVizeVeyaFinalNotu+";";
                ResultSet resultSetHesaplanaVizeBasarisiPaylasilanKisiSayisiHesapla = statement.executeQuery(sqlVizeBasariSirasiPaylasilanKisiSayisiHesapla);

                if (resultSetHesaplanaVizeBasarisiPaylasilanKisiSayisiHesapla.next()) {
                    basariSirasiPaylasilanKisiSayisi = resultSetHesaplanaVizeBasarisiPaylasilanKisiSayisiHesapla.getInt(1);

                }
                resultSetHesaplanaVizeBasarisiPaylasilanKisiSayisiHesapla.close();
            }else{
                String sqlFinalBasariSirasiPaylasilanKisiSayisiHesapla ="SELECT COUNT(*) FROM not_bilgileri WHERE ders_idf IN ( SELECT ders_id FROM ders_bilgileri WHERE ders_isim = '"+dersIsim+"') AND final_notu = "+kisininVizeVeyaFinalNotu+";";
                ResultSet resultSetHesaplanaFinalBasarisiPaylasilanKisiSayisiHesapla = statement.executeQuery(sqlFinalBasariSirasiPaylasilanKisiSayisiHesapla);

                if (resultSetHesaplanaFinalBasarisiPaylasilanKisiSayisiHesapla.next()) {
                    basariSirasiPaylasilanKisiSayisi = resultSetHesaplanaFinalBasarisiPaylasilanKisiSayisiHesapla.getInt(1);

                }
                resultSetHesaplanaFinalBasarisiPaylasilanKisiSayisiHesapla.close();
            }

        }catch (SQLException e){
            System.out.println("Kişinin vize,final başarı sırasını paylaştığı kiişi sayısı hesaplanırken oluşan sql hatası + "+e.getMessage());
        }
          return --basariSirasiPaylasilanKisiSayisi;
    }


    int kisiVizeFinalBasariSirasiOgrenme(int kisininVizeVeyaFinalNotu,String dersIsim,boolean isVize){
          int basariSirasi=0;
        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        Statement statement;
        try {
            statement = baglan.createStatement();

            if (isVize) {
                String sqlVizeBasariSirasiHesapla ="SELECT COUNT(*) FROM not_bilgileri WHERE ders_idf IN ( SELECT ders_id FROM ders_bilgileri WHERE ders_isim = '"+dersIsim+"') AND vize_notu > "+kisininVizeVeyaFinalNotu+";";
                ResultSet resultSetHesaplanaVizeBasarisi = statement.executeQuery(sqlVizeBasariSirasiHesapla);

                if (resultSetHesaplanaVizeBasarisi.next()) {
                    basariSirasi = resultSetHesaplanaVizeBasarisi.getInt(1);

                }
                resultSetHesaplanaVizeBasarisi.close();
            }else{
                String sqlFinalBasariSirasiHesapla ="SELECT COUNT(*) FROM not_bilgileri WHERE ders_idf IN ( SELECT ders_id FROM ders_bilgileri WHERE ders_isim = '"+dersIsim+"') AND final_notu > "+kisininVizeVeyaFinalNotu+";";
                ResultSet resultSetHesaplanaFinalBasarisi = statement.executeQuery(sqlFinalBasariSirasiHesapla);

                if (resultSetHesaplanaFinalBasarisi.next()) {
                    basariSirasi = resultSetHesaplanaFinalBasarisi.getInt(1);

                }
                resultSetHesaplanaFinalBasarisi.close();
            }
        }catch (SQLException e){
            System.out.println("Kişinin vize,final başarı sırası hesaplanırken oluşan sql hatası + "+e.getMessage());
        }
          return ++basariSirasi;
    }



    int sinifVizeFinalNotOrtalamasiGonder(String dersIsim,boolean isVize){
         int sinifVizeVeyaFinalOrtalama=0;

        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        Statement statement;
        try {
            statement = baglan.createStatement();

            if (isVize) {
                String sqlVizeGenelOrtHesapla ="Select AVG(vize_notu) from not_bilgileri where ders_idf IN(select ders_id from ders_bilgileri  where ders_isim = '"+dersIsim+"') ;";
                ResultSet resultSetHesaplanaVizeGenelOrt = statement.executeQuery(sqlVizeGenelOrtHesapla);

                if (resultSetHesaplanaVizeGenelOrt.next()) {
                    sinifVizeVeyaFinalOrtalama = resultSetHesaplanaVizeGenelOrt.getInt(1);

                }
                resultSetHesaplanaVizeGenelOrt.close();
            }else{
                String sqlFinalGenelOrtHesapla ="Select AVG(final_notu) from not_bilgileri where ders_idf IN(select ders_id from ders_bilgileri  where ders_isim = '"+dersIsim+"') ;";
                ResultSet resultSetHesaplanaFinalGenelOrt = statement.executeQuery(sqlFinalGenelOrtHesapla);

                if (resultSetHesaplanaFinalGenelOrt.next()) {
                    sinifVizeVeyaFinalOrtalama = resultSetHesaplanaFinalGenelOrt.getInt(1);

                }
                resultSetHesaplanaFinalGenelOrt.close();
            }
        }catch (SQLException e){
            System.out.println("Sınıfın vize,final genel ortalaması hesaplanırken oluşan sql hatası + "+e.getMessage());
        }

          return sinifVizeVeyaFinalOrtalama;
    }



    float sinifKisiGenelNotOrtalamasiGonder(String dersIsim,int kisiId,boolean isSinif){
        float sinifVeyaKisiGenelOrtalama=0.00f;


        if (!baglanmaDurumu){
            try {
                msqlBaglan();
                baglanmaDurumu=true;
            } catch (SQLException e) {
                baglanmaDurumu=false;
                throw new RuntimeException(e);
            }
        }
        Statement statement;
        try {
            statement = baglan.createStatement();

            if (isSinif) {
                String sqlSinifGenelOrtGetir ="Select AVG(dersten_gecme_notu100) from ders_ortalama_bilgileri where ders_idf IN(select ders_id from ders_bilgileri  where ders_isim = '"+dersIsim+"') ;";
                ResultSet resultSetGetirilenSinifGenelOrt = statement.executeQuery(sqlSinifGenelOrtGetir);

                if (resultSetGetirilenSinifGenelOrt.next()) {
                    sinifVeyaKisiGenelOrtalama = resultSetGetirilenSinifGenelOrt.getFloat(1);

                }
                resultSetGetirilenSinifGenelOrt.close();
            }else{
                String sqlKisiGenelOrtGetir ="Select dersten_gecme_notu100 from ders_ortalama_bilgileri where ders_idf IN(select ders_id from ders_bilgileri  where ders_isim = '"+dersIsim+"') and kisi_idf= "+kisiId+" ;";
                ResultSet resultSetGetirilenKisiGenelOrt = statement.executeQuery(sqlKisiGenelOrtGetir);

                if (resultSetGetirilenKisiGenelOrt.next()) {
                    sinifVeyaKisiGenelOrtalama = resultSetGetirilenKisiGenelOrt.getFloat(1);

                }
                resultSetGetirilenKisiGenelOrt.close();
            }
        }catch (SQLException e){
            System.out.println("Sınıfın, Kişinin genel ortalaması hesaplanırken oluşan sql hatası + "+e.getMessage());
        }

        return sinifVeyaKisiGenelOrtalama;
    }


       String dersGenelEnyuksekOrtalamaVeyaKisisiniGetir(String dersIsim,boolean isOrtalama){
          float dersGenelEnyuksekOrtalama=0.00f;
          String enYuksekGenelOrtAlanKisi="";
          String dondurulecekDeger="";

           if (!baglanmaDurumu){
               try {
                   msqlBaglan();
                   baglanmaDurumu=true;
               } catch (SQLException e) {
                   baglanmaDurumu=false;
                   throw new RuntimeException(e);
               }
           }
           Statement statement;
           try {
               statement = baglan.createStatement();

               if (isOrtalama) {
                   String sqlGenelEnyuksekOrtGetir ="Select Top 1 dersten_gecme_notu100 from ders_ortalama_bilgileri where ders_idf IN(select ders_id from ders_bilgileri  where ders_isim = '"+dersIsim+"') ORDER BY dersten_gecme_notu100 DESC;";
                   ResultSet resultSetGetirilenEnYuksekGenelOrt = statement.executeQuery(sqlGenelEnyuksekOrtGetir);

                   if (resultSetGetirilenEnYuksekGenelOrt.next()) {
                       dersGenelEnyuksekOrtalama = resultSetGetirilenEnYuksekGenelOrt.getFloat(1);

                   }
                   resultSetGetirilenEnYuksekGenelOrt.close();
               }else{
                   String sqlKisiGenelOrtGetir ="  Select concat(kisi_isim,' ',kisi_soyisim) from kisi_bilgileri where kisi_id= (Select Top 1 kisi_idf from ders_ortalama_bilgileri where ders_idf IN(select ders_id from ders_bilgileri  where ders_isim = '"+dersIsim+"') ORDER BY dersten_gecme_notu100 DESC);";
                   ResultSet resultSetGetirilenKisiGenelOrt = statement.executeQuery(sqlKisiGenelOrtGetir);

                   if (resultSetGetirilenKisiGenelOrt.next()) {
                       enYuksekGenelOrtAlanKisi = resultSetGetirilenKisiGenelOrt.getString(1);

                   }
                   resultSetGetirilenKisiGenelOrt.close();
               }
           }catch (SQLException e){
               System.out.println("En yüksek genel ortalaması,Kişi getirilirken oluşan sql hatası + "+e.getMessage());
           }

           if (dersGenelEnyuksekOrtalama!=0){
               dondurulecekDeger=String.valueOf(dersGenelEnyuksekOrtalama);
           }else {
               dondurulecekDeger= enYuksekGenelOrtAlanKisi;
           }
          return dondurulecekDeger;
       }

       int dersGenelBasariSirasiGetir(String dersIsim,String kisiDersGenelOrt){
          int dersGenelBasariSirasi=0;
           if (!baglanmaDurumu){
               try {
                   msqlBaglan();
                   baglanmaDurumu=true;
               } catch (SQLException e) {
                   baglanmaDurumu=false;
                   throw new RuntimeException(e);
               }
           }
           Statement statement;
           try {
               statement = baglan.createStatement();


                   String sqlDersGenelBasariSirasiHesapla =" Select count(*) from ders_ortalama_bilgileri where dersten_gecme_notu100 > "+kisiDersGenelOrt+" and ders_idf IN(select ders_id from ders_bilgileri  where ders_isim = '"+dersIsim+"');";
                   ResultSet resultSetDersGenelBasariSirasi = statement.executeQuery(sqlDersGenelBasariSirasiHesapla);

                   if (resultSetDersGenelBasariSirasi.next()) {
                       dersGenelBasariSirasi = 1 + (int) resultSetDersGenelBasariSirasi.getInt(1);
                   }
                   resultSetDersGenelBasariSirasi.close();


           }catch (SQLException e){
               System.out.println("Kişinin ders genel başarı sırası getirilirken oluşan sql hatası + "+e.getMessage());
           }

          return dersGenelBasariSirasi;
       }


       int []derstenGecenKalanKisiSayisiGetir(String dersIsim,String dersiToplamAlanKisiSayisiString){
           int []dondurulenDeger={0,0};
           int derstenKalanKisiSayisi=0,derstenGecenKisiSayisi=0,dersiAlanToplamKisiSayisi=0;
           dersiAlanToplamKisiSayisi=Integer.parseInt(dersiToplamAlanKisiSayisiString);

           if (!baglanmaDurumu){
               try {
                   msqlBaglan();
                   baglanmaDurumu=true;
               } catch (SQLException e) {
                   baglanmaDurumu=false;
                   throw new RuntimeException(e);
               }
           }
           Statement statement;
           try {
               statement = baglan.createStatement();


                   String sqlGecenKisiSayisiGetir =" Select count(dersten_gecme_durumu) from ders_ortalama_bilgileri where dersten_gecme_durumu ='Geçti' and ders_idf  IN(select ders_id from ders_bilgileri  where ders_isim = '"+dersIsim+"');";
                   ResultSet resultSetGecenKisiSayisiGetir = statement.executeQuery(sqlGecenKisiSayisiGetir);

                   if (resultSetGecenKisiSayisiGetir.next()) {
                       derstenGecenKisiSayisi = resultSetGecenKisiSayisiGetir.getInt(1);
                       dondurulenDeger[0] = derstenGecenKisiSayisi;
                       derstenKalanKisiSayisi = dersiAlanToplamKisiSayisi - derstenGecenKisiSayisi;
                       dondurulenDeger[1] = derstenKalanKisiSayisi;
                   }
                   resultSetGecenKisiSayisiGetir.close();
           }catch (SQLException e){
               System.out.println("Dersten geçen kalan kişi sayısı hesaplanırken oluşan sql hatası + "+e.getMessage());
           }

          return dondurulenDeger;
       }

}
