import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GirisEkrani  extends JFrame{
    public JTextField fld_kullaniciAdiGiris;
    private JPasswordField fld_parolaGiris;
    private JPanel JP_giris_ekran;
    private JButton btn_girisYap;
    private JCheckBox chckbx_ParolaGoster;
    private JLabel fld_kayitOl;
    VeriTabaniIslemleri veriTabaniIslemleri2 =new VeriTabaniIslemleri();

    GirisEkrani(){

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


        setSize(600,600);
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
                String kullaniciAdiGirisText = fld_kullaniciAdiGiris.getText();
                String parolaGirisText =fld_parolaGiris.getText();


                if(!kullaniciAdiGirisText.isEmpty() &&  !parolaGirisText.isEmpty() ){
                   // VeriTabaniIslemleri veriTabaniIslemleri2 =new VeriTabaniIslemleri();
                    veriTabaniIslemleri2.kullaniciGirisiDogruMu(kullaniciAdiGirisText,parolaGirisText);
                    if(!veriTabaniIslemleri2.isKullaniciGirisiDogruMu){
                     JOptionPane.showMessageDialog(null,"KULLANICI SİSTEMDE YOK");
                  }else {
                        JOptionPane.showMessageDialog(null,"KULLANICI GİRİŞİ BAŞARILI");
                       AktifKullanici.aktifKullaniciParola=fld_parolaGiris.getText();


                        veriTabaniIslemleri2.kullaniciBilgileriAktar();
                        dispose();
                        new MenuGui();
                    }

                }else{
                  JOptionPane.showMessageDialog(null,"!! Lütfen Boş Alan Bırakmayınız !!");
                }
            }
        });
    }
}
