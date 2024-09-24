import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GirisEkrani  extends JFrame{
    public JTextField fld_kullaniciAdiGiris;
    private JPasswordField fld_parolaGiris;
    private JPanel JP_giris_ekran;
    private JButton btn_girisYap;
    private JCheckBox chckbx_ParolaGoster;
    private JLabel fld_kayitOl;
    VeriTabaniIslemleri veriTabaniIslemleri2 =new VeriTabaniIslemleri();

    private void girisIslemiYap(){
        String kullaniciAdiGirisText = fld_kullaniciAdiGiris.getText();
        String parolaGirisText =fld_parolaGiris.getText();

        if(!kullaniciAdiGirisText.isEmpty() &&  !parolaGirisText.isEmpty() ){
            // VeriTabaniIslemleri veriTabaniIslemleri2 =new VeriTabaniIslemleri();
            veriTabaniIslemleri2.kullaniciGirisiDogruMu(kullaniciAdiGirisText,parolaGirisText);
            if(!veriTabaniIslemleri2.isKullaniciGirisiDogruMu){
                tamEkranYap(false);
                JOptionPane.showMessageDialog(this,"KULLANICI SİSTEMDE YOK");
                tamEkranYap(true);
            }else {
                tamEkranYap(false);
                JOptionPane.showMessageDialog(this, "KULLANICI GİRİŞİ BAŞARILI");
                tamEkranYap(true);

                AktifKullanici.aktifKullaniciParola=fld_parolaGiris.getText();
                setAlwaysOnTop(false);

                veriTabaniIslemleri2.kullaniciBilgileriAktar();
                dispose();
                new MenuGui();
            }

        }else{
            tamEkranYap(false);
            JOptionPane.showMessageDialog(null,"!! Lütfen Boş Alan Bırakmayınız !!");
            tamEkranYap(true);
        }
    }
    public  void tamEkranYap(boolean isTamEkranYap){
        new TamEkran(this, isTamEkranYap);
        System.out.println("tam ekran yapıldı");
    }

    GirisEkrani(){
        // Kullanıcı adı ve parola alanlarına ActionListener ekliyoruz
        fld_kullaniciAdiGiris.addActionListener(e -> handleLogin());
        fld_parolaGiris.addActionListener(e -> handleLogin());

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        this.add(JP_giris_ekran);
        // new ImageIcon("C:\\Users\\HP\\IdeaProjects\\OrtalamaUygulamasi\\src\\A+.jpeg");

        ImageIcon icon = new ImageIcon("C:\\Users\\HP\\IdeaProjects\\OrtalamaHesaplamaUygulamasi\\src\\A+.jpeg"); // İkonunuzun yolunu doğru şekilde belirtin
        Image image = icon.getImage();

        // JFrame'in ikonunu ayarla
        setIconImage(image);

        // Ekran boyutlarını almak için GraphicsDevice kullan
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        // Ekranı tam ekran yap
        device.setFullScreenWindow(this);

       // setSize(1500,1000);
        setTitle("Ortalama Hesaplama Uygulaması");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width )/2,(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height )/2);

        fld_kayitOl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Fare işaretçisini el işareti yap
        fld_kayitOl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new kayitEkrani();


            }
        });


        chckbx_ParolaGoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!chckbx_ParolaGoster.isSelected()) {
                    fld_parolaGiris.setEchoChar('•');
                } else {
                    fld_parolaGiris.setEchoChar((char)0);
                }
            }
        });
        btn_girisYap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                girisIslemiYap();
            }
        });

    }
    private void handleLogin() {
        // Kullanıcı adı ve parola alanı dolu mu kontrol et
        if (!fld_kullaniciAdiGiris.getText().isEmpty() && fld_parolaGiris.getPassword().length > 0) {
            System.out.println("Kullanıcı bilgileri denetleniyor...");
            girisIslemiYap();
        } else {
            tamEkranYap(false);
            JOptionPane.showMessageDialog(null,"Lütfen Kullanıcıadı ve parola alanlarını doldurun.");
            tamEkranYap(true);
            System.out.println("Lütfen  adı ve parola alanlarını doldurun.");
        }
    }
}
