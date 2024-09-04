import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;


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
    private JCheckBox chckbx_rastgeleDersler;
    private JCheckBox chckbx_kayitliDersler;
    private JSpinner spn_getirilecekDonem;
    private JButton btn_hesaplaOrtalamaDene;
    private JTextField fld_vize1;
    private JTextField fld_final1;
    private JTextField fld_vizeEtki1;
    private JButton btn_dersleriGetir;
    private JTextField fld_vize2;
    private JTextField fld_vize3;
    private JTextField fld_vize4;
    private JTextField fld_vize5;
    private JTextField fld_vize6;
    private JTextField fld_vize7;
    private JTextField fld_vize8;
    private JTextField fld_vize9;
    private JTextField fld_vize10;
    private JTextField fld_vize11;
    private JTextField fld_final2;
    private JTextField fld_final3;
    private JTextField fld_final4;
    private JTextField fld_final5;
    private JTextField fld_final6;
    private JTextField fld_final7;
    private JTextField fld_final8;
    private JTextField fld_final9;
    private JTextField fld_final10;
    private JTextField fld_final11;
    private JTextField fld_vizeEtki2;
    private JTextField fld_vizeEtki3;
    private JTextField fld_vizeEtki4;
    private JTextField fld_vizeEtki5;
    private JTextField fld_vizeEtki6;
    private JTextField fld_vizeEtki7;
    private JTextField fld_vizeEtki8;
    private JTextField fld_vizeEtki9;
    private JTextField fld_vizeEtki10;
    private JTextField fld_vizeEtki11;
    private JTextField fld_finalEtki1;
    private JTextField fld_finalEtki2;
    private JTextField fld_finalEtki3;
    private JTextField fld_finalEtki4;
    private JTextField fld_finalEtki5;
    private JTextField fld_finalEtki6;
    private JTextField fld_finalEtki7;
    private JTextField fld_finalEtki8;
    private JTextField fld_finalEtki9;
    private JTextField fld_finalEtki10;
    private JTextField fld_finalEtki11;
    private JLabel txt_hangiDonem;
    private JSpinner spn_aktsDers1;
    private JSpinner spn_aktsDers2;
    private JSpinner spn_aktsDers3;
    private JSpinner spn_aktsDers4;
    private JSpinner spn_aktsDers5;
    private JSpinner spn_aktsDers6;
    private JSpinner spn_aktsDers7;
    private JSpinner spn_aktsDers8;
    private JSpinner spn_aktsDers9;
    private JSpinner spn_aktsDers10;
    private JSpinner spn_aktsDers11;
    private JPanel jp_checkboxlar;
    private JLabel txt_vizeEtkiOrani;
    private JLabel txt_finalNotu;
    private JLabel txt_vizeNotu;
    private JLabel txt_akts;
    private JLabel txt_dersIsim;
    private JScrollPane scrool_ortalamaDene;
    private JTextField txt_dersIsim1;
    private JTextField txt_dersIsim3;
    private JTextField txt_dersIsim4;
    private JTextField txt_dersIsim2;
    private JTextField txt_dersIsim5;
    private JTextField txt_dersIsim6;
    private JTextField txt_dersIsim7;
    private JTextField txt_dersIsim8;
    private JTextField txt_dersIsim9;
    private JTextField txt_dersIsim10;
    private JTextField txt_dersIsim11;
    private JLabel txt_kacDersHesaplanicak;
    private JSpinner spn_hesaplanicakDersSayisi;
    private JLabel txt_finaltkiOrani;
    ArrayList<Component> temizlenecekComponent = new ArrayList<>();
    ArrayList<JTextField> vizeNotlariOrtalamaDene=new ArrayList<>();
    ArrayList<JTextField> finalNotlariOrtalamaDene=new ArrayList<>();
    ArrayList<JSpinner> aktslerOrtalamaDene=new ArrayList<>();
    ArrayList<JTextField> vizeEtkiOranlariOrtalamaDene=new ArrayList<>();
    ArrayList<JTextField> finalEtkiOranlariOrtalamaDene=new ArrayList<>();
    static int dersSayisi = 0;
    static String dersSayisiString="";
    static int finalNotu=0;
    static int vizeNotu=0;
    static int vizeEtkiOrani=0;
    static int finalEtkiOrani=0;
    static int akts=0;
    static int donem=0;
    static int dersSayisiIndex = 1;
    ArrayList<Integer> derstenGecmeNotlari100lukOrtDene=new ArrayList<>();
    boolean isNotGirisindeHata=false;
    String cmbxSilinecekDersIsim;
    String cmbxguncellenicekDersIsim;
    String cmbxEnyuksekDersIsim;
    String eskiGnoKayit;
    int eskiGecerliDonem;

VeriTabaniIslemleri vt= new  VeriTabaniIslemleri();
SilinenVerileriKaydirma silVerKaydir =new SilinenVerileriKaydirma();

    private static void addNumericKeyListenerToAllTextFields(Container container) {
        for (Component component : container.getComponents()) {

            if (component instanceof JTextField) {
                ((JTextField) component).addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        // Eğer karakter rakam değilse, işlem yapma

                        if (!Character.isDigit(c) && component.getName()!=null  &&component.getName().startsWith("number")) {
                            e.consume(); // İşlemi iptal et
                        }
                    }
                });
            } else if (component instanceof Container) {
                // Eğer bileşen başka bir Container ise, bu metod ile devam et
                addNumericKeyListenerToAllTextFields((Container) component);
            }
        }
    }

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
    void ortalamaDeneSyfDersleriGetir(boolean isRastgeleDersleriGetir,int DersSayisi){

        if (isRastgeleDersleriGetir){

            kayitliDersleriGizle();
            kayitliDersleriGetir(DersSayisi);

        }else {

         }

    }
    void spinnerLimitle(){

         int minDeger =1;
         float aktifDegilkenkiDeger=1.1f;
         int maxDeger =30;
         int minDeger2 =1;
         int maxDeger2 =20;

         SpinnerModel spinnerModelAktsNotKaydet = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
         SpinnerModel spinnerModel2 = new SpinnerNumberModel(minDeger2,minDeger2,maxDeger2,1);

         spn_Akts.setModel(spinnerModelAktsNotKaydet);
         spn_donem.setModel(spinnerModel2);

        SpinnerModel spinnerModelAktsOrtHesaplaDers1 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers2 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers3 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers4 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers5 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers6 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers7 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers8 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers9 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers10 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelAktsOrtHesaplaDers11 = new SpinnerNumberModel(minDeger,minDeger,maxDeger,1);
        SpinnerModel spinnerModelOrtHesaplaDonem = new SpinnerNumberModel(1,1,18,1);
        SpinnerModel spinnerModelOrtHesaplaDersSayisi = new SpinnerNumberModel(1,1,11,1);

         spn_aktsDers1.setModel(spinnerModelAktsOrtHesaplaDers1);
         spn_aktsDers2.setModel(spinnerModelAktsOrtHesaplaDers2);
         spn_aktsDers3.setModel(spinnerModelAktsOrtHesaplaDers3);
         spn_aktsDers4.setModel(spinnerModelAktsOrtHesaplaDers4);
         spn_aktsDers5.setModel(spinnerModelAktsOrtHesaplaDers5);
         spn_aktsDers6.setModel(spinnerModelAktsOrtHesaplaDers6);
         spn_aktsDers7.setModel(spinnerModelAktsOrtHesaplaDers7);
         spn_aktsDers8.setModel(spinnerModelAktsOrtHesaplaDers8);
         spn_aktsDers9.setModel(spinnerModelAktsOrtHesaplaDers9);
         spn_aktsDers10.setModel(spinnerModelAktsOrtHesaplaDers10);
         spn_aktsDers11.setModel(spinnerModelAktsOrtHesaplaDers11);
         spn_getirilecekDonem.setModel(spinnerModelOrtHesaplaDonem);
         spn_hesaplanicakDersSayisi.setModel(spinnerModelOrtHesaplaDersSayisi);

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
        JComponent editorOrtKaydetAktsDers1 = spn_aktsDers1.getEditor();
        if (editorOrtKaydetAktsDers1 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers1;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers2 = spn_aktsDers2.getEditor();
        if (editorOrtKaydetAktsDers2 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers2;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers3 = spn_aktsDers3.getEditor();
        if (editorOrtKaydetAktsDers3 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers3;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers4 = spn_aktsDers4.getEditor();
        if (editorOrtKaydetAktsDers4 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers4;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers5 = spn_aktsDers5.getEditor();
        if (editorOrtKaydetAktsDers5 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers5;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers6 = spn_aktsDers6.getEditor();
        if (editorOrtKaydetAktsDers6 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers6;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers7 = spn_aktsDers7.getEditor();
        if (editorOrtKaydetAktsDers7 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers7;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers8 = spn_aktsDers8.getEditor();
        if (editorOrtKaydetAktsDers8 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers8;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers9 = spn_aktsDers9.getEditor();
        if (editorOrtKaydetAktsDers9 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers9;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers10 = spn_aktsDers10.getEditor();
        if (editorOrtKaydetAktsDers10 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers10;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetAktsDers11 = spn_aktsDers11.getEditor();
        if (editorOrtKaydetAktsDers11 instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetAktsDers11;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetDonem = spn_getirilecekDonem.getEditor();
        if (editorOrtKaydetDonem instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetDonem;
            spinnerEditor.getTextField().setEditable(false);
        }
        JComponent editorOrtKaydetDersSayisi = spn_hesaplanicakDersSayisi.getEditor();
        if (editorOrtKaydetDersSayisi instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editorOrtKaydetDersSayisi;
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
   public void ortalamaDeneSayfasindakiComponentleriDiziyeAktar(){

        temizlenecekComponent.add(txt_dersIsim1);
        temizlenecekComponent.add(txt_dersIsim2);
        temizlenecekComponent.add(txt_dersIsim3);
        temizlenecekComponent.add(txt_dersIsim4);
        temizlenecekComponent.add(txt_dersIsim5);
        temizlenecekComponent.add(txt_dersIsim6);
        temizlenecekComponent.add(txt_dersIsim7);
        temizlenecekComponent.add(txt_dersIsim8);
        temizlenecekComponent.add(txt_dersIsim9);
        temizlenecekComponent.add(txt_dersIsim10);
        temizlenecekComponent.add(txt_dersIsim11);



        temizlenecekComponent.add(spn_aktsDers1);
        temizlenecekComponent.add(spn_aktsDers2);
        temizlenecekComponent.add(spn_aktsDers3);
        temizlenecekComponent.add(spn_aktsDers4);
        temizlenecekComponent.add(spn_aktsDers5);
        temizlenecekComponent.add(spn_aktsDers6);
        temizlenecekComponent.add(spn_aktsDers7);
        temizlenecekComponent.add(spn_aktsDers8);
        temizlenecekComponent.add(spn_aktsDers9);
        temizlenecekComponent.add(spn_aktsDers10);
        temizlenecekComponent.add(spn_aktsDers11);

        temizlenecekComponent.add(fld_vize1);
        temizlenecekComponent.add(fld_vize2);
        temizlenecekComponent.add(fld_vize3);
        temizlenecekComponent.add(fld_vize4);
        temizlenecekComponent.add(fld_vize5);
        temizlenecekComponent.add(fld_vize6);
        temizlenecekComponent.add(fld_vize7);
        temizlenecekComponent.add(fld_vize8);
        temizlenecekComponent.add(fld_vize9);
        temizlenecekComponent.add(fld_vize10);
        temizlenecekComponent.add(fld_vize11);


        temizlenecekComponent.add(fld_final1);
        temizlenecekComponent.add(fld_final2);
        temizlenecekComponent.add(fld_final3);
        temizlenecekComponent.add(fld_final4);
        temizlenecekComponent.add(fld_final5);
        temizlenecekComponent.add(fld_final6);
        temizlenecekComponent.add(fld_final7);
        temizlenecekComponent.add(fld_final8);
        temizlenecekComponent.add(fld_final9);
        temizlenecekComponent.add(fld_final10);
        temizlenecekComponent.add(fld_final11);

        temizlenecekComponent.add(fld_vizeEtki1);
        temizlenecekComponent.add(fld_vizeEtki2);
        temizlenecekComponent.add(fld_vizeEtki3);
        temizlenecekComponent.add(fld_vizeEtki4);
        temizlenecekComponent.add(fld_vizeEtki5);
        temizlenecekComponent.add(fld_vizeEtki6);
        temizlenecekComponent.add(fld_vizeEtki7);
        temizlenecekComponent.add(fld_vizeEtki8);
        temizlenecekComponent.add(fld_vizeEtki9);
        temizlenecekComponent.add(fld_vizeEtki10);
        temizlenecekComponent.add(fld_vizeEtki11);



        temizlenecekComponent.add(fld_finalEtki1);
        temizlenecekComponent.add(fld_finalEtki2);
        temizlenecekComponent.add(fld_finalEtki3);
        temizlenecekComponent.add(fld_finalEtki4);
        temizlenecekComponent.add(fld_finalEtki5);
        temizlenecekComponent.add(fld_finalEtki6);
        temizlenecekComponent.add(fld_finalEtki7);
        temizlenecekComponent.add(fld_finalEtki8);
        temizlenecekComponent.add(fld_finalEtki9);
        temizlenecekComponent.add(fld_finalEtki10);
        temizlenecekComponent.add(fld_finalEtki11);

    }public void ortalamaDeneSayfasindakiVerileriTemizle(){
        for(Component temizle:temizlenecekComponent){

            if (temizle instanceof JTextField ){
                ((JTextField) temizle).setText("");
            } else{
                if (temizle instanceof JSpinner){
                    ((JSpinner) temizle).setValue(1);
                }
            }
        }
    }

    void kayitliDersleriGizle(){

        txt_dersIsim.setVisible(false);
        txt_akts.setVisible(false);
        txt_vizeNotu.setVisible(false);
        txt_finalNotu.setVisible(false);
        txt_vizeEtkiOrani.setVisible(false);
        txt_finaltkiOrani.setVisible(false);

        for (Component component:temizlenecekComponent){        //Öncesinde tüm componentlerin görünürlüğünü kapatır.
            component.setVisible(false);
        }
    }

     void kayitliDersleriGetir(int dersSayisi) {
        MenuGui.dersSayisiIndex=1;
        String ifade="";

         txt_dersIsim.setVisible(true);
         txt_akts.setVisible(true);
         txt_vizeNotu.setVisible(true);
         txt_finalNotu.setVisible(true);
         txt_vizeEtkiOrani.setVisible(true);
         txt_finaltkiOrani.setVisible(true);


         for (dersSayisi=dersSayisi;dersSayisiIndex<=dersSayisi;dersSayisiIndex++) {

             ifade=String.valueOf(dersSayisiIndex);

             for (Component component:temizlenecekComponent){
                 try {
                      if (component.getName().endsWith(ifade) && !component.getName().endsWith("11")) {

                          component.setVisible(true);
                          if(component.getName().startsWith("spn")){
                               JSpinner aktsJS = (JSpinner) component;
                               aktsJS.setValue(1);
                          }
                      } else if (dersSayisi==11 && component.getName().endsWith("11")){

                          component.setVisible(true);
                          if(component.getName().startsWith("spn")){
                              JSpinner aktsJS = (JSpinner) component;
                              aktsJS.setValue(1);
                          }
                       }
                 }catch (NullPointerException e){
                  System.out.println(e.getMessage());    //  getName ile dönen değer null ise burası çalışıyor .
                  component.setVisible(false);
                  }
             }
         }
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

        txt_kacDersHesaplanicak.setVisible(false);
        spn_hesaplanicakDersSayisi.setVisible(false);

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
        if(fld_anlikGnoKayit.getText().isEmpty() || fld_anlikGnoKayit.getText().equals("0.0")){
            JOptionPane.showMessageDialog(null,"Gno(Genel ortalama) bilginizi giriniz");
            btn_gnoEkle.doClick();
            btn_gnoEkle.setAction(btn_gnoEkle.getAction());
        }
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
                    addNumericKeyListenerToAllTextFields(tab_ortalamaDene);//Ortalama Dene sekmesinde sayılar dışında ifade yazılmasını engeller.
                    ortalamaDeneSayfasindakiComponentleriDiziyeAktar();
                    //kayitliDersleriGizle();
                    //kayitliDersleriGetir(1);
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

               tabbedPane1.setSelectedIndex(3);
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


                   tabbedPane1.setSelectedIndex(4);
                   tabbedPane1.setSelectedIndex(2);
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
        chckbx_kayitliDersler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              chckbx_rastgeleDersler.setSelected(false);
              chckbx_rastgeleDersler.setEnabled(true);
              chckbx_kayitliDersler.setEnabled(false);

                txt_hangiDonem.setVisible(true);
                spn_getirilecekDonem.setVisible(true);

                txt_kacDersHesaplanicak.setVisible(false);
                spn_hesaplanicakDersSayisi.setVisible(false);

                kayitliDersleriGizle();

            }
        });
        chckbx_rastgeleDersler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_dersIsim.setVisible(true);
                txt_akts.setVisible(true);
                txt_vizeNotu.setVisible(true);
                txt_finalNotu.setVisible(true);
                txt_vizeEtkiOrani.setVisible(true);
                txt_finaltkiOrani.setVisible(true);

                kayitliDersleriGizle();
                kayitliDersleriGetir(1);


                  chckbx_kayitliDersler.setSelected(false);
                  chckbx_rastgeleDersler.setEnabled(false);
                  chckbx_kayitliDersler.setEnabled(true);

                  txt_hangiDonem.setVisible(false);
                  spn_getirilecekDonem.setVisible(false);

                  txt_kacDersHesaplanicak.setVisible(true);
                  spn_hesaplanicakDersSayisi.setVisible(true);

            }
        });

        btn_hesaplaOrtalamaDene.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vizeNotuOrtHesapla=0,finalNotuOrtHesapla=0,vizeEtkiOraniOrtHesapla=0,finalEtkiOraniOrtHesapla=0,aktsOrtHesapla=0;

                try {
                    String finalStringOrtHesapla = fld_final1.getText();
                    finalNotuOrtHesapla = Integer.parseInt(finalStringOrtHesapla);

                    String vizeStringOrtHesapla = fld_vize1.getText();
                     vizeNotuOrtHesapla = Integer.parseInt(vizeStringOrtHesapla);

                    String vizeEtkiOStringOrtHesapla = fld_vizeEtki1.getText();
                    vizeEtkiOraniOrtHesapla = Integer.parseInt(vizeEtkiOStringOrtHesapla);

                    String finalEtkiStringOrtHesapla = fld_finalEtki1.getText();
                    finalEtkiOraniOrtHesapla = Integer.parseInt(finalEtkiStringOrtHesapla);

                    aktsOrtHesapla = (int) spn_aktsDers1.getValue();
                    //donem=(int) spn_donem.getValue();
                    isNotGirisindeHata=false;
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }

                if( vizeNotuOrtHesapla <0 || vizeNotuOrtHesapla >100){
                    isNotGirisindeHata=true;
                    JOptionPane.showInternalMessageDialog(null,"!! Vize Notunuz 0-100 Aralığında Olmalılıdır !!");
                }  if (finalNotuOrtHesapla < 0 || finalNotuOrtHesapla > 100) {
                    isNotGirisindeHata=true;
                    JOptionPane.showInternalMessageDialog(null,"!! Final Notunuz 0-100 Aralığında Olmalılıdır !!");
                } if ( (vizeEtkiOraniOrtHesapla + finalEtkiOraniOrtHesapla ) != 100) {
                    isNotGirisindeHata=true;
                    JOptionPane.showInternalMessageDialog(null,"!! Vize ve Final Etki Oranları Toplamı 100 'ü Vermelidir !!");
                }  if (aktsOrtHesapla > 30 || aktsOrtHesapla <= 0) {
                    isNotGirisindeHata=true;
                    JOptionPane.showInternalMessageDialog(null,"!! Akts Değeriniz 30 'dan Büyük, 0 'a Küçük-Eşit Olamaz !!");
                }if(!isNotGirisindeHata){

                    new  YnoHesaplaOrtDeneSyf(Integer.parseInt(spn_hesaplanicakDersSayisi.getValue().toString()),vizeNotlariOrtalamaDene,finalNotlariOrtalamaDene,finalEtkiOranlariOrtalamaDene,vizeEtkiOranlariOrtalamaDene,aktslerOrtalamaDene,temizlenecekComponent);

                    float ynoOrtDene=0.00f;
                    ynoOrtDene = YnoHesaplaOrtDeneSyf.yno100lukOrtDene;

                    fld_yno.setText("0.00");
                    lbl_yno.setVisible(true);
                    fld_yno.setVisible(true);
                    fld_yno.setText(String.valueOf(ynoOrtDene));


                    /*
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
                       */

                }
            }
        });
        btn_dersleriGetir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ortalamaDeneSayfasindakiVerileriTemizle();
                ortalamaDeneSyfDersleriGetir(chckbx_rastgeleDersler.isSelected(),Integer.parseInt(spn_hesaplanicakDersSayisi.getValue().toString()));

            }
        });
    }

}
