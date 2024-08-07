import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class kayitEkrani extends JFrame {
    private JPanel giris_ekran;
    private JTextField fld_soyad;
    private JTextField fld_isim;
    private JComboBox cmbx_okul;
    private JTextField fld_bolum;
    private JComboBox cmbx_sinif;
    private JRadioButton listedeYokRadioButton;
    private JButton kayitOlButton;
    private JPasswordField fld_parola;
    private JCheckBox chkbx_sifreGoster;
    private JButton btn_GeriDon;
    private JTextField fld_kullaniciAdi;
    VeriTabaniIslemleri veriTabaniIslemleri1 = new VeriTabaniIslemleri();
    kayitEkrani(){


        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.add(giris_ekran);

        ImageIcon icon = new ImageIcon("C:\\Users\\HP\\IdeaProjects\\OrtalamaHesaplamaUygulamasi\\src\\A+.jpeg"); // İkonunuzun yolunu doğru şekilde belirtin
        Image image = icon.getImage();

        // JFrame'in ikonunu ayarla
        setIconImage(image);


        setSize(600,600);
        setTitle("Ortalama Hesaplama Uygulaması");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width )/2,(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height )/2);


        kayitOlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
/*
                System.out.println("Giriş yapan kullanıcının İsmi : " + fld_isim.getText());
                System.out.println("Giriş yapan kullanıcının Soyadı : " + fld_soyad.getText());
                System.out.println("Giriş yapan kullanıcının Okulu : " + cmbx_okul.getSelectedItem());
                System.out.println("Giriş yapan kullanıcının Bölümü : " + fld_bolum.getText());
                System.out.println("Giriş yapan kullanıcının Sınıfı : " + cmbx_sinif.getSelectedItem());
*/

                String isimText = fld_isim.getText();
                String soyisimText =fld_soyad.getText() ;
                String parolaText =fld_parola.getText();
                String okulText = cmbx_okul.getSelectedItem() != null ? cmbx_okul.getSelectedItem().toString() : null;
                String bolumText = fld_bolum.getText();
                String sinifText = cmbx_sinif.getSelectedItem() != null ? cmbx_sinif.getSelectedItem().toString() : null;
                String kAdiText = fld_kullaniciAdi.getText();

                if(!isimText.isEmpty() &&  !soyisimText.isEmpty() &&  !parolaText.isEmpty() &&  okulText !=null &&  !bolumText.isEmpty() &&  sinifText !=null && kAdiText != null){

                   // VeriTabaniIslemleri veriTabaniIslemleri1 = new VeriTabaniIslemleri();
                    veriTabaniIslemleri1.enYuksekKisiId = veriTabaniIslemleri1.enYuksekKisiId();
                   // veriTabaniIslemleri1.veriGirmeDurumu = veriTabaniIslemleri1.veriyiParametreIleGir((veriTabaniIslemleri1.enYuksekKisiId()+1), fld_isim.getText().toString(), fld_soyad.getText(), fld_parola.getText(), cmbx_okul.getSelectedItem().toString(), fld_bolum.getText(), cmbx_sinif.getSelectedItem().toString());
                    veriTabaniIslemleri1.veriGirmeDurumu = veriTabaniIslemleri1.veriyiParametreIleGir((veriTabaniIslemleri1.enYuksekKisiId+1),fld_isim.getText(), fld_soyad.getText(),fld_kullaniciAdi.getText() ,fld_parola.getText(), cmbx_sinif.getSelectedItem().toString(), fld_bolum.getText(), cmbx_okul.getSelectedItem().toString() );

                    if (!veriTabaniIslemleri1.veriGirmeDurumu) {
                        JOptionPane.showMessageDialog(null, "Veri Aktarımı başarısız,\n\tTekrar deneyiniz.");
                    }else{
                        JOptionPane.showMessageDialog(null,"Kayıt İşleminiz Başarılı Şekilde Gerçekleşmiştir");
                         dispose();
                         new GirisEkrani();
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz,\n\tBoşlukları doldurunuz.");
                }


            }
        });

        chkbx_sifreGoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (chkbx_sifreGoster.isSelected()) {

                    fld_parola.setEchoChar((char) 0);
                } else {
                    fld_parola.setEchoChar('•');
                }


            }
        });
        btn_GeriDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GirisEkrani();
            }
        });
    }

}
