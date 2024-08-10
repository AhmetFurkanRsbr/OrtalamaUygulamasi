import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;


public class MenuGui extends  JFrame{
   // Ders ders1= new Ders();

    OrtalamaHesapla ortalamaHesapla1=new OrtalamaHesapla();
    private JTabbedPane tabbedPane1;
    private JPanel JP_Menu;
    private JTextField fld_dersIsim;
    private JSpinner spn_Akts;
    private JTextField fld_vize;
    private JTextField fld_final;
    private JTextField fld_vizeEtki;
    private JTextField fld_finalEtki;
    private JTree tree1;
    private JButton btn_ortalamaHesapla;
    private JButton btn_sistemeKayitEt;
    private JButton btn_cikisYapKullanici;
    private JTextField fld_gno;
    private JTextField fld_yno;
    private JTextField fld_dersGecme100;
    private JTextField fld_dersGecme4;
    private JLabel lbl_yno;
    private JLabel lbl_gno;
    private JLabel lbl_dersGecme100;
    private JLabel lbl_dersGecme4;
    private JLabel lbl_aktifKullanici;
    private JTextField fld_kalanDersSayisi;
    private JLabel lbl_kalanDersSayisi;
    private JPanel tab_ortalama;
    private JPanel tab_kayitliNot;
    private JTextField fld_kayitliDersSayimiz;
    private JPanel tab_dersBilgiGuncelle;
    private JButton btn_dersSil;
    private JButton btn_dersBilgiGuncelle;
    private JComboBox cmbx_guncellenicekDers;
    private JComboBox cmbx_silinecekDers;
    private JTextField fld_eskiDrsIsim;
    private JTextField fld_eskiDrsVize;
    private JTextField fld_eskiFinal;
    private JTextField fld_eskiVizeEtkiO;
    private JTextField fld_yeniDrsIsim;
    private JSpinner spn_eskiAkts;
    private JSpinner spn_yeniAkts;
    private JTextField fld_yeniDrsVize;
    private JTextField fld_yeniDrsFinal;
    private JTextField fld_yeniVizeEtkiO;
    private JTextField fld_yeniFinalEtkiO;
    private JLabel txt_eskiDrsIsim;
    private JLabel txt_eskiDrsAkts;
    private JLabel txt_eskiDrsVize;
    private JLabel txt_eskiDrsFinal;
    private JLabel txt_eskiVizeEtki;
    private JLabel txt_eskiFinalEtki;
    private JLabel txt_yeniDrsIsim;
    private JLabel txt_yeniDrsAkts;
    private JLabel txt_yeniDrsVize;
    private JLabel txt_yeniDrsFinal;
    private JLabel txt_yeniVizeEtki;
    private JLabel txt_yeniFinalEtki;
    private JTextField fld_silmeDersIsim;
    private JTextField fld_silmeAkts;
    private JTextField fld_silmeVizeNotu;
    private JTextField fld_silmeFinalNotu;
    private JTextField fld_silmeVizeEtkiO;
    private JTextField fld_EskiFinalEtkiOranı;
    private JTextField fld_silmeFinalEtkiO;
    private JLabel txt_silmeDersIsim;
    private JLabel txt_silmeAkts;
    private JLabel txt_silmeVizeNotu;
    private JLabel txt_silmeFinalNotu;
    private JLabel txt_silmeVizeEtkiO;
    private JLabel txt_silmeFinalEtkiO;
    private JComboBox cmbx_derslerEnyksk;
    private JTextField fld_dersiAlanSayisi;
    private JTextField fld_enyAlanKisi;
    private JTextField fld_enyNot;
    private JButton btn_sorgulaEnyksk;
    private JTextField fld_enyFalanToplamKisiSayisi;
    private JTextField fld_enyFalanKisi;
    private JTextField fld_enyFfinalNot;
    private JTextField fld_dersIsimKayit;
    private JTextField fld_aktsKayit;
    private JTextField fld_vizeNotKayit;
    private JTextField fld_finalNotKayit;
    private JTextField fld_vizeEtkiKayit;
    private JTextField fld_dersOrtKayit;
    private JTextField fld_derstgenGecmeKayi;
    private JLabel txt_dersIsimKayit;
    private JLabel txt_aktsKayit;
    private JLabel txt_vizeKayit;
    private JLabel txt_finalKayit;
    private JLabel txt_vizeEtkiO;
    private JLabel txt_dersOrtalamaKayit;
    private JLabel txt_derstengecmeKayit;
    private JButton btn_hesabimiSil;
    private JSpinner spn_donem;
    private JLabel txt_donem;
    private JTextField fld_EskiYno;
    private JLabel lbl_eskiyno;
    private JTextField fld_Eskigno;
    private JLabel lbl_eskigno;
    private JTextField fld_anlikGnoKayit;
    private JLabel txt_anlıkGnoKayit;
    private JButton btn_gnoEkle;
    private JTextField fld_gnoGercerliDonem;
    private JLabel txt_gnoGecerliDonem;
    private JButton btn_gnoDegis;
    private JPanel tab_ortalamaDene;
    private JPanel tab_enyuksekAlinanNot;
    private JPanel tab_dersSil;
    private JTextField fld_vizeBasariSirasi;
    private JTextField fld_finalBasariSirasi;
    private JTextField fld_vizeNotun;
    private JTextField fld_finalNotun;
    private JLabel txt_vizeBasariSirasi;
    private JLabel txt_finalBasariSirasi;
    private JLabel txt_vizeNotun;
    private JLabel txt_finalNotun;
    private JLabel txt_vizeBasariSirasiPaylastigi;
    private JTextField fld_vizeBasariSirasiPaylastigi;
    private JLabel txt_finalBasariSirasiPaylastigi;
    private JTextField fld_finalBasariSirasiPaylastigi;
    private JLabel txt_sinifVizeOrt;
    private JTextField fld_sinifVizeOrt;
    private JLabel txt_sinifFinalOrt;
    private JTextField fld_sinifFinalOrt;
    private JTextField fld_sinifDersGenelOrt;
    private JTextField fld_kisiDersGenelOrt;
    private JLabel txt_sinifDersGenelOrt;
    private JLabel txt_kisiDersGenelOrt;
    private JTextField fld_dersGenelBirincisi;
    private JTextField fld_dersGenelBasariSiralaman;
    private JLabel txt_dersGenelBirinci;
    private JLabel txt_dersGenelBasariSiran;
    private JLabel txt_dersGenelEnYuksekOrt;
    private JTextField fld_dersGenelEnyOrt;
    private JLabel txt_dersiAlanKisiSayisi;
    private JTextField fld_derstenGecenKisiSayisi;
    private JTextField fld_derstenKalanKisiSayisi;
    private JLabel txt_derstenGecenKisiSayis;
    private JLabel txt_derstenKalanKisiSayis;
    static int dersSayisi = 0;
    static String dersSayisiString="";
   static int finalNotu=0;
   static int vizeNotu=0;
    static int vizeEtkiOrani=0;
    static int finalEtkiOrani=0;
    static int akts=0;
   static int donem=0;
    boolean isNotGirisindeHata=false;
    String cmbxSilinecekDersIsim;
    String cmbxguncellenicekDersIsim;
    String cmbxEnyuksekDersIsim;
    String eskiGnoKayit;
    int eskiGecerliDonem;

VeriTabaniIslemleri vt= new  VeriTabaniIslemleri();
SilinenVerileriKaydirma silVerKaydir =new SilinenVerileriKaydirma();
    void gnoKayitEkle(){

        if(fld_anlikGnoKayit.getText().isEmpty() || fld_anlikGnoKayit.getText().equals("0.0") ){
            System.out.println("gno ekleme başlatıldı");
            String gnoKayitString =  JOptionPane.showInputDialog(null,"Şuanki Gno'nuz Nedir ?(!!ondalık kısım için . kullanınız!!) ");
            float gnoKayit= Float.parseFloat(gnoKayitString);

            if(gnoKayit<0.0 || gnoKayit>4.0){
                JOptionPane.showMessageDialog(null,"Gno'nuz 0.00-4.00 Arasında Olmalıdır !!");
                gnoKayitEkle();
            }else{
                fld_anlikGnoKayit.setText(gnoKayitString);
                fld_gnoGercerliDonem.setText(JOptionPane.showInputDialog(null,"Gno'nuzun Geçerli Olduğu Son Dönemi Giriniz(1-2-3)"));
                vt.sistemeGnoEkle(AktifKullanici.aktifKullaniciID,fld_anlikGnoKayit.getText(),fld_gnoGercerliDonem.getText());
            }

        }else {
            JOptionPane.showMessageDialog(null,"Zaten Sistemde Gno Kaydınız Var.... Gno Güncelle Kısmını Kullanınınz !!");
        }
    }
    void spinnerLimitle(){
         int minDeger =1;
         int maxDeger =30;
         int minDeger2 =1;
         int maxDeger2 =20;

         SpinnerModel spinnerModel1 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModel2 = new SpinnerNumberModel(minDeger2,minDeger2,maxDeger2,1);
         spn_Akts.setModel(spinnerModel1);
         spn_donem.setModel(spinnerModel2);

         //Spinner a text tipinden yazı yazılmasını engelleyen kısım(akts değerini sadece arttırma eksilme yapılmasına izin veriyor)
         JComponent editor = spn_Akts.getEditor();
         if (editor instanceof JSpinner.DefaultEditor) {
             JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
             spinnerEditor.getTextField().setEditable(false);
         }
        JComponent editor1 = spn_donem.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor1;
            spinnerEditor.getTextField().setEditable(false);
        }


     }
    void ortalamaSonucuGorunurYap(boolean aktifBilgiGirmeDevam){
        if(!aktifBilgiGirmeDevam){
            /*
            fld_yno.setVisible(false);
            fld_gno.setVisible(false);
            fld_yno.setVisible(false);
            fld_gno.setVisible(false);
            lbl_yno.setVisible(false);
            lbl_gno.setVisible(false);
           */
            fld_yno.setVisible(true);
            fld_gno.setVisible(true);
            fld_yno.setVisible(true);
            fld_gno.setVisible(true);
            lbl_yno.setVisible(true);
            lbl_gno.setVisible(true);
            lbl_eskigno.setVisible(true);
            lbl_eskiyno.setVisible(true);
            fld_Eskigno.setVisible(true);
            fld_EskiYno.setVisible(true);


            fld_dersGecme100.setVisible(true);
            fld_dersGecme4.setVisible(true);

            lbl_dersGecme4.setVisible(true);
            lbl_dersGecme100.setVisible(true);
        }

    }

    void ortalamaSonucuGizle(){
        lbl_eskigno.setVisible(false);
        lbl_eskiyno.setVisible(false);
        fld_Eskigno.setVisible(false);
        fld_EskiYno.setVisible(false);

        fld_yno.setVisible(false);
        fld_gno.setVisible(false);
        fld_dersGecme100.setVisible(false);
        fld_dersGecme4.setVisible(false);

        lbl_dersGecme4.setVisible(false);
        lbl_gno.setVisible(false);
        lbl_yno.setVisible(false);
        lbl_dersGecme100.setVisible(false);
    }
    void agacListeAyarla(){
        if(!vt.baglanmaDurumu){
            try {
                vt.msqlBaglan();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        DefaultMutableTreeNode node=new DefaultMutableTreeNode("Dersler");
        vt.kisininKayitliDersleriniGetir();
         fld_kayitliDersSayimiz.setText(""+AktifKullanici.aktifKullaniciDersSayi);
        if(vt.kisininKayitliDersGetirmeDurumu){

            DefaultMutableTreeNode[] alt = new DefaultMutableTreeNode[AktifKullanici.aktifKullaniciDersSayi];
            DefaultTreeModel model1=new DefaultTreeModel(node);
            for (int j=0;j<AktifKullanici.aktifKullaniciDersSayi;j++){

                alt[j] = new DefaultMutableTreeNode(""+vt.cekilenDers[j]);
                node.add(alt[j]);
            }
            tree1.setModel(model1);
        }
    }

    void cmbx_EnYuksekGonder() {
        cmbx_derslerEnyksk.removeAll();

        DefaultComboBoxModel<String> guncellenicekEnYModel = new DefaultComboBoxModel<>();
        cmbx_derslerEnyksk.setModel(guncellenicekEnYModel);

        for (int z = 0; z < AktifKullanici.aktifKullaniciDersSayi; z++) {
            cmbxEnyuksekDersIsim = vt.cekilenDers[z];
            guncellenicekEnYModel.addElement(cmbxEnyuksekDersIsim);
        }
    }
    void cmbx_guncellenicekDersGonder(){
        cmbx_guncellenicekDers.removeAll();
        DefaultComboBoxModel<String> guncellenicekModel = new DefaultComboBoxModel<>();
        cmbx_guncellenicekDers.setModel(guncellenicekModel);

        for (int m=0;m<AktifKullanici.aktifKullaniciDersSayi;m++){
            cmbxguncellenicekDersIsim = vt.cekilenDers[m];
            guncellenicekModel.addElement(cmbxguncellenicekDersIsim);
        }

    }
    void cmbx_silinecekDersGonder(){
        cmbx_silinecekDers.removeAll();
        DefaultComboBoxModel<String> silinecekModel = new DefaultComboBoxModel<>();
        cmbx_silinecekDers.setModel(silinecekModel);
        for (int k=0;k<AktifKullanici.aktifKullaniciDersSayi;k++){
            cmbxSilinecekDersIsim = vt.cekilenDers[k];
            silinecekModel.addElement(cmbxSilinecekDersIsim);
        }

    }

    void guncellenicekSayfasindakileriGizle(){
        txt_eskiDrsIsim.setVisible(false);
        txt_eskiDrsAkts.setVisible(false);
        txt_eskiDrsVize.setVisible(false);
        txt_eskiDrsFinal.setVisible(false);
        txt_eskiVizeEtki.setVisible(false);
        txt_eskiFinalEtki.setVisible(false);

        txt_yeniDrsIsim.setVisible(false);
        txt_yeniDrsAkts.setVisible(false);
        txt_yeniDrsVize.setVisible(false);
        txt_yeniDrsFinal.setVisible(false);
        txt_yeniVizeEtki.setVisible(false);
        txt_yeniFinalEtki.setVisible(false);

        fld_yeniDrsIsim.setVisible(false);
        spn_yeniAkts.setVisible(false);
        fld_yeniDrsVize.setVisible(false);
        fld_yeniDrsFinal.setVisible(false);
        fld_yeniVizeEtkiO.setVisible(false);
        fld_yeniFinalEtkiO.setVisible(false);

        fld_eskiDrsIsim.setVisible(false);
        spn_eskiAkts.setVisible(false);
        fld_eskiDrsVize.setVisible(false);
        fld_eskiFinal.setVisible(false);
        fld_eskiVizeEtkiO.setVisible(false);
        fld_EskiFinalEtkiOranı.setVisible(false);

        btn_dersBilgiGuncelle.setVisible(false);
    }

    void guncellenicekVerileriGorunurYap(){
        txt_eskiDrsIsim.setVisible(true);
        txt_eskiDrsAkts.setVisible(true);
        txt_eskiDrsVize.setVisible(true);
        txt_eskiDrsFinal.setVisible(true);
        txt_eskiVizeEtki.setVisible(true);
        txt_eskiFinalEtki.setVisible(true);

        txt_yeniDrsIsim.setVisible(true);
        txt_yeniDrsAkts.setVisible(true);
        txt_yeniDrsVize.setVisible(true);
        txt_yeniDrsFinal.setVisible(true);
        txt_yeniVizeEtki.setVisible(true);
        txt_yeniFinalEtki.setVisible(true);

        fld_yeniDrsIsim.setVisible(true);
        spn_yeniAkts.setVisible(true);
        fld_yeniDrsVize.setVisible(true);
        fld_yeniDrsFinal.setVisible(true);
        fld_yeniVizeEtkiO.setVisible(true);
        fld_yeniFinalEtkiO.setVisible(true);

        fld_eskiDrsIsim.setVisible(true);
        spn_eskiAkts.setVisible(true);
        fld_eskiDrsVize.setVisible(true);
        fld_eskiFinal.setVisible(true);
        fld_eskiVizeEtkiO.setVisible(true);
        fld_EskiFinalEtkiOranı.setVisible(true);

        btn_dersBilgiGuncelle.setVisible(true);

    }

    /////////////////////////////
    void silinecekSayfasindakileriGizle(){
        txt_silmeDersIsim.setVisible(false);
        txt_silmeAkts.setVisible(false);
        txt_silmeVizeNotu.setVisible(false);
        txt_silmeFinalNotu.setVisible(false);
        txt_silmeVizeEtkiO.setVisible(false);
        txt_silmeFinalEtkiO.setVisible(false);

        fld_silmeDersIsim.setVisible(false);
        fld_silmeAkts.setVisible(false);
        fld_silmeVizeNotu.setVisible(false);
        fld_silmeFinalNotu.setVisible(false);
        fld_silmeVizeEtkiO.setVisible(false);
        fld_silmeFinalEtkiO.setVisible(false);

        btn_dersSil.setVisible(false);
    }

    void silinecekVerileriGorunurYap(){
       txt_silmeDersIsim.setVisible(true);
       txt_silmeAkts.setVisible(true);
       txt_silmeVizeNotu.setVisible(true);
       txt_silmeFinalNotu.setVisible(true);
       txt_silmeVizeEtkiO.setVisible(true);
       txt_silmeFinalEtkiO.setVisible(true);

       fld_silmeDersIsim.setVisible(true);
       fld_silmeAkts.setVisible(true);
       fld_silmeVizeNotu.setVisible(true);
       fld_silmeFinalNotu.setVisible(true);
       fld_silmeVizeEtkiO.setVisible(true);
       fld_silmeFinalEtkiO.setVisible(true);

       btn_dersSil.setVisible(true);

    }
    void kayitEkraniGizle(){
        txt_aktsKayit.setVisible(false);
        txt_finalKayit.setVisible(false);
        txt_derstengecmeKayit.setVisible(false);
        txt_dersIsimKayit.setVisible(false);
        txt_vizeKayit.setVisible(false);
        txt_dersOrtalamaKayit.setVisible(false);
        txt_vizeEtkiO.setVisible(false);
        txt_silmeFinalEtkiO.setVisible(false);

        fld_aktsKayit.setVisible(false);
        fld_dersIsimKayit.setVisible(false);
        fld_dersOrtKayit.setVisible(false);
        fld_vizeNotKayit.setVisible(false);
        fld_vizeEtkiKayit.setVisible(false);
        fld_finalNotKayit.setVisible(false);
        fld_derstgenGecmeKayi.setVisible(false);
    }
    void kayitEkraniGoster(){
        fld_aktsKayit.setVisible(true);
        fld_dersIsimKayit.setVisible(true);
        fld_dersOrtKayit.setVisible(true);
        fld_vizeNotKayit.setVisible(true);
        fld_vizeEtkiKayit.setVisible(true);
        fld_finalNotKayit.setVisible(true);
        fld_derstgenGecmeKayi.setVisible(true);
    }
    MenuGui(){
        ortalamaSonucuGizle();
        btn_sistemeKayitEt.setVisible(false);
        spinnerLimitle();
        lbl_aktifKullanici.setText(AktifKullanici.aktifKullaniciKullaniciAdi);
        String anlikGnoString =String.valueOf(vt.gnoVarsaGetir(AktifKullanici.aktifKullaniciID));
        fld_anlikGnoKayit.setText(anlikGnoString);
        fld_gnoGercerliDonem.setText(String.valueOf(VeriTabaniIslemleri.gecerliDonem));
        kayitEkraniGizle();
        agacListeAyarla();

        silinecekSayfasindakileriGizle();
        guncellenicekSayfasindakileriGizle();
        cmbx_silinecekDersGonder();
        cmbx_guncellenicekDersGonder();

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.add(JP_Menu);

        ImageIcon icon = new ImageIcon("C:\\Users\\HP\\IdeaProjects\\OrtalamaHesaplamaUygulamasi\\src\\A+.jpeg");
        //ImageIcon icon =new ImageIcon("C:\\Users\\HP\\IdeaProjects\\OrtalamaHesaplamaUygulamasi\\src\\Ortalama Hesapla6.png");
        Image image = icon.getImage();
        setIconImage(image);

        setSize(600,600);
        setTitle("Ortalama Hesaplama Uygulaması");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width )/2,(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height )/2);


        btn_ortalamaHesapla.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String finalString = fld_final.getText();
                    finalNotu = Integer.parseInt(finalString);

                    String vizeString = fld_vize.getText();
                     vizeNotu = Integer.parseInt(vizeString);

                    String vizeEtkiOString = fld_vizeEtki.getText();
                    vizeEtkiOrani = Integer.parseInt(vizeEtkiOString);

                    String finalEtkiString = fld_finalEtki.getText();
                    finalEtkiOrani = Integer.parseInt(finalEtkiString);

                    akts = (int) spn_Akts.getValue();
                    donem=(int) spn_donem.getValue();
                    isNotGirisindeHata=false;
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }

                if( vizeNotu <0 || vizeNotu >100){
                    isNotGirisindeHata=true;
                    JOptionPane.showInternalMessageDialog(null,"!! Vize Notunuz 0-100 Aralığında Olmalılıdır !!");
                }  if (finalNotu < 0 || finalNotu > 100) {
                    isNotGirisindeHata=true;
                    JOptionPane.showInternalMessageDialog(null,"!! Final Notunuz 0-100 Aralığında Olmalılıdır !!");
                } if ( (vizeEtkiOrani + finalEtkiOrani ) != 100) {
                    isNotGirisindeHata=true;
                    JOptionPane.showInternalMessageDialog(null,"!! Vize ve Final Etki Oranları Toplamı 100 'ü Vermelidir !!");
                }  if (akts > 30 || akts <= 0) {
                    isNotGirisindeHata=true;
                    JOptionPane.showInternalMessageDialog(null,"!! Akts Değeriniz 30 'dan Büyük, 0 'dan Küçük Olamaz !!");
                }if(!isNotGirisindeHata){

                     ortalamaHesapla1.dersOrtalamasiHesapla(vizeNotu,finalNotu,akts,vizeEtkiOrani,finalEtkiOrani);
                    //ortalamaHesapla1.anlikDonemOrtalamasiHesapla(AktifKullanici.aktifKullaniciID,donem,Integer.parseInt(fld_kalanDersSayisi.getText()));
                     ortalamaHesapla1.donemOrtalamaHesapla(AktifKullanici.aktifKullaniciID,donem);
                     ortalamaHesapla1.yeniDonemOrtalamasiHesapla(AktifKullanici.aktifKullaniciID,donem);
                     fld_Eskigno.setText(String.valueOf(vt.eskiGnoGetir(AktifKullanici.aktifKullaniciID,donem)));
                     vt.yeniGnoHesapla(AktifKullanici.aktifKullaniciID,donem,OrtalamaHesapla.yeniDonemOrtalamasi4,OrtalamaHesapla.donemOrtalamasi4);

                    JOptionPane.showMessageDialog(null,"DERS:"+ fld_dersIsim.getText() + "\ndersten geçme notunuz(4lük) : "+ortalamaHesapla1.dortlukDersGecmeNotu+"\ndersten geçme notunuz(100 lük) : "+ortalamaHesapla1.derstenGecmeNotu100+"\n\tDERSTEN GEÇME DURUMUNUZ-->> "+ortalamaHesapla1.dersGecmeDurumuString);
                    fld_yno.setText(String.valueOf(OrtalamaHesapla.yeniDonemOrtalamasi4));
                    fld_EskiYno.setText(String.valueOf(OrtalamaHesapla.donemOrtalamasi4));
                    fld_dersGecme100.setText(String.valueOf(OrtalamaHesapla.derstenGecmeNotu100));
                    fld_dersGecme4.setText(String.valueOf(OrtalamaHesapla.dortlukDersGecmeNotu));
                    fld_gno.setText(String.valueOf(VeriTabaniIslemleri.yeniGno));
                    btn_sistemeKayitEt.setVisible(true);
                        if(fld_kalanDersSayisi.getText().equals("1")) {
                         ortalamaHesapla1.donemOrtalamaHesapla(AktifKullanici.aktifKullaniciID,donem);
                            ortalamaHesapla1.anlikDonemOrtalamasiHesapla(AktifKullanici.aktifKullaniciID,donem,Integer.parseInt(fld_kalanDersSayisi.getText()));
                            ortalamaSonucuGorunurYap(false);

                        }else{
                            ortalamaSonucuGorunurYap(true);
                        }

                }
            }
        });
        btn_cikisYapKullanici.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AktifKullanici.aktifKullaniciBilgileriSifirla();
                new GirisEkrani();
            }
        });
        tabbedPane1.addChangeListener(e -> {
            int secilenIndex = tabbedPane1.getSelectedIndex();
            String secilenTabIsmi = tabbedPane1.getTitleAt(secilenIndex);

            switch (secilenTabIsmi){
                case "Not Kaydet":

                    do {
                        try {
                            String dersSayisiString = JOptionPane.showInputDialog(null, "Kaç ders için hesaplama işlemi yapıcaksınız.");


                            dersSayisi = Integer.parseInt(dersSayisiString);
                               fld_kalanDersSayisi.setText(dersSayisiString);


                        } catch (NumberFormatException e2) {

                                if(dersSayisiString.isEmpty()){

                                    cmbx_silinecekDersGonder();
                                    cmbx_guncellenicekDersGonder();
                                    cmbx_EnYuksekGonder();

                                    dispose();
                                    new MenuGui();
                                    break;
                                }else{
                                    System.out.println("Kaç ders girelecği sorusuna cancel cevabı verildi : " + e2.getMessage());
                                    dersSayisiString=null;
                                    dersSayisi = 0;
                                }
                        }
                    } while (dersSayisi <= 0);


                        fld_dersIsim.setEnabled(true);
                        fld_vize.setEnabled(true);
                        fld_final.setEnabled(true);
                        fld_vizeEtki.setEnabled(true);
                        fld_finalEtki.setEnabled(true);
                        spn_Akts.setEnabled(true);
                        spn_donem.setEnabled(true);
                        btn_ortalamaHesapla.setEnabled(true);
                        this.revalidate();
                        this.repaint();

                        cmbx_silinecekDersGonder();
                        cmbx_guncellenicekDersGonder();
                        cmbx_EnYuksekGonder();

                    break;
                case "Kayıtlı Notlar":
                    break;
                case "Ders Bilgisi Güncelle":
                    cmbx_guncellenicekDersGonder();
                    guncellenicekSayfasindakileriGizle();
                    break;
                case "Ders Sil":
                    cmbx_silinecekDersGonder();
                    silinecekSayfasindakileriGizle();
                    break;
                case "En Yüksek Alınan Not":
                    cmbx_EnYuksekGonder();
                    break;
                case "Ortalama Dene":
                    //Yapılacak işlemler.
                    break;
                default:
                    System.out.println("HATALI PENCERE DEĞİŞİMİ");
            }

        });

        btn_sistemeKayitEt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dersSayisi>0){

                    vt.dersBilgileriGir(donem,fld_dersIsim.getText(),akts,vizeNotu,vizeEtkiOrani,finalNotu,finalEtkiOrani);

                    agacListeAyarla();

                    fld_dersIsim.setText("");
                    fld_vize.setText("");
                    fld_finalEtki.setText("");
                    fld_final.setText("");
                    fld_vizeEtki.setText("");
                    spn_Akts.setValue(1);
                    spn_donem.setValue(1);
                    dersSayisi-=1;
                    dersSayisiString=String.valueOf(dersSayisi);
                    fld_kalanDersSayisi.setText(dersSayisiString);


                    ortalamaSonucuGizle();
                    btn_sistemeKayitEt.setVisible(false);
                    if(dersSayisi==0){
                        int cevap = JOptionPane.showConfirmDialog(null,"Yeni ders ekleyecek misiniz ?");
                        //
                        vt.gnoYnoGuncelle(AktifKullanici.aktifKullaniciID,donem,Float.parseFloat(fld_gno.getText()),Float.parseFloat(fld_yno.getText()));

                         switch (cevap){
                            case 0://ders ekliycek
                                dersSayisi=1;
                                fld_dersIsim.setEnabled(false);
                                fld_vize.setEnabled(false);
                                fld_final.setEnabled(false);
                                fld_vizeEtki.setEnabled(false);
                                fld_finalEtki.setEnabled(false);
                                spn_Akts.setEnabled(false);
                                spn_donem.setEnabled(false);
                                btn_ortalamaHesapla.setEnabled(false);
                                break;
                            case 1://ders eklemiycek
                               fld_dersIsim.setEnabled(false);
                               fld_vize.setEnabled(false);
                               fld_final.setEnabled(false);
                               fld_vizeEtki.setEnabled(false);
                               fld_finalEtki.setEnabled(false);
                               spn_Akts.setEnabled(false);
                               spn_donem.setEnabled(false);
                               btn_ortalamaHesapla.setEnabled(false);
                                break;
                            case 2://ders eklemiycek
                                fld_dersIsim.setEnabled(false);
                                fld_vize.setEnabled(false);
                                fld_final.setEnabled(false);
                                fld_vizeEtki.setEnabled(false);
                                fld_finalEtki.setEnabled(false);
                                spn_Akts.setEnabled(false);
                                spn_donem.setEnabled(false);
                                btn_ortalamaHesapla.setEnabled(false);
                                System.out.println("cancel");
                                break;
                        }
                    }
                }else {
                   int ders_ekleme=JOptionPane.showConfirmDialog(null,"Yeni ders ekleyecek misiniz ?");
                    System.out.println(ders_ekleme);
                }

            }
        });
        cmbx_guncellenicekDers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(cmbx_guncellenicekDers.getSelectedIndex()!=-1){
                    guncellenicekVerileriGorunurYap();

                   GuncellenicekBilgiler.guncellenicekDersIsmi= (String) cmbx_guncellenicekDers.getSelectedItem();

                   vt.guncellenicekKullaniclarinBilgileriniCekme((String)cmbx_guncellenicekDers.getSelectedItem());

                    fld_eskiDrsIsim.setText(GuncellenicekBilgiler.guncellenicekDersIsmi);
                    spn_eskiAkts.setValue(GuncellenicekBilgiler.guncellenicekDersAkts);
                    fld_eskiDrsVize.setText(""+GuncellenicekBilgiler.guncellenicekVizeNotu);
                    fld_eskiFinal.setText(""+GuncellenicekBilgiler.guncellenicekFinalNotu);
                    fld_eskiVizeEtkiO.setText(""+GuncellenicekBilgiler.guncellenicekVizeEtkiO);
                    fld_EskiFinalEtkiOranı.setText(""+GuncellenicekBilgiler.guncellenicekFinalEtkiO);


                    fld_yeniDrsIsim.setText(fld_eskiDrsIsim.getText());
                    fld_yeniDrsVize.setText(""+GuncellenicekBilgiler.guncellenicekVizeNotu);
                    fld_yeniDrsFinal.setText(""+GuncellenicekBilgiler.guncellenicekFinalNotu);
                    fld_yeniVizeEtkiO.setText(""+GuncellenicekBilgiler.guncellenicekVizeEtkiO);
                    fld_yeniFinalEtkiO.setText(""+GuncellenicekBilgiler.guncellenicekFinalEtkiO);
                    spn_yeniAkts.setValue(GuncellenicekBilgiler.guncellenicekDersAkts);

                }
            }
        });
        cmbx_silinecekDers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(cmbx_silinecekDers.getSelectedIndex()!=-1){

                    silinecekVerileriGorunurYap();

                    fld_silmeDersIsim.setText((String) cmbx_silinecekDers.getSelectedItem());

                    SilinecekBilgiler.silinecekDersIsmi= (String) cmbx_silinecekDers.getSelectedItem();


                    vt.silinecekKullanicininBilgileriniCekme(SilinecekBilgiler.silinecekDersIsmi);

                        fld_silmeAkts.setText(String.valueOf(SilinecekBilgiler.silinecekDersAkts));
                        fld_silmeVizeNotu.setText(""+SilinecekBilgiler.silinecekVizeNotu);
                        fld_silmeFinalNotu.setText(""+SilinecekBilgiler.silinecekFinalNotu);
                        fld_silmeVizeEtkiO.setText(""+SilinecekBilgiler.silinecekVizeEtkiO);
                        fld_silmeFinalEtkiO.setText(""+SilinecekBilgiler.silinecekFinalEtkiO);


                }
            }
        });
        btn_dersSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

           boolean isDersVeNotSil =vt.dersVeNotSil();
           if (isDersVeNotSil){
               JOptionPane.showMessageDialog(null,"Seçtiğiniz derse ait bilgiler sistemden silinmiştir.");
               cmbx_EnYuksekGonder();
               cmbx_guncellenicekDersGonder();
               cmbx_silinecekDersGonder();

               dispose();
               new MenuGui();
           }

            }
        });
        btn_dersBilgiGuncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!fld_yeniDrsIsim.getText().isEmpty() && !fld_yeniDrsVize.getText().isEmpty() && !fld_yeniDrsFinal.getText().isEmpty() && !fld_yeniVizeEtkiO.getText().isEmpty() && !fld_yeniFinalEtkiO.getText().isEmpty()){

                    GuncellenicekBilgiler.guncelDersIsmi=fld_yeniDrsIsim.getText();
                    GuncellenicekBilgiler.guncelDersAkts= (Integer) spn_yeniAkts.getValue();
                    GuncellenicekBilgiler.guncelVizeNotu = Integer.parseInt(fld_yeniDrsVize.getText());
                    GuncellenicekBilgiler.guncelFinalNotu =Integer.parseInt(fld_yeniDrsFinal.getText());
                    GuncellenicekBilgiler.guncelVizeEtkiO = Integer.parseInt(fld_yeniVizeEtkiO.getText());
                    GuncellenicekBilgiler.guncelFinalEtkiO =Integer.parseInt(fld_yeniFinalEtkiO.getText());

                    vt.dersVeNotguncelle();

                   JOptionPane.showMessageDialog(null,"Güncelleme İşlemi Başarıyla Gerçekleşti");
                }else {
                    JOptionPane.showMessageDialog(null,"Eksik Yeni Değerler Tespit Edildi !!");
                }
            }
        });
        btn_sorgulaEnyksk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(cmbx_derslerEnyksk.getSelectedIndex()!=-1) {
                     EnYuksekBilgileri.enYuksekDersIsim =(String) cmbx_derslerEnyksk.getSelectedItem();
                     vt.enYuksekSorgulariYap(EnYuksekBilgileri.enYuksekDersIsim);

                     fld_enyAlanKisi.setText(EnYuksekBilgileri.enYuksekVNotuAlan);
                     fld_enyFalanKisi.setText(EnYuksekBilgileri.enYuksekFNotuAlan);
                     fld_enyNot.setText(""+EnYuksekBilgileri.enYuksekVizeNotu);
                     fld_enyFfinalNot.setText(""+EnYuksekBilgileri.enYuksekFinalNotu);
                     fld_enyFalanToplamKisiSayisi.setText(""+EnYuksekBilgileri.enyFDersiAlanSayisi);

                     int kisiVizeNotu=vt.kisiVizeFinalNotuGetir(EnYuksekBilgileri.enYuksekDersIsim,true);
                     int kisiFinalNotu=vt.kisiVizeFinalNotuGetir(EnYuksekBilgileri.enYuksekDersIsim,false);

                     fld_vizeNotun.setText(""+kisiVizeNotu);
                     fld_finalNotun.setText(""+kisiFinalNotu);

                     fld_vizeBasariSirasi.setText(""+vt.kisiVizeFinalBasariSirasiOgrenme(kisiVizeNotu,EnYuksekBilgileri.enYuksekDersIsim,true));
                     fld_finalBasariSirasi.setText(""+vt.kisiVizeFinalBasariSirasiOgrenme(kisiFinalNotu,EnYuksekBilgileri.enYuksekDersIsim,false));

                     fld_vizeBasariSirasiPaylastigi.setText(""+vt.kisiVizeFinalBasariSirasiPaylastigiKisiSayisiGetirme(kisiVizeNotu,EnYuksekBilgileri.enYuksekDersIsim,true));
                     fld_finalBasariSirasiPaylastigi.setText(""+vt.kisiVizeFinalBasariSirasiPaylastigiKisiSayisiGetirme(kisiFinalNotu,EnYuksekBilgileri.enYuksekDersIsim,false));

                     fld_sinifVizeOrt.setText(""+vt.sinifVizeFinalNotOrtalamasiGonder(EnYuksekBilgileri.enYuksekDersIsim,true));
                     fld_sinifFinalOrt.setText(""+vt.sinifVizeFinalNotOrtalamasiGonder(EnYuksekBilgileri.enYuksekDersIsim,false));

                     fld_sinifDersGenelOrt.setText(""+vt.sinifKisiGenelNotOrtalamasiGonder(EnYuksekBilgileri.enYuksekDersIsim,AktifKullanici.aktifKullaniciID,true));
                     fld_kisiDersGenelOrt.setText(""+vt.sinifKisiGenelNotOrtalamasiGonder(EnYuksekBilgileri.enYuksekDersIsim,AktifKullanici.aktifKullaniciID,false));

                     fld_dersGenelEnyOrt.setText(vt.dersGenelEnyuksekOrtalamaVeyaKisisiniGetir(EnYuksekBilgileri.enYuksekDersIsim,true));
                     fld_dersGenelBirincisi.setText(vt.dersGenelEnyuksekOrtalamaVeyaKisisiniGetir(EnYuksekBilgileri.enYuksekDersIsim,false));

                     fld_dersGenelBasariSiralaman.setText(""+vt.dersGenelBasariSirasiGetir(EnYuksekBilgileri.enYuksekDersIsim,fld_kisiDersGenelOrt.getText()));

                     fld_derstenGecenKisiSayisi.setText(""+vt.derstenGecenKalanKisiSayisiGetir(EnYuksekBilgileri.enYuksekDersIsim,fld_enyFalanToplamKisiSayisi.getText())[0]);
                     fld_derstenKalanKisiSayisi.setText(""+vt.derstenGecenKalanKisiSayisiGetir(EnYuksekBilgileri.enYuksekDersIsim,fld_enyFalanToplamKisiSayisi.getText())[1]);

                }

            }
        });

        tree1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

               //kayitEkraniGoster();
            }
        });
        btn_hesabimiSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SilinecekBilgiler.silinecekKisiId=AktifKullanici.aktifKullaniciID;
                silVerKaydir.SilinenVerileriKaydir();
                dispose();
                new GirisEkrani();
            }
        });

        btn_gnoEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gnoKayitEkle();
            }
        });
        btn_gnoDegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("gno güncelleme başlatıldı");
                 eskiGnoKayit = fld_anlikGnoKayit.getText();
                 eskiGecerliDonem = Integer.parseInt(fld_gnoGercerliDonem.getText());

                if(fld_anlikGnoKayit.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Kayıtlı Gno'nuz Yok Gno Ekle Kısmını Kullanınız");
                }else{
                    String guncelGnoString = JOptionPane.showInputDialog(null,"Güncelleyeceğiniz Gno'yu Giriniz (ondalıklı kısım için . kullanınız)");
                    float guncelGno=Float.parseFloat(guncelGnoString);
                     if(guncelGno<0.0 || guncelGno>4){
                         JOptionPane.showMessageDialog(null,"Gno'nuz 0.00-4.00 Arasında Olmalıdır !!");
                         guncelGnoString=  JOptionPane.showInputDialog(null,"Şuanki Gno'nuz Nedir ?(!!ondalık kısım için . kullanınız!!) ");
                         guncelGno= Float.parseFloat(guncelGnoString);
                     }

                    fld_anlikGnoKayit.setText(guncelGnoString);
                    fld_gnoGercerliDonem.setText(JOptionPane.showInputDialog(null,"Gno'nuzun Geçerli Olduğu Son Dönemi Giriniz(1-2-3)"));
                    vt.sistemdekiGnoGuncelle(AktifKullanici.aktifKullaniciID,guncelGnoString,fld_gnoGercerliDonem.getText(),eskiGecerliDonem,eskiGnoKayit);
                }
            }
        });
    }



}
