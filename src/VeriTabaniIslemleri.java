import javax.swing.*;
import java.sql.*;

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
    int dersIdBul(String anlikDersIsim){
        AnlikdersId=0;
        kullanici=AktifKullanici.aktifKullaniciKullaniciAdi;
        if(!baglanmaDurumu){
            try {
                msqlBaglan();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hhh");
            try {
                System.out.println("fsm");
                Statement stat3 =  baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String sqlDersIDiAlma ="select ders_id from ders_bilgileri where ders_isim ='"+anlikDersIsim+"' and " +
                        "kisi_idf = (SELECT kisi_idf FROM kullanici_bilgileri WHERE kullanici_ad = '"+AktifKullanici.aktifKullaniciKullaniciAdi+"'); ";
                ResultSet resultSetCekilenDersID = stat3.executeQuery(sqlDersIDiAlma);
                while (resultSetCekilenDersID.next()){
                    AnlikdersId = resultSetCekilenDersID.getInt(1);
                    System.out.println("BURDAKİ DERSıd : "+AnlikdersId);
                }
                resultSetCekilenDersID.close();

            }catch(SQLException a){
                AnlikdersId=0;
                System.out.println("DersID Bulunurken oluşan sql hatası : "+a.getMessage());
            }

        }

        try {
            System.out.println("fsm");
            Statement stat3 = baglan.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sqlDersIDiAlma = "select ders_id from ders_bilgileri where ders_isim ='" + anlikDersIsim + "' and " +
                    "kisi_idf = (SELECT kisi_idf FROM kullanici_bilgileri WHERE kullanici_ad = '" + AktifKullanici.aktifKullaniciKullaniciAdi + "'); ";
            ResultSet resultSetCekilenDersID = stat3.executeQuery(sqlDersIDiAlma);
            while (resultSetCekilenDersID.next()) {
                AnlikdersId = resultSetCekilenDersID.getInt(1);
                System.out.println("BURDAKİ DERSıd : " + AnlikdersId);
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
                System.out.println("Ders sayınız: " + kisininKayitliDersSayisi);


                String sqlKullaniciKayitliDersAlma = "SELECT ders_isim FROM ders_bilgileri WHERE kisi_idf = '" + AktifKullanici.aktifKullaniciID + "'";
                ResultSet resultSetCekilenDers = statement.executeQuery(sqlKullaniciKayitliDersAlma);

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
    void gnoYnoGuncelle(int kisiId,int gecerliDonem,float gno,float yno){
        String sqlGnoYnoGuncelle = "update kisi_ortalama_bilgileri set alindigi_donem = "+gecerliDonem+" ,genel_ortalamasi = "+gno+", donem_ortalamasi = "+yno+" where kisi_idf = "+kisiId+" and alindigi_donem ="+gecerliDonem+" ;";
        try {
            PreparedStatement StatGnoYnoGuncelle = baglan.prepareStatement(sqlGnoYnoGuncelle);
            StatGnoYnoGuncelle.executeUpdate();
            System.out.println("Gno-Yno güncelleme başarıyla gerçekleşti");
        } catch (SQLException e) {
            System.out.println("Gno-Yno güncellenirken oluşan sql hatası "+e.getMessage());
            throw new RuntimeException(e);
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

    boolean dersBilgileriGir(int donem,String dersIsim,int akts,int vizeNotu,int vizeEtkiOrani,int finalNotu,int finalEtkiOrani){

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
            String sqlDersBilgisiGir =" insert into ders_ortalama_bilgileri(ders_ortalama_id,dersten_gecme_notu100,dersten_gecme_notu4,dersten_gecme_durumu,ders_idf,alindigi_donem,kisi_idf) VALUES (" +
                    "?,?,?,?,?,?,?); ";

            PreparedStatement parametreliStatDersOrtBilgi =baglan.prepareStatement(sqlDersBilgisiGir);

            parametreliStatDersOrtBilgi.setInt(1,yeniDersId);
            parametreliStatDersOrtBilgi.setFloat(2,OrtalamaHesapla.derstenGecmeNotu100);
            parametreliStatDersOrtBilgi.setFloat(3,OrtalamaHesapla.dortlukDersGecmeNotu);
            parametreliStatDersOrtBilgi.setString(4,OrtalamaHesapla.dersGecmeDurumuString);
            parametreliStatDersOrtBilgi.setInt(5,yeniDersId);
            parametreliStatDersOrtBilgi.setInt(6,donem);
            parametreliStatDersOrtBilgi.setInt(7,kisi_idf);

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
                    "ders_idf = (select TOP 1 ders_id from ders_bilgileri where ders_isim = '"+dersIsim+"');";


            ResultSet resultSetGCekilenDersVize = statement.executeQuery(sqlGuncellenicekDersVize);

            if(resultSetGCekilenDersVize.next()) {
                GuncellenicekBilgiler.guncellenicekVizeNotu= resultSetGCekilenDersVize.getInt(1);

            }
            resultSetGCekilenDersVize.close();

            String sqlGuncellenicekDersFinal = "SELECT final_notu from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+dersIsim+"');";

            ResultSet resultSetGCekilenDersFinal = statement.executeQuery(sqlGuncellenicekDersFinal);

            if (resultSetGCekilenDersFinal.next()) {
                GuncellenicekBilgiler.guncellenicekFinalNotu = resultSetGCekilenDersFinal.getInt(1);

            }
            resultSetGCekilenDersFinal.close();

            String sqlGuncellenicekDersVizeEtkiO = "SELECT vize_etkiO from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+dersIsim+"');";

            ResultSet resultSetGCekilenDersVizeEtkiO = statement.executeQuery(sqlGuncellenicekDersVizeEtkiO);

            if (resultSetGCekilenDersVizeEtkiO.next()) {
                GuncellenicekBilgiler.guncellenicekVizeEtkiO = resultSetGCekilenDersVizeEtkiO.getInt(1);

            }
            resultSetGCekilenDersVizeEtkiO.close();

            String sqlGuncellenicekDersFinalEtkiO = "SELECT final_etkiO from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+dersIsim+"');";

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
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"');";

            ResultSet resultSetCekilenDersVize = statement.executeQuery(sqlSilinecekDersVize);

            if(resultSetCekilenDersVize.next()) {
                SilinecekBilgiler.silinecekVizeNotu = resultSetCekilenDersVize.getInt(1);

            }
            resultSetCekilenDersVize.close();

            String sqlSilinecekDersFinal = "SELECT final_notu from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"');";

            ResultSet resultSetCekilenDersFinal = statement.executeQuery(sqlSilinecekDersFinal);

            if (resultSetCekilenDersFinal.next()) {
                SilinecekBilgiler.silinecekFinalNotu = resultSetCekilenDersFinal.getInt(1);

            }
            resultSetCekilenDersFinal.close();

            String sqlSilinecekDersVizeEtkiO = "SELECT vize_etkiO from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"');";

            ResultSet resultSetCekilenDersVizeEtkiO = statement.executeQuery(sqlSilinecekDersVizeEtkiO);

            if (resultSetCekilenDersVizeEtkiO.next()) {
                SilinecekBilgiler.silinecekVizeEtkiO = resultSetCekilenDersVizeEtkiO.getInt(1);

            }
            resultSetCekilenDersVizeEtkiO.close();

            String sqlSilinecekDersFinalEtkiO = "SELECT final_etkiO from not_bilgileri where kisi_idf ="+AktifKullanici.aktifKullaniciID +" and " +
                    "ders_idf = (select top 1 ders_id from ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"');";

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

            String sqlDersSilme1 ="DELETE FROM ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"' and ders_id = " +
                    " "+dersIdBul(SilinecekBilgiler.silinecekDersIsmi)+";";

            String sqlDersSilme ="DELETE FROM ders_bilgileri where ders_isim = '"+SilinecekBilgiler.silinecekDersIsmi+"' and ders_id = " +
                    "(SELECT not_id from not_bilgileri where ders_idf ="+dersIdBul(SilinecekBilgiler.silinecekDersIsmi)+"" +
                    "AND kisi_idf = "+AktifKullanici.aktifKullaniciID+");";
            PreparedStatement parametreliStatDersSilme   = baglan.prepareStatement(sqlDersSilme1);
            parametreliStatDersSilme.executeUpdate();

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

}
